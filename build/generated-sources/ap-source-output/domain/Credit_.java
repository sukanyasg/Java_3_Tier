package domain;

import domain.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-12-12T15:18:57")
@StaticMetamodel(Credit.class)
public class Credit_ extends CommonEntity_ {

    public static volatile SingularAttribute<Credit, Integer> noOfCredits;
    public static volatile SingularAttribute<Credit, Course> course;
    public static volatile SingularAttribute<Credit, String> type;

}