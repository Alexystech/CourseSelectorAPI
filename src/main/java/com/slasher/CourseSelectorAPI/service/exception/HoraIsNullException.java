package com.slasher.CourseSelectorAPI.service.exception;

public class HoraIsNullException extends RuntimeException{

  public static HoraIsNullException of() {
    return new HoraIsNullException();
  }

  public HoraIsNullException() {
    super("Time is null");
  }

}
