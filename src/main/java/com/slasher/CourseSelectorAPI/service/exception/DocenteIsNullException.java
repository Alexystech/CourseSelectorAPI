package com.slasher.CourseSelectorAPI.service.exception;

public class DocenteIsNullException extends RuntimeException{

  public static DocenteIsNullException of() {
    return new DocenteIsNullException();
  }

  public DocenteIsNullException() {
    super("professor is null");
  }

}
