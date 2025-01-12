package CodingOnPAR.spring_boot_mybatis.Service;
import CodingOnPAR.spring_boot_mybatis.DTO.NoticeDTO;
import CodingOnPAR.spring_boot_mybatis.mapper.NoticeMapper;
import CodingOnPAR.spring_boot_mybatis.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 이 클레스가 서비스 계층의 컴포넌트 임을 나타냄
@Service
public class noticeService
{
    //UserMapper 인터페이스의 구현체를 자동으로 주입받아 사용
    @Autowired
    private NoticeMapper noticeMappers;

    /*
    * 모든 사용자의 정보를 UserDTO LIST로 반환하는 함수
     */
    public List<NoticeDTO> getAllNotices()
    {
        //1) 모든 domain.User 정보를 가져와야 함.
        List<Notice> Notices = noticeMappers.findAll();

        //2) 새로운 DTO 객체 생성
        List<NoticeDTO> NoticeDTOS = new ArrayList<>();

        //3) 반복문을 이용해 각 User 객체를 UserDTO 객체로 변환하고 리스트에 추가시킴
        for(Notice notice : Notices)
        {
            NoticeDTO NoticeDTO =  convertToDto(notice);
            NoticeDTOS.add(NoticeDTO);
        }

        return NoticeDTOS;
    }

    //domain to dto
    private NoticeDTO convertToDto (Notice notice)
    {
        NoticeDTO NoticeDTO = new NoticeDTO();
        NoticeDTO.setId(notice.getId());
        NoticeDTO.setTitle(notice.getTitle());
        NoticeDTO.setWriter(notice.getWriter());
        NoticeDTO.setRegistered(notice.getRegistered());
        NoticeDTO.setContent(notice.getContent());

        NoticeDTO.setNo((int) (notice.getId() + 100));
        return  NoticeDTO;
    }

    private Notice convertToDomain (NoticeDTO userDTO)
    {
        Notice notice = new Notice();
        notice.setId(userDTO.getId());
        notice.setTitle(userDTO.getTitle());
        notice.setWriter(userDTO.getWriter());
        notice.setContent(userDTO.getContent());
        notice.setRegistered(userDTO.getRegistered());

        return notice;
    }
    // 새 사용자 생성
    public void createNotices(NoticeDTO noticeDTO)
    {
        Notice notice = convertToDomain(noticeDTO);
        noticeMappers.insert(notice);
    }

    // 특정 ID의 사용자 정보를 UserDTO로 반환
    public NoticeDTO getNoticeById(Long id)
    {
       Notice notice = noticeMappers.FindById(id);
       return convertToDto(notice);
    }

    //  사용자 정보 업데이트
    public void updateNotice(NoticeDTO noticeDTO)
    {
        Notice user = convertToDomain(noticeDTO);
        noticeMappers.update(user);
    }

    //특정 ID의 사용자 삭제
    public void deleteNotice(Long id)
    {
        noticeMappers.delete(id);
    }

}
