/**
 * @officialDocumentation
 */
package de.feffi.jnumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> The type of evaluation set.
 * @author feffi
 */
public abstract class AbstractSerial<T> implements Serial<T> {

  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(AbstractSerial.class);
  /**
   * The given serial number
   */
  public String valueRaw = null;
  /**
   * The chars to strip from the raw serial.
   */
  protected String charFilter = null;
  /**
   * The internal serial algorithm version.
   */
  protected String internalVersion = null;
  /**
   * The manufacturer documentation URI.
   */
  protected URI manufacturerDocumentationUri = null;
  /**
   * The manufacturer serial algorithm version.
   */
  protected String manufacturerVersion = null;

  /**
   * Constructor
   *
   * @param charFilter                   The chars to strip from the raw serial.
   * @param internalVersion              The internal serial algorithm version.
   * @param manufacturerDocumentationUri The manufacturer documentation URI.
   * @param manufacturerVersion          The manufacturer serial algorithm version.
   */
  public AbstractSerial(
      final String charFilter,
      final String internalVersion,
      final String manufacturerVersion,
      final String manufacturerDocumentationUri) {
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
      LOG.error("Could not instaciate! Errornous URI given! {}", e.getMessage());
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
  public abstract T getEvaluationSet();

  /**
   * @return the internalVersion
   */
  protected String getInternalVersion() {
    return this.internalVersion;
  }

  /**
   * @param internalVersion the internalVersion to set
   */
  protected void setInternalVersion(final String internalVersion) {
    this.internalVersion = internalVersion;
  }

  /**
   * @return the manufacturerDocumentationUri
   */
  protected URI getManufacturerDocumentationUri() {
    return this.manufacturerDocumentationUri;
  }

  /**
   * @param manufacturerDocumentationUri the manufacturerDocumentationUri to set
   */
  protected void setManufacturerDocumentationUri(final URI manufacturerDocumentationUri) {
    this.manufacturerDocumentationUri = manufacturerDocumentationUri;
  }

  /**
   * @return the manufacturerVersion
   */
  protected String getManufacturerVersion() {
    return this.manufacturerVersion;
  }

  /**
   * @param manufacturerVersion the manufacturerVersion to set
   */
  protected void setManufacturerVersion(final String manufacturerVersion) {
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
    boolean valid = false;
    try {
      this.validate();
      valid = true;
    } catch (final ValidationException ve) {
      valid = false;
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
    final List<ValidationException> validationErrors = new ArrayList<ValidationException>();

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
  public abstract void validateSemantic() throws ValidationException;

  /**
   * Validates the syntax of a number.
   *
   * @throws ValidationException If validations fails.
   */
  public abstract void validateSyntax() throws ValidationException;
}
