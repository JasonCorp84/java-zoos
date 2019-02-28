package com.zoo.repository;

import com.zoo.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long> {

}
