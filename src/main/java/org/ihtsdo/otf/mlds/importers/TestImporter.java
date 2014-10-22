package org.ihtsdo.otf.mlds.importers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ihtsdo.otf.mlds.AbstractSpecificImporter;
import org.ihtsdo.otf.mlds.ImportController;
import org.ihtsdo.otf.mlds.Importdto;
import org.ihtsdo.otf.mlds.UUIDGenerator;

public class TestImporter extends AbstractSpecificImporter {

	private static final Logger LOG = Logger.getLogger(TestImporter.class
			.getName());

	private int count = 100;
	private int counter = 1;
	// Remove column values to test empty col handling
	private boolean testEmptycol = true;
	// What col to start at. If looking to test all set to 0
	private int emptyColStartCol = 2;

	public final int getEmptyColStartCol() {
		return emptyColStartCol;
	}

	public final void setEmptyColStartCol(int emptyColStartColIn) {
		emptyColStartCol = emptyColStartColIn;
	}

	private static final String TEST = "Test";

	private String testName;

	private String member = "IHTSDO";
	private String importKey;
	private String type;
	private String subType;
	private String agreementType;
	private String otherText = "othertext";
	private String firstName = "firstname";
	private String lastName = "lastname";
	private String email = "@email.com";
	private String alternateEmail = "@alternateEmail.com";
	private String thirdEmail = "@thirdEmail.com";
	private String landlineNumber = "11111";
	private String landlineExtension = "22222";
	private String mobileNumber = "33333";
	private String organizationType;
	private String organizationTypeOther = "organizationTypeOther";
	private String organizationName = "organizationName";
	private String addressStreet = "addressStreet";
	private String addressCity = "addressCity";
	private String addressPost = "addressPost";
	private String addressCountry = "addressCountry";
	private String billingStreet = "billingStreet";
	private String billingCity = "billingCity";
	private String billingPost = "billingPost";
	private String billingCountry = "billingCountry";

	@Override
	public final Collection<String[]> getLines() {
		List<String[]> lines = new ArrayList<String[]>();
		int colcount = emptyColStartCol;
		while (counter <= count) {
			setTestName();
			String[] line = getId().getLine();

			// if testEmptycol set 1 col to empty
			if (testEmptycol) {
				line[colcount] = "";
				if (colcount + 1 < line.length) {
					colcount++;
				} else {
					colcount = emptyColStartCol;
				}
			}

			lines.add(line);
			counter++;
		}

		return lines;
	}

	private Importdto getId() {
		Importdto id = new Importdto();
		id.setMember(getMember());
		id.setImportKey(getImportKey());
		id.setType(getType());
		id.setSubType(getSubType());
		id.setAgreementType(getAgreementType());
		id.setOtherText(getOtherText());
		id.setFirstName(getFirstName());
		id.setLastName(getLastName());
		id.setEmail(getEmail());
		id.setAlternateEmail(getAlternateEmail());
		id.setThirdEmail(getThirdEmail());
		id.setLandlineNumber(getLandlineNumber());
		id.setLandlineExtension(getLandlineExtension());
		id.setMobileNumber(getMobileNumber());
		id.setOrganizationType(getOrganizationType());
		id.setOrganizationTypeOther(getOrganizationTypeOther());
		id.setOrganizationName(getOrganizationName());
		id.setAddressStreet(getAddressStreet());
		id.setAddressCity(getAddressCity());
		id.setAddressPost(getAddressPost());
		id.setAddressCountry(getAddressCountry());
		id.setBillingStreet(getBillingStreet());
		id.setBillingCity(getBillingCity());
		id.setBillingPost(getBillingPost());
		id.setBillingCountry(getBillingCountry());
		return id;
	}

	public final String getTestName() {
		return testName;
	}

	public final void setTestName() {
		StringBuilder sbuild = new StringBuilder();
		sbuild.append(TEST).append(counter);
		testName = sbuild.toString();
	}

	public final void setTestName(final String testNameIn) {
		testName = testNameIn;
	}

	@Override
	public void setInputFile(final String fileUrlIn) {
		// Do nothing as no file involved

	}

	public final int getCount() {
		return count;
	}

	public final void setCount(final int countIn) {
		count = countIn;
	}

	public final String getImportKey() {

		try {
			importKey = UUIDGenerator.get(getTestName()).toString();
		} catch (NoSuchAlgorithmException e) {
			LOG.log(Level.SEVERE, "Problem gen uuid", e);
		} catch (UnsupportedEncodingException e) {
			LOG.log(Level.SEVERE, "Problem gen uuid", e);
		}
		return importKey;
	}

	public final void setImportKey(final String importKeyIn) {
		importKey = importKeyIn;
	}

	private String getListVal(final List<String> list) {
		// randomly select
		int len = list.size();
		Random rand = new Random();
		int randomNum = rand.nextInt((len - 2) + 1) + 1;
		String val = list.get(randomNum);
		return val.trim();

	}

