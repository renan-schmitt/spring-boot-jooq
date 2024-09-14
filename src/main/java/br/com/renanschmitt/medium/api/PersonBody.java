package br.com.renanschmitt.medium.api;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PersonBody {
  private final String name;
  private final LocalDate birthDate;
}
