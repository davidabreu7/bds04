package com.devsuperior.bds04.entities;

import com.devsuperior.bds04.dto.EventDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate date;
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	public Event() {
	}

	public Event(Long id, String name, LocalDate date, String url, City city) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
		this.city = city;
	}

	public Event(EventDto dto, City city) {
		this.name = dto.getName();
		this.date = dto.getDate();
		this.url = dto.getUrl();
		this.city = city;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
