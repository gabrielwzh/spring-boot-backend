package com.springbootbackend.fe_trade.stockinfo;

import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/fetrade")
public class FeTradeInfoResource {

    @Autowired
    FeTradeInfoRepository feTradeInfoRepository;

//    @Autowired
//    private RestTemplate feTradeRestTemplate;

//    @Autowired
//    private FeTradeInfoService feTradeInfoService;

//    @Bean
//    public RestTemplate feTradeRestTemplate() {
//        return new RestTemplate();
//    }

    private static final Logger log = LoggerFactory.getLogger(FeTradeInfoResource.class);

    @GetMapping(value = "/stockinfo")
    public List<FeTradeInfoEntity> listFeTradeInfo() {
        return feTradeInfoRepository.findAll();
    }

//    @PostMapping(value = "/register")
//    public List<UsersEntity> addUsers(@Validated @RequestBody UsersEntity users) {
//        usersRepository.save(users);
//        return usersRepository.findAll();
//    }
}
