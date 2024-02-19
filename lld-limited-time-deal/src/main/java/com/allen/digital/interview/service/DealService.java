package com.allen.digital.interview.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.allen.digital.interview.dto.ClaimDealDto;
import com.allen.digital.interview.entity.Deal;
import com.allen.digital.interview.entity.User;
import com.allen.digital.interview.entity.UserDealDetails;
import com.allen.digital.interview.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealService {

  private final DealRepository dealRepository;

  private final UserService userService;

  private final UserDealService userDealService;

  public Deal saveDeal(Deal deal) {
    log.info("enter saveDeal");
    return dealRepository.save(deal);
  }

  public Deal updateDeal(Deal deal) throws Exception {
    log.info("enter updateDeal");
    Optional<Deal> dealOptional = dealRepository.findById(deal.getId());
    if (!dealOptional.isPresent()) {
      throw new Exception("Deal not found with id: " + deal.getId());
    }
    log.info("exit saveDeal");
    return saveDeal(deal);
  }

  public Deal endDeal(Integer dealId) throws Exception {
    log.info("enter endDeal");
    Deal deal = getDealById(dealId);
    deal.setActive(false);
    log.info("exit endDeal");
    return saveDeal(deal);
  }

  public Deal getDealById(Integer dealId) throws Exception {
    log.info("enter getDealById");
    Optional<Deal> deal = dealRepository.findById(dealId);
    if (!deal.isPresent()) {
      throw new Exception("Deal not found with id: " + dealId);
    }
    log.info("exit getDealById");
    return deal.get();
  }

  public UserDealDetails claimDeal(ClaimDealDto dto) throws Exception {
    log.info("enter claimDeal");
    Deal deal = getDealById(dto.getDealId());
    User user = userService.getUserById(dto.getUserId());
    validateDeal(user, deal, dto);
    UserDealDetails userDeal = processDeal(user, deal, dto);
    log.info("exit claimDeal");
    return userDeal;
  }

  private void validateDeal(User user, Deal deal, ClaimDealDto dto) throws Exception {
    log.info("enter validateDeal");
    if (!deal.getActive()) {
      throw new Exception("Deal has been ended");
    }
    if ((LocalDateTime.now()).isAfter(deal.getEndTime())) {
      throw new Exception("Deal has expired");
    }
    List<UserDealDetails> claimedDeals = userDealService.getClaimedDealsById(dto.getDealId());
    if (!(claimedDeals.size() < deal.getMaxAllowedQty())) {
      deal.setActive(false);
      saveDeal(deal);
      throw new Exception("Deal has been fully claimed.");
    }
    Optional<UserDealDetails> userDeal = userDealService.getUserDealDetails(dto.getUserId(), dto.getDealId());
    if (userDeal.isPresent()) {
      throw new Exception("User has already claimed this deal");
    }
    log.info("exit validateDeal");
  }

  private UserDealDetails processDeal(User user, Deal deal, ClaimDealDto dto) {
    log.info("enter processDeal");
    UserDealDetails userDeal = new UserDealDetails(null, user.getId(), deal.getId());
    userDeal = userDealService.save(userDeal);
    log.info("exit processDeal");
    return userDeal;
  }
}
