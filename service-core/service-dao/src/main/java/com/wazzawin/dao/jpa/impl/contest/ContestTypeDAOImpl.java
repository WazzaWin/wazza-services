package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.ContestType;
import com.wazzawin.dao.interf.contest.IContestTypeDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaContestTypeDAO")
@Profile(value = "jpa")
public class ContestTypeDAOImpl extends AbstractJpaDAO<ContestType, Long> implements
        IContestTypeDAO {

    public ContestTypeDAOImpl() {
        super(ContestType.class);
    }
}
