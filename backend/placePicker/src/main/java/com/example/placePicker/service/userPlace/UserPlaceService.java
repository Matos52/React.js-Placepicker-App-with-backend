package com.example.placePicker.service.userPlace;

import com.example.placePicker.dto.userPlace.UserPlaceDTO;
import com.example.placePicker.dto.userPlace.UserPlacesDTO;

import java.util.List;

public interface UserPlaceService {

    public List<UserPlaceDTO> getUserPlaces();

    public UserPlacesDTO updateUserPlaces(UserPlacesDTO userPlacesDTO);
}
