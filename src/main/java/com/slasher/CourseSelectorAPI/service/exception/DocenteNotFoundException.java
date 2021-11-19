package com.slasher.CourseSelectorAPI.service.exception;

public class DocenteNotFoundException extends RuntimeException{

  public static DocenteNotFoundException of(String idDocente) {
    return new DocenteNotFoundException(idDocente);
  }

  public DocenteNotFoundException(String idDocente) {
    super(String.format("professor with id %d was not found",
        idDocente));
  }

}
