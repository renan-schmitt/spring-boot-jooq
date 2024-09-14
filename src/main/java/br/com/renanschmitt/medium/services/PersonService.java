package br.com.renanschmitt.medium.services;

import br.com.renanschmitt.medium.db.tables.Persons;
import br.com.renanschmitt.medium.db.tables.daos.PersonsDao;
import br.com.renanschmitt.medium.db.tables.pojos.PersonsPojo;
import br.com.renanschmitt.medium.db.tables.records.PersonsRecord;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonsDao personsDao;
  private final DSLContext dslContext;

  public void create(PersonsRecord personsRecord) {
    var personPojo =
        new PersonsPojo(
            personsRecord.getId(), personsRecord.getName(), personsRecord.getBirthDate());

    personsDao.insert(personPojo);
  }

  public List<PersonsPojo> getAll() {
    return personsDao.findAll();
  }

  public List<PersonsPojo> getAll2() {
    return dslContext
        .select()
        .from(Persons.PERSONS)
        .where(DSL.field(Persons.PERSONS.BIRTH_DATE).ge(LocalDate.of(1990, 1, 1)))
        .fetchInto(PersonsPojo.class);
  }
}
