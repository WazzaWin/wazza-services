package com.wazzawin.persistence.configuration.export;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public abstract class PersistenceSchemaExport implements InitializingBean {

    protected SchemaExport schema;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.createSchema();
    }

    protected void exportSchema() {
        schema.setOutputFile("target/schema.sql");

        schema.setFormat(true);
        schema.setDelimiter(";");
        schema.create(true, false);
    }

    protected abstract void createSchema();
}
