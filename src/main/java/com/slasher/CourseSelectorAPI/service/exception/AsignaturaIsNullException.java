package com.slasher.CourseSelectorAPI.service.exception;

public class AsignaturaIsNullException extends RuntimeException{

  public static AsignaturaIsNullException of() {
    return new AsignaturaIsNullException();
  }

  public AsignaturaIsNullException() {
    super("course is null");
  }

}
