# Programming_SpringBoot_GraphQL
Step-by-Step Learning for GraphQL with SpringBoot

- GraphQL LocalHost URL
  - http://localhost:8080/graphiql?path=/graphql

<hr>

- #### Query 
  - Getting all the Users and respective posts
    <br>
    query {
      findAllUsers {
        id,
        firstName,
        lastName,
        posts {
          id,
          comment
        }
      }
    }
  - Getting all the Users
    <br>
    query {
      findAllUsers {
          id,
          firstName,
          lastName,
      }
    }
  - Getting the count of all users
    <br> 
    query {
      countUsers
    }
  - Getting a User by ID
    <br>
    query {
      findUserById(id : 102) {
        id,
        firstName,
        lastName
      }
    }
  - Getting all the Posts
    <br>
    query { 
      findAllPosts {
        id,
        comment,
        user {
          id,
          firstName,
          lastName
        }
      }
    }

- #### Mutation
  - Create the User 
    <br>
    mutation {
     createUser(firstName: "Tom", lastName: "Jerry") {
      id, firstName, lastName
     }
    }
  - Update the User
    <br>
    mutation {
      updateUser(userId: 101, firstName: "Ananya", lastName: "Chauhan")
    }
  - Delete the User
    <br>
    mutation {
      deleteUser(userId: 101)
    }