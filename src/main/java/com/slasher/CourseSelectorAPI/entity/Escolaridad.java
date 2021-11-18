package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "escolaridades")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Escolaridad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_escolaridad")
  private Long idEscolaridad;

  @Column(name = "cedula_prof", length = 8)
  private String cedulaProfecional;

  @Column(length = 70)
  private String carrera;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "docentes_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

  public Escolaridad(String cedulaProfecional, String carrera, Docente idDocente) {
    super();
    this.cedulaProfecional = cedulaProfecional;
    this.carrera = carrera;
    this.idDocente = idDocente;
  }

}
