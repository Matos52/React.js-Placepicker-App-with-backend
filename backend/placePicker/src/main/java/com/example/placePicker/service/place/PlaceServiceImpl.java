package com.example.placePicker.service.place;

import com.example.placePicker.dao.PlaceRepository;
import com.example.placePicker.dto.place.PlaceDTO;
import com.example.placePicker.dto.place.PlaceToPlaceDTOMapper;
import com.example.placePicker.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceToPlaceDTOMapper placeToPlaceDTOMapper;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository, PlaceToPlaceDTOMapper placeToPlaceDTOMapper) {
        this.placeRepository = placeRepository;
        this.placeToPlaceDTOMapper = placeToPlaceDTOMapper;
    }

    @Override
    public List<PlaceDTO> getPlaces() {
        List<Place> places = placeRepository.findAll();
        return places.stream().map(placeToPlaceDTOMapper::apply).collect(Collectors.toList());
    }

    @Override
    public byte[] getImage(String imageName) throws IOException {
        Resource imageResource = new ClassPathResource("static/images/" + imageName);
        return Files.readAllBytes(Path.of(imageResource.getURI()));
    }
}
