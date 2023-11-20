package com.dmadev.crud.repository;
import com.dmadev.crud.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

//    Метод flush() в JPA принудительно синхронизирует изменения в объектах с базой данных.
//    Все накопленные изменения в контексте управляемых сущностей будут отправлены в базу данных,
//    что может привести к выполнению SQL-запросов для обновления, вставки или удаления записей.
    @Override
    public void updateUser(User user) {
    entityManager.merge(user);
    entityManager.flush();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User deleteUser(int id) throws NullPointerException {
        User user = getUserById(id);
        if(null==user){
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
