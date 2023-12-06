package com.rafot.rpgpoo2.dao;

import com.rafot.rpgpoo2.models.DndCharacters;
import com.rafot.rpgpoo2.models.Race;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RaceDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public void create(Race race) {
        em.getTransaction().begin();
        em.persist(race);
        em.getTransaction().commit();
    }

    public Race getById(long id) {
        return em.find(Race.class, id);
    }

    public List<Race> getAll() {
        TypedQuery<Race> query = em.createQuery("SELECT g FROM Race g", Race.class);
        return query.getResultList();
    }

    public void update(Race race) {
        em.getTransaction().begin();
        em.merge(race);
        em.getTransaction().commit();
    }

    public void delete(Race race) {
        em.getTransaction().begin();
        em.remove(race);
        em.getTransaction().commit();
    }
}




