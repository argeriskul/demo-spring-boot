package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Res")
@Setter
@Getter
public class Res {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	
	@ManyToMany 
	@JoinTable (name = "Countres", joinColumns = @JoinColumn (name = "resid"), inverseJoinColumns = @JoinColumn(name = "countid"))
	private List<Country> country = new ArrayList<Country>();
}
