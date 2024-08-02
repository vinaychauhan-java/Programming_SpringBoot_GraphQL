package com.vinay.Programming_SpringBoot_GraphQL.resolver;

import com.vinay.Programming_SpringBoot_GraphQL.domain.User;
import com.vinay.Programming_SpringBoot_GraphQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserResolver {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public long countUsers() {
        return userRepository.count();
    }

    public User createUser(String fName, String lName) {
        User userObj = User.builder().firstName(fName).lastName(lName).build();
        userRepository.save(userObj);
        return userObj;
    }

    public String updateUser(Long userId, String fName, String lName) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User userObj = existingUser.get();
            userObj.setFirstName(fName);
            userObj.setLastName(lName);
            userRepository.save(userObj);
            return "User Updated Successfully";
        } else {
            return "User Record Not Found";
        }
    }

    public String deleteUser(Long userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return "User Deleted Successfully";
        } else {
            return "User Record Not Found";
        }
    }

}
