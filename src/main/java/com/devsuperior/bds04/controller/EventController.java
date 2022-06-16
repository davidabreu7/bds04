package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    final
    EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}

