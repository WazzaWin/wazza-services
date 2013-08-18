package com.wazzawin.dao.jpa.impl.customer;

import com.wazzawin.core.model.customer.Company;
import com.wazzawin.dao.interf.customer.ICompanyDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaCompanyDAO")
@Profile(value = "jpa")
public class CompanyDAOImpl extends AbstractJpaDAO<Company, Long> implements
        ICompanyDAO {

    public CompanyDAOImpl() {
        super(Company.class);
    }
}
