package api.crudpessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.crudpessoa.entity.Person;
import api.crudpessoa.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService service;

    @PostMapping("/create")
    public Person createPerson(
        @RequestBody
        Person person
    )
    {
        return service.createPerson(person);
    }

    @GetMapping("/cpf/{cpf}")
    public Person findPersonByCPF(
        @PathVariable
        String cpf
    )
    {
        return service.getPersonByCPF(cpf);
    }

    @PutMapping("/update")
    public Person updatePerson(
        @RequestBody
        Person person
    )
    {
        return service.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(
        @PathVariable
        int id
    )
    {
        return service.deletePersonById(id);
    }

}
