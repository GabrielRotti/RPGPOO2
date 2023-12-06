package com.rafot.rpgpoo2.dao;

import com.rafot.rpgpoo2.models.DndCharacters;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DndCharactersDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public void create(DndCharacters DndCharactersOBJ) {
        em.getTransaction().begin();
        em.persist(DndCharactersOBJ);
        em.getTransaction().commit();
    }

    public DndCharacters getById(long id) {
        return em.find(DndCharacters.class, id);
    }

    public List<DndCharacters> getAll() {
        TypedQuery<DndCharacters> query = em.createQuery("SELECT g FROM DndCharacters g", DndCharacters.class);
        return query.getResultList();
    }

    public void update(DndCharacters DndCharactersOBJ) {
        em.getTransaction().begin();
        em.merge(DndCharactersOBJ);
        em.getTransaction().commit();
    }

    public void delete(DndCharacters DndCharactersOBJ) {
        em.getTransaction().begin();
        em.remove(DndCharactersOBJ);
        em.getTransaction().commit();
    }
}




