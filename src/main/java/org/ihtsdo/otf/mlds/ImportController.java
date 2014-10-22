package org.ihtsdo.otf.mlds;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

public class ImportController {

	private static final Logger LOG = Logger.getLogger(ImportController.class
			.getName());

	public static final String SET_PROPS = "settings";
	private static Properties settings;

	private PropertiesLoader propLoad;

	private static List<String> countryCodes;
	private static List<String> memberCountryCodes;
	private static List<String> type;
	private static List<String> subtype;
	private static List<String> agreementType;
	private static List<String> orgType;

	private SpecificImporter specImp = null;

	private static String lineEnd = "\n";

	public static void main(final String[] args) {
		ImportController mm = new ImportController();
		mm.run(args);
	}

	public final void run(final String[] args) {
		init(args);
		run();
	}

	public final void run() {
		createRunSpecImp();
		if (specImp != null) {
			String inFile = settings
					.getProperty(DefaultValues.MLDS_IN_FILE_KEY);
			if (stringOK(inFile)) {
				specImp.setInputFile(inFile);
			}

			String outval = write();
			String outfile = getSettings().getProperty(
					DefaultValues.MLDS_OUT_FILE_KEY);

			if (stringOK(outfile)) {
				File outfileF = new File(outfile);
				try {
					FileUtils.writeStringToFile(outfileF, outval, "UTF-8");
				} catch (IOException e) {
					LOG.log(Level.SEVERE, "Error writing file to " + outfile, e);
				}
			}

		}
	}

	private String write() {
		// specImp.getLines()

		StringBuilder sbuild = new StringBuilder();

		sbuild.append(DefaultValues.HEADER).append(lineEnd);
		for (String[] arr : specImp.getLines()) {
			String line = Importdto.getArrAsString(arr);
			// LOG.info("line = " + line);
			if (line != null) {
				sbuild.append(line).append(lineEnd);
			}
		}

		return sbuild.toString();

	}

	private void createRunSpecImp() {
		String clname = getSettings().getProperty(DefaultValues.MLDS_SPEC_IMP);
		// LOG.info("createRunSpecImp clname = " + clname);
		if (stringOK(clname)) {
			Object obj = DefaultValues.getNewInstClass(clname);
			if (obj == null) {
				LOG.log(Level.SEVERE,
						"SpecificImporter Could not be created using = "
								+ clname);
			} else {
				if (obj instanceof SpecificImporter) {
					specImp = (SpecificImporter) obj;
				}
			}
		}
	}

	public final void init(final String[] args) {
		getPropLoad(args);
		setSettings(getPropLoad().getSettings());
		// getSettings();
	}

	public static final Properties getSettings() {
		// if (settings == null) {
		// setSettings(getPropLoad().getSettings());
		// }
		return settings;
	}

	public final void setSettings(final Properties settingsIn) {
		settings = settingsIn;
	}

	public final PropertiesLoader getPropLoad() {

		if (propLoad == null) {
			propLoad = new PropertiesLoader(DefaultValues.getSettingsList(),
					SET_PROPS);
		}
		return propLoad;
	}

	public final PropertiesLoader getPropLoad(final String[] argsIn) {
		getPropLoad();
		propLoad.setArgs(argsIn);
		return propLoad;
	}

	public static final List<String> getCountryCodes() {
		if (countryCodes == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_COUNTRY_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.COUNTRIES;
			}
			countryCodes = DefaultValues.getList(listVals);
		}
		return countryCodes;
	}

	public final void setCountryCodes(final List<String> countryCodesIn) {
		countryCodes = countryCodesIn;
	}

	public static final List<String> getMemberCountryCodes() {
		if (memberCountryCodes == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_MEMBER_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.MEMBERS;
			}
			memberCountryCodes = DefaultValues.getList(listVals);
		}
		return memberCountryCodes;
	}

	public final void setMemberCountryCodes(
			final List<String> memberCountryCodesIn) {
		memberCountryCodes = memberCountryCodesIn;
	}

	public static final List<String> getType() {
		if (type == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_TYPE_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.TYPE;
			}
			type = DefaultValues.getList(listVals);
		}
		return type;
	}

	public final void setType(final List<String> typeIn) {
		type = typeIn;
	}

	public static final List<String> getSubtype() {
		if (subtype == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_SUB_TYPE_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.SUB_TYPE;
			}
			subtype = DefaultValues.getList(listVals);
		}
		return subtype;
	}

	public final void setSubtype(final List<String> subtypeIn) {
		subtype = subtypeIn;
	}

	public static final List<String> getAgreementType() {
		if (agreementType == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_AGR_TYPE_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.AGREEMENT_TYPE;
			}
			agreementType = DefaultValues.getList(listVals);
		}
		return agreementType;
	}

	public final void setAgreementType(final List<String> agreementTypeIn) {
		agreementType = agreementTypeIn;
	}

	public static final List<String> getOrgType() {

		if (orgType == null) {
			// check string is in props
			String listVals = getSettings().getProperty(
					DefaultValues.MLDS_ORG_TYPE_KEY);
			if (!stringOK(listVals)) {
				listVals = DefaultValues.ORG_TYPE;
			}
			orgType = DefaultValues.getList(listVals);
		}
		return orgType;
	}

	public final void setOrgType(final List<String> orgTypeIn) {
		orgType = orgTypeIn;
	}

	public static final boolean stringOK(final String toCheck) {
		return toCheck != null && toCheck.length() > 0;
	}

	public static final String getLineEnd() {
		return lineEnd;
	}

	public static final void setLineEnd(final String lineEndIn) {
		lineEnd = lineEndIn;
	}

}
