package com.blogs.saulipartanen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.blogs.saulipartanen.data.Blog;
import com.blogs.saulipartanen.service.BlogService;
import com.blogs.saulipartanen.data.CourseData;
import com.blogs.saulipartanen.data.StudentCourse;
import com.blogs.saulipartanen.service.CourseService;

@RestController
public class BlogRestController {
    
    @Autowired
    BlogService myBlogService;
    @Autowired
    CourseService myCourseService;
    @Autowired
    StudentCourse myStudentCourseService;

    // tieto tulee code.js:stä ensimmäiksei controlleriin. Yksi
    // controller on vastuussa koko ohjelman kartoituksesta
    // täältä tieto liikkuu taas serviceen

    @GetMapping("blogs")
    public List<Blog> getBlogs(){
        return  myBlogService.getBlogs();
    }
    @GetMapping("blogs/{student}")
    public Blog getStudentBlogs(@PathVariable("student") int student){
        return myBlogService.getBlogsByStudent(student);
    }
    @PostMapping("addblog")
    public String addBlog(@RequestBody Blog blog){
        myBlogService.addBlog(blog);
        return "Oppilaan lisäys onnistui!";
    }
    @PostMapping("addbloginfo")
    public String addBlogInfo(@RequestParam String student, @RequestParam String email, @RequestParam String classYear){
        myBlogService.addBlog(new Blog(student, email, classYear));
        return "Oppilaan lisäys tietoineen onnistui!";
    }
    @GetMapping("courses")
    public List<CourseData> getCourses(){
        return  myCourseService.getCourses();
    }
    @GetMapping("courses/{courseId}")
    public CourseData getCourseByName(@PathVariable("courseId") int courseId){
        return myCourseService.getCourseByName(courseId);
    }
    @PostMapping("addcourse")
    public String addCourse(@RequestBody CourseData courseData){
        myCourseService.addCourse(courseData);
        return "";
    }
    @PostMapping("addcourseinfo")
    public String addCourseInfo(@RequestParam String courseName, @RequestParam String teacherName){
        myCourseService.addCourse(new CourseData(courseName, teacherName));
        return "";
    }
    @PostMapping("addcoursestudent")
    public Integer addStudentToCourse(@RequestBody StudentCourse studentCourse){
        myBlogService.addStudentToCourse(studentCourse.getUserId(), studentCourse.getCourseId()); 
        return 0;
    }
    @GetMapping("studentcourses/{userId}")
    public List<Integer> getStudentCourses(@PathVariable("userId") int userId){
        return myBlogService.getBlogListByStudent(userId);
    }

}
