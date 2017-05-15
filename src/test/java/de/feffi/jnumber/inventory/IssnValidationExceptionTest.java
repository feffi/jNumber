/**
 *
 */
package de.feffi.jnumber.inventory;

import de.feffi.jnumber.ValidationException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feffi
 */
public class IssnValidationExceptionTest {

  private static final String DEFAULT_EXCEPTION_MESSAGE = "This is a validation exception";

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException()}
   * .
   */
  @Test
  public void testIssnValidationException() {
    Assert.assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.util.List)}
   * .
   */
  @Test
  public void testIssnValidationExceptionListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new IssnValidationException("Testexception 01"));
    validationErrors.add(new IssnValidationException("Testexception 02"));
    validationErrors.add(new IssnValidationException("Testexception 03"));
    final IssnValidationException validationException = new IssnValidationException(validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.String)}
   * .
   */
  @Test
  public void testIssnValidationExceptionString() {
    final IssnValidationException validationException = new IssnValidationException(IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE);
    Assert.assertTrue(validationException.getMessage().equals(IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.String, java.util.List)}
   * .
   */
  @Test
  public void testIssnValidationExceptionStringListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new IssnValidationException("Testexception 04"));
    validationErrors.add(new IssnValidationException("Testexception 05"));
    validationErrors.add(new IssnValidationException("Testexception 06"));
    final IssnValidationException validationException = new IssnValidationException(
        IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE,
        validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getMessage().equals(IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.String, java.lang.Throwable)}
   * .
   */
  @Test
  public void testIssnValidationExceptionStringThrowable() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new IssnValidationException("Testexception 13"));
    final IssnValidationException validationException = new IssnValidationException(
        IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE,
        new ValidationException("Testexception 14"));
    Assert.assertTrue(validationException.getValidationErrors().isEmpty());
    Assert.assertTrue(validationException.getMessage().equals(IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 14"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.String, java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testIssnValidationExceptionStringThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new IssnValidationException("Testexception 07"));
    validationErrors.add(new IssnValidationException("Testexception 08"));
    validationErrors.add(new IssnValidationException("Testexception 09"));
    final IssnValidationException validationException = new IssnValidationException(
        IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE,
        new ValidationException("Testexception 15"),
        validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getMessage().equals(IssnValidationExceptionTest.DEFAULT_EXCEPTION_MESSAGE));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 15"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.Throwable)}
   * .
   */
  @Test
  public void testIssnValidationExceptionThrowable() {
    final IssnValidationException validationException = new IssnValidationException(new ValidationException("Testexception 16"));
    Assert.assertTrue(validationException.getValidationErrors().isEmpty());
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 16"));
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnValidationException#IssnValidationException(java.lang.Throwable, java.util.List)}
   * .
   */
  @Test
  public void testIssnValidationExceptionThrowableListOfValidationException() {
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();
    validationErrors.add(new IssnValidationException("Testexception 10"));
    validationErrors.add(new IssnValidationException("Testexception 11"));
    validationErrors.add(new IssnValidationException("Testexception 12"));
    final IssnValidationException validationException = new IssnValidationException(new ValidationException("Testexception 17"), validationErrors);
    final List<ValidationException> expected = validationException.getValidationErrors();
    Assert.assertTrue(expected.containsAll(validationErrors));
    Assert.assertTrue(validationException.getCause().getMessage().equals("Testexception 17"));
  }
}
