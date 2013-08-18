package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Periodicity;
import com.wazzawin.dao.interf.contest.IPeriodicityDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaPeriodicityDAO")
@Profile(value = "jpa")
public class PeriodicityDAOImpl extends AbstractJpaDAO<Periodicity, Long> implements
        IPeriodicityDAO {

    public PeriodicityDAOImpl() {
        super(Periodicity.class);
    }
}
