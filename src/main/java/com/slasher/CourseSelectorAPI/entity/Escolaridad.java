package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

  public Escolaridad(String cedulaProfecional, String carrera, Docente idDocente) {
    super();
    this.cedulaProfecional = cedulaProfecional;
    this.carrera = carrera;
    this.idDocente = idDocente;
  }

}
