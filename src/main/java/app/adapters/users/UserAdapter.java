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
 import lombok.Setter;
 import lombok.NoArgsConstructor;

 @Setter
 @Getter
 @NoArgsConstructor
 @Service


public class UserAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUserName(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) {
            return null;
        }
        return userAdapter(userEntity);
    }
    

    @Override
    public boolean existUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = userEntityAdapter(user);
            userRepository.save(userEntity);
            user.setDocument(userEntity.getPersonDocument().getDocument());
    }
         
    @Override
    public User findByPersonId(Person person) {
         
        PersonEntity personEntity = personAdapter(person);
        UserEntity userEntity = userRepository.findByPersonId(personEntity);
        return userAdapter(userEntity);
    }

    private User userAdapter(UserEntity userEntity) {
        if (userEntity == null ) {
            return null;
        }
        User user = new User();
        Person person = personAdapter(userEntity.getPersonDocument());
        user.setPerson(person);
        user.setUserName(userEntity.getUserName());
        user.setUserDocument(userEntity.getPersonDocument().getDocument());
        user.setRole(userEntity.getPersonDocument().getRole());
        user.setPassword(userEntity.getPassword());
        user.setDocument(userEntity.getPersonDocument().getDocument());
        user.setName(userEntity.getPersonDocument().getName());
        return user;
    }

    private UserEntity userEntityAdapter(User user) {
        if (user==null){
            return null;
        }
        UserEntity userEntinty = new UserEntity();
        PersonEntity personEntity = personAdapter(user.getPerson());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setUserId(user.getUserId());

        return userEntity;
    } 
    private PersonEntity personAdapter(Person person){
        if (person==null){
            return null;
        }
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonId(person.getPersonId());
        personEntity.setDocument(person.getDocument());
        personEntity.setName(person.getName());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
    private Person personAdapter(PersonEntity personEntity){
        if (personEntity == null){
            return null;
        }
        Person person = new Person();
        person.setPersonId(personEntity.getPersonId());
        person.setDocument(personEntity.getDocument());
        person.setName(personEntity.getName());
        person.setRole(personEntity.getRole());
        
        return person;
    }
    
 }