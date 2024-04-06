package org.library.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.library.Dto.LoginDto;
import org.library.Dto.UserDto;
import org.library.Entity.UserEntity;
import org.library.Response.UserResponse;
import org.library.Service.LoginService;
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
@RequiredArgsConstructor
public class UserController {


    final UserService userService;
    final LoginService loginService;

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        loginService.saveEmailAndPassword(new LoginDto(userDto.getEmail(),userDto.getPassword()));

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

    @GetMapping("find-by-userName/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserByUserName(@PathVariable String userName){
        try {
            return userService.findByUserName(userName);
        }catch (Exception ex){
            UserDto user = new UserDto();
            user.setId(-1L);
            return user;
        }
    }

    @GetMapping("is-exists-username/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isExistsUserName(@PathVariable String userName){
        return userService.isExistsUserName(userName);
    }



}
