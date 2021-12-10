package com.slasher.CourseSelectorAPI.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TopDocentesMayorDisponibilidad {
  private String idDocente;
  private Integer horasDisponibles;
}
