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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

  @OneToOne
  @JoinColumn(name = "fk_id_semestre", referencedColumnName = "id_semestre", nullable = false)
  private Semestre idSemestre;

  @OneToOne
  @JoinColumn(name = "fk_id_hora", referencedColumnName = "id_hora", nullable = false)
  private Hora idHora;

  @ManyToOne
  @JoinColumn(name = "fk_id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
  private Asignatura idAsignatura;

  @OneToOne
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

}