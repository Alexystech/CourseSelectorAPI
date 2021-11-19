package com.slasher.CourseSelectorAPI.service.exception;

public class AsignacionHorarioIsNullException extends RuntimeException{

  public static AsignacionHorarioIsNullException of() {
    return new AsignacionHorarioIsNullException();
  }

  public AsignacionHorarioIsNullException() {
    super("The assignation cant be null");
  }

}
