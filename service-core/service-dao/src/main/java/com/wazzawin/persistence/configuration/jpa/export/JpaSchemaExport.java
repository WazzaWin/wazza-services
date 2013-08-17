package com.wazzawin.persistence.configuration.jpa.export;

import com.wazzawin.persistence.configuration.export.PersistenceSchemaExport;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "jpaSchemaExport")
@Profile("jpa")
public class JpaSchemaExport extends PersistenceSchemaExport {

    @Autowired
    private LocalContainerEntityManagerFactoryBean gpEntityManagerFactory;

    @Override
    protected void createSchema() {
        Ejb3Configuration cfg = new Ejb3Configuration();
        Ejb3Configuration configured =
                cfg.configure(gpEntityManagerFactory.getPersistenceUnitInfo(),
                gpEntityManagerFactory.getJpaPropertyMap());

        schema = new SchemaExport(configured.getHibernateConfiguration());

        super.exportSchema();
    }
}
