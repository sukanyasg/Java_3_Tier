/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sukanya
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "select t from Teacher t"),
    @NamedQuery(name = "Teacher.findByUsername", query = "select t from Teacher t where t.user.userName = :userName")
})
public class Teacher extends CommonEntity implements Serializable {

    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Set both sides of the relationship when adding a course.
     *
     * Add it to the courses collection within teacher (this) as well as
     * setting the teacher to this within the course.
     *
     * @param t
     */
    public void addCourse(Course t) {
        if (!this.courses.contains(t)) {
            this.courses.add(t);
        }

        if (t.getTeacher() != this) {
            t.setTeacher(this);
        }
    }

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + ", id=" + id + '}';
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
