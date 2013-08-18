package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Hint;
import com.wazzawin.dao.interf.contest.IHintDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaHintDAO")
@Profile(value = "jpa")
public class HintDAOImpl extends AbstractJpaDAO<Hint, Long> implements
        IHintDAO {

    public HintDAOImpl() {
        super(Hint.class);
    }
}
