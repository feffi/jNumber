package de.feffi.jnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author feffi <feffi@feffi.org>
 */
public class EnumSerialErrorTest {

  /**
   * Test method for {@link de.feffi.jnumber.EnumSerialError#toString()}.
   */
  @Test
  public void testToString() {
		assertEquals("Check digit failure!", EnumSerialError.CHECKDIGIT.toString());
		assertEquals("Fake serial!", EnumSerialError.FAKE_SERIAL.toString());
		assertEquals("Invalid serial chars!", EnumSerialError.INVALID_CHARS.toString());
		assertEquals("Invalid serial length!", EnumSerialError.INVALID_LENGTH.toString());
  }
}
