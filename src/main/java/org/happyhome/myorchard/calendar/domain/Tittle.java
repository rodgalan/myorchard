package org.happyhome.myorchard.calendar.domain;

import java.util.Objects;

public class Tittle {
  private final String tittle;

  public Tittle(String tittle) {
    this.tittle = tittle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tittle tittle1 = (Tittle) o;
    return Objects.equals(tittle, tittle1.tittle);
  }
}
