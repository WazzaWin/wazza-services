package com.wazzawin.dao.jpa.impl.user;

import com.wazzawin.core.model.user.WazzaUser;
import com.wazzawin.dao.interf.user.IWazzaUserDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaWazzaUserDAO")
@Profile(value = "jpa")
public class WazzaUserDAOImpl extends AbstractJpaDAO<WazzaUser, Long> implements
        IWazzaUserDAO {

    public WazzaUserDAOImpl() {
        super(WazzaUser.class);
    }

    @Override
    public WazzaUser findByUserName(String userName) {
        Criteria crit = super.getSession().createCriteria(
                super.getPersistentClass());
        crit.add(Restrictions.eq("userName", userName));
        return (WazzaUser) crit.uniqueResult();
    }
}
