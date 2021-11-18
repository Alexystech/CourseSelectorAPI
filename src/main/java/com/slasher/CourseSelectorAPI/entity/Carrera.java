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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

  @OneToOne(mappedBy = "idCarrera")
  private JefeCarrera jefeCarrera;

  public Carrera(String nombreCarrera, JefeCarrera jefeCarrera) {
    super();
    this.nombreCarrera = nombreCarrera;
    this.jefeCarrera = jefeCarrera;
  }

}
