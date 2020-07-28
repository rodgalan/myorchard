package org.happyhome.myorchard.calendar.domain;

import java.util.Objects;

public class Description {
  private final String description;

  public Description(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Description that = (Description) o;
    return Objects.equals(description, that.description);
  }

}
