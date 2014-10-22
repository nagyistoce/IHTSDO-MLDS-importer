package org.ihtsdo.otf.mlds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DefaultValues {

	private static final Logger LOG = Logger.getLogger(DefaultValues.class
			.getName());

	public static final String HEADER = "member^importKey^type^subType^"
			+ "agreementType^otherText^firstName^lastName^email^alternateEmail^"
			+ "thirdEmail^landlineNumber^landlineExtension^mobileNumber^"
			+ "organizationType^organizationTypeOther^organizationName^"
			+ "addressStreet^addressCity^addressPost^addressCountry^"
			+ "billingStreet^billingCity^billingPost^billingCountry";

	public static final String COUNTRIES = "AC, AD, AE, AF, AG, AI, AL, AM, AN, "
			+ "AO, AQ, AR, AS, AT, AU, AW, AX, AZ, BA, BB, BD, BE, BF, BG, BH, "
			+ "BI, BJ, BM, BN, BO, BR, BS, BT, BV, BW, BY, BZ, CA, CC, CD, CF, "
			+ "CG, CH, CI, CK, CL, CM, CN, CO, CR, CU, CV, CX, CY, CZ, DE, DJ, "
			+ "DK, DM, DO, DZ, EC, EE, EG, ER, ES, ET, FI, FJ, FK, FM, FO, FR, "
			+ "GA, GB, GD, GE, GF, GG, GH, GI, GL, GM, GN, GP, GQ, GR, GS, GT, "
			+ "GU, GW, GY, HK, HM, HN, HR, HT, HU, ID, IE, IL, IM, IN, IO, IQ, "
			+ "IR, IS, IT, JE, JM, JO, JP, KE, KG, KH, KI, KM, KN, KP, KR, KW, "
			+ "KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, "
			+ "ME, MG, MH, MK, ML, MM, MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, "
			+ "MX, MY, MZ, NA, NC, NE, NF, NG, NI, NL, NO, NP, NR, NU, NZ, OM, "
			+ "PA, PE, PF, PG, PH, PK, PL, PM, PN, PR, PT, PW, PY, QA, RE, RO, "
			+ "RS, RU, RW, SA, SB, SC, SD, SE, SG, SH, SI, SJ, SK, SL, SM, SN, "
			+ "SO, SR, ST, SV, SY, SZ, TA, TC, TD, TF, TG, TH, TJ, TK, TL, TM, "
			+ "TN, TO, TR, TT, TV, TW, TZ, UA, UG, UM, US, UY, UZ, VA, VC, VE, "
			+ "VG, VI, VN, VU, WF, WS, YE, YT, ZA, ZM, ZW";

	public static final String MEMBERS = "AU, BE, BN, CA, CL, CZ, DK, EE, ES, "
			+ "GB, HK, IHTSDO, IL, IN, IS, LT, MT, MY, NL, NZ, PL, PT, SE, SG, "
			+ "SI, SK, US, UY";

	public static final String TYPE = "ACADEMIC, COMMERCIAL, INDIVIDUAL, OTHER";

	public static final String SUB_TYPE = "DEVELOPER, DEVELOPMENT, EDUCATIONAL, "
			+ "HEALTHCAREPROVIDER, PERSONAL, RESEARCH, VENDOR";

	public static final String AGREEMENT_TYPE = "AFFILIATE_NORMAL, "
			+ "AFFILIATE_PUBLIC_GOOD, AFFILIATE_RESEARCH";

	public static final String ORG_TYPE = "EDUCATIONAL_INSTITUTE, "
			+ "GENERAL_PRACTITIONER_PRACTICE, "
			+ "HEALTHERCARE_APPLICATION_DEVELOPER, OTHER, "
			+ "PRIVATE_HEALTH_ORGANIZATION, PUBLIC_HEALTH_ORGANIZATION, "
			+ "RESEARCH_AND_DEVELOPMENT_ORGANIZATION";

	public static final String MLDS_COUNTRY_KEY = "mlds_countries";

	public static final String MLDS_MEMBER_KEY = "mlds_members";

	public static final String MLDS_TYPE_KEY = "mlds_type";

	public static final String MLDS_SUB_TYPE_KEY = "mlds_sub_type";

	public static final String MLDS_AGR_TYPE_KEY = "mlds_agr_type";

	public static final String MLDS_ORG_TYPE_KEY = "mlds_org_type";

	public static final String MLDS_IN_FILE_KEY = "mlds_in_file";

	public static final String MLDS_OUT_FILE_KEY = "mlds_out_file";

	public static final String MLDS_SPEC_IMP = "mlds_spec_imp";

	public static List<String> getSettingsList() {

		List<String> keyVals = new ArrayList<String>();
		keyVals.add(MLDS_COUNTRY_KEY);
		keyVals.add(MLDS_MEMBER_KEY);
		keyVals.add(MLDS_TYPE_KEY);
		keyVals.add(MLDS_SUB_TYPE_KEY);
		keyVals.add(MLDS_AGR_TYPE_KEY);
		keyVals.add(MLDS_ORG_TYPE_KEY);
		keyVals.add(MLDS_IN_FILE_KEY);
		keyVals.add(MLDS_OUT_FILE_KEY);
		keyVals.add(MLDS_SPEC_IMP);

		return keyVals;
	}

	public static List<String> getList(final String lov) {
		return Arrays.asList(getAr(lov));
	}

	public static String[] getAr(final String lov) {
		return lov.split(",");

	}

	/**
	 * Gets a new Instance of a given class
	 **/

	public static Object getNewInstClass(final String classname) {
		Object obj = null;
		try {
			obj = instantiateClass(classname);
			checkState(classname, obj);
		} catch (Exception excep) {
			LOG.log(Level.SEVERE, "Error instantiating a class called "
					+ classname, excep);
		}
		return obj;
	}

	/**
	 * Instantiates a class from it's (String) class name.
	 * 
	 * @param className
	 *            The class name of the object to be created.
	 * @return The object created or null if fails.
	 * @throws ClassNotFoundException
	 *             If the class is not found/
	 * @throws IllegalAccessException
	 *             If an illegal access.
	 * @throws InstantiationException
	 *             If there was a problem instantiating the class.
	 */
	private static Object instantiateClass(final String className)
			throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		if (className == null) {
			return null;
		}
		return Class.forName(className).newInstance();
	}

	/**
	 * Checks to see that a class has been loaded correctly.
	 * 
	 * @param interfaceName
	 *            The name of the interface
	 * @param interfaceObject
	 *            The object to be checked against the interface.
	 */
	private static void checkState(final String interfaceName,
			final Object interfaceObject) {
		if (interfaceObject == null) {
			throw new IllegalStateException("Name of class that implements "
					+ interfaceName + " not set.");
		}
	}

}
