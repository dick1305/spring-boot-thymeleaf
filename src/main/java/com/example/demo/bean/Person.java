package com.example.demo.bean;

public class Person {
 private String name;
 public Person(String name, Integer age) {
	super();
	this.name = name;
	this.age = age;
}
private Integer age;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
 
}
