package com.example.userFormManupulation.Controller;

import com.example.userFormManupulation.Model.User;
import com.example.userFormManupulation.Repository.userRepository;
import com.example.userFormManupulation.apiResponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")

public class userController {

    @Autowired
private userRepository userRepository;

    @PostMapping
public ApiResponse saveUsers(@RequestBody User user){
User u = userRepository.save(user);
return new ApiResponse(HttpStatus.OK.value(),"user added successfully",u);
}

//@PostMapping(value="/save1")
//public String saveAllUsers(@RequestBody List<User> users){
//userRepository.saveAll(users);
//return "Saved Successfully";
//}

    @GetMapping(value="/getUserById/{id}")
    public ApiResponse<User> getUser(@PathVariable Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(),"Data returned",userRepository.findById(id));
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers(){

        return new ApiResponse(HttpStatus.OK.value(), "User List returned successfully",userRepository.findAll() );
    }

    @PutMapping(value="/updateUser/{id}")
    public String updateUser(@RequestBody User user){
        Optional<User> u = userRepository.findById(user.getId());
        if(u.isPresent()){
            u.get().setFirstName(user.getFirstName());
            u.get().setLastName(user.getLastName());
            u.get().setEmail(user.getEmail());
            u.get().setCountry(user.getCountry());
            u.get().setAge(user.getAge());
            u.get().setUsername(user.getUsername());
            userRepository.save(u.get());
        }
        return "Data Updated successfully";
    }
}
