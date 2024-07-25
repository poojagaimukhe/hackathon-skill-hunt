package com.hackathon.skillhunt.service;

import com.hackathon.skillhunt.entity.UserInfo;
import com.hackathon.skillhunt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class userService {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void loadProductsFromDB() {
//        productList = IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> Product.builder()
//                        .productId(i)
//                        .name("product " + i)
//                        .qty(new Random().nextInt(10))
//                        .price(new Random().nextInt(5000)).build()
//                ).collect(Collectors.toList());
//    }


//    public List<Product> getProducts() {
//        return productList;
//    }

//    public Product getProduct(int id) {
//        return productList.stream()
//                .filter(product -> product.getProductId() == id)
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
//    }


    public String addUser(UserInfo userInfo) {
        userInfo.setCreatedBy(userInfo.getUsername());
        userInfo.setCreatedDate(LocalDateTime.now());
        userInfo.setUpdatedBy(userInfo.getUsername());
        userInfo.setUpdatedDate(LocalDateTime.now());
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
