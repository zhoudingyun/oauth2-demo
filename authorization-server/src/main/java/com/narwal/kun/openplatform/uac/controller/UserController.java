package com.narwal.kun.openplatform.uac.controller;

import com.narwal.kun.openplatform.uac.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/login1")
    public String login() {
        return "login";
    }

    @RequestMapping("/me")
    @ResponseBody
    public Result user(Principal principal) {
        return Result.success(principal);
    }

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @RequestMapping("/logout1")
    @ResponseBody
    public Result logout(@RequestParam("token") String token) {
        try {
            if (StringUtils.hasText(token)) {
                consumerTokenServices.revokeToken(token.replace(OAuth2AccessToken.BEARER_TYPE, "").replace(" ", ""));
            }
        } catch (Exception e) {
            LOGGER.error("token:" + token, e);
            // 登出失败
            return Result.fail();
        }

        return Result.success();
    }
}
