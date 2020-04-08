package com.swastik.spring_jpa2.dao;

import com.swastik.spring_jpa2.model.Post;
import com.swastik.spring_jpa2.model.Tag;
import com.swastik.spring_jpa2.service.PostRepository;
import com.swastik.spring_jpa2.service.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    public void savePost(Post post) {
         Set<Tag> tags = post.getTags();

        List<Tag> persistedTags = tagRepository.findAll();
        boolean tagPersited = false;

        for (Tag t : tags) {
            if (persistedTags.stream().filter(s -> s.getId().equals(t.getId())).findAny().isPresent()) {
                tagRepository.save(t);
                tagPersited = true;
            }
        }

        if (!tagPersited)
            postRepository.save(post);
    }


    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
