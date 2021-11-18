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
@Table(name = "asig_por_carrera")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AsignaturaPorCarrera {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asig_por_carrera")
  private Long idAsigPorCarrera;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "carreras_id_carrera", referencedColumnName = "id_carrera", nullable = false)
  private Carrera idCarrera;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "asignaturas_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
  private Asignatura idAsignatura;

  private Integer semestre;

  public AsignaturaPorCarrera(Carrera idCarrera, Asignatura idAsignatura, Integer semestre) {
    super();
    this.idCarrera = idCarrera;
    this.idAsignatura = idAsignatura;
    this.semestre = semestre;
  }

}
