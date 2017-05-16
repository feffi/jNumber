package de.feffi.jnumber.evaluation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author feffi <feffi@feffi.org>
 */
public class CommonEvaluationSetTest {

  /**
   * Test method
   */
  @Test
  public void testCommonEvaluationSetString() {
    this.testGetValueTransformed();
    assertTrue(true);
  }

  /**
   * Test method
   */
  @Test
  public void testGetValueTransformed() {
    final CommonEvaluationSet testClass = new CommonEvaluationSet("test");
    assertEquals("test", testClass.getValueTransformed());
  }

  /**
   * Test method
   */
  @Test
  public void testSetValueTransformed() {
    final CommonEvaluationSet testClass = new CommonEvaluationSet("test");
    testClass.setValueTransformed("test2");
    assertEquals("test2", testClass.getValueTransformed());
  }
}
