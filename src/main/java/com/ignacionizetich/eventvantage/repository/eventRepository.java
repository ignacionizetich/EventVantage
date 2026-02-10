package com.ignacionizetich.eventvantage.repository;

import com.ignacionizetich.eventvantage.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface eventRepository extends JpaRepository<Event, Long> {

    boolean existsByTitleAndLocationAndEventDate(
            String title,
            String location,
            LocalDateTime eventDate
    );




}
