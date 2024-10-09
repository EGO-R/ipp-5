package org.java4me.ipp5.service;

import lombok.RequiredArgsConstructor;
import org.java4me.ipp5.entity.User;
import org.java4me.ipp5.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setUsername(user.getUsername());
                    user1.setRole(user.getRole());
                    return user1;
                })
                .map(userRepository::saveAndFlush);
    }

    @Transactional
    public Optional<User> delete(Long id) {
        return  userRepository.findById(id)
                        .map(user -> {
                            userRepository.delete(user);
                            return user;
                        });
    }
}
