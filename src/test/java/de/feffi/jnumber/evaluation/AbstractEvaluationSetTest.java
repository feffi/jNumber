package de.feffi.jnumber.evaluation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author feffi <feffi@feffi.org>
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
    assertTrue(true);
  }

  /**
   * Test method for
   * {@link de.feffi.jnumber.evaluation.AbstractEvaluationSet#getValueTransformed()}.
   */
  @Test
  public void testGetValueTransformed() {
    final AbstractEvaluationSetTestClass testClass = new AbstractEvaluationSetTestClass("test");
    assertEquals("test", testClass.getValueTransformed());
  }

  /**
   * Test method
   */
  @Test
  public void testSetValueTransformed() {
    final AbstractEvaluationSetTestClass testClass = new AbstractEvaluationSetTestClass("test");
    testClass.setValueTransformed("test2");
    assertEquals("test2", testClass.getValueTransformed());
  }

}
