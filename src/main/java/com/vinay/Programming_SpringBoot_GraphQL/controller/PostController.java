package com.vinay.Programming_SpringBoot_GraphQL.controller;

import com.vinay.Programming_SpringBoot_GraphQL.domain.Post;
import com.vinay.Programming_SpringBoot_GraphQL.resolver.PostQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostQueryResolver postQueryResolver;

    @QueryMapping
    public List<Post> findAllPosts() {
        return postQueryResolver.findAllPosts();
    }

}
