package com.magnesiatech.liquibasEexample.repository.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;


@Data // @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @NotNull
  private String surname;

  @NotNull
  private String address;
}
