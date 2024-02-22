/*
 * package com.api.service;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.api.model.User; import com.api.repository.UserRepository;
 * 
 * @Service public class UserService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * public List<User> findAll() { Iterable<User> users =
 * userRepository.findAll(); ArrayList<User> userList = new ArrayList<>();
 * users.forEach(e -> userList.add(e));
 * 
 * return userList; }
 * 
 * }
 */