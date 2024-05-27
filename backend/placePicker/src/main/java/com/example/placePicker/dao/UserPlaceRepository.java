package com.example.placePicker.dao;

import com.example.placePicker.entity.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlaceRepository extends JpaRepository<UserPlace, Integer> {
}
