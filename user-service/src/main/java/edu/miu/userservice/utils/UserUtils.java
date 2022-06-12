package edu.miu.userservice.utils;

import com.netflix.discovery.converters.Auto;
import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.dto.response.UserResponseFeignDTO;
import edu.miu.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class UserUtils {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static List<UserResponseDTO> parseUserToUserResponseDTO(List<User> users){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user :
                users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setSubscribed(user.getSubscribed());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    //TODO: THIS NEEDS TO BE REFACTORED
    public static User parseUserRequestDTOToUser(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setSubscribed(userRequestDTO.getSubscribed());
//        user.setPassword(BCrypt.hashpw(userRequestDTO.getPassword(), BCrypt.gensalt()));
        if(userRequestDTO.getRoles()!=null || !userRequestDTO.getRoles().isEmpty())
            user.setRoles(userRequestDTO.getRoles());

        return user;
    }

    public static UserResponseDTO parseUserRequestDTOToUserResponseDTO(UserRequestDTO userRequestDTO, Long id){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(id);
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setEmail(userRequestDTO.getEmail());
        userResponseDTO.setSubscribed(userRequestDTO.getSubscribed());
        return userResponseDTO;
    }

    public static UserResponseDTO parseUserToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());

        return userResponseDTO;
    }

    public static UserResponseFeignDTO parseUserToUserResponseFeignDTO(User user){
        UserResponseFeignDTO userResponseDTO = new UserResponseFeignDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());
        userResponseDTO.setRoles(user.getRoles());

        return userResponseDTO;
    }

    public static Function<User, UserResponseFeignDTO> convertToUserResponseFeignDTO = user -> {
        UserResponseFeignDTO responseDTO = new UserResponseFeignDTO();

        responseDTO.setId(user.getId());
        responseDTO.setPassword(user.getPassword());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setName(user.getName());
        responseDTO.setSubscribed(user.getSubscribed());

        return responseDTO;
    };
}
