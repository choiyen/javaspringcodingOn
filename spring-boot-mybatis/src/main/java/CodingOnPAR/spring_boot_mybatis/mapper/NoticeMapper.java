package CodingOnPAR.spring_boot_mybatis.mapper;


import CodingOnPAR.spring_boot_mybatis.domain.Notice;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
// 해당 인터페이스가 Mybatics mapper 임을 나타냄
public interface NoticeMapper
{
    // case 1.  어노테이션 기반 매퍼
    // - 간단한 쿼리의 경로에는 간결하게 표현 가능하다.
    // - 자바 코드 내에서 SQL을 직접 볼 수 있어, 즉각적인 이해가 가능하다.
    // - @Select, @Insert, @Update, @Delete 어노테이션 사용해서 쿼리를 작성

    //@Select("SELECT * FROM notice")
    List<Notice> findAll();


    //@Select("SELECT * FROM notice WHERE id = #{id}")
    Notice FindById(Long id);

    /*
        - insert 작업에 대한 추가 옵션 설정
        - useGeneratedKeys = true; : 데이테베이스에서 자동 생성되는 키(auto increment pk)로 사용하겠다는 의미
        - keyProperty = "id"; 생성된 키 값을 User 객체의 id 필드에 저장하겠다는 의미
        -> insert 메서드 호출 후 전달된 User 객체의 id 필드는 데이터베이스에서 생성된 실제 id 값으로 업데이트
        -> 이를 통해 새로 삽입된 레코드(행)의 id를 즉시 알 수 있다.
    */
    //sql문 오류 주의하자.....
    //@Insert("INSERT INTO notice(writer,title,content) VALUES(#{writer},#{title}, #{content})")
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Notice notice);
    //자동으로 해당 key 값으로 들어감.
    //id,writer,title,content,registered

    //@Update("UPDATE notice SET writer = #{writer}, title = #{title}, content = #{content} WHERE id = #{id}")
    void update(Notice user);


    //@Delete("DELETE FROM notice WHERE id = #{id}")
    void delete(Long id);

}
