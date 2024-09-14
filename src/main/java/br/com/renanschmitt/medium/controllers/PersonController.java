package br.com.renanschmitt.medium.controllers;

import br.com.renanschmitt.medium.api.CreateTableBody;
import br.com.renanschmitt.medium.api.PersonBody;
import br.com.renanschmitt.medium.db.tables.pojos.PersonsPojo;
import br.com.renanschmitt.medium.db.tables.records.PersonsRecord;
import br.com.renanschmitt.medium.services.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @PostMapping("/tables")
  @ResponseStatus(HttpStatus.CREATED)
  public void createTable(@RequestBody CreateTableBody createTableBody) {}

  @PostMapping("/persons")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody PersonBody personBody) {
    personService.create(new PersonsRecord(null, personBody.getName(), personBody.getBirthDate()));
  }

  @GetMapping("/persons")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public List<PersonsPojo> get() {
    return personService.getAll();
  }

  @GetMapping("/persons/v2")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public List<PersonsPojo> get2() {
    return personService.getAll2();
  }
}
