package com.wazzawin.persistence.configuration.hibernate.export;

import com.wazzawin.persistence.configuration.export.PersistenceSchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "hibSchemaExport")
@Profile("hibernate")
public class HibernateSchemaExport extends PersistenceSchemaExport {

    @Autowired
    private LocalSessionFactoryBean gpSessionFactoryBean;

    @Override
    protected void createSchema() {
        this.schema = new SchemaExport(
                this.gpSessionFactoryBean.getConfiguration());

        super.exportSchema();
    }
}
