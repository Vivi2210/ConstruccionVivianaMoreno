package app.adapters.users;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.adapters.users.repository.UserRepository;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@NoArgsConstructor
public class UserAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) {
            return null;
        }
        return toDomain(userEntity);
    }

    @Override
    public boolean existUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = toEntity(user);
        userRepository.save(userEntity);
        user.setDocument(userEntity.getPerson().getDocument());
    }

    @Override
    public User findByPersonId(Person person) {
        PersonEntity personEntity = personAdapter(person);
        UserEntity userEntity = userRepository.findByPersonDocument(person.getDocument());
       
        return userAdapter(userEntity);
    }
    @Override
    public User findById(long userId) {
        UserEntity entity = userRepository.findById(userId).orElse(null);
        if (entity == null) return null;
        return toDomain(entity);
    }
    
    private PersonEntity personAdapter(Person person){
        if (person== null){
            return null;
        }
        PersonEntity personEntity = new PersonEntity();
        personEntity.setDocument(person.getDocument());
        personEntity.setAge(person.getAge());
        personEntity.setName(person.getName());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
    private User userAdapter (UserEntity userEntity){
        if (userEntity == null){
            return null;
        }
        User user = new User();
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        return user;
    }

    private User toDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        
        if (userEntity.getPerson()!= null){
        Person person = toDomain(userEntity.getPerson());
        user.setDocument(person.getDocument());
        user.setName(person.getName());
        user.setAge(person.getAge());
        user.setRole(person.getRole());
        }
        return user;
    }

    private UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());

        return userEntity;
    }

    private Person toDomain(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }

        Person person = new Person();
        person.setDocument(personEntity.getDocument());
        person.setName(personEntity.getName());
        person.setRole(personEntity.getRole());
        person.setAge(personEntity.getAge());

        return person;
    }

    private PersonEntity toEntity(Person person) {
        if (person == null) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setDocument(person.getDocument());
        personEntity.setName(person.getName());
        personEntity.setRole(person.getRole());
        personEntity.setAge(person.getAge());

        return personEntity;
    }


}
