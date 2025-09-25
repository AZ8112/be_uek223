package com.example.demo.domain.user.dto;

import com.example.demo.core.generic.AbstractDTO;
import java.util.UUID;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserRegisterDTO extends AbstractDTO {
  @NotNull
  @Size(min = 2, max = 20)
  private String firstName;
  @NotNull
  @Size(min = 2, max = 20)
  private String lastName;

  @Email
  @NotNull
  @Size(min = 1, max = 200)
  private String email;

  @NotNull
  @Size(min = 4, max = 200)
  private String password;

  public UserRegisterDTO(UUID id, String firstName, String lastName, String email, String password) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }
}
