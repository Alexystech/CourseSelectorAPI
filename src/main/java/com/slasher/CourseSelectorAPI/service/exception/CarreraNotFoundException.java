package com.slasher.CourseSelectorAPI.service.exception;

public class CarreraNotFoundException extends RuntimeException{

  public static CarreraNotFoundException of(long idCarrera) {
    return new CarreraNotFoundException(idCarrera);
  }

  public CarreraNotFoundException(long idCarrera) {
    super(String.format("career with id %d was not found",
        idCarrera));
  }

}
