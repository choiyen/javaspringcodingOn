package backend.spring_boot_jpa_backend.controller;


import backend.spring_boot_jpa_backend.DTO.NoticeDTO;
import backend.spring_boot_jpa_backend.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

///api/notices/${userId}
// RESTful 웹 서비스의 컨트롤러
@RestController
@RequestMapping("/api/notices")
public class NoticeController
{
    // UserService 의존성을 자동으로 주입
    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public List<NoticeDTO> listnotices()
    {
        return noticeService.getAllNotices();
    }

    //특정 ID의 사용자 정보를 반환
    @GetMapping("/{id}")
    public NoticeDTO getNotice(@PathVariable Long id) {
        return noticeService.getNoticeById(id);
    }


    //api/notices/${userId}
    // 특정 ID의 사용자 정보를 업데이트하고 업데이트 된 정보를 반환
    @PutMapping("/{id}")
    public NoticeDTO updateNotice(@PathVariable Long id, @RequestBody NoticeDTO noticeDTO)
    {
        noticeService.updateNotice(id, noticeDTO);
        return noticeDTO;
    }

    //새 사용자를 생성하고, 생성된 사용자 정보를 반환
    @PostMapping
    public NoticeDTO createNotice(@RequestBody NoticeDTO noticeDTO)
    {
        System.out.println("데이터 확인 :" + noticeDTO.getContent() +" " + noticeDTO.getTitle() + " " + noticeDTO.getWriter());
        noticeService.createNotices(noticeDTO);
        return noticeDTO;
    }

    //특정 ID의 사용자 삭제
    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Long id)
    {
        noticeService.deleteNotice(id);
    }
}
