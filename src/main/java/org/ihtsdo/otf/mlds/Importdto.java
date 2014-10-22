package org.ihtsdo.otf.mlds;

import java.util.logging.Logger;

public class Importdto {

	private static final Logger LOG = Logger.getLogger(ImportController.class
			.getName());

	public static final String SEP = "^";

	private String[] line = null;

	private String member;
	private String importKey;
	private String type;
	private String subType;
	private String agreementType;
	private String otherText;
	private String firstName;
	private String lastName;
	private String email;
	private String alternateEmail;
	private String thirdEmail;
	private String landlineNumber;
	private String landlineExtension;
	private String mobileNumber;
	private String organizationType;
	private String organizationTypeOther;
	private String organizationName;
	private String addressStreet;
	private String addressCity;
	private String addressPost;
	private String addressCountry;
	private String billingStreet;
	private String billingCity;
	private String billingPost;
	private String billingCountry;

	public Importdto(final String[] lineIn) {
		super();
		line = lineIn;
	}

	public Importdto() {
		super();
	}

	@Override
	public final String toString() {
		StringBuilder sbuild = new StringBuilder();
		int i = 0;
		int len = getLine().length;
		for (String val : getLine()) {
			if (i < len) {
				sbuild.append(val).append(SEP);
			} else {
				sbuild.append(val);
			}
			i++;
		}
		return sbuild.toString();
	}

	public final String getMember() {
		return member;
	}

	public final void setMember(final String memberIn) {
		member = memberIn;
	}

	public final String getImportKey() {
		return importKey;
	}

	public final void setImportKey(final String importKeyIn) {
		importKey = importKeyIn;
	}

	public final String getType() {
		return type;
	}

	public final void setType(final String typeIn) {
		type = typeIn;
	}

	public final String getSubType() {
		return subType;
	}

	public final void setSubType(final String subTypeIn) {
		subType = subTypeIn;
	}

	public final String getAgreementType() {
		return agreementType;
	}

	public final void setAgreementType(final String agreementTypeIn) {
		agreementType = agreementTypeIn;
	}

	public final String getOtherText() {
		return otherText;
	}

	public final void setOtherText(final String otherTextIn) {
		otherText = otherTextIn;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(final String firstNameIn) {
		firstName = firstNameIn;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(final String lastNameIn) {
		lastName = lastNameIn;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String emailIn) {
		email = emailIn;
	}

	public final String getAlternateEmail() {
		return alternateEmail;
	}

	public final void setAlternateEmail(final String alternateEmailIn) {
		alternateEmail = alternateEmailIn;
	}

	public final String getThirdEmail() {
		return thirdEmail;
	}

	public final void setThirdEmail(final String thirdEmailIn) {
		thirdEmail = thirdEmailIn;
	}

	public final String getLandlineNumber() {
		return landlineNumber;
	}

	public final void setLandlineNumber(final String landlineNumberIn) {
		landlineNumber = landlineNumberIn;
	}

	public final String getLandlineExtension() {
		return landlineExtension;
	}

	public final void setLandlineExtension(final String landlineExtensionIn) {
		landlineExtension = landlineExtensionIn;
	}

	public final String getMobileNumber() {
		return mobileNumber;
	}

	public final void setMobileNumber(final String mobileNumberIn) {
		mobileNumber = mobileNumberIn;
	}

	public final String getOrganizationType() {
		return organizationType;
	}

	public final void setOrganizationType(final String organizationTypeIn) {
		organizationType = organizationTypeIn;
	}

	public final String getOrganizationTypeOther() {
		return organizationTypeOther;
	}

	public final void setOrganizationTypeOther(
			final String organizationTypeOtherIn) {
		organizationTypeOther = organizationTypeOtherIn;
	}

	public final String getOrganizationName() {
		return organizationName;
	}

	public final void setOrganizationName(final String organizationNameIn) {
		organizationName = organizationNameIn;
	}

	public final String getAddressStreet() {
		return addressStreet;
	}

	public final void setAddressStreet(final String addressStreetIn) {
		addressStreet = addressStreetIn;
	}

	public final String getAddressCity() {
		return addressCity;
	}

	public final void setAddressCity(final String addressCityIn) {
		addressCity = addressCityIn;
	}

	public final String getAddressPost() {
		return addressPost;
	}

	public final void setAddressPost(final String addressPostIn) {
		addressPost = addressPostIn;
	}

	public final String getAddressCountry() {
		return addressCountry;
	}

	public final void setAddressCountry(final String addressCountryIn) {
		addressCountry = addressCountryIn;
	}

	public final String getBillingStreet() {
		return billingStreet;
	}

	public final void setBillingStreet(final String billingStreetIn) {
		billingStreet = billingStreetIn;
	}

	public final String getBillingCity() {
		return billingCity;
	}

	public final void setBillingCity(final String billingCityIn) {
		billingCity = billingCityIn;
	}

	public final String getBillingPost() {
		return billingPost;
	}

	public final void setBillingPost(final String billingPostIn) {
		billingPost = billingPostIn;
	}

	public final String getBillingCountry() {
		return billingCountry;
	}

	public final void setBillingCountry(final String billingCountryIn) {
		billingCountry = billingCountryIn;
	}

	public final String[] getLine() {
		if (line == null) {
			line = new String[25];
			line[0] = getMember();
			line[1] = getImportKey();
			line[2] = getType();
			line[3] = getSubType();
			line[4] = getAgreementType();
			line[5] = getOtherText();
			line[6] = getFirstName();
			line[7] = getLastName();
			line[8] = getEmail();
			line[9] = getAlternateEmail();
			line[10] = getThirdEmail();
			line[11] = getLandlineNumber();
			line[12] = getLandlineExtension();
			line[13] = getMobileNumber();
			line[14] = getOrganizationType();
			line[15] = getOrganizationTypeOther();
			line[16] = getOrganizationName();
			line[17] = getAddressStreet();
			line[18] = getAddressCity();
			line[19] = getAddressPost();
			line[20] = getAddressCountry();
			line[21] = getBillingStreet();
			line[22] = getBillingCity();
			line[23] = getBillingPost();
			line[24] = getBillingCountry();

		}
		return line;
	}

	public final void setLine(final String[] lineIn) {
		line = lineIn;
	}

	public static final String getArrAsString(final String[] arr) {
		int len = arr.length;
		if (len != 25) {
			LOG.severe("Not enough items in array num = " + len);
			return null;
		}
		StringBuilder sbuild = new StringBuilder();
		int i = 0;
		for (String val : arr) {
			if (i < len - 1) {
				sbuild.append(val).append(SEP);
			} else {
				sbuild.append(val);
			}
			i++;
		}
		return sbuild.toString();
	}
}
