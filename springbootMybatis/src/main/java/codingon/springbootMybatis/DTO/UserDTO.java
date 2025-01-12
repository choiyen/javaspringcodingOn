package codingon.springbootMybatis.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO
{
    private Long id;
    private String username;
    private String email;
    private int no;

    //domain.User 와 다르게 "no" 필드 추가
    // 실제 테이터에 존재하는 컬럼은 아니지만, 서비스 로직에서 no 정보를 활용할 예정이므로 추가함.

}

//dto.UserDTO
//- 데이터 전송 객체(dto)로 클라이언트와 서버 간에 데이터 교환에 사용
//- 클라이언트한테 노출하고 싶지 않은 민감한 정보를 User  객체 포함시키고,
// DTO 변환 과정에서 제외할 수 있다.
