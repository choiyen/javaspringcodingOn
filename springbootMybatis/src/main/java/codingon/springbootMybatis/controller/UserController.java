package codingon.springbootMybatis.controller;


import codingon.springbootMybatis.DTO.UserDTO;
import codingon.springbootMybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RESTful 웹 서비스의 컨트롤러
@RestController
@RequestMapping("/api/users")
public class UserController
{
    // UserService 의존성을 자동으로 주입
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listUsers()
    {
        return userService.getAllUsers();
    }

    //특정 ID의 사용자 정보를 반환
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    // 특정 ID의 사용자 정보를 업데이트하고 업데이트 된 정보를 반환
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO)
    {
        userDTO.setId(id);
        userService.updateUser(userDTO);
        return userDTO;
    }

    //새 사용자를 생성하고, 생성된 사용자 정보를 반환
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO)
    {

        userService.createUser(userDTO);
        return userDTO;
    }

    //특정 ID의 사용자 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }


}
