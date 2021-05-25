package com.stevens.spring_jpa2.main;

import com.stevens.spring_jpa2.config.JpaPersistance;
import com.stevens.spring_jpa2.dao.PostService;
import com.stevens.spring_jpa2.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner_1 {


    public static void main(String[] args) {

        try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(JpaPersistance.class);
            ctx.refresh();

            PostService postService = (PostService) ctx.getBean("postService");

            Post p1 = new Post("firstPost");
            Post p2 = new Post("secondPost");

            Tag t1 = new Tag("JV", "JAVA");
            Tag t2 = new Tag("MV", "Maven");

            Tag t3 = new Tag("JV", "JAVA");
            Tag t4 = new Tag("PY", "Python");

            p1.addTags(t1);
            p1.addTags(t2);

            p2.addTags(t3);
            p2.addTags(t4);

            postService.savePost(p1);
            postService.savePost(p2);

            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

