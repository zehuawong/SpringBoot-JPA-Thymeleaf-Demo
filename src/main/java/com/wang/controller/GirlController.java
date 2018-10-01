package com.wang.controller;

import com.wang.domain.Girl;
import com.wang.domain.Result;
import com.wang.repository.GirlRepository;
import com.wang.service.GirlService;
import com.wang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     * 查询一个女生信息
     * @param id
     * @return
     */
    @GetMapping(path = "findgirl/{id}")
    public Girl findOneGirl(@PathVariable("id") Long id){

        return girlRepository.findById(id).orElse(null);
    }


    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(path = "girllist")
    public List<Girl> listAllGirl( ) {

        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
//    @PostMapping(path = "addgirl")
//    public Girl addGirl(@RequestParam("name") String name, @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setAge(age);
//        girl.setName(name);
//        girlRepository.save(girl);
//        return girl;
//    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/addgirl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        //假如表单参数很多，用@RequestParam方式就不合适了
         //这里需要做表单验证
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));

    }

    @DeleteMapping(path = "deletegirl")
    public void deleteGirl(Long id) {
        girlRepository.deleteById(id);
    }

    /**
     * 事务管理测试
     */
    @RequestMapping(value = "inserttwo")
    public void insertTwo() {
        girlService.insertTwo();
    }

}
