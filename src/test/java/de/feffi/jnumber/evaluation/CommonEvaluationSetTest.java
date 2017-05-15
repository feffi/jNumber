/**
 *
 */
package de.feffi.jnumber.evaluation;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class CommonEvaluationSetTest {

  /**
   * Test method
   */
  @Test
  public void testCommonEvaluationSetString() {
    this.testGetValueTransformed();
    Assert.assertTrue(true);
  }

  /**
   * Test method
   */
  @Test
  public void testGetValueTransformed() {
    final CommonEvaluationSet testClass = new CommonEvaluationSet("test");
    Assert.assertEquals("test", testClass.getValueTransformed());
  }

  /**
   * Test method
   */
  @Test
  public void testSetValueTransformed() {
    final CommonEvaluationSet testClass = new CommonEvaluationSet("test");
    testClass.setValueTransformed("test2");
    Assert.assertEquals("test2", testClass.getValueTransformed());
  }
}
