
package org.example.service;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String addUser(UserDTO dto) {
        if (!dto.getLogin().isEmpty() && dto.getPassword().length() > 4) {
            User user = new User();
            user.setUser_name(dto.getUser_name());
            user.setUser_login(dto.getLogin());
            user.setUser_password(dto.getPassword());
            userRepository.save(user);
        }
        return "succes";
    }
}
