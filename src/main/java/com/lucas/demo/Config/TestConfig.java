package com.lucas.demo.Config;

import com.lucas.demo.Entities.Orders;
import com.lucas.demo.Entities.User;
import com.lucas.demo.Repositories.OrdersRepository;
import com.lucas.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "1234", "99999");
        User usuario2 = new User(null ,"Alex Green", "alex@gmail.com", "123456", "99999");

        Orders o1 = new Orders(null, Instant.parse("2019-06-20T19:53:07Z"), usuario1);
        Orders o2 = new Orders(null, Instant.parse("2019-07-21T03:42:10Z"), usuario2);

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));
        ordersRepository.saveAll(Arrays.asList(o1, o2));
    }
}
