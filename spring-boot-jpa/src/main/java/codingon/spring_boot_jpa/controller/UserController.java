package codingon.spring_boot_jpa.controller;

import codingon.spring_boot_jpa.DTO.UserDTO;
import codingon.spring_boot_jpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping //RequestMapping 시 defaullt GetMapping은 아무것도 안적어야 됨.
    public List<UserDTO> listUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping
    public  UserDTO createUser(@RequestBody UserDTO userDTO)
    {
        userService.createUser(userDTO);
        return userDTO;
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO)
    {
        userService.updateUser(id, userDTO);
        return userDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
}
