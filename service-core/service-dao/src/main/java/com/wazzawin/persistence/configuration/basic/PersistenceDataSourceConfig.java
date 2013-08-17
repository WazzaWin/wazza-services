package com.wazzawin.persistence.configuration.basic;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wazzawin.persistence.configuration.c3p0.C3P0BasicProperties;
import com.wazzawin.persistence.configuration.properties.PersistenceConnector;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
public class PersistenceDataSourceConfig {

    @Autowired
    private PersistenceConnector gpPersistenceConnector;
    //
    @Autowired
    private C3P0BasicProperties c3p0BasicProperties;

    @Bean
    public DataSource persitenceDataSource() throws Exception {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.gpPersistenceConnector.
                getDriverClassName());
        dataSource.setJdbcUrl(this.gpPersistenceConnector.getUrl());
        dataSource.setUser(this.gpPersistenceConnector.getUsername());
        dataSource.setPassword(this.gpPersistenceConnector.getPassword());


        /**
         * ************************ Poll Settings ****************************
         */
        dataSource.setAcquireIncrement(c3p0BasicProperties
                .getAcquireIncrement());
        dataSource.setAcquireRetryAttempts(c3p0BasicProperties.
                getAcquireRetryAttempts());
        dataSource.setMinPoolSize(c3p0BasicProperties.getMinPoolSize());
        dataSource.setMaxPoolSize(c3p0BasicProperties.getMaxPoolSize());
        dataSource.setMaxIdleTime(c3p0BasicProperties.getMaxIdleTime());
        dataSource.setMaxConnectionAge(c3p0BasicProperties
                .getMaxConnectionAge());
        dataSource.setConnectionCustomizerClassName(c3p0BasicProperties
                .getConnectionCustomizerClassName());

        return dataSource;
    }
}
