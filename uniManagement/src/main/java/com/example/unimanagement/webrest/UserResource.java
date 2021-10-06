package com.example.unimanagement.webrest;

import com.example.unimanagement.dao.User;
import com.example.unimanagement.dto.LoginDto;
import com.example.unimanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.unimanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

//    @GetMapping("/Allusers")
//    public ResponseEntity<List<User>>AllUsers()
//    {
////        User dtoUsers = userService.createUserWithAuthority(userDto);
//          List<User> users = userService.createUserWithAuthority();
//        return ResponseEntity.ok().body(users);
//    }

    @PostMapping("/create")
    public ResponseEntity<User> AddUser( @Valid @RequestBody  UserDto userDto){
//        if (userService.createUserWithAuthority(userDto).equals("invalid email pattern")){
//            return "inva"
//        }
        User userRes = userService.createUserWithAuthority(userDto);
//        if (userDto.getEmail().equals("invalid email pattern"))
//            return ResponseEntity.ok().body("invalid email pattern");
        return ResponseEntity.ok().body(userRes);
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok().body(userService.userLogin(loginDto));
    }


//    @PostMapping("/user")
//    public ResponseEntity<User> AddUser(@RequestBody User user){
//        User userRes = userService.create(user);
//        return ResponseEntity.ok().body(userRes);
//    }
//
//    @GetMapping("/Allusers")
//    public ResponseEntity<List<User>>AllUsers()
//    {
//        List<User> users = userService.getAll();
//        return ResponseEntity.ok().body(users);
//    }
//
//    @GetMapping("/user/{id}")
//    public User retrieveUser(@PathVariable int id){
//        return userService.findById(id);
//    }
//
//    @DeleteMapping("/delUser/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable int id){
//        userService.deleteById(id);
//        return ResponseEntity.ok().body("User deleted id : "+ id);
//    }
}
