package com.slasher.CourseSelectorAPI.service.exception;

public class AsignacionHorarioNotFoundException extends RuntimeException{

  public static AsignacionHorarioNotFoundException of(long idAsignacionHorario) {
    return new AsignacionHorarioNotFoundException(idAsignacionHorario);
  }

  public AsignacionHorarioNotFoundException(long idAsignacionHorario) {
    super(String.format("The hour that you try to get with id %d was not found",
        idAsignacionHorario));
  }

}
