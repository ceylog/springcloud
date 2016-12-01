package org.wg.springcloud.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wg.springcloud.model.User;

/**
 * @Author Sam Wang
 * @Date 2016/12/1.
 * @Version 0.0.1
 */
@RefreshScope
@RestController
public class RestAPIController {

    private final Logger logger = Logger.getLogger(getClass());

    private static User user;

    public RestAPIController(){
        user = new User();
        user.setName("abcda");
        user.setPhone("123434444");
    }

    @Autowired
    private DiscoveryClient client;

    @Value("${from}")
    private String from;


    @RequestMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @RequestMapping(value = "/from")
    public String getFrom(){
        return from;
    }

    @RequestMapping("/user")
    public User getUser(){
        return user;
    }
}
