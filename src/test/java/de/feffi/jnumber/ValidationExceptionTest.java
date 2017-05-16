package de.feffi.jnumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * @author feffi <feffi@feffi.org>
 */
public class ValidationExceptionTest {

  private static final String DEFAULT_VALIDATION_EXCEPTION = "This is a validation exception";

  /**
   * Test method for {@link de.feffi.jnumber.ValidationException#getValidationErrors()}.
   */
  @Test
  public void testGetValidationErrors() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 01"));
    validationErrors.add(new ValidationException("Testexception 02"));
    validationErrors.add(new ValidationException("Testexception 03"));
    final ValidationException validationException = new ValidationException(validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#setValidationErrors(java.util.List)}.
   */
  @Test
  public void testSetValidationErrors() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 04"));
    validationErrors.add(new ValidationException("Testexception 05"));
    validationErrors.add(new ValidationException("Testexception 06"));
    final ValidationException validationException = new ValidationException();
    validationException.setValidationErrors(validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
  }

  /**
   * Test method for {@link de.feffi.jnumber.ValidationException#ValidationException()}.
   */
  @Test
  public void testValidationException() {
    assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.util.List)}.
   */
  @Test
  public void testValidationExceptionListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 07"));
    validationErrors.add(new ValidationException("Testexception 08"));
    validationErrors.add(new ValidationException("Testexception 09"));
    final ValidationException validationException = new ValidationException(validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.String)}.
   */
  @Test
  public void testValidationExceptionString() {
    final ValidationException validationException = new ValidationException(DEFAULT_VALIDATION_EXCEPTION);
    assertTrue(validationException.getMessage().equals(DEFAULT_VALIDATION_EXCEPTION));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.String, java.util.List)}
   * .
   */
  @Test
  public void testValidationExceptionStringListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 10"));
    validationErrors.add(new ValidationException("Testexception 11"));
    validationErrors.add(new ValidationException("Testexception 12"));
    final ValidationException validationException = new ValidationException(DEFAULT_VALIDATION_EXCEPTION, validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
    assertTrue(validationException.getMessage().equals(DEFAULT_VALIDATION_EXCEPTION));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.String, java.lang.Throwable)}
   * .
   */
  @Test
  public void testValidationExceptionStringThrowable() {
    final ValidationException validationException = new ValidationException(DEFAULT_VALIDATION_EXCEPTION, new ValidationException("Testexception 14"));
    assertTrue(validationException.getValidationErrors().isEmpty());
    assertTrue(validationException.getMessage().equals(DEFAULT_VALIDATION_EXCEPTION));
    assertTrue(validationException.getCause().getMessage().equals("Testexception 14"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.String, java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testValidationExceptionStringThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 15"));
    validationErrors.add(new ValidationException("Testexception 16"));
    validationErrors.add(new ValidationException("Testexception 17"));
    final ValidationException validationException = new ValidationException(
        DEFAULT_VALIDATION_EXCEPTION,
        new ValidationException("Testexception 18"),
        validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
    assertTrue(validationException.getMessage().equals(DEFAULT_VALIDATION_EXCEPTION));
    assertTrue(validationException.getCause().getMessage().equals("Testexception 18"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.Throwable)}
   * .
   */
  @Test
  public void testValidationExceptionThrowable() {
    final ValidationException validationException = new ValidationException(new ValidationException("Testexception 19"));
    assertTrue(validationException.getValidationErrors().isEmpty());
    assertTrue(validationException.getCause().getMessage().equals("Testexception 19"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.ValidationException#ValidationException(java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testValidationExceptionThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<>();
    validationErrors.add(new ValidationException("Testexception 20"));
    validationErrors.add(new ValidationException("Testexception 21"));
    validationErrors.add(new ValidationException("Testexception 22"));
    final ValidationException validationException = new ValidationException(new ValidationException("Testexception 23"), validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    assertTrue(expected.containsAll(validationErrors));
    assertTrue(validationException.getCause().getMessage().equals("Testexception 23"));
  }
}
