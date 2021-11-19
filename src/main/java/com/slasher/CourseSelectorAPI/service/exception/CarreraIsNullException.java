package com.slasher.CourseSelectorAPI.service.exception;

public class CarreraIsNullException extends RuntimeException{

  public static CarreraIsNullException of() {
    return new CarreraIsNullException();
  }

  public CarreraIsNullException() {
    super("career is null");
  }

}
