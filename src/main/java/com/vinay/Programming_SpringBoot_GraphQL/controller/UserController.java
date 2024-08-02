package com.vinay.Programming_SpringBoot_GraphQL.controller;

import com.vinay.Programming_SpringBoot_GraphQL.domain.User;
import com.vinay.Programming_SpringBoot_GraphQL.resolver.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserResolver userResolver;

    // We need to annotate the handler methods with @QueryMapping annotation and place
    // this inside standard @Controller component. It will register the annotated classes
    // as data-fetching components in our GraphQL Application.
    @QueryMapping
    public String userGreetings() {
        return "GraphQL - Greetings";
    }

    @QueryMapping
    public User findUserById(@Argument Long id) {
        Optional<User> userObj = userResolver.findUserById(id);

        // Native way of returning the User instance.
        // if (userObj.isPresent())
        //    return userObj.get();
        // else
        //    return null;

        // Returning User using Functional Style Expression
        return userObj.orElse(null);
    }

    // By defining a method named findAllUsers annotated with @QueryMapping, this controller
    // declares how to fetch a Users as defined under the Query type.
    // Note:- Spring for GraphQL uses RuntimeWiring.Builder that registers each such controller
    // method as a graphql.schema.DataFetcher. A DataFetcher provides the logic to fetch the
    // data for a query or for any schema field. The Spring Boot starter for GraphQL has
    // auto-configurations that automates this registration.
    @QueryMapping
    public List<User> findAllUsers() {
        return userResolver.findAllUsers();
    }

    @QueryMapping
    public long countUsers() {
        return userResolver.countUsers();
    }

    @MutationMapping
    public User createUser(@Argument String firstName, @Argument String lastName) {
        return userResolver.createUser(firstName, lastName);
    }

    @MutationMapping
    public String updateUser(@Argument Long userId, @Argument String firstName, @Argument String lastName) {
        return userResolver.updateUser(userId, firstName, lastName);
    }

    @MutationMapping
    public String deleteUser(@Argument Long userId) {
        return userResolver.deleteUser(userId);
    }

}