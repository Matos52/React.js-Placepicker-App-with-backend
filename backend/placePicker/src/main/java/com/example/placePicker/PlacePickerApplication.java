package com.example.placePicker;

import com.example.placePicker.dao.PlaceRepository;
import com.example.placePicker.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PlacePickerApplication implements CommandLineRunner {

	private final PlaceRepository placeRepository;

	@Autowired
	public PlacePickerApplication(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlacePickerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		placeRepository.deleteAll();

		Place[] places = new Place[] {
				new Place(1, "Forest Waterfall", "forest-waterfall.jpg", "A tranquil forest with a cascading waterfall amidst greenery.", 44.5588, -80.344),
				new Place(2, "Sahara Desert Dunes", "desert-dunes.jpg", "Golden dunes stretching to the horizon in the Sahara Desert.", 25.0, 0.0),
				new Place(3, "Himalayan Peaks", "majestic-mountains.jpg", "The sun setting behind snow-capped peaks of majestic mountains.", 27.9881, 86.925),
				new Place(4, "Caribbean Beach", "caribbean-beach.jpg", "Pristine white sand and turquoise waters of a Caribbean beach.", 18.2208, -66.5901),
				new Place(5, "Ancient Grecian Ruins", "ruins.jpg", "Historic ruins standing tall against the backdrop of the Grecian sky.", 37.9715, 23.7257),
				new Place(6, "Amazon Rainforest Canopy", "rainforest.jpg", "Lush canopy of a rainforest, teeming with life.", -3.4653, -62.2159),
				new Place(7, "Northern Lights", "northern-lights.jpg", "Dazzling display of the Northern Lights in a starry sky.", 64.9631, -19.0208),
				new Place(8, "Japanese Temple", "japanese-temple.jpg", "Ancient Japanese temple surrounded by autumn foliage.", 34.9949, 135.785),
				new Place(9, "Great Barrier Reef", "great-barrier-reef.jpg", "Vibrant coral formations of the Great Barrier Reef underwater.", -18.2871, 147.6992),
				new Place(10, "Parisian Streets", "parisian-streets.jpg", "Charming streets of Paris with historic buildings and cafes.", 48.8566, 2.3522),
				new Place(11, "Grand Canyon", "grand-canyon.jpg", "Expansive view of the deep gorges and ridges of the Grand Canyon.", 36.1069, -112.1129),
				new Place(12, "Venetian Canals", "venetian-canals.jpg", "Glistening waters of the Venetian canals as gondolas glide by at sunset.", 45.4408, 12.3155),
				new Place(13, "Taj Mahal", "taj-mahal.jpg", "The iconic Taj Mahal reflecting in its surrounding waters during sunrise.", 27.1751, 78.0421),
				new Place(14, "Kerala Backwaters", "kerala-backwaters.jpg", "Tranquil waters and lush greenery of the Kerala backwaters.", 9.4981, 76.3388),
				new Place(15, "African Savanna", "african-savanna.jpg", "Wild animals roaming freely in the vast landscapes of the African savanna.", -2.153, 34.6857),
				new Place(16, "Victoria Falls", "victoria-falls.jpg", "The powerful cascade of Victoria Falls, a natural wonder between Zambia and Zimbabwe.", -17.9243, 25.8572),
				new Place(17, "Machu Picchu", "machu-picchu.jpg", "The historic Incan citadel of Machu Picchu illuminated by the morning sun.", -13.1631, -72.545),
				new Place(18, "Amazon River", "amazon-river.jpg", "Navigating the waters of the Amazon River, surrounded by dense rainforest.", -3.4653, -58.38)
		};

		placeRepository.saveAll(Arrays.asList(places));
	}
}
