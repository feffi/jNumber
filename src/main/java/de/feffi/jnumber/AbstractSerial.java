package de.feffi.jnumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feffi <feffi@feffi.org>
 *   
 * @param <T> The type of evaluation set.
 */
public abstract class AbstractSerial<T> implements Serial<T> {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(AbstractSerial.class);
  /**
   * The given serial number
   */
  private String valueRaw = null;
  /**
   * The chars to strip from the raw serial.
   */
  private String charFilter = null;
  /**
   * The internal serial algorithm version.
   */
  private String internalVersion = null;
  /**
   * The manufacturer documentation URI.
   */
  private URI manufacturerDocumentationUri = null;
  /**
   * The manufacturer serial algorithm version.
   */
  private String manufacturerVersion = null;

  /**
   * Constructor
   *
   * @param charFilter                   The chars to strip from the raw serial.
   * @param internalVersion              The internal serial algorithm version.
   * @param manufacturerDocumentationUri The manufacturer documentation URI.
   * @param manufacturerVersion          The manufacturer serial algorithm version.
   */
  protected AbstractSerial(
      final String charFilter,
      final String internalVersion,
      final String manufacturerVersion,
      final String manufacturerDocumentationUri) throws URISyntaxException {
    super();
    /*
		 * LOG.debug(
		 * "Init serial:\n - Internal version: {}\n - Manufacturer version: {}\n - Documentation: {}"
		 * , internalVersion, manufacturerVersion, manufacturerDocumentationUri);
		 */
    this.charFilter = charFilter;
    this.internalVersion = internalVersion;
    this.manufacturerVersion = manufacturerVersion;
    try {
      this.manufacturerDocumentationUri = new URI(manufacturerDocumentationUri);
    } catch (final URISyntaxException e) {
      LOG.error("Could not instantiate! Errornous URI given! {}", e.getMessage());
      throw e;
    }
  }

  /*
   * (non-Javadoc)
   * @see de.feffi.jnumber.Serial#evaluate()
   */
  public T evaluate() throws ValidationException {
    this.validate();
    return this.getEvaluationSet();
  }

  /**
   * @return the charFilter
   */
  public String getCharFilter() {
    return this.charFilter;
  }

  /**
   * @param charFilter the charFilter to set
   */
  public void setCharFilter(final String charFilter) {
    this.charFilter = charFilter;
  }

  /**
   * Validates the semantic of a number.
   *
   * @return The specialized evaluation set.
   */
  protected abstract T getEvaluationSet();

  /**
   * @return the internalVersion
   */
  String getInternalVersion() {
    return this.internalVersion;
  }

  /**
   * @param internalVersion the internalVersion to set
   */
  void setInternalVersion(final String internalVersion) {
    this.internalVersion = internalVersion;
  }

  /**
   * @return the manufacturerDocumentationUri
   */
  URI getManufacturerDocumentationUri() {
    return this.manufacturerDocumentationUri;
  }

  /**
   * @param manufacturerDocumentationUri the manufacturerDocumentationUri to set
   */
  void setManufacturerDocumentationUri(final URI manufacturerDocumentationUri) {
    this.manufacturerDocumentationUri = manufacturerDocumentationUri;
  }

  /**
   * @return the manufacturerVersion
   */
  String getManufacturerVersion() {
    return this.manufacturerVersion;
  }

  /**
   * @param manufacturerVersion the manufacturerVersion to set
   */
  void setManufacturerVersion(final String manufacturerVersion) {
    this.manufacturerVersion = manufacturerVersion;
  }

  /**
   * @return the serialNumberRaw
   */
  public String getValueRaw() {
    return this.valueRaw;
  }

  /**
   * @param serialNumberRaw the serialNumberRaw to set
   */
  public void setValueRaw(final String serialNumberRaw) {
    this.valueRaw = serialNumberRaw;
  }

  /*
   * (non-Javadoc)
   * @see de.feffi.jnumber.Serial#isValid()
   */
  public Boolean isValid() {
    boolean valid;
    try {
      this.validate();
      valid = true;
      LOG.debug("IMEI valid.");
    } catch (final Exception ve) {
      valid = false;
      LOG.debug("IMEI invalid::" + ve.getMessage(), ve);
    }
    return valid;
  }

  /**
   * Transforms the given raw serial to a standardized form.
   *
   * @return The transformation result.
   */
  public abstract String transform();

  /*
   * (non-Javadoc)
   * @see de.feffi.jnumber.Serial#validate()
   */
  public void validate() throws ValidationException {
    LOG.debug("Validating IMEI syntax.");
    final List<ValidationException> validationErrors = new ArrayList<>();

    // validate Syntax first
    try {
      this.validateSyntax();
    } catch (final ValidationException ve) {
      validationErrors.add(ve);
    }

    // if syntax is valid, check semantics
    if (validationErrors.isEmpty()) {
      try {
        this.validateSemantic();
      } catch (final ValidationException ve) {
        validationErrors.add(ve);
      }
    }

    if (!validationErrors.isEmpty()) {
      throw new ValidationException("Validation failed!", validationErrors);
    }
  }

  /**
   * Validates the semantic of a number.
   *
   * @throws ValidationException If validations fails.
   */
  protected abstract void validateSemantic() throws ValidationException;

  /**
   * Validates the syntax of a number.
   *
   * @throws ValidationException If validations fails.
   */
  protected abstract void validateSyntax() throws ValidationException;
}
