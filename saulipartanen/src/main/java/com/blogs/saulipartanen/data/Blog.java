package com.blogs.saulipartanen.data;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private String student;
    private String email;
    private String classYear;
    private int userId;
    private static int count = 1;
    private List<Integer> studentCourses = new ArrayList<>();

    // datakansion luokat blog, coursedata ja studentcourse ovat nimensä mukaan
    // datalle. Eli täällä on säännöt ja konstruktorit siitä, kuinka uusia olioita
    // luodaan ja kuinka niihin pääsee käsiksi. Esim alla on ohjeet siihen, miten
    // uusi opiskelija/blogi tehdään. Siihen tarvitsee kolme string-arvoa

    public Blog(String student, String email, String classYear) {
        this.student = student;
        this.email = email;
        this.classYear = classYear;
        this.userId  = count++;
    }
    public void setStudentToCourse(int courseId){
        if (studentCourses.contains(courseId)) 
            return;
            
        studentCourses.add(courseId);
    }
    public List<Integer> getStudentToCourse(){
        return this.studentCourses;
    }
    public int getUserId() {
        return this.userId;
    }

    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassYear() {
        return this.classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public Blog student(String student) {
        setStudent(student);
        return this;
    }

    public Blog email(String email) {
        setEmail(email);
        return this;
    }

    public Blog classYear(String classYear) {
        setClassYear(classYear);
        return this;
    }
}
