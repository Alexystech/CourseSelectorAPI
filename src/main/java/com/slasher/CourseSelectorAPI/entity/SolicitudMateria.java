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
import javax.persistence.Table;

@Entity
@Table(name = "sol_materias")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SolicitudMateria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_sol_materia")
  private Long idSolMateria;

  @ManyToOne
  @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente", nullable = false)
  private Docente docente;

  @ManyToOne
  @JoinColumn(name = "fk_id_asig_por_carrera", referencedColumnName = "id_asig_por_carrera", nullable = false)
  private AsignaturaPorCarrera asignaturaPorCarrera;

  public SolicitudMateria(Docente docente, AsignaturaPorCarrera asignaturaPorCarrera) {
    super();
    this.docente = docente;
    this.asignaturaPorCarrera = asignaturaPorCarrera;
  }

  public SolicitudMateria(Long idSolMateria) {
    this.idSolMateria = idSolMateria;
  }
}
