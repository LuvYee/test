package com.gdufe.community.controller;

import com.gdufe.community.dto.AccessTokenDTO;
import com.gdufe.community.dto.GithubUser;
import com.gdufe.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


@RestController
public class AuthorizeController {

    @Autowired
    //让写好的实例加载到control中
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code", required = false) String code,
                           @RequestParam(name = "state",required = false) String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("2bd2fd4a25e69bc6b3b2");
        accessTokenDTO.setClient_secret("545433c605ac7279327b6fd9452e22ea7a067e9a");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_url("http://localhost:9292/callback");
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

}
