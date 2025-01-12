package CodingOnPAR.spring_boot_mybatis.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice
{
    private Long id;
    private String writer;
    private String title;
    private String content;
    private String registered;
}
//id,writer,title,content,registered
//이름과 타입을 DB와 똑같이 호환되게 작성해야 한다.
//domain.User 클래스
//- 데이터베이스 엔티티를 표현하는 도메인
//- 실제 데이터의 역할이므로 "테이블 구조"와 동일해야 함.

