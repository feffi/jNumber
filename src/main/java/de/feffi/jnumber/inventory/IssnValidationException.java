/**
 *
 */
package de.feffi.jnumber.inventory;

import de.feffi.jnumber.ValidationException;

import java.util.List;

/**
 * @author feffi
 */
public class IssnValidationException extends ValidationException {
  /**
   * Default serial version ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   *
   */
  public IssnValidationException() {
    super();
  }

  /**
   * @param validationErrors
   */
  public IssnValidationException(final List<ValidationException> validationErrors) {
    super(validationErrors);
  }

  /**
   * @param arg0
   */
  public IssnValidationException(final String arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param validationErrors
   */
  public IssnValidationException(final String arg0, final List<ValidationException> validationErrors) {
    super(arg0, validationErrors);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public IssnValidationException(final String arg0, final Throwable arg1) {
    super(arg0, arg1);
  }

  /**
   * @param arg0
   * @param arg1
   * @param validationErrors
   */
  public IssnValidationException(final String arg0, final Throwable arg1, final List<ValidationException> validationErrors) {
    super(arg0, arg1, validationErrors);
  }

  /**
   * @param arg0
   */
  public IssnValidationException(final Throwable arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param validationErrors
   */
  public IssnValidationException(final Throwable arg0, final List<ValidationException> validationErrors) {
    super(arg0, validationErrors);
  }
}
