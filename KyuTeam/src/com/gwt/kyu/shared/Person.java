package com.gwt.kyu.shared;

import java.util.ArrayList;
public class Person {
	private String PersonName;
	private String PersonSurname;
	private String PersonMail;
	
	public String getPersonName() {
		return PersonName;
	}
	public void setPersonName(String personName) {
		PersonName = personName;
	}
	public String getPersonSurname() {
		return PersonSurname;
	}
	public void setPersonSurname(String personSurname) {
		PersonSurname = personSurname;
	}
	public String getPersonMail() {
		return PersonMail;
	}
	public void setPersonMail(String personMail) {
		PersonMail = personMail;
	}
	
	public ArrayList<Person> addPersonList(){
		Person person;
		ArrayList<Person> person_temp=new ArrayList<Person>();
		for(int i=1;i<5;i++){
			person = new Person();
			person.setPersonName("N"+i);
			person.setPersonSurname("S"+i);
			person.setPersonMail("0555789455"+i);
			person_temp.add(person);
		}
		return person_temp;
	}
}