	// List vals
	public final String getType() {
		type = getListVal(ImportController.getType());
		return type;
	}

	public final void setType(final String typeIn) {
		type = typeIn;
	}

	public final String getSubType() {
		subType = getListVal(ImportController.getSubtype());
		return subType;
	}

	public final void setSubType(final String subTypeIn) {
		subType = subTypeIn;
	}

	public final String getAgreementType() {
		agreementType = getListVal(ImportController.getAgreementType());
		return agreementType;
	}

	public final void setAgreementType(final String agreementTypeIn) {
		agreementType = agreementTypeIn;
	}

	public final String getMember() {
		// If member not set the use a randomly chosen member for the whole
		// import
		if (member == null || member.length() == 0) {
			member = getListVal(ImportController.getMemberCountryCodes());
		}
		return member;
	}

	public final void setMember(final String memberIn) {
		member = memberIn;
	}

	public final String getOrganizationType() {
		organizationType = getListVal(ImportController.getOrgType());
		return organizationType;
	}

	public final void setOrganizationType(final String organizationTypeIn) {
		organizationType = organizationTypeIn;
	}

	public final String getAddressCountry() {
		addressCountry = getListVal(ImportController.getCountryCodes());
		return addressCountry;
	}

	public final void setAddressCountry(final String addressCountryIn) {
		addressCountry = addressCountryIn;
	}

	public final String getBillingCountry() {
		billingCountry = getListVal(ImportController.getCountryCodes());
		return billingCountry;
	}

	public final void setBillingCountry(final String billingCountryIn) {
		billingCountry = billingCountryIn;
	}

	// String values

	public final String getOtherText() {

		return getTestName() + otherText;
	}

	public final void setOtherText(final String otherTextIn) {
		otherText = otherTextIn;
	}

	public final String getFirstName() {
		return getTestName() + firstName;
	}

	public final void setFirstName(final String firstNameIn) {
		firstName = firstNameIn;
	}

	public final String getLastName() {
		return getTestName() + lastName;
	}

	public final void setLastName(final String lastNameIn) {
		lastName = lastNameIn;
	}

	public final String getEmail() {
		return getTestName() + email;
	}

	public final void setEmail(final String emailIn) {
		email = emailIn;
	}

	public final String getAlternateEmail() {
		return getTestName() + alternateEmail;
	}

	public final void setAlternateEmail(final String alternateEmailIn) {
		alternateEmail = alternateEmailIn;
	}

	public final String getThirdEmail() {
		return getTestName() + thirdEmail;
	}

	public final void setThirdEmail(final String thirdEmailIn) {
		thirdEmail = thirdEmailIn;
	}

	public final String getLandlineNumber() {
		return landlineNumber + counter;
	}

	public final void setLandlineNumber(final String landlineNumberIn) {
		landlineNumber = landlineNumberIn;
	}

	public final String getLandlineExtension() {
		return landlineExtension + counter;
	}

	public final void setLandlineExtension(String landlineExtensionIn) {
		landlineExtension = landlineExtensionIn;
	}

	public final String getMobileNumber() {
		return mobileNumber + counter;
	}

	public final void setMobileNumber(final String mobileNumberIn) {
		mobileNumber = mobileNumberIn;
	}

	public final String getOrganizationTypeOther() {
		return getTestName() + organizationTypeOther;
	}

	public final void setOrganizationTypeOther(
			final String organizationTypeOtherIn) {
		organizationTypeOther = organizationTypeOtherIn;
	}

	public final String getOrganizationName() {
		return getTestName() + organizationName;
	}

	public final void setOrganizationName(final String organizationNameIn) {
		organizationName = organizationNameIn;
	}

	public final String getAddressStreet() {
		return getTestName() + addressStreet;
	}

	public final void setAddressStreet(final String addressStreetIn) {
		addressStreet = addressStreetIn;
	}

	public final String getAddressCity() {
		return getTestName() + addressCity;
	}

	public final void setAddressCity(final String addressCityIn) {
		addressCity = addressCityIn;
	}

	public final String getAddressPost() {
		return getTestName() + addressPost;
	}

	public final void setAddressPost(final String addressPostIn) {
		addressPost = addressPostIn;
	}

	public final String getBillingStreet() {
		return getTestName() + billingStreet;
	}

	public final void setBillingStreet(final String billingStreetIn) {
		billingStreet = billingStreetIn;
	}

	public final String getBillingCity() {
		return getTestName() + billingCity;
	}

	public final void setBillingCity(final String billingCityIn) {
		billingCity = billingCityIn;
	}

	public final String getBillingPost() {
		return getTestName() + billingPost;
	}

	public final void setBillingPost(final String billingPostIn) {
		billingPost = billingPostIn;
	}

	public final boolean isTestEmptycol() {
		return testEmptycol;
	}

	public final void setTestEmptycol(final boolean testEmptycolIn) {
		testEmptycol = testEmptycolIn;
	}

}
