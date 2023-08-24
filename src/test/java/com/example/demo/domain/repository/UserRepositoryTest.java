package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void f1(){
        userRepository.save(new User("boowooo","123","ROLE_USER"));
        userRepository.save(new User("boowooo1","1234","ROLE_USER"));
        userRepository.save(new User("boowooo2","12345","ROLE_MEMBER"));
        userRepository.save(new User("boowooo3","123456","ROLE_ADMIN"));
        userRepository.save(new User("boowooo4","1234567","ROLE_MEMBER"));
        userRepository.save(new User("boowooo5","12345678","ROLE_USER"));
    }

    @Test
    public void f2(){
        List<User> list = userRepository.SelectByRole("ROLE_ADMIN");
        list.forEach(user -> System.out.println(user));
    }
}