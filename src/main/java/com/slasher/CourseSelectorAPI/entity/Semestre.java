package com.slasher.CourseSelectorAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "semestres")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Semestre {

  @Id
  @Column(name = "id_semestre")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSemestre;

  @Column(name = "semestre")
  private Integer semestre;

  @JsonIgnore
  @OneToOne(mappedBy = "idSemestre")
  private AsignaturaPorCarrera asignaturaPorCarrera;

  @JsonIgnore
  @OneToOne(mappedBy = "idSemestre")
  private AsigHorarioDef asigHorarioDef;

  public Semestre(Integer semestre) {
    this.semestre = semestre;
  }

}
