package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Category;
import com.wazzawin.dao.interf.contest.ICategoryDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaCategoryDAO")
@Profile(value = "jpa")
public class CategoryDAOImpl extends AbstractJpaDAO<Category, Long> implements
        ICategoryDAO {

    public CategoryDAOImpl() {
        super(Category.class);
    }
}
