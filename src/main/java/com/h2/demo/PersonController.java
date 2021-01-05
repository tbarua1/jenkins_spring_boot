package com.h2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/")
    public Person addPeron(@RequestBody Person person){
        Person save = personRepository.save(person);
        return save;
    }
    @GetMapping("/list")
    public List<Person> listPeron(){
        List<Person> save = personRepository.findAll();
        return save;
    }
    @GetMapping("/{id}")
    public Person getPeron(@PathVariable Long id){
        Person save = personRepository.findById(id).get();
        return save;
    }
    @GetMapping("/new")
    public Person newPeron(){
        Person save = personRepository.save(new Person());
        return save;
    }
    @PostMapping("/update")
    public Person newPeron(@RequestBody Person person){
        Person byId = personRepository.findById(person.getPid()).get();
        byId.setAddress(person.getAddress());
        byId.setName(person.getName());
        byId.setPhone(person.getPhone());
        Person save = personRepository.save(byId);
        return save;
    }
    @DeleteMapping("/delete")
    public Person deletePeron(@RequestBody Person person){
        personRepository.delete(person);
        return person;
        //return "Record has been deleted succesfully";
    }
}
