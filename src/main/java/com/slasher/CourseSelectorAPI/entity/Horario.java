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
import java.time.LocalTime;

@Entity
@Table(name = "horarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Horario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_horario")
  private Long idHorario;

  @Column(name = "hora_disp")
  private LocalTime horaDisp;

  private Horario(LocalTime horaDisp) {
    super();
    this.horaDisp = horaDisp;
  }

}
