package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Sputnik")
@Setter
@Getter
public class Sputnik {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="sputnik")
	private String sputnik;
	
	
	@ManyToOne 
	@JoinColumn(name = "planetid")
	private Planet planet;


	@Override
	public String toString() {
		return "Sputnik id=" + id + ", sputnik=" + sputnik + " planet=" + planet.getPlanet();
	}
	
	

}
