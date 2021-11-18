package com.slasher.CourseSelectorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jefes_de_carrera")
public class JefeCarrera {

  @Id
  @Column(name = "id_jefe_de_carrera")
  private String idJefeCarrera;

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

  @Column(length = 200)
  private String domicilio;

  @Column(length = 11)
  private String nss;

  @OneToOne
  @JoinColumn(name = "carreras_id_carrera", referencedColumnName = "id_carrera")
  private Carrera idCarrera;

}
