package com.dariawan.userapp.entity;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
 
/*
 * You can annotate any field with @Getter and/or @Setter, to let lombok generate the default getter/setter automatically.
A default getter simply returns the field, and is named getFoo if the field is called foo 
(or isFoo if the field's type is boolean). A default setter is named setFoo if the field is called foo,
 returns void, and takes 1 parameter of the same type as the field. It simply sets the field to this value.

The generated getter/setter method will be public unless you explicitly specify an AccessLevel,
 as shown in the example below. Legal access levels are PUBLIC, PROTECTED, PACKAGE, and PRIVATE.

You can also put a @Getter and/or @Setter annotation on a class. In that case, it's as if you annotate 
all the non-static fields in that class with the annotation.
 */
@Entity @Table(name = "users", indexes = @Index(columnList = "email"))
@Getter @Setter @EqualsAndHashCode(of = {"email"}) @ToString
public class User implements Serializable {
    
    private static final long serialVersionUID = 63453822723859663L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String name;
    
    @NotNull
    @Column(unique = true)
    private String email;
    
    private String phone;
    private String address;
}