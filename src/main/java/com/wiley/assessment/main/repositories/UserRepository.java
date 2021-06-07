package com.wiley.assessment.main.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.assessment.main.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {

    // create Object Mapper
    ObjectMapper mapper = new ObjectMapper();

    public List<User> getAllUsers() {

        List<User> productList = null;

        // read JSON file and map/convert to java POJO
        try {
            File file = ResourceUtils.getFile("classpath:./static/user-list.json");
            productList = Arrays.asList(mapper.readValue(file, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public Optional<User> getUserByUsername(String username){
        return getAllUsers().stream().filter( u -> u.getUsername().equals(username)).findFirst();
    }
}
