package de.feffi.jnumber;

import de.feffi.jnumber.evaluation.CommonEvaluationSet;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author feffi <feffi@feffi.org>
 */
@SuppressWarnings("PMD.TooManyMethods")
public class AbstractSerialTest {

  private static final String STRIPCHARS = "-";
  private static final String VALID_IMEI = "298364923649843";
  private static final String VERSION_INTERNAL = "0.0";
  private static final String VERSION_MANUFACTURER = "0.0.0";
  private static final String VERSION_MANUFACTURER_URI = "http://foo.bar";
  private static final String VERSION_MANUFACTURER_URI_INVALID = "://foo.bar";

  /**
   * Test method for
   * {@link de.feffi.jnumber.AbstractSerial#AbstractSerial(String, String, String, String)}
   * .
   */
  @Test
  public void testAbstractSerial() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      final CommonEvaluationSet testSet = testClass.evaluate();
      Assert.assertEquals(VALID_IMEI, testSet.getValueTransformed());
      Assert.assertEquals(AbstractSerialTestClass.class, testClass.getClass());
    } catch (final ValidationException e) {
      Assert.assertTrue(false);
    }
    Assert.assertTrue(true);
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#evaluate()}.
   */
  @Test
  public void testEvaluate() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      final CommonEvaluationSet testSet = testClass.evaluate();
      Assert.assertEquals(VALID_IMEI, testSet.getValueTransformed());
      Assert.assertTrue(true);
    } catch (final ValidationException e) {
      Assert.assertTrue(false);
    }
  }

  /**
   * Test method
   */
  @Test
  public void testGetCaonfiguration() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      Assert.assertEquals(STRIPCHARS, testClass.getCharFilter());
      Assert.assertEquals(VERSION_INTERNAL, testClass.getInternalVersion());
      Assert.assertEquals(VERSION_MANUFACTURER, testClass.getManufacturerVersion());
      Assert.assertEquals(new URI(VERSION_MANUFACTURER_URI), testClass.getManufacturerDocumentationUri());
    } catch (final URISyntaxException e) {
      Assert.assertTrue(false);
    }
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#getEvaluationSet()}.
   */
  @Test
  public void testGetEvaluationSet() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    final CommonEvaluationSet testSet = testClass.getEvaluationSet();
    Assert.assertEquals(VALID_IMEI, testSet.getValueTransformed());
    Assert.assertTrue(true);
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#getValueRaw()}.
   */
  @Test
  public void testGetValueRaw() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    Assert.assertEquals(VALID_IMEI, testClass.getValueRaw());
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#isValid()}.
   */
  @Test
  public void testIsValid() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    Assert.assertTrue(testClass.isValid());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.AbstractSerial#setCharFilter(java.lang.String)}.
   */
  @Test
  public void testSetCharFilter() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    final String expectedString = "+";
    testClass.setCharFilter(expectedString);
    Assert.assertEquals(expectedString, testClass.getCharFilter());
  }

  /**
   * Test method
   */
  @Test
  public void testSetInternalVersion() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    final String expected = "99.99";
    testClass.setInternalVersion(expected);
    Assert.assertEquals(expected, testClass.getInternalVersion());
  }

  /**
   * Test method
   */
  @Test
  public void testSetManufacturerDocumentationUri() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    final String expected = "http://bar.fumm";
    try {
      testClass.setManufacturerDocumentationUri(new URI(expected));
      Assert.assertEquals(new URI(expected), testClass.getManufacturerDocumentationUri());
    } catch (final URISyntaxException e) {
      Assert.assertTrue(false);
    }
  }

  /**
   * Test method
   */
  @Test
  public void testSetManufacturerVersion() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    final String expected = "999.99";
    testClass.setManufacturerVersion(expected);
    Assert.assertEquals(expected, testClass.getManufacturerVersion());
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#setValueRaw(java.lang.String)}
   * .
   */
  @Test
  public void testSetValueRaw() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    testClass.setValueRaw(VALID_IMEI);
    Assert.assertEquals(VALID_IMEI, testClass.getValueRaw());
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#transform()}.
   */
  @Test
  public void testTransform() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    Assert.assertEquals(VALID_IMEI, testClass.transform());
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#validate()}.
   */
  @Test
  public void testValidate() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      testClass.validate();
      Assert.assertTrue(true);
    } catch (final ValidationException e) {
      Assert.assertTrue(false);
    }
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#validateSemantic()}.
   */
  @Test
  public void testValidateSemantic() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      testClass.validateSemantic();
      Assert.assertTrue(true);
    } catch (final ValidationException e) {
      Assert.assertTrue(false);
    }
  }

  /**
   * Test method for {@link de.feffi.jnumber.AbstractSerial#validateSyntax()}.
   */
  @Test
  public void testValidateSyntax() throws URISyntaxException {
    final AbstractSerialTestClass testClass = new AbstractSerialTestClass(
        STRIPCHARS,
        VERSION_INTERNAL,
        VERSION_MANUFACTURER,
        VERSION_MANUFACTURER_URI,
        VALID_IMEI);
    try {
      testClass.validateSyntax();
      Assert.assertTrue(true);
    } catch (final ValidationException e) {
      Assert.assertTrue(false);
    }
  }
}
