package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "super_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SuperUsuario {

  @Id
  @Column(name = "id_super_usuario", length = 9)
  private String idSuperUsuario;

  private String password;

}
