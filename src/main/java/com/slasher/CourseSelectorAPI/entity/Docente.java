package com.slasher.CourseSelectorAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docentes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Docente {

  @Id
  @Column(name = "id_docente", length = 9)
  private String idDocente;

  private String password;

  @Column(length = 20)
  private String nombre;

  @Column(name = "apellido_paterno", length = 20)
  private String apellidoPaterno;

  @Column(name = "apellido_materno", length = 20)
  private String apellidoMaterno;

  @Column(length = 13)
  private String rfc;

  @Column(length = 18)
  private String curp;

  @Column(length = 70)
  private String domicilio;

  @Column(length = 11)
  private String nss;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_id_asig_por_carrera", referencedColumnName = "id_asig_por_carrera", nullable = false)
  private AsignaturaPorCarrera idAsigPorCarrera;

}