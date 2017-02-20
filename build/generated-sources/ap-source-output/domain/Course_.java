package domain;

import domain.Credit;
import domain.Student;
import domain.Teacher;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-12-12T15:18:57")
@StaticMetamodel(Course.class)
public class Course_ extends CommonEntity_ {

    public static volatile SingularAttribute<Course, Teacher> teacher;
    public static volatile ListAttribute<Course, Credit> credits;
    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, String> title;
    public static volatile SingularAttribute<Course, Integer> courseId;
    public static volatile SingularAttribute<Course, Date> dateRegistered;

}