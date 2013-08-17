package com.wazzawin.persistence.configuration.jpa;

import com.wazzawin.persistence.configuration.properties.PersistenceHibProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
@Profile(value = "jpa")
public class JpaVendorAdapterConfig {

    @Autowired
    private PersistenceHibProperties gpHibernateProperties;

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        final JpaVendorAdapter gpVendorAdapter = new HibernateJpaVendorAdapter() {

            {
                this.setDatabasePlatform(
                        gpHibernateProperties.getHibDatabasePlatform());
                this.setShowSql(gpHibernateProperties.isHibShowSql());
                this.setGenerateDdl(gpHibernateProperties.isHibGenerateDdl());
            }
        };

        return gpVendorAdapter;
    }
}
