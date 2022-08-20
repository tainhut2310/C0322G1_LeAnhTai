package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IMusicRepository implements com.codegym.repository.IMusicRepository {
    @Override
    public List<Music> findAll() {
        String queryStr = "SELECT m FROM Music AS m";
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findOne(int id) {
        String queryStr = "SELECT m FROM Music AS m WHERE m.idTheSong = :id";
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music origin = findOne(music.getIdTheSong());
            origin.setNameOfTheSong(music.getNameOfTheSong());
            origin.setPerformingArtist(music.getPerformingArtist());
            origin.setKindOfMusic(music.getKindOfMusic());
            origin.setSongFilePath(music.getSongFilePath());
            session.delete(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
