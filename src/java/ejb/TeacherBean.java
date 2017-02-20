/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sukanya
 */
@Stateless
public class TeacherBean {

    @PersistenceContext(unitName = "Ssengupt_FP_PU")
    private EntityManager em;

    public TeacherBean() {
    }

    public void create(Teacher p) {
        em.persist(p);
    }

    public void update(Teacher p) {
        em.merge(p);
    }

    public void remove(Teacher p) {
        em.remove(p);
    }

    public Teacher find(long id) {
        return em.find(Teacher.class, id);
    }

    public List<Teacher> findAll() {
        return em.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
    }

    public Teacher findByUsername(String userName) {
        return em.createNamedQuery("Teacher.findByUsername", Teacher.class).setParameter("userName", userName).getSingleResult();
    }

}
