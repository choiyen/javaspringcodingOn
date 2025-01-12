package codingon.spring_boot_jpa.Service;


import codingon.spring_boot_jpa.DTO.UserDTO;
import codingon.spring_boot_jpa.entity.UserEntity;
import codingon.spring_boot_jpa.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers()
    {
        // repository로 전체 조회 가능
        // findAll() JpaRepository 인터페이스에 정의되어 있는 레포지토리
        List<UserEntity> users = userRepository.findAll();

        // Entity => DTO 변환
        List<UserDTO> userDTOS = new ArrayList<>();

        for(UserEntity user : users)
        {
            UserDTO userDTO = convertToDTO(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }


    //특정 ID의 사용자 정보를 UserDTO로 반환
    public UserDTO getUserById(Long id)
    {
        UserEntity user = userRepository.findById(id).orElse(null);
        if(user == null)
        {
            throw  new RuntimeException("User not found");
        }

        return convertToDTO(user);
    }

    // 새 사용자 생성
    public void createUser(UserDTO userDTO)
    {
        UserEntity user = convertToEntity(userDTO);
        userRepository.save(user);
    }

    // 사용자 정보 업데이트
    public void updateUser(Long id, UserDTO userDTO)
    {
        UserEntity user = convertToEntityWithId(id,userDTO);
        System.out.println("Userid : " + user.getId());
        userRepository.save(user);
        //jpa save(T) : 메서드 : Entity
        // - insert 할 때 사용
        // - 기본값 (PK) 상태에 따라 다르게 동작함.
        // - PK가 존재한다면 PK와 연결된 entry를 업데이트 함.
        // - PK가 없는 경우, 새로운 Entity를 insert함.
    }
    // 특정 ID의 사용자 삭제
    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
    private UserDTO convertToDTO(UserEntity user)
    {
        return UserDTO.builder()
        .no((int)(user.getId() + 100))
        .email(user.getEmail())
        .id(user.getId())
        .username(user.getUsername())
        .build();
    }
    private UserEntity convertToEntity(UserDTO userDTO)
    {
        return UserEntity.builder()
                .email(userDTO.getEmail())
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .build();
    }
    private UserEntity convertToEntityWithId(Long id, UserDTO userDTO)
    {
        return UserEntity.builder()
                .email(userDTO.getEmail())
                .id(id)
                .username(userDTO.getUsername())
                .build();
    }

}
