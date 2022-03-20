package com.blogs.saulipartanen.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.blogs.saulipartanen.data.StudentCourse;

@Service
public class StudentCourseService {

    // studentcourseservice tehtiin sitä varten, että opiskelijoita
    // voi sijoittaa kursseihin. 
    
    private List<StudentCourse> studentcourses = new ArrayList<>();

    public List<StudentCourse> getStudentCourses(){
        return new ArrayList<>(studentcourses);
    }
    public StudentCourse addStudentToCourse(int userId, int courseId){
        for (StudentCourse studentCourse : studentcourses) {
            if(userId == studentCourse.getUserId() && courseId == studentCourse.getCourseId()){
                return studentCourse;
            }           
        }
        return null;
    }
}