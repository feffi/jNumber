package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.AbstractSerial;
import de.feffi.jnumber.EnumSerialError;
import de.feffi.jnumber.ValidationException;
import de.feffi.jnumber.checksum.LuhnAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * @author feffi <feffi@feffi.org>
 */
public class Imei extends AbstractSerial<ImeiEvaluationSet> {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(Imei.class);
  private static final String STRIPCHARS = "[^0-9]";
  private static final String VERSION_INTERNAL = "1.0";
  private static final String VERSION_MANUFACTURER = "11.0.0";
  private static final String VERSION_MANUFACTURER_URI = "http://www.3gpp.org/ftp/Specs/html-info/23003.htm";

  /**
   * @param serial The IMEI to check.
   * @throws URISyntaxException In case of a wrong URI.
   */
  Imei(final String serial) throws URISyntaxException {
    super(STRIPCHARS, VERSION_INTERNAL, VERSION_MANUFACTURER, VERSION_MANUFACTURER_URI);
    this.setValueRaw(serial);
  }

  @Override
  public ImeiEvaluationSet getEvaluationSet() {
    final String transformedSerial = this.transform();
    LOG.debug("Evaluating IMEI [{}] -> [{}].", this.getValueRaw(), transformedSerial);
    final String typeAllocationCode = transformedSerial.substring(0, 6);
    LOG.debug(" - type allocation code: {}", typeAllocationCode);
    final String finalAssemblyCode = transformedSerial.substring(6, 8);
    LOG.debug(" - final assembly code: {}", finalAssemblyCode);
    final String softwareVersionNumber = transformedSerial.substring(8, 14);
    LOG.debug(" - serial version number: {}", softwareVersionNumber);
    final int checkDigit = new LuhnAlgorithm(transformedSerial.substring(0, 14) + "0").getChecksum();
    LOG.debug(" - check digit: {}", checkDigit);
    return new ImeiEvaluationSet(transformedSerial, checkDigit, typeAllocationCode, finalAssemblyCode, softwareVersionNumber);
  }

  @Override
  public String transform() {
    final String transformed = getValueRaw().trim().replaceAll(this.getCharFilter(), "");
    LOG.debug("Transforming IMEI [{}] to [{}].", this.getValueRaw(), transformed);
    return transformed;
  }

  @Override
  public void validateSemantic() throws ValidationException {
    final String transformedSerial = this.transform();

    // catch fake IMEIs like "000000000000000"
    if (Long.parseLong(transformedSerial) == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("IMEI [{}] semantic check failure: {}", transformedSerial, EnumSerialError.FAKE_SERIAL.toString());
      }
      throw new ValidationException(EnumSerialError.FAKE_SERIAL.toString());
    }

    if (!new LuhnAlgorithm(transformedSerial).accept()) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("IMEI [{}] semantic check failure: {}", transformedSerial, EnumSerialError.CHECKDIGIT.toString());
      }
      throw new ValidationException(EnumSerialError.CHECKDIGIT.toString());
    }
    LOG.debug("IMEI [{}] semantic check success.", transformedSerial);
  }

  @Override
  public void validateSyntax() throws ValidationException {
    final String transformedSerial = this.transform();

    // IMEI must be 14+1 digits
    if (transformedSerial.length() != 15) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("IMEI [{}] syntactic check failure: {}", transformedSerial, EnumSerialError.INVALID_LENGTH.toString());
      }
      throw new ValidationException(EnumSerialError.INVALID_LENGTH.toString());
    }

    // cehck for allowed chars
    if (!transformedSerial.chars().allMatch(Character::isDigit)) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("IMEI [{}] syntactic check failure: {}", transformedSerial, EnumSerialError.INVALID_CHARS.toString());
      }
      throw new ValidationException(EnumSerialError.INVALID_CHARS.toString());
    }
    LOG.debug("IMEI [{}] syntactic check success.", transformedSerial);
  }
}
