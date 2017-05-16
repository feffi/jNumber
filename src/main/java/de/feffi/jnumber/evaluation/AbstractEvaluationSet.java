package de.feffi.jnumber.evaluation;

/**
 * @author feffi <feffi@feffi.org>
 */
public abstract class AbstractEvaluationSet implements EvaluationSet {

  /**
   * The given serial transformed to the (manufacturer, emitter) form.
   */
  private String valueTransformed = null;

  /**
   * @param valueTransformed The tranformed value.
   */
  protected AbstractEvaluationSet(final String valueTransformed) {
    super();
    this.valueTransformed = valueTransformed;
  }

  /**
   * @return The transformed value.
   */
  public String getValueTransformed() {
    return this.valueTransformed;
  }

  /**
   * @param valueTransformed The transformed value to set.
   */
  void setValueTransformed(final String valueTransformed) {
    this.valueTransformed = valueTransformed;
  }
}
