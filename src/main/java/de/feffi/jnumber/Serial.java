package de.feffi.jnumber;

/**
 * @param <T> Type of EvaluationSet.
 * @author feffi <feffi@feffi.org>
 */
interface Serial<T> {

  /**
   * Evaluates, if possible, the given serial number.
   *
   * @return The evaluation set of the specialized serial number.
   * @throws ValidationException If validations fails.
   */
  T evaluate() throws ValidationException;

  /**
   * Checks if the given serial number is valid.
   *
   * @return The validation result.
   */
  Boolean isValid();

  /**
   * Validates the given serial number.
   *
   * @throws ValidationException If syntax or semantic (or both) validation fails.
   */
  void validate() throws ValidationException;
}
