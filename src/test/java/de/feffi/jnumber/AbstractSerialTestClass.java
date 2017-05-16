package de.feffi.jnumber;

import de.feffi.jnumber.evaluation.CommonEvaluationSet;

import java.net.URISyntaxException;

/**
 * @author feffi <feffi@feffi.org>
 */
public class AbstractSerialTestClass extends AbstractSerial<CommonEvaluationSet> {

  /**
   * 
   * Constructor
   *
   * @param charFilter                   The chars to strip from the raw serial.
   * @param internalVersion              The internal serial algorithm version.
   * @param manufacturerVersion          The manufacturer serial algorithm version.
   * @param manufacturerDocumentationUri The manufacturer documentation URI.
   * @param serial                       The serial number in raw form.
   * @throws URISyntaxException          In case of a wrong URI.
   */
  public AbstractSerialTestClass(
      final String charFilter,
      final String internalVersion,
      final String manufacturerVersion,
      final String manufacturerDocumentationUri,
      final String serial) throws URISyntaxException {
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
