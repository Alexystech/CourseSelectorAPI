package com.slasher.CourseSelectorAPI.service.exception;

public class DocenteIdIsEmptyException extends RuntimeException{

  public static DocenteIdIsEmptyException of() {
    return new DocenteIdIsEmptyException();
  }

  public DocenteIdIsEmptyException() {
    super("professor id is empty");
  }

}
