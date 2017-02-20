/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Sukanya
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "select s from Student s"),
    @NamedQuery(name = "Student.findByUsername", query = "select s from Student s where s.user.userName = :userName")
})
public class Student extends CommonEntity implements Serializable, Comparable<Student> {

    private String name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public void addCourse(Course t) {
        if (!this.courses.contains(t)) {
            this.courses.add(t);
        }
        if (!t.getStudents().contains(this)) {
            t.getStudents().add(this);
        }
    }

    public Student() {
    }

    public Student(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", dateOfBirth=" + dateOfBirth + ", id=" + id + '}';
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /*
     * If this is equal that, return 0
     * If this is greater than that, return 1
     * If this is less than that, return -1
     */
    @Override
    public int compareTo(Student o) {
        if (this.name.equals(o.name)) {
            return 0;
        }
        return name.compareToIgnoreCase(o.name);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
