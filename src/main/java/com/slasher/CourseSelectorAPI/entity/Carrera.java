package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carreras")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Carrera {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_carrera")
  private Long idCarrera;

  @Column(name = "nombre_carrera", length = 75)
  private String nombreCarrera;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "fk_id_jefe_carrera", referencedColumnName = "id_jefe_de_carrera")
  private JefeCarrera jefeCarrera;

  public Carrera(String nombreCarrera, JefeCarrera jefeCarrera) {
    super();
    this.nombreCarrera = nombreCarrera;
    this.jefeCarrera = jefeCarrera;
  }

}
