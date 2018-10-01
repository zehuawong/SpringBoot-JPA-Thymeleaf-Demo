package com.wang.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wzh-zhua on 2018/9/30.
 */

@Component //如果使用@Autowired还需要使用@Component
@ConfigurationProperties(prefix = "girl")   //前缀属性是girl的映射到这个类
public class GirlProperties {
    private String cupSize;

    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
