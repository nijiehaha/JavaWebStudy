package org.example.SpringBootDemo.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class Hello {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @PostMapping("upload")
    public String getResult(@RequestBody String req) {
        Gson gson = new Gson();
        Value value = gson.fromJson(req, Value.class);
        value.result = value.num1 + value.num2;
        return gson.toJson(value);
    }

}

class Value {
   int num1 = 0;
   int num2 = 0;
   int result = 0;
}
