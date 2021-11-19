package com.slasher.CourseSelectorAPI.service.exception;

public class JefeCarreraIsNullException extends RuntimeException{

  public static JefeCarreraIsNullException of() {
    return new JefeCarreraIsNullException();
  }

  public JefeCarreraIsNullException() {
    super("chief career officer is null");
  }

}
