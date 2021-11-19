package com.slasher.CourseSelectorAPI.service.exception;

public class JefeCarreraIdIsEmptyException extends RuntimeException{

  public static JefeCarreraIdIsEmptyException of() {
    return new JefeCarreraIdIsEmptyException();
  }

  public JefeCarreraIdIsEmptyException() {
    super("chief career officer id is empty");
  }

}
