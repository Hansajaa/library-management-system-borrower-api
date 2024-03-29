package org.library.Controller;

import lombok.RequiredArgsConstructor;
import org.library.Dto.LoginDto;
import org.library.Service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;

    @PostMapping("request-login")
    public Boolean authenticateUser(@RequestBody LoginDto dto){
        return loginService.existsByEmailAndPassword(dto);
    }
}
