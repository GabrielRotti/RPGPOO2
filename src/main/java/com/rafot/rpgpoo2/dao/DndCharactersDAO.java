package com.rafot.rpgpoo2.dao;

import com.rafot.rpgpoo2.models.DndCharacters;
import com.rafot.rpgpoo2.utils.CharacterTitleGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;

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

    public DndCharacters createEntityFromRequest(HttpServletRequest request) {
        DndCharacters character = new DndCharacters();
        character.setId(request.getParameter("character_id") == null ? character.getId() : Integer.parseInt(request.getParameter("character_id")));
        character.setCharacterName(request.getParameter("name"));

        String titleParam = request.getParameter("title");

        if (titleParam == null || titleParam.isBlank())
            character.setTitle(CharacterTitleGenerator.generateTitle());
        else
            character.setTitle(titleParam);

        character.setLvl(Integer.parseInt(request.getParameter("lvl")));
        character.setStr(Integer.parseInt(request.getParameter("str")));
        character.setDex(Integer.parseInt(request.getParameter("dex")));
        character.setCon(Integer.parseInt(request.getParameter("con")));
        character.setWis(Integer.parseInt(request.getParameter("wis")));
        character.setCha(Integer.parseInt(request.getParameter("cha")));
        character.setSmt(Integer.parseInt(request.getParameter("smt")));
        character.setUserId(Integer.parseInt(request.getParameter("user_id")));
        character.setRaceId(Integer.parseInt(request.getParameter("race_id")));
        return character;
    }
}




