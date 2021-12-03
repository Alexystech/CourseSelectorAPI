package com.slasher.CourseSelectorAPI.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AsigHorarioDefByDocente {
  private Integer semestre;
  private LocalTime hora;
  private String asignatura;
}
