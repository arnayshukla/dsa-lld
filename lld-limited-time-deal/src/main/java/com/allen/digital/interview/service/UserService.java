package com.allen.digital.interview.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.allen.digital.interview.entity.User;
import com.allen.digital.interview.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User getUserById(int userId) throws Exception {
    Optional<User> user = userRepository.findById(userId);
    if (!user.isPresent()) {
      throw new Exception("User not found with id: " + userId);
    }
    return user.get();
  }

  
}
