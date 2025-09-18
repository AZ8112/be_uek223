package com.example.demo.domain.user;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.domain.authority.Authority;

public record UserDetailsImpl(User user) implements UserDetails {
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getRoles()
               .stream()
               .flatMap(r -> r.getAuthorities()
                              .stream())
               .map(a -> new SimpleGrantedAuthority(a.getName()))
               .toList();
  }

  public boolean hasAuthority(String authorityName) {
    return user.getRoles().stream().flatMap(role -> role.getAuthorities().stream())
            .map(Authority::getName).anyMatch(auth->auth.equals(authorityName));
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
