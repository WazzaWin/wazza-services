package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Contest;
import com.wazzawin.dao.interf.contest.IContestDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaContestDAO")
@Profile(value = "jpa")
public class ContestDAOImpl extends AbstractJpaDAO<Contest, Long> implements
        IContestDAO {

    public ContestDAOImpl() {
        super(Contest.class);
    }
}
