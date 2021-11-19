package com.slasher.CourseSelectorAPI.service.exception;

public class JefeCarreraNotFoundException extends RuntimeException{

  public static JefeCarreraNotFoundException of(String idJefeCarrera) {
    return new JefeCarreraNotFoundException(idJefeCarrera);
  }

  public JefeCarreraNotFoundException(String idJefeCarrera) {
    super(String.format("chief career officer with id %s was not found",
        idJefeCarrera));
  }

}
