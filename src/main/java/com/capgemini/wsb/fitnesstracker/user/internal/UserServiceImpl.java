package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import com.capgemini.wsb.fitnesstracker.user.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementacja serwisu do zarządzania użytkownikami.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Tworzy nowego użytkownika w systemie.
     *
     * @param userDto obiekt transferu danych zawierający szczegóły użytkownika
     * @return utworzony UserDto
     * @throws IllegalArgumentException jeśli userDto zawiera ID
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("Creating User {}", userDto);
        if (userDto.id() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        User user = userMapper.toEntity(userDto);
        if (user == null) {
            throw new IllegalArgumentException("Mapped User entity must not be null");
        }
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    /**
     * Aktualizuje istniejącego użytkownika w systemie.
     *
     * @param id      ID użytkownika do aktualizacji
     * @param userDto obiekt transferu danych zawierający zaktualizowane szczegóły użytkownika
     * @return zaktualizowany UserDto
     * @throws IllegalArgumentException jeśli użytkownik nie został znaleziony
     */
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        log.info("Updating User with ID {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setBirthdate(userDto.birthdate());
        user.setEmail(userDto.email());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    /**
     * Usuwa użytkownika z systemu.
     *
     * @param id ID użytkownika do usunięcia
     */
    @Override
    public void deleteUser(Long id) {
        log.info("Deleting User with ID {}", id);
        userRepository.deleteById(id);
    }

    /**
     * Pobiera wszystkich użytkowników z systemu.
     *
     * @return lista UserDto reprezentująca wszystkich użytkowników
     */
    @Override
    public List<UserDto> findAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Pobiera użytkownika według jego ID.
     *
     * @param id ID użytkownika do pobrania
     * @return UserDto reprezentujący użytkownika
     * @throws IllegalArgumentException jeśli użytkownik nie został znaleziony
     */
    @Override
    public UserDto findUserById(Long id) {
        log.info("Fetching User with ID {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userMapper.toDto(user);
    }

    /**
     * Wyszukuje użytkowników według adresu e-mail, ignorując wielkość liter.
     *
     * @param email adres e-mail do wyszukania
     * @return lista UserDto reprezentująca pasujących użytkowników
     */
    @Override
    public List<UserDto> searchUsersByEmail(String email) {
        log.info("Searching users by email {}", email);
        return userRepository.findByEmailContainingIgnoreCase(email).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Pobiera użytkowników starszych niż określony wiek.
     *
     * @param age wiek do porównania
     * @return lista UserDto reprezentująca pasujących użytkowników
     */
    @Override
    public List<UserDto> getUsersOlderThan(int age) {
        log.info("Fetching users older than {}", age);
        LocalDate date = LocalDate.now().minusYears(age);
        List<User> users = userRepository.findByBirthdateBefore(date);
        users.forEach(user -> log.info("User found: {} {}", user.getFirstName(), user.getLastName()));
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}