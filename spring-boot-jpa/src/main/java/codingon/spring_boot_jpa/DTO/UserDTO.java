package codingon.spring_boot_jpa.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserDTO
{
    private Long id;
    private String username;
    private String email;
    private int no;

    //domain.User 와 다르게 "no" 필드 추가
    // 실제 테이터에 존재하는 컬럼은 아니지만, 서비스 로직에서 no 정보를 활용할 예정이므로 추가함.
}

// @Builder
// - 빌더 패턴 : 디자인 패턴의 "생성" 패턴 중에 하나.
// - 객체를 생성하는 방법 중에 하나
// - 빌더를 사용하게 되면 setter 없이 생성이 가능해짐
// 빌더 사용 시 좋은 점
// - 생성자는  파라미터가 많은 경우, 가독성이 떨어짐.
// - 생성자를 이용해서 생성할 경우는 순서가 정해짐.
// - 빌더를 이용하면 어떤 값을 먼저 넣든 상관이 없게 됨.



//dto.UserDTO
//- 데이터 전송 객체(dto)로 클라이언트와 서버 간에 데이터 교환에 사용
//- 클라이언트한테 노출하고 싶지 않은 민감한 정보를 User  객체 포함시키고,
// DTO 변환 과정에서 제외할 수 있다.
