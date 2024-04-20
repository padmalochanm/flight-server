package flightsserver.server.service.impl;

import flightsserver.server.dto.UserRegistrationDto;
import flightsserver.server.entity.Flight;
import flightsserver.server.entity.User;
import flightsserver.server.exception.ResourceNotFound;
import flightsserver.server.mapper.FlightMapper;
import flightsserver.server.mapper.UserMapper;
import flightsserver.server.repository.UserRepository;
import flightsserver.server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {
        User user = UserMapper.mapToUser(userRegistrationDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserRegistrationDto(savedUser);
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public UserRegistrationDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound("No flight exists with email: " + email));
        return UserMapper.mapToUserDto(user);

    }
}
