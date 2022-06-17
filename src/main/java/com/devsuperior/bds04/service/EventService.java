package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.exceptions.ResourceNotFoundException;
import com.devsuperior.bds04.repository.CityRepository;
import com.devsuperior.bds04.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    final EventRepository eventRepository;
    final CityRepository cityRepository;

    public EventService(EventRepository repository, CityRepository cityRepository) {
        this.eventRepository = repository;
        this.cityRepository = cityRepository;
    }

    @Transactional(readOnly = true)
    public Page<EventDto> findAll(Pageable page) {
        return eventRepository.findAll(page)
                .map(EventDto::new);
    }

    public EventDto findById(Long id) {
        return eventRepository.findById(id)
                .map(EventDto::new)
                .orElseThrow(() -> new ResourceNotFoundException("Resource id: %d not found".formatted(id)));
    }

    @Transactional
    public EventDto update(Long id, EventDto dto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource id: %d not found".formatted(id)));
        event.setDate(dto.getDate());
        event.setCity(cityRepository.getById(dto.getCityId()));
        event.setName(dto.getName());
        event.setUrl(dto.getUrl());
        return new EventDto(event);

    }

    public EventDto insert(EventDto dto) {
        City cityEvent = cityRepository
                .findById(dto.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException("City id: %d not found".formatted(dto.getCityId())));
        return new EventDto(eventRepository.save(new Event(dto, cityEvent)));
    }
}
