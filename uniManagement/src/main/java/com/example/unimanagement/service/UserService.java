package com.example.unimanagement.service;

import com.example.unimanagement.dao.Authority;
import com.example.unimanagement.dao.User;
import com.example.unimanagement.dto.LoginDto;
import com.example.unimanagement.dto.UserDto;
import com.example.unimanagement.repo.AuthorityRepository;
import com.example.unimanagement.repo.UserRepository;
import com.mysql.cj.log.Log;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.unimanagement.dto.UserDto.doHashing;
import static java.lang.Integer.parseInt;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public User /*String*/ createUserWithAuthority(UserDto userDto) {
        User user = new User();
        Set<Authority> authoritySet = new HashSet<>();
            user.setEmail(userDto.getEmail());
            user.setPassword(doHashing(userDto.getPassword()));
            user.setUserName(userDto.getUserName());
            for (String authority : userDto.getAuthorities()) {
                Optional<Authority> authorityRes = authorityRepository.findById(authority);
                if (authorityRes.isPresent())
                    authoritySet.add(authorityRes.get());
            }
            user.setAuthorized_User(authoritySet);
        return userRepository.save(user);
    }

    public String userLogin(LoginDto loginDto) {
        Optional<User> emailRes = userRepository.findByEmail(loginDto.getEmail());
        if (emailRes.isPresent()) {
                if(emailRes.get().getPassword().equals(doHashing(loginDto.getPassword())))
                    return "Login";
                else
                    return "Wrong password";
        }
        else
            return "User Not Found of email : "+ loginDto.getEmail();
    }

}