package com.slasher.CourseSelectorAPI.service.exception;

public class HorarioNotFoundException extends RuntimeException{

  public static HorarioNotFoundException of(long idHorario) {
    return new HorarioNotFoundException(idHorario);
  }

  public HorarioNotFoundException(long idHorario) {
    super(String.format("Time with id %d was not found",
        idHorario));
  }

}
