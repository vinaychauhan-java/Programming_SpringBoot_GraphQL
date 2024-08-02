package com.vinay.Programming_SpringBoot_GraphQL.resolver;

import com.vinay.Programming_SpringBoot_GraphQL.domain.Post;
import com.vinay.Programming_SpringBoot_GraphQL.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQueryResolver {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

}
