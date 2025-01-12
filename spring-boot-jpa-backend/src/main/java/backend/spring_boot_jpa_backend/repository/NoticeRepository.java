package backend.spring_boot_jpa_backend.repository;


import backend.spring_boot_jpa_backend.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository 인터페이스
//JpaRepository<T, ID>
//              - T : 테이블에 매핑될 엔티티 클래스
//               ID : 엔티티의 기본키 타입
@Repository
public interface NoticeRepository extends JpaRepository <NoticeEntity, Long>
{

    //case 1.  repository 메서드 사용
    //List<UserEntity> findByUsername();



    //case 2 : @query 어노테이션 사용


}
