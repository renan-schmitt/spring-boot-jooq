package br.com.renanschmitt.medium.api;

import java.util.List;
import lombok.Data;

@Data
public class CreateTableBody {
  private String name;
  private List<Attribute> attributes;

  @Data
  public static class Attribute {
    private String name;
    private String type;
  }
}
