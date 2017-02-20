/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Sukanya
 */
@Entity
@NamedQuery(name = "Course.findAll", query = "select t from Course t")
public class Course extends CommonEntity implements Serializable {

    private String title;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegistered;
    private Integer courseId;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL)
    private List<Credit> credits = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public void addStudent(Student a) {
        if (!this.students.contains(a)) {
            this.students.add(a);
        }
        if (!a.getCourses().contains(this)) {
            a.getCourses().add(this);
        }
    }

    public void addCredit(Credit c) {
        if (!this.credits.contains(c)) {
            this.credits.add(c);
        }
        if (c.getCourse() != this) {
            c.setCourse(this);
        }
    }

    public Course(String title, Date dateRegistered, Integer courseId) {
        this.title = title;
        this.dateRegistered = dateRegistered;
        this.courseId = courseId;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", dateRegistered=" + dateRegistered + ", courseId=" + courseId + ", id=" + id + '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        // set the teacher of this course
        this.teacher = teacher;

        // and if the teacher list of courses does not yet contain this
        // course, add it to the list
        if (!teacher.getCourses().contains(this)) {
            teacher.getCourses().add(this);
        }
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
