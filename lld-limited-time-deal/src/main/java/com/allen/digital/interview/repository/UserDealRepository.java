package com.allen.digital.interview.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.allen.digital.interview.entity.UserDealDetails;

public interface UserDealRepository extends JpaRepository<UserDealDetails, Integer> {

  Optional<UserDealDetails> findByUserIdAndDealId(int userId, int dealId);

  List<UserDealDetails> findByDealId(int dealId);

}
