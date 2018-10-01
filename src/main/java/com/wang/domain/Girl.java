package com.wang.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


/**
 * Created by wzh-zhua on 2018/10/1.
 */
@Entity     //表示对应数据库中的表，没有则会创建一个表
@Table(name = "girl")
public class Girl {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = true, length = 20)
    @NotBlank(message = "这个字段必传")
    private String name;

    //    @NotNull
    @Column(name = "age", nullable = true, length = 4)
    @Min(value = 18,message = "年龄需要大于18岁")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
