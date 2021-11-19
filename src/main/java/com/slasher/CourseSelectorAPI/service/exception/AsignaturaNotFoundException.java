package com.slasher.CourseSelectorAPI.service.exception;

public class AsignaturaNotFoundException extends RuntimeException{

  public static AsignaturaNotFoundException of(long idAsignatura) {
    return new AsignaturaNotFoundException(idAsignatura);
  }

  public AsignaturaNotFoundException(long idAsignatura) {
    super(String.format("course with id %d was not found",
        idAsignatura));
  }

}
