package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository 인터페이스
//JpaRepository<T, ID>
//              - T : 테이블에 매핑될 엔티티 클래스
//               ID : 엔티티의 기본키 타입
@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long>
{

    //case 1.  repository 메서드 사용
    //List<UserEntity> findByUsername();



    //case 2 : @query 어노테이션 사용


}
