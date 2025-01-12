package codingon.springbootMybatis.Service;


import codingon.springbootMybatis.DTO.UserDTO;
import codingon.springbootMybatis.domain.User;
import codingon.springbootMybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 이 클레스가 서비스 계층의 컴포넌트 임을 나타냄
@Service
public class UserService
{
    //UserMapper 인터페이스의 구현체를 자동으로 주입받아 사용
    @Autowired
    private UserMapper userMapper;

    /*
    * 모든 사용자의 정보를 UserDTO LIST로 반환하는 함수
     */
    public List<UserDTO> getAllUsers()
    {
        //1) 모든 domain.User 정보를 가져와야 함.
        List<User> users = userMapper.findAll();

        //2) 새로운 DTO 객체 생성
        List<UserDTO> userDTOS = new ArrayList<>();

        //3) 반복문을 이용해 각 User 객체를 UserDTO 객체로 변환하고 리스트에 추가시킴
        for(User user : users)
        {
            UserDTO userDTO =  convertToDto(user);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    //domain to dto
    private UserDTO convertToDto (User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setNo((int) (user.getId() + 100));

        return  userDTO;
    }

    private User convertToDomain (UserDTO userDTO)
    {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        return user;
    }
    // 새 사용자 생성
    public void createUser(UserDTO userDTO) {
        User user = convertToDomain(userDTO);
        userMapper.insert(user);
    }

    // 특정 ID의 사용자 정보를 UserDTO로 반환
    public UserDTO getUserById(Long id)
    {
       User user = userMapper.FindById(id);
       return convertToDto(user);
    }

    //  사용자 정보 업데이트
    public void updateUser(UserDTO userDTO)
    {
        User user = convertToDomain(userDTO);
        userMapper.update(user);
    }

    //특정 ID의 사용자 삭제
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

}
