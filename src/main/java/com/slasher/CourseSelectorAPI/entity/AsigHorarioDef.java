package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asig_horario_def")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AsigHorarioDef {

  @Id
  @Column(name = "id_asig_horario_def")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAsigHorarioDef;

  private Integer semestre;

  @ManyToOne
  @JoinColumn(name = "fk_id_hora", referencedColumnName = "id_hora", nullable = false)
  private Hora idHora;

  @ManyToOne
  @JoinColumn(name = "fk_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
  private Asignatura idAsignatura;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

  public AsigHorarioDef(Long idAsigHorarioDef) {
    this.idAsigHorarioDef = idAsigHorarioDef;
  }

  public AsigHorarioDef(Integer semestre, Hora idHora, Asignatura idAsignatura, Docente idDocente) {
    this.semestre = semestre;
    this.idHora = idHora;
    this.idAsignatura = idAsignatura;
    this.idDocente = idDocente;
  }
}
