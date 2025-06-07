package com.firstmeet.FirstMeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstmeet.FirstMeet.model.Room;

@Repository

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
