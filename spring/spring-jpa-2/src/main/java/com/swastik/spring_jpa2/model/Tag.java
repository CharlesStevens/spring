package com.swastik.spring_jpa2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    private String id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
    private Set<Post> posts = new HashSet<>();

    public Tag() {
    }

    public Tag(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        if (!this.posts.contains(post)) {
            this.posts.add(post);
            post.addTags(this);
        }
    }
}
