package com.HCSBackEnd.HCS.Back.End.security.mappers;


import com.HCSBackEnd.HCS.Back.End.security.dtos.SignUpDto;
import com.HCSBackEnd.HCS.Back.End.security.dtos.UserDto;
import com.HCSBackEnd.HCS.Back.End.security.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
