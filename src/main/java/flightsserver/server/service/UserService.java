package flightsserver.server.service;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.dto.UserRegistrationDto;
import flightsserver.server.entity.User;

public interface UserService {
    UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto);
    boolean authenticateUser(String email, String password);
    UserRegistrationDto getUserByEmail(String email);
}
