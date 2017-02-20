/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author Sukanya
 */
@Entity
@NamedQuery(name = "Credit.findAll", query = "select c from Credit c")
public class Credit extends CommonEntity implements Serializable {

    private String type;
    private Integer noOfCredits;

    @ManyToOne
    private Course course;

    public Credit() {
    }

    public Credit(String type, Integer noOfCredits) {
        this.type = type;
        this.noOfCredits = noOfCredits;
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Integer getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(Integer noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    @Override
    public String toString() {
        return "Credit{" + "type=" + type + ", noOfCredits=" + noOfCredits + ", id=" + id + '}';
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        // set the course for this credit
        this.course = course;

        // and, if the list of credits for the course does not contain this
        // credit yet, add it to the list.
        if (!course.getCredits().contains(this)) {
            course.getCredits().add(this);
        }
    }

}
