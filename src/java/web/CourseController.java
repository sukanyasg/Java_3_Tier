/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Student;
import domain.Teacher;
import domain.Course;
import ejb.StudentBean;
import ejb.TeacherBean;
import ejb.CourseBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sukanya
 */
@Named
@RequestScoped
public class CourseController extends AbstractController {

    private static final Logger LOG = Logger.getLogger(CourseController.class.getName());

    @Inject
    private CourseBean courseBean;
    @Inject
    private TeacherBean teacherBean;
    @Inject
    private StudentBean studentBean;
    @Inject
    LoginController loginController;

    private List<Course> courses;
    private Course course;

    public CourseController() {
    }

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        course = new Course();
        course.setTeacher(new Teacher());
        refreshCourseList();
    }

    private void refreshCourseList() {
        if (loginController.isStudent()) {
            courses = studentBean.findByUsername(loginController.getRemoteUser()).getCourses();
        } else if (loginController.isTeacher()) {
            courses = teacherBean.findByUsername(loginController.getRemoteUser()).getCourses();
        } else {
            courses = new ArrayList<>();
        }
    }

    public String getStudentDisplayNames(Course course) {
        List<String> authNames = new ArrayList<>();
        for (Student a : course.getStudents()) {
            authNames.add(a.getName());
        }
        return String.join(",", authNames);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String doUpdate(Course course) {
        this.course = course;
        return loginController.getPortalPathByRole() + "/updateCourse.xhtml";
    }

    public String executeUpdate() {
        LOG.info("About to update course" + course.toString());
        courseBean.update(course);
        refreshCourseList();
        return loginController.getPortalPathByRole() + "/welcome.xhtml";
    }

    public String doDelete(Course course) {
        LOG.info("About to delete course " + course.toString());
        courseBean.delete(course);
        refreshCourseList();
        return loginController.getPortalPathByRole() + "/welcome.xhtml";
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
