package com.example.demo.domain.user.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.role.dto.RoleDTO;
import java.util.Set;
import java.util.UUID;
import jakarta.validation.Valid;
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
public class UserDTO extends AbstractDTO {
  @Size(min = 2, max = 20)
  @NotNull
  private String firstName;
  @Size(min = 2, max = 20)
  @NotNull
  private String lastName;

  @Email
  @Size(min = 1, max = 200)
  @NotNull
  private String email;

  @Valid
  private Set<RoleDTO> roles;

  public UserDTO(UUID id, String firstName, String lastName, String email, Set<RoleDTO> roles) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
  }

  @Getter
  @Setter
  public static class BaseUserDTO extends AbstractDTO {
    @Size(min = 2, max = 20)
    @NotNull
    private String firstName;
    @Size(min = 2, max = 20)
    @NotNull
    private String lastName;
  }
}
