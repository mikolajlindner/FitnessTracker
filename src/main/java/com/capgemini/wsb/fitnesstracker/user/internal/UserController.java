package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import com.capgemini.wsb.fitnesstracker.user.api.UserService;
import com.capgemini.wsb.fitnesstracker.user.api.UserSimpleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler REST do zarządzania użytkownikami.
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Pobiera wszystkich użytkowników.
     *
     * @return lista obiektów UserDto reprezentujących wszystkich użytkowników
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * Pobiera użytkownika na podstawie jego ID.
     *
     * @param id ID użytkownika do pobrania
     * @return UserDto reprezentujący użytkownika
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    /**
     * Pobiera podstawowe informacje o wszystkich użytkownikach (tylko ID, imię i nazwisko).
     *
     * @return lista uproszczonych obiektów UserDto reprezentujących wszystkich użytkowników
     */
    @GetMapping("/simple")
    public List<UserSimpleDto> getAllSimpleUsers() {
        return userService.findAllUsers().stream()
                .map(user -> new UserSimpleDto(user.id(), user.firstName(), user.lastName()))
                .toList();
    }

    /**
     * Tworzy nowego użytkownika.
     *
     * @param userDto obiekt DTO zawierający szczegóły użytkownika
     * @return utworzony obiekt UserDto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    /**
     * Aktualizuje istniejącego użytkownika.
     *
     * @param id ID użytkownika do aktualizacji
     * @param userDto obiekt DTO zawierający zaktualizowane szczegóły użytkownika
     * @return zaktualizowany obiekt UserDto
     */
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    /**
     * Usuwa użytkownika.
     *
     * @param id ID użytkownika do usunięcia
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    /**
     * Wyszukuje użytkowników na podstawie ich adresu e-mail, ignorując wielkość liter.
     *
     * @param email adres e-mail do wyszukania
     * @return lista obiektów UserDto reprezentujących pasujących użytkowników
     */
    @GetMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> searchUsersByEmail(@RequestParam String email) {
        return userService.searchUsersByEmail(email);
    }

    /**
     * Pobiera użytkowników starszych niż określony wiek.
     *
     * @param age wiek do porównania
     * @return lista obiektów UserDto reprezentujących pasujących użytkowników
     */
    @GetMapping("/age")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsersOlderThan(@RequestParam int age) {
        return userService.getUsersOlderThan(age);
    }
}