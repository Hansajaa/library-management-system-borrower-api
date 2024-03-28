package org.library.Controller;

import lombok.extern.slf4j.Slf4j;
import org.library.Dto.UserDto;
import org.library.Entity.UserEntity;
import org.library.Response.UserResponse;
import org.library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        boolean isSaved = userService.addUser(userDto);
        return isSaved ? ResponseEntity.ok(String.format("Saved %s", userDto.getFirstName())) : ResponseEntity.badRequest().body("Not Saved");
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserEntity> getUsers(){
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        return userService.getUsers();
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse deleteUser(@PathVariable Long id){
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? new UserResponse(String.format("userId %d is Successfully Deleted",id)):new UserResponse("User Not Found");
    }

}
