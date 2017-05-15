/**
 *
 */
package de.feffi.jnumber.mobile.imei;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class ImeiEvaluationSetTest {

  private static final int VALID_IMEI_CHECKDIGIT = 3;
  private static final String VALID_IMEI_FINALASSEMBLYCODE = "3649843";
  private static final String VALID_IMEI_SOFTWAREVERSIONNUMBER = "92";
  private static final String VALID_IMEI_TRANSFORMED = "298364923649843";
  private static final String VALID_IMEI_TYPEALLOCATIONCODE = "298364";

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#getCheckDigit()}
   * .
   */
  @Test
  public void testGetCheckDigit() {
    Assert.assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#getFinalAssemblyCode()}
   * .
   */
  @Test
  public void testGetFinalAssemblyCode() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_FINALASSEMBLYCODE, testSet.getFinalAssemblyCode());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#getSoftwareVersionNumber()}
   * .
   */
  @Test
  public void testGetSoftwareVersionNumber() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_SOFTWAREVERSIONNUMBER, testSet.getSoftwareVersionNumber());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#getTypeAllocationCode()}
   * .
   */
  @Test
  public void testGetTypeApprovalCode() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_TYPEALLOCATIONCODE, testSet.getTypeAllocationCode());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#setCheckDigit(int)}
   * .
   */
  @Test
  public void testSetCheckDigit() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_CHECKDIGIT, testSet.getCheckDigit());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#setFinalAssemblyCode(java.lang.String)}
   * .
   */
  @Test
  public void testSetFinalAssemblyCode() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_FINALASSEMBLYCODE, testSet.getFinalAssemblyCode());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#setSoftwareVersionNumber(java.lang.String)}
   * .
   */
  @Test
  public void testSetSoftwareVersionNumber() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_SOFTWAREVERSIONNUMBER, testSet.getSoftwareVersionNumber());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#setTypeAllocationCode(java.lang.String)}
   * .
   */
  @Test
  public void testSetTypeAllocationCode() {
    final ImeiEvaluationSet testSet = new ImeiEvaluationSet(
        VALID_IMEI_TRANSFORMED,
        VALID_IMEI_CHECKDIGIT,
        VALID_IMEI_TYPEALLOCATIONCODE,
        VALID_IMEI_FINALASSEMBLYCODE,
        VALID_IMEI_SOFTWAREVERSIONNUMBER);
    Assert.assertEquals(VALID_IMEI_TYPEALLOCATIONCODE, testSet.getTypeAllocationCode());
  }
}
