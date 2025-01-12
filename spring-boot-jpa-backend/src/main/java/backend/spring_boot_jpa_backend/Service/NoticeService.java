package backend.spring_boot_jpa_backend.Service;

import backend.spring_boot_jpa_backend.DTO.NoticeDTO;
import backend.spring_boot_jpa_backend.entity.NoticeEntity;
import backend.spring_boot_jpa_backend.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService
{
    @Autowired
    NoticeRepository noticeRepository;
    public List<NoticeDTO> getAllNotices()
    {
        // repository로 전체 조회 가능
        // findAll() JpaRepository 인터페이스에 정의되어 있는 레포지토리
        List<NoticeEntity> notices = noticeRepository.findAll();

        // Entity => DTO 변환
        List<NoticeDTO> noticeDTOS = new ArrayList<>();

        for(NoticeEntity notice : notices)
        {
            NoticeDTO noticeDTO = convertToDTO(notice);
            noticeDTOS.add(noticeDTO);
        }
        return noticeDTOS;
    }

    //특정 ID의 사용자 정보를 UserDTO로 반환
    public NoticeDTO getNoticeById(Long id)
    {
        NoticeEntity noticeEntity = noticeRepository.findById(id).orElse(null);
        if(noticeEntity == null)
        {
            throw  new RuntimeException("User not found");
        }

        return convertToDTO(noticeEntity);
    }

    // 새 사용자 생성
    public void createNotices(NoticeDTO noticeDTO)
    {
        NoticeEntity noticeEntity = convertToEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
    }

    // 사용자 정보 업데이트
    public void updateNotice(Long id, NoticeDTO noticeDTO)
    {
        NoticeEntity user = convertToEntityWithId(id,noticeDTO);
        System.out.println("Userid : " + user.getId());
        noticeRepository.save(user);
        //jpa save(T) : 메서드 : Entity
        // - insert 할 때 사용
        // - 기본값 (PK) 상태에 따라 다르게 동작함.
        // - PK가 존재한다면 PK와 연결된 entry를 업데이트 함.
        // - PK가 없는 경우, 새로운 Entity를 insert함.
    }
    // 특정 ID의 사용자 삭제
    public void deleteNotice(Long id)
    {
        noticeRepository.deleteById(id);
    }

    private NoticeDTO convertToDTO(NoticeEntity notice)
    {
        return NoticeDTO.builder()
                .no((int)(notice.getId() + 100))
                .title(notice.getTitle())
                .content(notice.getContent())
                .registered(notice.getRegistered())
                .writer(notice.getWriter())
                .id(notice.getId())
                .build();
    }

    private NoticeEntity convertToEntity(NoticeDTO noticeDTO)
    {
        return NoticeEntity.builder()
                .title(noticeDTO.getTitle())
                .content(noticeDTO.getContent())
                .registered(noticeDTO.getRegistered())
                .writer(noticeDTO.getWriter())
                .id(noticeDTO.getId())
                .build();
    }

    private NoticeEntity convertToEntityWithId(Long id, NoticeDTO noticeDTO)
    {
        return NoticeEntity.builder()
                .title(noticeDTO.getTitle())
                .content(noticeDTO.getContent())
                .registered(noticeDTO.getRegistered())
                .writer(noticeDTO.getWriter())
                .id(id)
                .build();
    }


}
