package com.example.schoolapp;

public class StudentModel {
    private String   rollNo;
    private String name;
    private String Father;
    private String Mother;
    private String phone;
    private String age;
    private String email;
    private String address;

    public StudentModel(String rollNo, String name, String father, String  mother, String phone, String age, String email, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.Father = father;
        this.Mother = mother;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", Father='" + Father + '\'' +
                ", Mother='" + Mother + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return Father;
    }

    public void setFather(String father) {
        Father = father;
    }

    public String getMother() {
        return Mother;
    }

    public void setMother(String mother) {
        Mother = mother;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String  rollNo) {
        this.rollNo = rollNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
