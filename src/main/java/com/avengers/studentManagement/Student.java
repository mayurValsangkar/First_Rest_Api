package com.avengers.studentManagement;

public class Student {

    private String name;
    private int age;
    private int admissionNo;
    private String state;

    public Student(String name, int age, int admissionNo, String state) {
        this.name = name;
        this.age = age;
        this.admissionNo = admissionNo;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(int admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
