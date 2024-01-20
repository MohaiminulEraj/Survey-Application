//package com.mohaiminuleraj.survey.survey.mapper;
//package com.mohaiminuleraj.survey.survey.dto;
//import com.mohaiminuleraj.survey.survey.dto.UserAnswerDto;
//import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
//import com.mohaiminuleraj.survey.user.User;
//import com.mohaiminuleraj.survey.user.dto.UserDto;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class DtoMapper {
//
//    private final ModelMapper modelMapper;
//
//    public DtoMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    public UserDto mapUserToDto(User user) {
//        UserDto userDto = modelMapper.map(user, UserDto.class);
//        userDto.setUserAnswers(mapUserAnswersToDto(user.getUserAnswers()));
//        return userDto;
//    }
//
//    public List<UserAnswerDto> mapUserAnswersToDto(List<UserAnswer> userAnswers) {
//        return userAnswers.stream()
//                .map(this::mapUserAnswerToDto)
//                .collect(Collectors.toList());
//    }
//
//    public UserAnswerDto mapUserAnswerToDto(UserAnswer userAnswer) {
//        return modelMapper.map(userAnswer, UserAnswerDto.class);
//    }
//
//    // Add similar methods for Question and Answer mappings
//}
