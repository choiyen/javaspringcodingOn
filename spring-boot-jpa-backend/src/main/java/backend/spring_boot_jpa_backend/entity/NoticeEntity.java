package backend.spring_boot_jpa_backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notice")
public class NoticeEntity
{
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 옵션
    private Long id;

    @Column(nullable = false, length = 50) //VARCHAR(50)
    private String writer;

    @Column(nullable = false, length = 50) //VARCHAR(50)
    private String title;

    @Column(nullable = false, length = 500) //VARCHAR(50)
    private String content;

    @Column(name = "registered", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime registered;

    @Builder
    public NoticeEntity(Long id, String writer, String title, String content, LocalDateTime registered) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.registered = registered;
    }

    @PrePersist
    // 엔티티가 데이터베이스에 저장되기 전에 필요한 초기화 작업을 수행할 수 있게 해줌
    // 값을 만들어서 넣어야함.
    protected void onCreate()
    {
        //메서드 이름 자유롭게 설정 가능, 단 메서드 반환 타입은 void, 매개변수 X
        registered = LocalDateTime.now();
    }
}
