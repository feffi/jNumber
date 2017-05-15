/**
 *
 */
package de.feffi.jnumber.evaluation;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author feffi
 */
public class AbstractEvaluationSetTest {

  /**
   * Test method for
   * {@link de.feffi.jnumber.evaluation.AbstractEvaluationSet#AbstractEvaluationSet(java.lang.String)}
   * .
   */
  @Test
  public void testAbstractEvaluationSetString() {
    this.testGetValueTransformed();
    Assert.assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.evaluation.AbstractEvaluationSet#getValueTransformed()}.
   */
  @Test
  public void testGetValueTransformed() {
    final AbstractEvaluationSetTestClass testClass = new AbstractEvaluationSetTestClass("test");
    Assert.assertEquals("test", testClass.getValueTransformed());
  }

  /**
   * Test method
   */
  @Test
  public void testSetValueTransformed() {
    final AbstractEvaluationSetTestClass testClass = new AbstractEvaluationSetTestClass("test");
    testClass.setValueTransformed("test2");
    Assert.assertEquals("test2", testClass.getValueTransformed());
  }

}
