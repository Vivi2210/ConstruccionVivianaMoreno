package app.adapters.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.User;


public interface UserRepository  extends JpaRepository<UserEntity, Long > {

    public boolean existsByUserName(String username);

    public UserEntity findByPersonId(PersonEntity person);

    public UserEntity findByUserName(String username);

}