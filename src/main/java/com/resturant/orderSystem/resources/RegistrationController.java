package com.resturant.orderSystem.resources;

import com.resturant.orderSystem.services.RegistrationRequest;
import com.resturant.orderSystem.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService  registrationService;


    @PostMapping("/user")
    public String register(@RequestBody RegistrationRequest request){


        return  registrationService.register(request);
    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String t){


        return registrationService.confirmToken(t);
    }






}
