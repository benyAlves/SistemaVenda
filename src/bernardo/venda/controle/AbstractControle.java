/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardo.venda.controle;

import bernardo.venda.util.ExceptionDialog;
import bernardo.venda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @param <T> Entidade Qualquer
 * @author Bernardo Alves
 */
public class AbstractControle<T extends Serializable> {


    private static final ThreadLocal session = new ThreadLocal();
    private final Class<T> persistentClass;

    public AbstractControle() {
        this.persistentClass = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        Session sessao = (Session) AbstractControle.session.get();
        if (sessao == null) {
            sessao = HibernateUtil.getSessionFactory().openSession();
            AbstractControle.session.set(sessao);
        }
        return sessao;
    }

    protected T save(T entidade) {
        try {
            getSession().getTransaction().begin();
            getSession().save(entidade);
            getSession().getTransaction().commit();
            return entidade;
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    protected T update(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().update(entity);
            getSession().getTransaction().commit();
            return entity;
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
            ExceptionDialog ld = new ExceptionDialog(
                    "Erro Inesperado Ocorreu!",
                    "Houve um erro na tentativa de executar a actualização", t);

            ld.setVisible(true);

        } finally {
            close();
        }
        return null;
    }

    protected boolean delete(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().delete(entity);
            getSession().getTransaction().commit();
            return true;
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            ExceptionDialog ld = new ExceptionDialog(
                    "Erro Inesperado Ocorreu!",
                    "Houve um erro na tentativa de executar a remoção", t);

            ld.setVisible(true);

        } finally {
            close();
        }
        return false;
    }

    public Long ultimoCodigo() {
        Long codigo = null;
        try {
            codigo = (Long) getSession().createCriteria(persistentClass).setProjection(Projections.max("codigo")).uniqueResult();
        } catch (HibernateException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro Inesperado\n" + e);
        }
        return codigo;
    }

    public List<T> findAll() {
        List<T> l = getSession().createCriteria(persistentClass).list();
        return l;
    }

    public T findByName(String string, String nome) {
        T l = (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("" + string + "", nome).ignoreCase()).uniqueResult();
        return l;
    }

    public T findById(String string, long id) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("" + string + "", id)).uniqueResult();
    }

    private void close() {
        // if (getSession() != null && getSession().isOpen()) {
        getSession().close();
        AbstractControle.session.set(null);
        //}
    }
}
