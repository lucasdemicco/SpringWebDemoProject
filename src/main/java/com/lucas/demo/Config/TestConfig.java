package com.lucas.demo.Config;

import com.lucas.demo.Entities.User;
import com.lucas.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "1234", "99999");
        User usuario2 = new User(null ,"Alex Green", "alex@gmail.com", "123456", "99999");

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
