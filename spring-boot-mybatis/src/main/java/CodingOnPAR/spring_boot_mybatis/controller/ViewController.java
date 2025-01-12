package CodingOnPAR.spring_boot_mybatis.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController
{
    // GET / 요청 시 /users 경로로 리다이렉트
    @GetMapping("/")
    public String redirectToUsers() {return "redirect:/notices";}

    //GET /users 요청 시 userList.html 템플릿 뷰 반환
    @GetMapping("/notices")
    public String listNotice()
    {
        return "Noticelist";
    }

    @GetMapping("/notice/new")
    public String newNoticeForm()
    {
        return "NoticeForm";
    }

    @GetMapping("/notices/{id}/edit")
    public String editNoticeForm()
    {
        return "NoticeForm";
    }
}
