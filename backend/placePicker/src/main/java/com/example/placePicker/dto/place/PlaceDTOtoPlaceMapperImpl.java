package com.example.placePicker.dto.place;

import com.example.placePicker.entity.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceDTOtoPlaceMapperImpl implements PlaceDTOtoPlaceMapper{
    @Override
    public Place apply(PlaceDTO placeDTO) {

        return new Place(
                placeDTO.id(),
                placeDTO.title(),
                placeDTO.image(),
                placeDTO.image_text(),
                placeDTO.lat(),
                placeDTO.lon()
        );
    }
}
