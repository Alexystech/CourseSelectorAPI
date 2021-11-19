package com.slasher.CourseSelectorAPI.service.exception;

public class AsignaturaPorCarreraIsNullException extends RuntimeException{

  public static AsignaturaPorCarreraIsNullException of() {
    return new AsignaturaPorCarreraIsNullException();
  }

  public AsignaturaPorCarreraIsNullException() {
    super("Assigment of career is null");
  }

}
