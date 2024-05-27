package com.example.placePicker.dto.place;

import com.example.placePicker.entity.Place;
import org.springframework.stereotype.Service;

public interface PlaceToPlaceDTOMapper {

    public PlaceDTO apply(Place place);
}
