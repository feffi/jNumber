package de.feffi.jnumber.inventory;

import de.feffi.jnumber.AbstractSerial;
import de.feffi.jnumber.EnumSerialError;
import de.feffi.jnumber.ValidationException;
import de.feffi.jnumber.checksum.Modulo11Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * @author feffi <feffi@feffi.org>
 */
public class Issn extends AbstractSerial<IssnEvaluationSet> {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(Issn.class);
  private static final String STRIPCHARS = "[^0-9]";
  private static final String VERSION_INTERNAL = "1.0";
  private static final String VERSION_MANUFACTURER = "11.0.0";
  private static final String VERSION_MANUFACTURER_URI = "http://www.3gpp.org/ftp/Specs/html-info/23003.htm";

  /**
   * @param issn The ISSN to check.
   * @throws URISyntaxException In case of a wrong URI.
   */

  Issn(final String issn) throws URISyntaxException {
    super(STRIPCHARS, VERSION_INTERNAL, VERSION_MANUFACTURER, VERSION_MANUFACTURER_URI);
    this.setValueRaw(issn);
  }

  @Override
  public IssnEvaluationSet getEvaluationSet() {
    final String transformedSerial = this.transform();
    LOG.debug("Evaluating ISSN [{}] -> [{}].", this.getValueRaw(), transformedSerial);

    final int checkDigit = new Modulo11Algorithm(transformedSerial.substring(0, 7) + "0").getChecksum();
    LOG.debug(" - check digit: {}", checkDigit);

    return new IssnEvaluationSet(transformedSerial, checkDigit);
  }

  @Override
  public String transform() {
    final String transformed = getValueRaw().trim().replaceAll(this.getCharFilter(), "");
    LOG.debug("Transforming ISSN [{}] to [{}].", this.getValueRaw(), transformed);
    return transformed;
  }

  @Override
  public void validateSemantic() throws ValidationException {
    final String transformedSerial = this.transform();

    // catch fake IMEIs like "00000000"
    if (Long.parseLong(transformedSerial) == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("ISSN [{}] semantic check failure: {}", transformedSerial, EnumSerialError.FAKE_SERIAL.toString());
      }
      throw new ValidationException(EnumSerialError.FAKE_SERIAL.toString());
    }

    if (!new Modulo11Algorithm(transformedSerial).accept()) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("ISSN [{}] semantic check failure: {}", transformedSerial, EnumSerialError.CHECKDIGIT.toString());
      }
      throw new ValidationException(EnumSerialError.CHECKDIGIT.toString());
    }
    LOG.debug("ISSN [{}] semantic check success.", transformedSerial);

  }

  @Override
  public void validateSyntax() throws ValidationException {
    final String transformedSerial = this.transform();

    // ISSN must be 8 digits
    if (transformedSerial.length() != 8) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("ISSN [{}] syntactic check failure: {}", transformedSerial, EnumSerialError.INVALID_LENGTH.toString());
      }
      throw new ValidationException(EnumSerialError.INVALID_LENGTH.toString());
    }

    // cehck for allowed chars
    if (!transformedSerial.chars().allMatch(Character::isDigit)) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("ISSN [{}] syntactic check failure: {}", transformedSerial, EnumSerialError.INVALID_CHARS.toString());
      }
      throw new ValidationException(EnumSerialError.INVALID_CHARS.toString());
    }
    LOG.debug("ISSN [{}] syntactic check success.", transformedSerial);
  }
}
