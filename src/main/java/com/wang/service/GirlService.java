package com.wang.service;

import com.wang.model.Girl;
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

}
