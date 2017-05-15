/**
 *
 */
package de.feffi.jnumber.checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author feffi
 */
public class Modulo11Algorithm {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(Modulo11Algorithm.class);

  private String value = null;

  /**
   * @param value
   */
  public Modulo11Algorithm(final String value) {
    super();
    this.value = value;
  }

  /**
   * Checks if serial is Modulo 11 compatible
   *
   * @return The check result.
   */
  public Boolean accept() {
    return this.getChecksum() == Character.digit(this.getValue().charAt(this.getValue().length() - 1), 10);
  }

  /**
   * Computes the Modulo 11 algorithm against the given value.
   *
   * @return The computation result.
   */
  public int compute() {
    if (this.getValue() == null) {
      throw new NumberFormatException("Cannot compute modulo 11! Empty number given!");
    }

    int sum = 0;
    // final char[] tmp = transformedSerial.toCharArray();
    for (int i = 0; i < this.getValue().length() - 1; i++) {
      final int value = Character.digit(this.getValue().charAt(i), 10);// Integer.parseInt(String.valueOf(tmp[i]));
      final int pos = this.getValue().length() - i;
      sum += value * pos;
    }
    sum = sum % 11;
    LOG.debug("Computed Modulo 11 sum for [{}]: [{}]", this.getValue(), sum);
    return sum;
  }

  /**
   * Computes the Modulo 11 algorithm checksum against the given value.
   *
   * @return The computation checksum.
   */
  public int getChecksum() {
    final int checksum = 11 - this.compute();
    LOG.debug("Computed Modulo 11 checksum for [{}]: [{}]", this.getValue(), checksum);
    return checksum;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(final String value) {
    this.value = value;
  }
}
