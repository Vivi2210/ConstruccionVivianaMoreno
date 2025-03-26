
package app.adapters.persons.entity;

import app.domain.models.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="person")

public class PersonEntity {
    @Id
<<<<<<< Updated upstream
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long personId;
>>>>>>> Stashed changes
    @Column(name="document")
    private long document;
    @Column (name= "name")
    private String name;
    @Column(name = "role")
    private String role;
    @Column(name = "age")
    private int age;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    public long getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(int age) {
        this.age = age;
    }
<<<<<<< Updated upstream
    
    
=======

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }




>>>>>>> Stashed changes
}
