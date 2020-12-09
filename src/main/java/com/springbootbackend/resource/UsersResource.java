package com.springbootbackend.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springbootbackend.model.Users;
import com.springbootbackend.repository.UsersRepository;
import com.springbootbackend.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsersService usersService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private static final Logger log = LoggerFactory.getLogger(UsersResource.class);


    @GetMapping(value = "/users")
    public List<Users> listUsers() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/register")
    public List<Users> addUsers(@Validated @RequestBody Users users) {
        usersRepository.save(users);
        return usersRepository.findAll();
    }

    @GetMapping("/data")
    public String getFromUrl() throws JsonProcessingException {
        return restTemplate.getForObject("https://services.odata.org/V3/Northwind/Northwind.svc/Customers",
                String.class);
    }


    @PostMapping(value = "/authenticate")
    public String userAuthenticate(@Validated @RequestBody Users users) {
        try {
            log.info("authenticate request");
            return usersService.userAuthenticate(users);
        } catch (NullPointerException e) {
            log.error(String.format("auth req exception - %s", e.getLocalizedMessage()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "auth failed");
        }
    }


//    @GetMapping(value = "/greeting")
//    public String addUser(@RequestHeader("Authorization") String jwt) {
//        try {
//            log.info("add users");
//            return usersService.addUser(jwt);
//        } catch (NullPointerException e) {
//            log.error(String.format("add user req exception - %s", e.getLocalizedMessage()));
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "auth failed");
//        }
//    }

    @GetMapping(value = "/greeting")
    public String addUser(@RequestHeader("Authorization") String jwt) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("Content-Type", "application/json");
            headers.add("Authorization", jwt);
            HttpEntity entity = new HttpEntity(headers);
            String url = "https://spring-boot-jwt.herokuapp.com/greeting";
         //   ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch(NullPointerException | DataAccessException e) {
            log.error(String.format("add user req exception - service", e.getLocalizedMessage()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "auth failed service");
        }
    }

}
