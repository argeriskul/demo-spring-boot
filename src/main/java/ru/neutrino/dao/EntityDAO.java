package ru.neutrino.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.neutrino.model.Planet;
import ru.neutrino.model.Sputnik;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class EntityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Transactional(readOnly=true)
	public List<Planet> allPlanets(){
		return entityManager.createQuery("select c from Planet c").getResultList();
			}

	
	@Transactional(readOnly=true)
	public List<Sputnik> allSputniks(){
		return entityManager.createQuery("select c from Sputnik c").getResultList();
			}
	

	@Transactional(readOnly=true)
	public Planet findPlanetById(int id){
		return (Planet) entityManager.createQuery("select c from Planet c where c.id = :id").setParameter("id", id).getSingleResult();
			}
	
	

	public Planet savePlanet(Planet planet) { 
					
		if (planet.getId() == 0) { 
		 System.out.println("Запись");
			entityManager.persist(planet);
		}
		
		else { 
			System.out.println("Обновление");
			entityManager.merge(planet); 
		
		}
		return planet; 
	
	}
	

	public void deletePlanet(Planet planet) { 
		Planet mergedPlanet = entityManager.merge(planet); 
		entityManager.remove(mergedPlanet);
	}

}
