package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import org.springframework.stereotype.Component;

/**
 * Mapper do konwersji między encjami User a obiektami UserDto.
 */
@Component
public class UserMapper {

    /**
     * Konwertuje encję User na UserDto.
     *
     * @param user encja użytkownika
     * @return obiekt UserDto
     */
    public UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    /**
     * Konwertuje UserDto na encję User.
     *
     * @param userDto obiekt DTO użytkownika
     * @return encja User
     */
    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return User.builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .birthdate(userDto.birthdate())
                .email(userDto.email())
                .build();
    }
}