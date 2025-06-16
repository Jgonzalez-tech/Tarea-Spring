package com.project.demo.logic.entity.rol;

import com.project.demo.logic.entity.user.User;
import com.project.demo.logic.entity.user.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Order(2)
@Component
public class UserSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserSeeder(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createUserIfNotExists("Super", "Admin", "super.admin@gmail.com", "superadmin123", RoleEnum.SUPER_ADMIN);
        createUserIfNotExists("Normal", "User", "user@gmail.com", "user123", RoleEnum.USER);
    }

    private void createUserIfNotExists(String name, String lastname, String email, String rawPassword, RoleEnum roleEnum) {
        Optional<Role> role = roleRepository.findByName(roleEnum);
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (role.isEmpty() || userOpt.isPresent()) {
            return;
        }

        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role.get());

        userRepository.save(user);
    }
}
