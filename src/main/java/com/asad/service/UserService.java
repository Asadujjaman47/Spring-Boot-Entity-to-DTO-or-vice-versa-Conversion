package com.asad.service;

import com.asad.dto.UserLocationDTO;
import com.asad.model.User;
import com.asad.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    3rd Step
    @Autowired
    private ModelMapper modelMapper;

    public List<UserLocationDTO> getAllUsersLocation() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    // manually convert Entity to DTO
//    private UserLocationDTO convertEntityToDto(User user) {
//        UserLocationDTO userLocationDTO = new UserLocationDTO();

//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());

//        return userLocationDTO;
//    }


//    4th Step
//    Using Model Mapper Methods/API (to map user JPA Entity to userLocationDTO class)
//    private UserLocationDTO convertEntityToDto(User user) {
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
//
//        return userLocationDTO;
//    }
    // here manyTOne relationship, so cannot work with Location(because it is reference type)
    // Sometime, it may not able to match the property from reference type
    // So, it needs this configuration


//    //    4th Step
////    Using Model Mapper Methods/API (to map user JPA Entity to userLocationDTO class)
    private UserLocationDTO convertEntityToDto(User user) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);

        return userLocationDTO;
    }


    private User convertDtoToEntity(UserLocationDTO userLocationDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        User user = new User();
        user = modelMapper.map(userLocationDTO, User.class);

        return user;
    }
}
