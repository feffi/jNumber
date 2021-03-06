package de.feffi.jnumber.inventory;

import de.feffi.jnumber.evaluation.AbstractEvaluationSet;

/**
 * @author feffi <feffi@feffi.org>
 */
class IssnEvaluationSet extends AbstractEvaluationSet {

  /**
   * The ISSNs check digit.
   */
  private int checkDigit;

  /**
   * @param valueTransformed The cleaned ISSN value.
   * @param checkDigit       The ISSNs check digit.
   */
  IssnEvaluationSet(final String valueTransformed, final int checkDigit) {
    super(valueTransformed);
    this.checkDigit = checkDigit;
  }

  /**
   * @return the checkDigit
   */
  int getCheckDigit() {
    return this.checkDigit;
  }

  /**
   * @param checkDigit the checkDigit to set
   */
  void setCheckDigit(final int checkDigit) {
    this.checkDigit = checkDigit;
  }
}
