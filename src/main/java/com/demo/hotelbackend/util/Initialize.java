package com.demo.hotelbackend.util;

import com.demo.hotelbackend.Interface.typeRoomRepository;
import com.demo.hotelbackend.Interface.userRepository;
import com.demo.hotelbackend.Model.Collections.TypeRoom;
import com.demo.hotelbackend.Model.Collections.user;
import com.demo.hotelbackend.constants.enums;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Initialize implements CommandLineRunner {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private typeRoomRepository typeRoomRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${password}")
    private String password;

    @Override
    public void run(String... args) throws Exception {
        if (typeRoomRepository.findAll().toStream().count() == 0) {
            typeRoomRepository.save(new TypeRoom("DOBLE")).subscribe();
            typeRoomRepository.save(new TypeRoom("SIMPLE")).subscribe();
            typeRoomRepository.save(new TypeRoom("FAMILIAR")).subscribe();
            typeRoomRepository.save(new TypeRoom("MATRIMONIAL")).subscribe();
        }
        if (userRepository.findAll().count().block() == 0) {
            Set<String> roles = new HashSet<>();
            roles.add(enums.ROLE_ADMIN.name());

            user useradmin = new user(
                "Jackeline",
                "Picoy Rosas",
                "941472816",
                "Jpicoyrosas@gmail.com",
                passwordEncoder.encode(password),
                "data:image/png;base64,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",
                roles
            );
            userRepository.save(useradmin).subscribe();
        }
    }
}
