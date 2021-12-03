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
@Table(name = "asig_horarios")
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

  @ManyToOne
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente idDocente;

  @ManyToOne
  @JoinColumn(name = "fk_id_hora", referencedColumnName = "id_hora", nullable = false)
  private Hora idHora;

  public AsignacionHorario(Docente idDocente, Hora idHora) {
    super();
    this.idDocente = idDocente;
    this.idHora = idHora;
  }

}
