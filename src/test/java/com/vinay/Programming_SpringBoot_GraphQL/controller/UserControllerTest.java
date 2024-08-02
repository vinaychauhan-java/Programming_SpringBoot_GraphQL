package com.vinay.Programming_SpringBoot_GraphQL.controller;

import com.vinay.Programming_SpringBoot_GraphQL.domain.User;
import com.vinay.Programming_SpringBoot_GraphQL.resolver.UserResolver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@AutoConfigureHttpGraphQlTester
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    UserResolver userResolver;

    @Test
    void testFindUserById() {
        String userGreetings = graphQlTester.document("{\n" +
                        "  userGreetings\n" +
                        "}")
                .execute()
                .path("userGreetings")
                .entity(String.class)
                .get();
        Assert.assertEquals("GraphQL - Greetings", userGreetings);
    }

    @Test
    public void testFindAllUsers() {
        when(userResolver.findAllUsers()).thenReturn(List.of(User.builder()
                .id(101L)
                .firstName("Vinay")
                .lastName("Chauhan")
                .build()));
        graphQlTester.document("""
                        {
                          findAllUsers {
                            id,
                            firstName,
                            lastName
                          }
                        }
                        """)
                .execute()
                .path("findAllUsers")
                .matchesJson("""
                        [{
                             "id": "101",
                             "firstName": "Vinay",
                             "lastName": "Chauhan"
                         }]
                        """);
        Mockito.verify(userResolver, times(1)).findAllUsers();
    }

}
