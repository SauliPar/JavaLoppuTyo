package com.blogs.saulipartanen.data;

import org.springframework.stereotype.Service;

@Service
public class StudentCourse {
    private int userId;
    private int courseId;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
