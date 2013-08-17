package com.wazzawin.persistence.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "gpHibernateProperties")
public class PersistenceHibProperties {

    @Value("persistence{db_databasePlatform}")
    private String hibDatabasePlatform;
    @Value("persistence{db_showSql:@null}")
    private Boolean hibShowSql;
    @Value("persistence{db_generateDdl:@null}")
    private Boolean hibGenerateDdl;
    @Value("persistence{db_hbm2ddlAuto}")
    private String hibHbm2ddlAuto;
    @Value("persistence{db_cacheProviderClass:@null}")
    private String hibCacheProviderClass;
    @Value("persistence{db_cacheRegionFactoryClass}")
    private String hibCacheRegionFactoryClass;
    @Value("persistence{db_useSecondLevelCache:@null}")
    private Boolean hibUseSecondLevelCache;
    @Value("persistence{db_useQueryCache:@null}")
    private Boolean hibUseQueryCache;
    @Value("persistence{db_generateStatistics:@null}")
    private Boolean hibGenerateStatistics;
    @Value("persistence{db_defaultSchema}")
    private String hibDefaultSchema;
    @Value("persistence{db_ehcacheConfigurationResourceName}")
    private String ehcacheConfResourceName;

    /**
     * @return the hibDatabasePlatform
     */
    public String getHibDatabasePlatform() {
        return hibDatabasePlatform;
    }

    /**
     * @return the hibShowSql
     */
    public boolean isHibShowSql() {
        return (hibShowSql == null) ? false : hibShowSql;
    }

    /**
     * @return the hibGenerateDdl
     */
    public boolean isHibGenerateDdl() {
        return (hibGenerateDdl == null) ? false : hibGenerateDdl;
    }

    /**
     * @return the hibHbm2ddlAuto
     */
    public String getHibHbm2ddlAuto() {
        return hibHbm2ddlAuto;
    }

//    /**
//     * @return the hibCacheProviderClass
//     */
    public String getHibCacheProviderClass() {
        return hibCacheProviderClass;
    }
//
//    /**
//     * @return the hibCacheRegionFactoryClass
//     */
    public String getHibCacheRegionFactoryClass() {
        return hibCacheRegionFactoryClass;
    }
//
//    /**
//     * @return the hibUseSecondLevelCache
//     */
    public boolean isHibUseSecondLevelCache() {
        return (hibUseSecondLevelCache == null) ? false : hibUseSecondLevelCache;
    }
//
//    /**
//     * @return the hibUseQueryCache
//     */
    public boolean isHibUseQueryCache() {
        return (hibUseQueryCache == null) ? false : hibUseQueryCache;
    }
    /**
     * @return the hibGenerateStatistics
     */
    public boolean isHibGenerateStatistics() {
        return (hibGenerateStatistics == null) ? false : hibGenerateStatistics;
    }

    /**
     * @return the hibDefaultSchema
     */
    public String getHibDefaultSchema() {
        return hibDefaultSchema;
    }

    //    /**
    //     * @return the ehcacheConfResourceName
    //     */
        public String getEhcacheConfResourceName() {
            return ehcacheConfResourceName;
        }
    @Override
    public String toString() {
        return "GPPersistenceHibProperties{ " + "hibDatabasePlatform = "
                + hibDatabasePlatform + ", hibShowSql = " + hibShowSql
                + ", hibGenerateDdl = " + hibGenerateDdl
                + ", hibHbm2ddlAuto = " + hibHbm2ddlAuto
                + ", hibGenerateStatistics = " + hibGenerateStatistics
                + ", hibDefaultSchema = " + hibDefaultSchema + '}';
    }

}