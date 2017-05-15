/**
 *
 */
package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class ImeiTest {

  private static final String INVALID_IMEI_CHARS = "10A010101010104";
  private static final String INVALID_IMEI_CHECKSUM = "101010101010104";
  private static final String INVALID_IMEI_FAKE = "000000000000000";
  private static final String INVALID_IMEI_LENGTH = "1010101010101";
  private static final String VALID_IMEI = "101010101010103";
  private static final String VALID_IMEI_CHARS = "  10-101010-101010-3 ";
  private static final String VALID_IMEI_TWO = "202020202020206";

  /**
   * Test method for {@link de.feffi.jnumber.mobile.imei.Imei#Imei(java.lang.String)} .
   */
  @Test
  public void testImei() {
    final Imei imei = new Imei(VALID_IMEI);
    Assert.assertEquals(Imei.class, imei.getClass());
  }

  /**
   * Test method for {@link de.feffi.jnumber.mobile.imei.Imei#transform()} .
   */
  @Test
  public void testTransform() {
    final Imei imei1 = new Imei(VALID_IMEI_CHARS);
    Assert.assertEquals(imei1.transform(), "101010101010103");
  }

  /**
   * Test method for {@link de.feffi.jnumber.mobile.imei.Imei#validateSemantic()} .
   */
  @Test
  public void testValidateSemantic() {
    final Imei imei1 = new Imei(VALID_IMEI);
    final Imei imei2 = new Imei(VALID_IMEI_TWO);
    final Imei imeiInvalid1 = new Imei(INVALID_IMEI_CHECKSUM);
    final Imei imeiInvalid2 = new Imei(INVALID_IMEI_FAKE);

    try {
      imei1.validateSemantic();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      imei2.validateSemantic();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      imeiInvalid1.validateSemantic();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }

    try {
      imeiInvalid2.validateSemantic();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }
  }

  /**
   * Test method for {@link de.feffi.jnumber.mobile.imei.Imei#validateSyntax()} .
   */
  @Test
  public void testValidateSyntax() {
    final Imei imei1 = new Imei(VALID_IMEI);
    final Imei imei2 = new Imei(VALID_IMEI_TWO);
    final Imei imeiInvalid1 = new Imei(INVALID_IMEI_CHARS);
    final Imei imeiInvalid2 = new Imei(INVALID_IMEI_LENGTH);

    try {
      imei1.validateSyntax();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      imei2.validateSyntax();
      Assert.assertTrue(true);
    } catch (final ValidationException ve) {
      Assert.assertTrue(false);
    }

    try {
      imeiInvalid1.validateSyntax();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }

    try {
      imeiInvalid2.validateSyntax();
      Assert.assertTrue(false);
    } catch (final ValidationException ve) {
      Assert.assertTrue(true);
    }
  }
}
