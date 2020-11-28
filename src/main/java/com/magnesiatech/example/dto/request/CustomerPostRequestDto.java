package com.magnesiatech.example.dto.request;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPostRequestDto implements Serializable {

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private String surname;

  @NotNull
  @NotBlank
  private String address;

}
