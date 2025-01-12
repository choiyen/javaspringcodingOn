package codingon.spring_boot_jpa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController
{
    // GET / 요청 시 /users 경로로 리다이렉트
    @GetMapping("/")
    public String redirectToUsers() {return "redirect:/users";}

    //GET /users 요청 시 userList.html 템플릿 뷰 반환
    @GetMapping("/users")
    public String listUser()
    {
        return "userList";
    }

    @GetMapping("/users/new")
    public String newUserForm()
    {
        return "userForm";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm()
    {
        return "userForm";
    }
}
