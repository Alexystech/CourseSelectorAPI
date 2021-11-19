package com.slasher.CourseSelectorAPI.service.exception;

public class AsignaturaPorCarreraNotFoundException extends RuntimeException {

  public AsignaturaPorCarreraNotFoundException of(long idAsignaturaPorCarrera) {
    return new AsignaturaPorCarreraNotFoundException(idAsignaturaPorCarrera);
  }

  public AsignaturaPorCarreraNotFoundException(long idAsignaturaPorCarrera) {
    super(String.format("assigment of career with id %d was not found",
        idAsignaturaPorCarrera));
  }

}
