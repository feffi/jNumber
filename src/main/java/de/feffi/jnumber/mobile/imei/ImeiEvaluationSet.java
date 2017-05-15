/**
 *
 */
package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.evaluation.AbstractEvaluationSet;

/**
 * @author feffi
 */

// TODO: Validator for TAC, FAC, SVN
public class ImeiEvaluationSet extends AbstractEvaluationSet {

  /**
   * The IMEI check digit.
   */
  private int checkDigit;

  /**
   * Final Assembly Code
   */
  private String finalAssemblyCode;

  /**
   * Serial Number
   */
  private String softwareVersionNumber;

  /**
   * Type Allocation Code
   */
  private String typeAllocationCode;

  /**
   * @param valueTransformed      The transformed IMEI.
   * @param checkDigit            The IMEI check digit, @see http://en.wikipedia.org/wiki/Luhn_algorithm
   * @param typeAllocationCode    Type Allocation Code, @see http://en.wikipedia.org/wiki/Type_Allocation_Code
   * @param finalAssemblyCode     Final Assembly Code, @see http://en.wikipedia.org/wiki/Final_Assembly_Code
   * @param softwareVersionNumber Software version number identifying the revision of the software installed
   *                              on the phone. 99 is reserved.
   */
  public ImeiEvaluationSet(
      final String valueTransformed,
      final int checkDigit,
      final String typeAllocationCode,
      final String finalAssemblyCode,
      final String softwareVersionNumber) {
    super(valueTransformed);
    this.checkDigit = checkDigit;
    this.typeAllocationCode = typeAllocationCode;
    this.finalAssemblyCode = finalAssemblyCode;
    this.softwareVersionNumber = softwareVersionNumber;
  }

  /**
   * @return checkDigit The IMEI check digit, @see
   * http://en.wikipedia.org/wiki/Luhn_algorithm
   */
  public int getCheckDigit() {
    return this.checkDigit;
  }

  /**
   * @param checkDigit the checkDigit to set
   */
  public void setCheckDigit(final int checkDigit) {
    this.checkDigit = checkDigit;
  }

  /**
   * @return the finalAssemblyCode
   */
  public String getFinalAssemblyCode() {
    return this.finalAssemblyCode;
  }

  /**
   * @param finalAssemblyCode the finalAssemblyCode to set
   */
  public void setFinalAssemblyCode(final String finalAssemblyCode) {
    this.finalAssemblyCode = finalAssemblyCode;
  }

  /**
   * @return the serialNumber
   */
  public String getSoftwareVersionNumber() {
    return this.softwareVersionNumber;
  }

  /**
   * @param softwareVersionNumber the serialNumber to set
   */
  public void setSoftwareVersionNumber(final String softwareVersionNumber) {
    this.softwareVersionNumber = softwareVersionNumber;
  }

  /**
   * @return the typeAllocationCode Type Approval Code, @see
   * http://en.wikipedia.org/wiki/Type_Allocation_Code
   */
  public String getTypeAllocationCode() {
    return this.typeAllocationCode;
  }

  /**
   * @param typeAllocationCode Type Allocation Code, @see http://en.wikipedia.org/wiki/Type_Allocation_Code
   */
  public void setTypeAllocationCode(final String typeAllocationCode) {
    this.typeAllocationCode = typeAllocationCode;
  }
}
