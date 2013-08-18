package com.wazzawin.dao;

import com.wazzawin.exception.DAOException;
import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public interface IBaseDAO<T extends Object, ID extends Serializable> {

    T persist(T entity);

    T update(T entity);

    int removeAll();

    void delete(Long id);

    T find(Long id) throws DAOException;

    List<T> findAll();

    List<T> findAll(int start,
            int end) throws DAOException;

    List<T> findAll(int start,
            int end, Criterion... criterion) throws DAOException;

    List<T> findByCriteria(Criterion... criterion) throws DAOException;
}
