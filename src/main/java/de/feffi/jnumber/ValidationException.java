/**
 *
 */
package de.feffi.jnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception any errors regarding the syntax or semantic.
 *
 * @author feffi
 */
public class ValidationException extends Exception {

  /**
   * Default serial version ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The occured validation errors
   */
  private List<ValidationException> validationErrors = new ArrayList<ValidationException>();

  /**
   * Default constructor.
   */
  public ValidationException() {
    super();
  }

  /**
   * Default constructor.
   *
   * @param validationErrors The validation exceptions causes.
   */
  public ValidationException(final List<ValidationException> validationErrors) {
    super();
    this.validationErrors = validationErrors;
  }

  /**
   * @param exceptionMessage The message of the failed validation.
   */
  public ValidationException(final String exceptionMessage) {
    super(exceptionMessage);
  }

  /**
   * @param exceptionMessage The message of the failed validation.
   * @param validationErrors The validation exceptions causes.
   */
  public ValidationException(final String exceptionMessage, final List<ValidationException> validationErrors) {
    super(exceptionMessage);
    this.validationErrors = validationErrors;
  }

  /**
   * @param exceptionMessage The message of the failed validation.
   * @param cause            The validation exceptions cause.
   */
  public ValidationException(final String exceptionMessage, final Throwable cause) {
    super(exceptionMessage, cause);
  }

  /**
   * @param exceptionMessage The message of the failed validation.
   * @param cause            The validation exceptions cause.
   * @param validationErrors The validation exceptions causes.
   */
  public ValidationException(final String exceptionMessage, final Throwable cause, final List<ValidationException> validationErrors) {
    super(exceptionMessage, cause);
    this.validationErrors = validationErrors;
  }

  /**
   * @param cause The validation exceptions cause.
   */
  public ValidationException(final Throwable cause) {
    super(cause);
  }

  /**
   * @param cause            The validation exceptions cause.
   * @param validationErrors The validation exceptions causes.
   */
  public ValidationException(final Throwable cause, final List<ValidationException> validationErrors) {
    super(cause);
    this.validationErrors = validationErrors;
  }

  /**
   * @return The validation errors.
   */
  public List<ValidationException> getValidationErrors() {
    return this.validationErrors;
  }

  /**
   * @param validationErrors The validation errors to set.
   */
  public void setValidationErrors(final List<ValidationException> validationErrors) {
    this.validationErrors = validationErrors;
  }
}
