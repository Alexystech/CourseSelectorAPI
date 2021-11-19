package com.slasher.CourseSelectorAPI.service.exception;

public class HorarioIsNullException extends RuntimeException{

  public static HorarioIsNullException of() {
    return new HorarioIsNullException();
  }

  public HorarioIsNullException() {
    super("Time is null");
  }

}
