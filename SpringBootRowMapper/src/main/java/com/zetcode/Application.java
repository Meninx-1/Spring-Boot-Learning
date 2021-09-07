package com.zetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/* in eclipse you have to enable preview features via the menu:
window > preferences > java > compile 

	Java 14 is out and Eclipse JDT supports Java 14 for 4.16.
	
The release notably includes the following Java 14 features:

JEP 361: Switch Expressions (Standard)
JEP 359: Records (Preview)
JEP 368: Text Blocks (Second Preview)
JEP 305: Pattern Matching for Instanceof (Preview)

Please note that the enable preview features option should be on for preview language features. 
For an informal introduction of the support, please refer to the Java 14 Examples wiki.
*/