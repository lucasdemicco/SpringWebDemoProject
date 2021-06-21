package com.lucas.demo.Config;

import com.lucas.demo.Entities.Category;
import com.lucas.demo.Entities.OrderStatus;
import com.lucas.demo.Entities.Orders;
import com.lucas.demo.Entities.User;
import com.lucas.demo.Repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "1234", "99999");
        User u2 = new User(null ,"Alex Green", "alex@gmail.com", "123456", "99999");

        Orders o1 = new Orders(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Orders o2 = new Orders(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u1, u2));
        ordersRepository.saveAll(Arrays.asList(o1, o2));
    }
}
