package ru.neutrino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neutrino.dao.EntityDAO;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

    @Autowired
    private EntityDAO entityDAO;

    public void showallPlanet()  {
        for (Planet x : entityDAO.allPlanets()) {
            System.out.println(x);
        }
    }
}
