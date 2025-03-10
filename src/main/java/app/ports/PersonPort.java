
package app.ports;

import app.domain.models.Person;

public interface PersonPort {

    /**
     *
     * @param personId
     * @return
     */
    public boolean existePerson(long personId);
    public void savePerson(Person person);
    public Person findByPersonId(long personId);
    
}
