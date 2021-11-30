package com.slasher.CourseSelectorAPI.service.exception;

import org.springframework.http.HttpStatus;

/**
 * En este enum se definen los diferentes Exceptions que
 * serán soportados en el backend, si el error es soportado
 * se retornara un error personalizado, en caso de que el error
 * no este definido en este enum, se dirá que es un error no
 * soportado y por lo tanto retornara un Internal Server Error
 * 500.
 *
 * @see com.slasher.CourseSelectorAPI.config.RestExceptionInterceptor
 */
public enum SupportedException {

  ASIGNACION_HORARIO_IS_NULL(AsignacionHorarioIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  ASIGNACION_HORARIO_NOT_FOUND(AsignacionHorarioNotFoundException.class, HttpStatus.NOT_FOUND),
  ASIGNATURA_IS_NULL(AsignaturaIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  ASIGNATURA_NOT_FOUND(AsignaturaNotFoundException.class, HttpStatus.NOT_FOUND),
  ASIGNATURA_POR_CARRERA_IS_NULL(AsignaturaPorCarreraIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  ASIGNATURA_POR_CARRERA_NOT_FOUND(AsignaturaPorCarreraNotFoundException.class, HttpStatus.NOT_FOUND),
  CARRERA_IS_NULL(CarreraIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  CARRERA_NOT_FOUND(CarreraNotFoundException.class, HttpStatus.NOT_FOUND),
  DOCENTE_ID_IS_EMPTY(DocenteIdIsEmptyException.class, HttpStatus.NOT_ACCEPTABLE),
  DOCENTE_ID_NULL(DocenteIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  DOCENTE_NOT_FOUND(DocenteNotFoundException.class, HttpStatus.NOT_FOUND),
  ESCOLARIDAD_IS_NULL(EscolaridadIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  ESCOLARIDAD_NOT_FOUND(EscolaridadNotFoundException.class, HttpStatus.NOT_FOUND),
  HORA_IS_NULL(HoraIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  HORA_NOT_FOUND(HoraNotFoundException.class, HttpStatus.NOT_FOUND),
  JEFE_CARRERA_ID_IS_EMPTY(JefeCarreraIdIsEmptyException.class, HttpStatus.NOT_ACCEPTABLE),
  JEFE_CARRERA_IS_NULL(JefeCarreraIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
  JEFE_CARRERA_NOT_FOUND(JefeCarreraNotFoundException.class, HttpStatus.NOT_FOUND);

  private final Class<? extends Throwable> exceptionClass;
  private final HttpStatus status;

  SupportedException(Class<?extends Throwable> exceptionClass, HttpStatus status) {
    this.exceptionClass = exceptionClass;
    this.status = status;
  }

  public Class<? extends Throwable> getExceptionClass() {
    return exceptionClass;
  }

  public HttpStatus getStatus() {
    return status;
  }

}
