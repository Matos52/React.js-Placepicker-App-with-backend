package com.example.placePicker.service.place;

import com.example.placePicker.dto.place.PlaceDTO;

import java.io.IOException;
import java.util.List;

public interface PlaceService {

    public List<PlaceDTO> getPlaces();

    public byte[] getImage(String imageName) throws IOException;

}
