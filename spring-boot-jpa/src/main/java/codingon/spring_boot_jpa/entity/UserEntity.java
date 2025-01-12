package codingon.spring_boot_jpa.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Entity
// - DB에서 쓰이는 필드와 매핑이 되는 클래스(DB 테이블과 대응)


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// entity는 기본 생성자가 필요함(@NoArgsConstructor -> 무분별한 객체 생성을 막기 위해 접근 제한 걸기)
// 빌더 -> 모든 필드를 생성하는 생성자가 필요함.(@AllArgsConstructor)
@Table(name = "users") // 테이블명과 클레스 명이 동일한 경우에는 생략 가능(대문자를 사용하려면 설정 추가가 필요)
public class UserEntity
{
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 옵션
    private Long id;

    @Column(nullable = false, length = 50) //VARCHAR(50)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime createdAt;


    @PrePersist
    // 엔티티가 데이터베이스에 저장되기 전에 필요한 초기화 작업을 수행할 수 있게 해줌
    protected void onCreate()
    {
        //메서드 이름 자유롭게 설정 가능, 단 메서드 반환 타입은 void, 매개변수 X
        createdAt = LocalDateTime.now();
    }

    @Builder
    public UserEntity(Long id, String username, String email, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}

