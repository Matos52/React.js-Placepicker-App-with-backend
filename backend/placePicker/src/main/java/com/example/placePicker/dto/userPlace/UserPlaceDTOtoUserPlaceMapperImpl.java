package com.example.placePicker.dto.userPlace;

import com.example.placePicker.entity.UserPlace;
import org.springframework.stereotype.Service;

@Service
public class UserPlaceDTOtoUserPlaceMapperImpl implements UserPlaceDTOtoUserPlaceMapper {

    @Override
    public UserPlace apply(UserPlaceDTO userPlaceDTO) {
        return new UserPlace(
                userPlaceDTO.id(),
                userPlaceDTO.title(),
                userPlaceDTO.image(),
                userPlaceDTO.image_text(),
                userPlaceDTO.lat(),
                userPlaceDTO.lon()
        );
    }
}
