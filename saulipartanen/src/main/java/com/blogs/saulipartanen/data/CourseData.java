package com.blogs.saulipartanen.data;

public class CourseData {
    private int courseId;
    private String courseName;
    private String teacherName;
    private static int count = 1;

    public CourseData(String courseName, String teacherName) {
        this.courseId = count++;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
