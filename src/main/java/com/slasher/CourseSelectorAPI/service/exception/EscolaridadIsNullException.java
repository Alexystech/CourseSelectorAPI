package com.slasher.CourseSelectorAPI.service.exception;

public class EscolaridadIsNullException extends RuntimeException{

  public static EscolaridadIsNullException of() {
    return new EscolaridadIsNullException();
  }

  public EscolaridadIsNullException() {
    super("Scholarship is null");
  }

}
