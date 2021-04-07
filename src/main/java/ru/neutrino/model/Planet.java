package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Planet")
@Setter
@Getter
public class Planet implements Serializable {

	public Planet () {
	}
	
	
	public Planet (String planet) {
		this.planet = planet;
	}
	
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="planet")
	private String planet;
	
	
	@OneToMany(mappedBy = "planet", cascade=CascadeType.ALL, orphanRemoval=true) 
	private List<Sputnik> sputnik = new ArrayList<Sputnik>(); 


	@Override
	public String toString() {
		return "Planet id=" + id + ", planet=" + planet;
	}
	
	



}
