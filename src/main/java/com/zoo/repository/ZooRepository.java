package com.zoo.repository;

import com.zoo.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
    List<Zoo> findZooByZoonameEquals(String name);

    // this only deletes from courses where
    @Transactional
    @Modifying // I am going to change data, and change only this data
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteZooFromZooanimals(long zooid);
}
