/**
 *
 */
package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feffi
 */
public class ImeiValidationExceptionTest {

  private static final String DEFAULT_EXCEPTION_MESSAGE = "This is a validation exception";

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException()}
   * .
   */
  @Test
  public void testImeiValidationException() {
    Assert.assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.util.List)}
   * .
   */
  @Test
  public void testImeiValidationExceptionListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new ImeiValidationException("Testexception 01"));
    validationErrors.add(new ImeiValidationException("Testexception 02"));
    validationErrors.add(new ImeiValidationException("Testexception 03"));
    final ImeiValidationException validationException = new ImeiValidationException(validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.String)}
   * .
   */
  @Test
  public void testImeiValidationExceptionString() {
    final ImeiValidationException validationException = new ImeiValidationException(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE);
    Assert.assertTrue(validationException.getMessage().equals(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.String, java.util.List)}
   * .
   */
  @Test
  public void testImeiValidationExceptionStringListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new ImeiValidationException("Testexception 04"));
    validationErrors.add(new ImeiValidationException("Testexception 05"));
    validationErrors.add(new ImeiValidationException("Testexception 06"));
    final ImeiValidationException validationException = new ImeiValidationException(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE, validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getMessage().equals(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.String, java.lang.Throwable)}
   * .
   */
  @Test
  public void testImeiValidationExceptionStringThrowable() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new ImeiValidationException("Testexception 13"));
    final ImeiValidationException validationException = new ImeiValidationException(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE, new ValidationException(
        "Testexception 14"));
    Assert.assertTrue(validationException.getValidationErrors().isEmpty());
    Assert.assertTrue(validationException.getMessage().equals(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 14"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.String, java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testImeiValidationExceptionStringThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new ImeiValidationException("Testexception 07"));
    validationErrors.add(new ImeiValidationException("Testexception 08"));
    validationErrors.add(new ImeiValidationException("Testexception 09"));
    final ImeiValidationException validationException = new ImeiValidationException(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE, new ValidationException(
        "Testexception 15"), validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getMessage().equals(ImeiValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 15"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.Throwable)}
   * .
   */
  @Test
  public void testImeiValidationExceptionThrowable() {
    final ImeiValidationException validationException = new ImeiValidationException(new ValidationException("Testexception 16"));
    Assert.assertTrue(validationException.getValidationErrors().isEmpty());
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 16"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiValidationException#ImeiValidationException(java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testImeiValidationExceptionThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new ImeiValidationException("Testexception 10"));
    validationErrors.add(new ImeiValidationException("Testexception 11"));
    validationErrors.add(new ImeiValidationException("Testexception 12"));
    final ImeiValidationException validationException = new ImeiValidationException(new ValidationException("Testexception 17"), validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 17"));
  }
}
