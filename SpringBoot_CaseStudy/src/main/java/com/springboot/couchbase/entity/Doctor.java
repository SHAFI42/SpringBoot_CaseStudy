package com.springboot.couchbase.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//lombok annotations

@NoArgsConstructor
@AllArgsConstructor

// identified the domain object to be persisted to couchbase
@Document
public class Doctor {

    //identifies a field which will not be stored in the couchbase document but rather
    //used an document id
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    String docid;
    //denotes a field which in the couchbase document
    @Field(value = "full_name")
    String fullName;
    @Field
    int age;
    @Field
    String email;
//    @Field(value = "phone_number")
//    String phoneNumber;
//    @Field
//    String address;
//    @Field(value = "work_department")
//    String workDepartment;
    
	public String getId() {
		return docid;
	}
	public void setId(String id) {
		this.docid = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String mail) {
		this.email = mail;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", fullName=" + fullName + ", age=" + age + ", email=" + email + "]";
	}
	
	
}
