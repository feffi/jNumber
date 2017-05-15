/**
 *
 */
package de.feffi.jnumber.inventory;

import de.feffi.jnumber.ValidationException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class IssnTest {

  private static final String INVALID_ISSN_CHARS = "037LL955";
  private static final String INVALID_ISSN_CHECKSUM = "03785959";
  private static final String INVALID_ISSN_LENGTH = "03785955123";
  private static final String VALID_ISSN = "0378-5955";
  private static final String VALID_ISSN_TRANSFORMED = "03785955";

  /**
   * Test method for {@link de.feffi.jnumber.inventory.Issn#getEvaluationSet()} .
   */
  @Test
  public void testGetEvaluationSet() {
    final Issn testClass = new Issn(VALID_ISSN);
    Assert.assertEquals(IssnEvaluationSet.class, testClass.getEvaluationSet().getClass());
  }

  /**
   * Test method for {@link de.feffi.jnumber.inventory.Issn#Issn(java.lang.String)} .
   */
  @Test
  public void testInternationalStandardBookNumber() {
    final Issn testClass = new Issn(VALID_ISSN);
    Assert.assertEquals(Issn.class, testClass.getClass());
  }

  /**
   * Test method for {@link de.feffi.jnumber.inventory.Issn#transform()}.
   */
  @Test
  public void testTransform() {
    final Issn testClass = new Issn(VALID_ISSN);
    Assert.assertEquals(VALID_ISSN_TRANSFORMED, testClass.transform());
  }

  /**
   * Test method for {@link de.feffi.jnumber.inventory.Issn#validateSemantic()} .
   */
  @Test
  public void testValidateSemantic() {
    final Issn issn1 = new Issn(VALID_ISSN);
    final Issn issnInvalid1 = new Issn(INVALID_ISSN_CHECKSUM);

    try {
      issn1.validateSemantic();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      issnInvalid1.validateSemantic();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }
  }

  /**
   * Test method for {@link de.feffi.jnumber.inventory.Issn#validateSyntax()}.
   */
  @Test
  public void testValidateSyntax() {
    final Issn issn1 = new Issn(VALID_ISSN);
    final Issn issnInvalid1 = new Issn(INVALID_ISSN_CHARS);
    final Issn issnInvalid2 = new Issn(INVALID_ISSN_CHECKSUM);
    final Issn issnInvalid3 = new Issn(INVALID_ISSN_LENGTH);

    try {
      issn1.validateSyntax();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }
    try {
      issnInvalid1.validateSyntax();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }
    try {
      issnInvalid2.validateSyntax();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      issnInvalid3.validateSyntax();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }
  }
}
