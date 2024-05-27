package com.example.placePicker.web;

import com.example.placePicker.dto.place.PlaceDTO;
import com.example.placePicker.service.place.PlaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping()
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(@Qualifier("placeServiceImpl") PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public ResponseEntity<List<PlaceDTO>> getPlaces() {
        return new ResponseEntity<>(placeService.getPlaces(), HttpStatus.OK);
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(placeService.getImage(imageName));
    }
}
