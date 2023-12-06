package com.rafot.rpgpoo2.dao;

import com.rafot.rpgpoo2.models.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UsersDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public void create(Users users) {
        em.getTransaction().begin();
        em.persist(users);
        em.getTransaction().commit();
    }

    public Users getById(long id) {
        return em.find(Users.class, id);
    }

    public List<Users> getAll() {
        TypedQuery<Users> query = em.createQuery("SELECT g FROM Users g", Users.class);
        return query.getResultList();
    }

    public void update(Users Users) {
        em.getTransaction().begin();
        em.merge(Users);
        em.getTransaction().commit();
    }

    public void delete(Users Users) {
        em.getTransaction().begin();
        em.remove(Users);
        em.getTransaction().commit();
    }
}
