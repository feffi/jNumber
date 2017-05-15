/**
 *
 */
package de.feffi.jnumber;

import de.feffi.jnumber.evaluation.CommonEvaluationSet;

import java.net.URISyntaxException;

/**
 * @author feffi
 */
public class AbstractSerialTestClass extends AbstractSerial<CommonEvaluationSet> {

  /**
   * @param charFilter
   * @param internalVersion
   * @param manufacturerVersion
   * @param manufacturerDocumentationUri
   * @param serial
   * @throws URISyntaxException
   */
  public AbstractSerialTestClass(
      final String charFilter,
      final String internalVersion,
      final String manufacturerVersion,
      final String manufacturerDocumentationUri,
      final String serial) {
    super(charFilter, internalVersion, manufacturerVersion, manufacturerDocumentationUri);
    this.setValueRaw(serial);
  }

  @Override
  public CommonEvaluationSet getEvaluationSet() {
    return new CommonEvaluationSet(this.transform());
  }

  @Override
  public String transform() {
    return this.getValueRaw();
  }

  @Override
  public void validateSemantic() throws ValidationException {
    // nothing to test
  }

  @Override
  public void validateSyntax() throws ValidationException {
    // nothing to test
  }
}
