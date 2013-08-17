package com.wazzawin.persistence.configuration.hibernate;

import com.wazzawin.persistence.configuration.basic.strategy.PropertiesStrategyManager;
import com.wazzawin.persistence.configuration.properties.PersistenceConnector;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
@Profile(value = "hibernate")
@EnableTransactionManagement
public class PersistenceHibernateConfig {

    @Autowired
    private PersistenceConnector persistenceConnector;
    //
    @Autowired
    private DataSource persitenceDataSource;
    //
    @Autowired
    private PropertiesStrategyManager hibPropStrategyManager;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(this.persitenceDataSource);
        factoryBean.setPackagesToScan(
                this.persistenceConnector.getPackagesToScan());
        factoryBean.setHibernateProperties(
                this.hibPropStrategyManager.getProperties());

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(this.sessionFactoryBean().getObject());

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor sessionExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
