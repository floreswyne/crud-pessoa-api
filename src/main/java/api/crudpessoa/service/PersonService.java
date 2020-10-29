package api.crudpessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.crudpessoa.entity.Person;
import api.crudpessoa.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository repository;

    public Person createPerson(Person person)
    {
        return repository.save(person);
    }

    public Person getPersonByCPF(String cpf)
    {
        return repository.findByCPF(cpf);
    }

    public Person getPersonByName(String name)
    {
        return repository.findByName(name);
    }

    public List<Person> getPeople()
    {
        return repository.findAll();
    }

    public Person updatePerson(Person person)
    {
        Person existingPerson = repository.findByCPF(person.getCpf());

        existingPerson.setName(person.getName());
        existingPerson.setSex(person.getSex());
        existingPerson.setCpf(person.getCpf());
        existingPerson.setBirthday(person.getBirthday());
        existingPerson.setEmail(person.getEmail());

        existingPerson.setAddresses(person.getAddresses());
        existingPerson.setPhones(person.getPhones());

        return repository.save(existingPerson);
    }

    public String deletePersonById(long id)
    {
        repository.deleteById(id);
        return "Deletando...";
    }

}
