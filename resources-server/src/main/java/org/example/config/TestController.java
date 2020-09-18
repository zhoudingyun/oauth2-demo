package org.example.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String a() {
        return "11";
    }

    @GetMapping("/oauth/callback")
    public void a(HttpServletRequest request) {
       System.out.println(request.getParameter("code"));
    }
}
