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
import java.time.LocalTime;

@Entity
@Table(name = "horas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Hora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_hora")
  private Long idHora;

  @Column(name = "hora_disp")
  private LocalTime hora;

  @ManyToOne
  @JoinColumn(name = "fk_id_dia", referencedColumnName = "id_dia", nullable = false)
  private Dia dia;

  public Hora(Long idHora) {
    this.idHora = idHora;
  }

  public Hora(LocalTime hora, Dia dia) {
    super();
    this.hora = hora;
    this.dia = dia;
  }
}
