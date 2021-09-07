package com.zetcode.conf;

import com.zetcode.model.Manager;
import com.zetcode.model.Person;
import com.zetcode.model.Student;
import com.zetcode.qualifier.PersonQ;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonFactory {

	// note there is no @Bean the bean is created using the @component in other files here only the identification
    @PersonQ("student")
    public Person createStudent() {

        return new Student();
    }

    @PersonQ("manager")
    public Person createManager() {

        return new Manager();
    }
}