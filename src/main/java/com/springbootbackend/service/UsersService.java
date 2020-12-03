package com.springbootbackend.service;

import com.springbootbackend.model.Users;
import com.springbootbackend.resource.UsersResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;


@Service
public class UsersService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(UsersResource.class);

//    public ResponseModel userAuthenticate(Users users) {
//        try {
//            log.info("authenticate request service");
//            HttpHeaders headers = new HttpHeaders();
//            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//            headers.add("Content-Type", "application/json");
//            HttpEntity<Users> entity = new HttpEntity<Users>(users, headers);
//            String url = "https://spring-boot-jwt.herokuapp.com/authenticate";
//            ResponseEntity<ResponseModel> response = restTemplate.postForEntity(url, entity, ResponseModel.class);
//            return response.getBody();
//        } catch(NullPointerException | DataAccessException e) {
//            log.error(String.format("auth req exception - service", e.getLocalizedMessage()));
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "auth failed service");
//        }
//    }

    public String userAuthenticate(Users users) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("Content-Type", "application/json");
            HttpEntity<Users> entity = new HttpEntity<Users>(users, headers);
            String url = "https://spring-boot-jwt.herokuapp.com/authenticate";
            return restTemplate.postForObject(url, entity, String.class);
//            ResponseEntity<ResponseModel> response = restTemplate.postForEntity(url, entity, ResponseModel.class);
        } catch(NullPointerException | DataAccessException e) {
            log.error(String.format("auth req exception - service", e.getLocalizedMessage()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "auth failed service");
        }
    }
}