package com.spring.data.jpa.tutorial.repository;

import com.spring.data.jpa.tutorial.entity.CheckUpRq;
import com.spring.data.jpa.tutorial.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CheckUpRepo extends JpaRepository<CheckUpRq,Integer> {
    List<CheckUpRq> findByStatus(Status status);

    CheckUpRq findPatientById(Integer id);

    @Modifying
    @Transactional
    @Query("update CheckUpRq set status = '%s' where name='%s'")
    void update(@Param("status") CheckUpRq status);

}
