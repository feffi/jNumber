/**
 *
 */
package de.feffi.jnumber.checksum;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class LuhnAlgorithmTest {

  private static final String COMPUTE_TEST = "101010101010100";
  private static final String INVALID_LUHN = "101010101010104";
  private static final String VALID_LUHN = "101010101010103";
  private static final String VALID_LUHN_TWO = "202020202020206";

  /**
   * Test method for {@link de.feffi.jnumber.checksum.LuhnAlgorithm#accept()}.
   */
  @Test
  public void testAccept() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    Assert.assertTrue(luhn.accept());

    final LuhnAlgorithm luhn2 = new LuhnAlgorithm(VALID_LUHN_TWO);
    Assert.assertTrue(luhn2.accept());

    final LuhnAlgorithm luhnNegative = new LuhnAlgorithm(INVALID_LUHN);
    Assert.assertFalse(luhnNegative.accept());

  }

  /**
   * Test method for {@link de.feffi.jnumber.checksum.LuhnAlgorithm#compute()}.
   */
  @Test
  public void testCompute() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    Assert.assertEquals(0, luhn.compute());
    final LuhnAlgorithm luhn2 = new LuhnAlgorithm(COMPUTE_TEST);
    Assert.assertEquals(7, luhn2.compute());
  }

  /**
   * Test method for {@link de.feffi.jnumber.checksum.LuhnAlgorithm#getChecksum()}.
   */
  @Test
  public void testGetChecksum() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    Assert.assertEquals(10, luhn.getChecksum());
    final LuhnAlgorithm luhn2 = new LuhnAlgorithm(COMPUTE_TEST);
    Assert.assertEquals(3, luhn2.getChecksum());
  }

  /**
   * Test method for {@link de.feffi.jnumber.checksum.LuhnAlgorithm#getValue()}.
   */
  @Test
  public void testGetValue() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    Assert.assertEquals(VALID_LUHN, luhn.getValue());
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.checksum.LuhnAlgorithm#LuhnAlgorithm(java.lang.String)}.
   */
  @Test
  public void testLuhnAlgorithm() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    final LuhnAlgorithm luhn2 = new LuhnAlgorithm(VALID_LUHN_TWO);
    Assert.assertNotSame(luhn, luhn2);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.checksum.LuhnAlgorithm#setValue(java.lang.String)}.
   */
  @Test
  public void testSetValue() {
    final LuhnAlgorithm luhn = new LuhnAlgorithm(VALID_LUHN);
    Assert.assertEquals(VALID_LUHN, luhn.getValue());
    luhn.setValue(VALID_LUHN_TWO);
    Assert.assertEquals(VALID_LUHN_TWO, luhn.getValue());
  }
}
