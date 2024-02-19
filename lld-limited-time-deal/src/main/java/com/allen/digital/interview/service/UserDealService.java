package com.allen.digital.interview.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.allen.digital.interview.entity.UserDealDetails;
import com.allen.digital.interview.repository.UserDealRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDealService {

  private final UserDealRepository userDealRepository;

  public Optional<UserDealDetails> getUserDealDetails(int userId, int dealId) throws Exception {
    return userDealRepository.findByUserIdAndDealId(userId, dealId);
  }

  public List<UserDealDetails> getClaimedDealsById(int dealId) {
    return userDealRepository.findByDealId(dealId);
  }

  public UserDealDetails save(UserDealDetails userDeal) {
    return userDealRepository.save(userDeal);
  }
}
