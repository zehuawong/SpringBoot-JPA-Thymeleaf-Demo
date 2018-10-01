package com.wang.controller;

import com.wang.model.Girl;
import com.wang.repository.GirlRepository;
import com.wang.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wzh-zhua on 2018/10/1.
 */
@RestController
@RequestMapping("girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(path = "getgirlbyname/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findGirlByAge(age);
    }

    @GetMapping(path = "findgirl/{id}")
    public Girl findOneGirl(@PathVariable("id") Long id){

        return girlRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "girllist")
    public List<Girl> getGirl( ) {

        return girlRepository.findAll();
    }


    @PostMapping(path = "addgirl")
    public Girl addGirl(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        girlRepository.save(girl);

        return girl;
    }

    @DeleteMapping(path = "deletegirl")
    public void deleteGirl(Long id) {
        girlRepository.deleteById(id);
    }

    @RequestMapping(value = "inserttwo")
    public void insertTwo() {
        girlService.insertTwo();
    }

}
