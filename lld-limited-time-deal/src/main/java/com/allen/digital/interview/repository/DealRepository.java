package com.allen.digital.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.allen.digital.interview.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Integer>{

}
