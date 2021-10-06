package com.example.unimanagement.webrest;

import com.example.unimanagement.dao.Authority;
import com.example.unimanagement.service.AuthorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni/authority")
public class AuthorityResource {
    private final AuthorityService authorityService;

    public AuthorityResource(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @PostMapping("authority")
    public ResponseEntity<Authority> createAuthority(@RequestBody Authority authority){
        Authority authorityRes = authorityService.create(authority);
        return ResponseEntity.ok().body(authorityRes);
    }

    @GetMapping("/Allauthorities")
    public ResponseEntity<List<Authority>>AllAdmin()
    {
        List<Authority> administrators = authorityService.getAllAuthorities();
        return ResponseEntity.ok().body(administrators);
    }

}