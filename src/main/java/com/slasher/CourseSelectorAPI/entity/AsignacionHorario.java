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
@Table(name = "asig_horario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AsignacionHorario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asig_horario")
  private Long idAsigHorario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "docentes_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "horarios_id_horario", referencedColumnName = "id_horario", nullable = false)
  private Horario idHorario;

  public AsignacionHorario(Docente idDocente, Horario idHorario) {
    super();
    this.idDocente = idDocente;
    this.idHorario = idHorario;
  }

}
