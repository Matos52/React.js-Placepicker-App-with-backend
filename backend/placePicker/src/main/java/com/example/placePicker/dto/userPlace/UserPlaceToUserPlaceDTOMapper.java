package com.example.placePicker.dto.userPlace;

import com.example.placePicker.entity.UserPlace;
import org.springframework.stereotype.Service;

@Service
public interface UserPlaceToUserPlaceDTOMapper {

    public UserPlaceDTO apply(UserPlace userPlace);
}
