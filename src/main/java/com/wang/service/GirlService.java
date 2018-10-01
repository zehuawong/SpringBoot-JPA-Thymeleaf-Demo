package com.wang.service;

import com.wang.domain.Girl;
import com.wang.enums.ResultEnum;
import com.wang.exception.GirlException;
import com.wang.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by wzh-zhua on 2018/10/1.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional  //数据库事务注解
    public void insertTwo() {
        Girl girlA=new Girl();
        girlA.setName("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setName("B");
        girlB.setAge(19);

        girlRepository.save(girlB);

    }

    public void getAge(Long id) throws Exception{   //逻辑判断
        Girl girl = findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Long id) {
        return girlRepository.findById(id).orElse(null);
    }


}
