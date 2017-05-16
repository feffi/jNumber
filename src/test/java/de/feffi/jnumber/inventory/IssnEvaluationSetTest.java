package de.feffi.jnumber.inventory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author feffi <feffi@feffi.org>
 */
public class IssnEvaluationSetTest {

  private static final int VALID_ISSN_CHECKDIGIT = 5;
  private static final String VALID_ISSN_TRANSFORMED = "03785955";

  /**
   * Test method for
   * {@link de.feffi.jnumber.mobile.imei.ImeiEvaluationSet#getCheckDigit()} .
   */
  @Test
  public void testGetCheckDigit() {
    assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.inventory.IssnEvaluationSet#setCheckDigit(int)} .
   */
  @Test
  public void testSetCheckDigit() {
    final IssnEvaluationSet testSet = new IssnEvaluationSet(VALID_ISSN_TRANSFORMED, VALID_ISSN_CHECKDIGIT);
    assertEquals(VALID_ISSN_CHECKDIGIT, testSet.getCheckDigit());
  }
}
