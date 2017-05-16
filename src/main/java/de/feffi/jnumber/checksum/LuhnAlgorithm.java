package de.feffi.jnumber.checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author feffi <feffi@feffi.org>
 * @see <a href="http://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm</a>
 */
public class LuhnAlgorithm {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(LuhnAlgorithm.class);

  private String value = null;

  /**
   * @param value The value to check.
   */
  public LuhnAlgorithm(final String value) {
    super();
    this.value = value;
  }

  /**
   * Checks if serial is Luhn compatible
   *
   * @return The check result.
   */
  public Boolean accept() {
    return this.compute() == 0;
  }

  /**
   * Computes the Luhn algorithm against the given value.
   *
   * @return The computation result.
   */
  public int compute() {
    if (this.getValue() == null) {
      throw new NumberFormatException("Cannot compute luhn! Empty number given!");
    }

    final int[][] sumTable = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {0, 2, 4, 6, 8, 1, 3, 5, 7, 9}};
    int sum = 0;
    int flip = 0;

    for (int i = this.getValue().length() - 1; i >= 0; i--) {
      sum += sumTable[flip++ & 0x1][Character.digit(this.getValue().charAt(i), 10)];
    }
    sum = sum % 10;
    LOG.debug("Computed Luhn sum for [{}]: [{}]", this.getValue(), sum);
    return sum;
  }

  /**
   * Computes the Luhn algorithm checksum against the given value.
   *
   * @return The computation checksum.
   */
  public int getChecksum() {
    final int checksum = 10 - this.compute();
    LOG.debug("Computed Luhn checksum for [{}]: [{}]", this.getValue(), checksum);
    return checksum;
  }

  /**
   * @return the value
   */
  String getValue() {
    return this.value;
  }

  /**
   * @param value the value to set
   */
  void setValue(final String value) {
    this.value = value;
  }
}
