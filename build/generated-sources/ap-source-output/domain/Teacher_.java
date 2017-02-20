package domain;

import domain.Course;
import domain.security.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-12-12T15:18:57")
@StaticMetamodel(Teacher.class)
public class Teacher_ extends CommonEntity_ {

    public static volatile ListAttribute<Teacher, Course> courses;
    public static volatile SingularAttribute<Teacher, String> name;
    public static volatile SingularAttribute<Teacher, User> user;

}