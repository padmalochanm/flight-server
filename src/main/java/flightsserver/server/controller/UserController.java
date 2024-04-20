package flightsserver.server.controller;


import flightsserver.server.dto.FlightDto;
import flightsserver.server.dto.LoginDto;
import flightsserver.server.dto.UserRegistrationDto;
import flightsserver.server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationDto> createUser(@RequestBody UserRegistrationDto userRegistrationDto){
        UserRegistrationDto savedUser = userService.createUser(userRegistrationDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserRegistrationDto> authenticateUser(@RequestBody LoginDto loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        if (userService.authenticateUser(email, password)) {
            UserRegistrationDto userRegistrationDto = userService.getUserByEmail(email);
            return ResponseEntity.ok(userRegistrationDto);
        } else {
            return null;
        }
    }

}
