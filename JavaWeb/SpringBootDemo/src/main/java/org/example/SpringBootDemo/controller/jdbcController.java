package org.example.SpringBootDemo.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sql")
public class jdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/register")
    public String register(@RequestBody String req) {
        Gson gson = new Gson();
        User user = gson.fromJson(req, User.class);

        String name = user.name;
        String password = user.password;

        try{
            String sql = "insert into users (name,password) value (?,?)";
            jdbcTemplate.update(sql,name,password);
            return "success";
        }catch (Exception e) {
            return "failed";
        }

    }

}

class User {
    String name;
    String password;
}
