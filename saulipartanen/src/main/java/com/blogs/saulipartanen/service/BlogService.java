package com.blogs.saulipartanen.service;
import com.blogs.saulipartanen.data.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();

    // service-tiedostot välittävät tietoa edelleen luokkiin itseensä.
    // Esimerkiksi alla oleva addBlog ottaa sisäänsä blog-nimisen olion
    // ja lähettää sen Blog-luokkaan. Näin tehdään uusi olio
    // blog-olio on opiskelija tässä tapauksessa

    public void addBlog(Blog blog){
        blogs.add(blog);
    }
    public void addStudentToCourse(int userId, int courseId){
        for (Blog blog : blogs) {
            if(userId == blog.getUserId()){
                blog.setStudentToCourse(courseId);
            }           
        }
    }
    public List<Blog> getBlogs(){
        return new ArrayList<>(blogs); //tehdaan kopio blog-listasta, ettei kayttaja voi muuttaa alkuperaista
    }
    public Blog getBlogsByStudent(int userId){
        for (Blog blog : blogs) {
            if(userId == blog.getUserId()){
                return blog;
            }           
        }
        return null;
    }
    public List<Integer> getBlogListByStudent(int userId){
        for (Blog blog : blogs) {
            if(userId == blog.getUserId()){
                return blog.getStudentToCourse();
            }           
        }
        return null;
    }
}
