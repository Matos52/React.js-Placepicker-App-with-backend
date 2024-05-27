package com.example.placePicker.web;

import com.example.placePicker.dto.userPlace.UserPlaceDTO;
import com.example.placePicker.dto.userPlace.UserPlacesDTO;
import com.example.placePicker.service.userPlace.UserPlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping()
public class UserPlaceController {

    private final UserPlaceService userPlaceService;

    public UserPlaceController(UserPlaceService userPlaceService) {
        this.userPlaceService = userPlaceService;
    }

    @GetMapping("/user-places")
    public ResponseEntity<List<UserPlaceDTO>> getUserPlaces() {
        return new ResponseEntity<>(userPlaceService.getUserPlaces(), HttpStatus.OK);
    }

    @PutMapping("/user-places")
    public ResponseEntity<UserPlacesDTO> updateUserPlaces(@RequestBody UserPlacesDTO userPlacesDTO) {
        return new ResponseEntity<>(userPlaceService.updateUserPlaces(userPlacesDTO), HttpStatus.CREATED);
    }
}
