package com.slasher.CourseSelectorAPI.service.exception;

public class EscolaridadNotFoundException extends RuntimeException{

  public static EscolaridadNotFoundException of(long idEscolaridad) {
    return new EscolaridadNotFoundException(idEscolaridad);
  }

  public EscolaridadNotFoundException(long idEscolaridad) {
    super(String.format("Scholarship with id %d was not found",
        idEscolaridad));
  }

}
