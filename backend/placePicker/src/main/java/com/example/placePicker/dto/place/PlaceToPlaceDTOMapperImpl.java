package com.example.placePicker.dto.place;

import com.example.placePicker.entity.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceToPlaceDTOMapperImpl implements PlaceToPlaceDTOMapper {

    @Override
    public PlaceDTO apply(Place place) {

        return new PlaceDTO(
                place.getId(),
                place.getTitle(),
                place.getImage(),
                place.getImage_text(),
                place.getLat(),
                place.getLon()
        );
    }
}
