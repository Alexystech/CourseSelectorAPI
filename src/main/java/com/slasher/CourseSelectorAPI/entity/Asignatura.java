package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignaturas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Asignatura {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asignatura")
  private Long idAsignatura;

  @Column(name = "nombre_asignatura", length = 75)
  private String nombreAsignatura;

  public Asignatura(String nombreAsignatura) {
    super();
    this.nombreAsignatura = nombreAsignatura;
  }

}
