package com.wazzawin.persistence.configuration.jpa;

import com.wazzawin.persistence.configuration.basic.strategy.PropertiesStrategyManager;
import com.wazzawin.persistence.configuration.properties.PersistenceConnector;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
@Profile(value = "jpa")
@EnableTransactionManagement
public class PersistenceJpaConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Autowired
    private PersistenceConnector gpPersistenceConnector;
    //
    @Autowired
    private DataSource persitenceDataSource;
    //
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;
    //
    @Autowired
    private PropertiesStrategyManager hibPropStrategyManager;

    @Bean
    public LocalContainerEntityManagerFactoryBean gpEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean gpFactoryBean = new LocalContainerEntityManagerFactoryBean();
        gpFactoryBean.setDataSource(this.persitenceDataSource);
        gpFactoryBean.setPackagesToScan(
                this.gpPersistenceConnector.getPackagesToScan());

        gpFactoryBean.setJpaVendorAdapter(this.jpaVendorAdapter);
        gpFactoryBean.setLoadTimeWeaver(this.gpLoadTimeWeaver());
        gpFactoryBean.setJpaProperties(
                this.hibPropStrategyManager.getProperties());
        gpFactoryBean.setPersistenceUnitName("wazza-persistence-layer");

        return gpFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager gpTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                this.gpEntityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LoadTimeWeaver gpLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }
}
