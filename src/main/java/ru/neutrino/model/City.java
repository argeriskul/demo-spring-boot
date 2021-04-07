package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="City")
@Setter
@Getter
public class City implements Serializable {

	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="city")
	private String city;
	
	
	@ManyToOne 
	@JoinColumn(name = "country")
	private Country country;


	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + " country=" + getCountry().getCountry()+ "]";
	}
	
	
	
}
