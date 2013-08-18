package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.ContestPrize;
import com.wazzawin.dao.interf.contest.IContestPrizeDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaContestPrizeDAO")
@Profile(value = "jpa")
public class ContestPrizeDAOImpl extends AbstractJpaDAO<ContestPrize, Long> implements
        IContestPrizeDAO {

    public ContestPrizeDAOImpl() {
        super(ContestPrize.class);
    }
}
