package com.example.placePicker.dto.userPlace;

import com.example.placePicker.entity.UserPlace;
import org.springframework.stereotype.Service;

@Service
public class UserPlaceToUserPlaceDTOMapperImpl implements UserPlaceToUserPlaceDTOMapper {

    @Override
    public UserPlaceDTO apply(UserPlace userPlace) {
        return new UserPlaceDTO(
                userPlace.getId(),
                userPlace.getTitle(),
                userPlace.getImage(),
                userPlace.getImage_text(),
                userPlace.getLat(),
                userPlace.getLon()
        );
    }
}
