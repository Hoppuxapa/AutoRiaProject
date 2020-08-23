package com.boots.service;


import com.boots.repository.UserRepository;
import com.boots.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUsers(User users) {
        userRepository.save(users);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findAllByName(username);
    }

  /*  public void saveUser(User user, String username, Map<String, String> form) {
        user.setFirstName(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getUserRole().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getUserRole().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);
    }*/

}