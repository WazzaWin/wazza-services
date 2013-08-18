package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Period;
import com.wazzawin.dao.interf.contest.IPeriodDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaPeriodDAO")
@Profile(value = "jpa")
public class PeriodDAOImpl extends AbstractJpaDAO<Period, Long> implements
        IPeriodDAO {

    public PeriodDAOImpl() {
        super(Period.class);
    }
}
