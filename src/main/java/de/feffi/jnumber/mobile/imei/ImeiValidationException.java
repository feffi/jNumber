/**
 *
 */
package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;

import java.util.List;

/**
 * Exception any errors regarding the IMEI syntax or semantic.
 *
 * @author feffi
 */
public class ImeiValidationException extends ValidationException {

  /**
   * Default serial version ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   *
   */
  public ImeiValidationException() {
    super();
  }

  /**
   * @param validationErrors
   */
  public ImeiValidationException(final List<ValidationException> validationErrors) {
    super(validationErrors);
  }

  /**
   * @param arg0
   */
  public ImeiValidationException(final String arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param validationErrors
   */
  public ImeiValidationException(final String arg0, final List<ValidationException> validationErrors) {
    super(arg0, validationErrors);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public ImeiValidationException(final String arg0, final Throwable arg1) {
    super(arg0, arg1);
  }

  /**
   * @param arg0
   * @param arg1
   * @param validationErrors
   */
  public ImeiValidationException(final String arg0, final Throwable arg1, final List<ValidationException> validationErrors) {
    super(arg0, arg1, validationErrors);
  }

  /**
   * @param arg0
   */
  public ImeiValidationException(final Throwable arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param validationErrors
   */
  public ImeiValidationException(final Throwable arg0, final List<ValidationException> validationErrors) {
    super(arg0, validationErrors);
  }
}
