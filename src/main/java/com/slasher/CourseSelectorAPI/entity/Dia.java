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
import javax.persistence.Table;

@Entity
@Table(name = "dias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Dia {

  @Id
  @Column(name = "id_dia")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idDia;

  @Column(name = "nombre_dia", length = 45)
  private String nombreDia;

  public Dia(String nombreDia) {
    super();
    this.nombreDia = nombreDia;
  }

}
