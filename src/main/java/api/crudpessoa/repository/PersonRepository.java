package api.crudpessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.crudpessoa.entity.Person;

public interface PersonRepository
extends JpaRepository<Person, Long>
{
    Person findByName(String name);
    Person findByCPF(String cpf);
}
