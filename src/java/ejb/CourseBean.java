/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Course;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sukanya
 */
@Stateless
public class CourseBean extends AbstractBean<Course> {

    public CourseBean() {
        super(Course.class);
    }

    @Override
    public List<Course> findAll() {
        return getEntityManager().createNamedQuery("Course.findAll", Course.class).getResultList();
    }

}
