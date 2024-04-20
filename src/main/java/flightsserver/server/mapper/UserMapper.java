package flightsserver.server.mapper;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.dto.UserRegistrationDto;
import flightsserver.server.entity.Flight;
import flightsserver.server.entity.User;

public class UserMapper {
    public static UserRegistrationDto mapToUserRegistrationDto(User user){
        return new UserRegistrationDto(
               user.getName(),
               user.getEmail(),
               user.getPassword()

        );
    }

    public static User mapToUser(UserRegistrationDto userRegistrationDto){
        return new User(
                userRegistrationDto.getName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword()
        );
    }

    public static UserRegistrationDto mapToUserDto(User user){
        return new UserRegistrationDto(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
