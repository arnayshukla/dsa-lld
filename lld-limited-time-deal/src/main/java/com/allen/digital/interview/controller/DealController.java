package com.allen.digital.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.allen.digital.interview.dto.ClaimDealDto;
import com.allen.digital.interview.entity.Deal;
import com.allen.digital.interview.entity.UserDealDetails;
import com.allen.digital.interview.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/deals")
@RequiredArgsConstructor
@Slf4j
public class DealController {

  private final DealService dealService;

  @PostMapping("/create")
  ResponseEntity<?> createDeal(@RequestBody Deal deal) {
    try {
      log.info("create deal request received with data: {}", deal);
      Deal savedDeal = dealService.saveDeal(deal);
      log.info("deal created successfully with id: {}", savedDeal.getId());
      return new ResponseEntity<Deal>(savedDeal, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Exception occured in create deal: {}", e.getMessage());
      return new ResponseEntity<String>("Exception occured in creating the deal: " + e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/update")
  ResponseEntity<?> updateDeal(@RequestBody Deal deal) {
    try {
      log.info("update deal request received with data: {}", deal);
      Deal savedDeal = dealService.updateDeal(deal);
      log.info("deal updated successfully with id: {}", savedDeal.getId());
      return new ResponseEntity<Deal>(savedDeal, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Exception occured in update deal: {}", e.getMessage());
      return new ResponseEntity<String>("Exception occured in updating the deal: " + e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/end/{dealId}")
  ResponseEntity<?> updateDeal(@PathVariable Integer dealId) {
    try {
      log.info("end deal request received with dealId: {}", dealId);
      Deal savedDeal = dealService.endDeal(dealId);
      log.info("deal with id {} has been ended successfully");
      return new ResponseEntity<Deal>(savedDeal, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Exception occured in end deal: {}", e.getMessage());
      return new ResponseEntity<String>("Exception occured in ending the deal: " + e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/claim")
  ResponseEntity<?> claimDeal(@RequestBody ClaimDealDto claimDeal) {
    try {
      log.info("claim deal request received with data: {}", claimDeal);
      UserDealDetails userDeal = dealService.claimDeal(claimDeal);
      log.info("deal with id {} has been claimed by user with id {}", claimDeal.getDealId(), claimDeal.getUserId());
      return new ResponseEntity<UserDealDetails>(userDeal, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Exception occured in claim deal: {}", e.getMessage());
      return new ResponseEntity<String>("Exception occured in claiming the deal: " + e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
