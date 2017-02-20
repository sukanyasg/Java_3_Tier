/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Student;
import domain.Credit;
import domain.Teacher;
import domain.Course;
import domain.security.Group;
import domain.security.User;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Sukanya
 */
@Singleton
@Startup
public class StartupBean {

    @EJB
    private GroupBean groupBean;
    @EJB
    private UserBean userBean;
    @EJB
    private CreditBean creditBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private StudentBean studentBean;
    @EJB
    private TeacherBean teacherBean;

    public StartupBean() {
    }

    @PostConstruct
    private void populateDatabase() {

        // groups
        Group teachersGroup = new Group("teachers", "Group of all teachers");
        Group studentsGroup = new Group("students", "Group of all students");

        // users
        User u1 = new User("tom", "tom");
        User u2 = new User("dick", "dick");
        User u3 = new User("harry", "harry");
        User u4 = new User("rob", "rob");
        User u5 = new User("sandi", "sandi");
        u1.addGroup(studentsGroup);
        u2.addGroup(studentsGroup);
        u3.addGroup(studentsGroup);
        u4.addGroup(teachersGroup);
        u5.addGroup(teachersGroup);

        // student entities
        Student s1 = new Student("Tom", new GregorianCalendar(1990, 9, 20).getTime());
        Student s2 = new Student("Dick", new GregorianCalendar(1991, 10, 11).getTime());
        Student s3 = new Student("Harry", new GregorianCalendar(1992, 11, 23).getTime());
        s1.setUser(u1);
        s2.setUser(u2);
        s3.setUser(u3);

        // teacher entities
        Teacher t1 = new Teacher("Rob");
        Teacher t2 = new Teacher("Sandi");
        t1.setUser(u4);
        t2.setUser(u5);

        // course entities
        Course c1 = new Course("Rich Internet Applications", new GregorianCalendar(2014, 2, 24).getTime(), 300);
        Course c2 = new Course("Advanced Database", new GregorianCalendar(2014, 3, 10).getTime(), 400);
        Course c3 = new Course("Networking", new GregorianCalendar(2014, 6, 12).getTime(), 500);
        c1.setTeacher(t1);
        c2.setTeacher(t1);
        c3.setTeacher(t2);
        c1.addStudent(s1);
        c2.addStudent(s2);
        c3.addStudent(s3);

        // Course 4 and set teacher relationship, and add students
        Course c4 = new Course("Big Data", new GregorianCalendar(2014, 4, 2).getTime(), 600);
        c4.setTeacher(t2);
        c4.addStudent(s2);
        c4.addStudent(s3);
        
        // credit entities
        Credit cr1 = new Credit("Classroom", 4);
        Credit cr2 = new Credit("Classroom", 3);
        Credit cr3 = new Credit("Lab", 3);
        Credit cr4 = new Credit("Lab", 2);
        Credit cr5 = new Credit("Classroom", 4);
        c1.addCredit(cr1);
        c2.addCredit(cr2);
        c3.addCredit(cr3);
        c3.addCredit(cr4);
        c4.addCredit(cr5);

        groupBean.create(studentsGroup);
        groupBean.create(teachersGroup);
        userBean.create(u1);
        userBean.create(u2);
        userBean.create(u3);
        userBean.create(u4);
        userBean.create(u5);
        studentBean.create(s1);
        studentBean.create(s2);
        studentBean.create(s3);
        teacherBean.create(t1);
        teacherBean.create(t2);
        courseBean.create(c1);
        courseBean.create(c2);
        courseBean.create(c3);
        courseBean.create(c4);
        creditBean.create(cr1);
        creditBean.create(cr2);
        creditBean.create(cr3);
        creditBean.create(cr4);
        creditBean.create(cr5);
        
    }
}
