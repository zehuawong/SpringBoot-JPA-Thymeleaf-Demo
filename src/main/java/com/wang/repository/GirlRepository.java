package com.wang.repository;

import com.wang.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wzh-zhua on 2018/10/1.
 */
public interface GirlRepository extends JpaRepository<Girl,Long> {
    List<Girl> findGirlByAge(Integer id);
}
