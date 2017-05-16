package de.feffi.jnumber;

/**
 * @author feffi <feffi@feffi.org>
 */
@SuppressWarnings("all")
public enum EnumSerialError {
  CHECKDIGIT("Check digit failure!"),
  FAKE_SERIAL("Fake serial!"),
  INVALID_CHARS("Invalid serial chars!"),
  INVALID_LENGTH("Invalid serial length!");

  private String value;

  EnumSerialError(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
