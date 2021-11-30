package com.slasher.CourseSelectorAPI.service.exception;

public class HoraNotFoundException extends RuntimeException{

  public static HoraNotFoundException of(long idHorario) {
    return new HoraNotFoundException(idHorario);
  }

  public HoraNotFoundException(long idHorario) {
    super(String.format("Time with id %d was not found",
        idHorario));
  }

}
