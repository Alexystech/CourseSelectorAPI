package com.slasher.CourseSelectorAPI.service.exception;

import org.springframework.http.HttpStatus;

public enum SupportedException {
  ;

  private final Class<? extends Throwable> exceptionClass;
  private final HttpStatus status;

  SupportedException(Class<?extends Throwable> exceptionClass, HttpStatus status) {
    this.exceptionClass = exceptionClass;
    this.status = status;
  }

  public Class<? extends Throwable> getExceptionClass() {
    return exceptionClass;
  }

  public HttpStatus getStatus() {
    return status;
  }

}
