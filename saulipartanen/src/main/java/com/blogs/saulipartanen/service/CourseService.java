package com.blogs.saulipartanen.service;
import com.blogs.saulipartanen.data.CourseData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    // courseservice tekee samaa kuin blogservice, mutta
    // kursseille
    
    private List<CourseData> courseDatas = new ArrayList<>();

    public void addCourse(CourseData courseData){
        courseDatas.add(courseData);
    }
    public List<CourseData> getCourses(){
        return new ArrayList<>(courseDatas);
    }
    public CourseData getCourseByName(int courseId){
    
        for (CourseData courseData : courseDatas) {
            if(courseId == courseData.getCourseId()){
                return courseData;
            }           
        }
        return null;
    }
}
