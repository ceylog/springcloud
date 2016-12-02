package org.wg.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Sam Wang
 * @Date 2016/12/1.
 * @Version 0.0.1
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddService addService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://API-SERVICE/add?a=10&b=20", String.class).getBody();
    }
    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public String add1(){
        return addService.add(1,2);
    }

}
