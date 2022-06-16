package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    final
    EventService eventService;

    public EventController(EventService service) {
        this.eventService = service;
    }

    @GetMapping
    public ResponseEntity<Page<EventDto>> findAll(Pageable page){
        return ResponseEntity.ok(eventService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(eventService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> update(@PathVariable Long id, @RequestBody EventDto dto) {
        return ResponseEntity.ok(eventService.update(id, dto));
    }
}

