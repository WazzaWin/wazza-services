package com.wazzawin.persistence.configuration.basic;

import com.wazzawin.persistence.cache.api.HibernateCacheProvider;
import com.wazzawin.persistence.configuration.basic.strategy.PersistenceHibernateStrategy;
import com.wazzawin.persistence.configuration.properties.PersistenceHibProperties;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
public class BaseHibernateProperties
        implements PersistenceHibernateStrategy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Autowired
    private PersistenceHibProperties gpHibernateProperties;
    //
    @Autowired(required = false)
    private HibernateCacheProvider gpCacheProviderSupport;

    @Bean
    @Override
    public Properties hibernateProperties() {
        return new Properties() {

            private static final long serialVersionUID = 3109256773218160485L;

            {
                logger.debug("Hibernate Properties " + gpHibernateProperties);
                assert (gpHibernateProperties != null) : "The Persistence Hibernate Properties obj must not be null";
                this.put("hibernate.dialect",
                        gpHibernateProperties.getHibDatabasePlatform());
                this.put("hibernate.hbm2ddl.auto",
                        gpHibernateProperties.getHibHbm2ddlAuto());
                this.put("hibernate.show_sql",
                        gpHibernateProperties.isHibShowSql());
                this.put("hibernate.generate_statistics",
                        gpHibernateProperties.isHibGenerateStatistics());

                if (gpHibernateProperties.isHibUseSecondLevelCache()
                        && gpHibernateProperties.getHibCacheProviderClass() != null
                        && gpHibernateProperties.getHibCacheRegionFactoryClass() != null) {
//                        && gpHibernateProperties.getEhcacheConfResourceName() != null) {
                    this.put("hibernate.cache.provider_class",
                            gpHibernateProperties.getHibCacheProviderClass());
                    this.put("hibernate.cache.region.factory_class",
                            gpHibernateProperties.getHibCacheRegionFactoryClass());
                    this.put("hibernate.cache.use_second_level_cache",
                            gpHibernateProperties.isHibUseSecondLevelCache());
//                    this.put("net.sf.ehcache.configurationResourceName",
//                            gpHibernateProperties.getEhcacheConfResourceName());
                    this.put("hibernate.cache.use_query_cache",
                            gpHibernateProperties.isHibUseQueryCache());
                } else if (gpHibernateProperties.isHibUseSecondLevelCache()) {
                    throw new IllegalArgumentException(
                            BaseHibernateProperties.class.getCanonicalName()
                            + ": To use the Second level cache it is "
                            + "necessary to specify all the necessary parameters");
                }
                this.put("hibernate.default_schema",
                        gpHibernateProperties.getHibDefaultSchema());

                if (gpCacheProviderSupport != null) {
                    this.putAll(gpCacheProviderSupport.getCacheProviderProperties());
                }
            }
        };
    }
}
