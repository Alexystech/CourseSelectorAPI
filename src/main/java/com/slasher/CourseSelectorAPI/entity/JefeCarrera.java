package com.slasher.CourseSelectorAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jefes_de_carrera")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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

  @JsonIgnore
  @OneToOne(mappedBy = "jefeCarrera")
  private Carrera carrera;

  public JefeCarrera(String password, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String curp, String domicilio, String nss, Carrera carrera) {
    super();
    this.password = password;
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.rfc = rfc;
    this.curp = curp;
    this.domicilio = domicilio;
    this.nss = nss;
    this.carrera = carrera;
  }
}
