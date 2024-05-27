package com.example.placePicker.service.userPlace;

import com.example.placePicker.dao.UserPlaceRepository;
import com.example.placePicker.dto.userPlace.UserPlaceDTO;
import com.example.placePicker.dto.userPlace.UserPlaceDTOtoUserPlaceMapper;
import com.example.placePicker.dto.userPlace.UserPlaceToUserPlaceDTOMapper;
import com.example.placePicker.dto.userPlace.UserPlacesDTO;
import com.example.placePicker.entity.UserPlace;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPlaceServiceImpl implements UserPlaceService {

    private final UserPlaceRepository userPlaceRepository;
    private final UserPlaceToUserPlaceDTOMapper userPlaceToUserPlaceDTOMapper;
    private final UserPlaceDTOtoUserPlaceMapper userPlaceDTOtoUserPlaceMapper;

    @Autowired
    public UserPlaceServiceImpl(UserPlaceRepository userPlaceRepository, UserPlaceToUserPlaceDTOMapper userPlaceToUserPlaceDTOMapper, UserPlaceDTOtoUserPlaceMapper userPlaceDTOtoUserPlaceMapper) {
        this.userPlaceRepository = userPlaceRepository;
        this.userPlaceToUserPlaceDTOMapper = userPlaceToUserPlaceDTOMapper;
        this.userPlaceDTOtoUserPlaceMapper = userPlaceDTOtoUserPlaceMapper;
    }

    @Override
    public List<UserPlaceDTO> getUserPlaces() {
        List<UserPlace> userPlaces = userPlaceRepository.findAll();
        return userPlaces.stream().map(userPlaceToUserPlaceDTOMapper::apply).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserPlacesDTO updateUserPlaces(UserPlacesDTO userPlacesDTO) {

        List<UserPlaceDTO> tempUserPlaces = userPlacesDTO.places();
        List<UserPlace> userPlacesFromRepository = userPlaceRepository.findAll();
        List<UserPlaceDTO> userPlacesDTOtoAdd = new ArrayList<>();

        if(userPlacesFromRepository.isEmpty() || (userPlacesFromRepository.size() > tempUserPlaces.size())) {
            userPlacesDTOtoAdd = tempUserPlaces;
        } else {
            for (UserPlaceDTO userPlaceDTO : tempUserPlaces) {
                for (UserPlace userPlace : userPlacesFromRepository) {
                    if(userPlace.getId() != userPlaceDTO.id()) {
                        userPlacesDTOtoAdd.add(userPlaceDTO);
                    }
                }
            }
        }

        List<UserPlace> userPlaces = userPlacesDTOtoAdd.stream().map(userPlaceDTOtoUserPlaceMapper::apply).toList();
        userPlaceRepository.deleteAll();
        userPlaceRepository.saveAll(userPlaces);
        List<UserPlaceDTO> userPlaceDTOsToReturn = userPlacesFromRepository.stream().map(userPlaceToUserPlaceDTOMapper::apply).toList();
        return new UserPlacesDTO(userPlaceDTOsToReturn);
    }
}
