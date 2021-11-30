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
import javax.persistence.OneToOne;
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
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente")
  private Docente idDocente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
  private Asignatura idAsignatura;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_id_carrera", referencedColumnName = "id_carrera", nullable = false)
  private Carrera idCarrera;

  @OneToOne
  @JoinColumn(name = "fk_id_semestre", referencedColumnName = "id_semestre", nullable = false)
  private Semestre idSemestre;

  public AsignaturaPorCarrera(Docente idDocente, Asignatura idAsignatura, Carrera idCarrera, Semestre idSemestre) {
    super();
    this.idDocente = idDocente;
    this.idAsignatura = idAsignatura;
    this.idCarrera = idCarrera;
    this.idSemestre = idSemestre;
  }
}
