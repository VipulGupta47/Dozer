package com.headstrong.npi.raas;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headstrong.npi.raas.cobs.xml.pojo.AttributeBoolean;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeDouble;
import com.headstrong.npi.raas.cobs.xml.pojo.AttributeString;
import com.headstrong.npi.raas.xml.pojo.Address;
import com.headstrong.npi.raas.xml.pojo.CmAttribute;
import com.headstrong.npi.raas.xml.pojo.CmAttributeBoolean;
import com.headstrong.npi.raas.xml.pojo.CmAttributeCountry;
import com.headstrong.npi.raas.xml.pojo.CmAttributeCurrency;
import com.headstrong.npi.raas.xml.pojo.CmAttributeDate;
import com.headstrong.npi.raas.xml.pojo.CmAttributeDateMonthDay;
import com.headstrong.npi.raas.xml.pojo.CmAttributeEntityType;
import com.headstrong.npi.raas.xml.pojo.CmAttributeGender;
import com.headstrong.npi.raas.xml.pojo.CmAttributeLegalForm;
import com.headstrong.npi.raas.xml.pojo.CmAttributeMiFIDClassifications;
import com.headstrong.npi.raas.xml.pojo.CmAttributeOption;
import com.headstrong.npi.raas.xml.pojo.CmAttributeOwnershipType;
import com.headstrong.npi.raas.xml.pojo.CmAttributeString;
import com.headstrong.npi.raas.xml.pojo.CmAttributeWebsiteAddressType;
import com.headstrong.npi.raas.xml.pojo.ContactInfo;
import com.headstrong.npi.raas.xml.pojo.Country;
import com.headstrong.npi.raas.xml.pojo.CountryOfBusiness;
import com.headstrong.npi.raas.xml.pojo.Currency;
import com.headstrong.npi.raas.xml.pojo.Entity;
import com.headstrong.npi.raas.xml.pojo.Entity.BearerShares;
import com.headstrong.npi.raas.xml.pojo.Entity.BusinessActivities;
import com.headstrong.npi.raas.xml.pojo.Entity.CompanyAML;
import com.headstrong.npi.raas.xml.pojo.Entity.ContactInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.ControllerAndDirector.ControllersAndDirectors;
import com.headstrong.npi.raas.xml.pojo.Entity.EntityNames;
import com.headstrong.npi.raas.xml.pojo.Entity.FinancialInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.Formation;
import com.headstrong.npi.raas.xml.pojo.Entity.LicenseInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.ListedInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipCorporate;
import com.headstrong.npi.raas.xml.pojo.Entity.Ownership.OwnershipIndividual;
import com.headstrong.npi.raas.xml.pojo.Entity.PlaceOfBusiness;
import com.headstrong.npi.raas.xml.pojo.Entity.RegistrationInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.RegulatedInformation;
import com.headstrong.npi.raas.xml.pojo.Entity.WebsiteAddresses;
import com.headstrong.npi.raas.xml.pojo.Entity.WebsiteAddresses.WebsiteAddress;
import com.headstrong.npi.raas.xml.pojo.EntityType;
import com.headstrong.npi.raas.xml.pojo.Exchanges;
import com.headstrong.npi.raas.xml.pojo.Exchanges.Exchange;
import com.headstrong.npi.raas.xml.pojo.ExternalIdentifiers;
import com.headstrong.npi.raas.xml.pojo.GenderType;
import com.headstrong.npi.raas.xml.pojo.GovtIDInfo;
import com.headstrong.npi.raas.xml.pojo.Identifier;
import com.headstrong.npi.raas.xml.pojo.IndustryClassification;
import com.headstrong.npi.raas.xml.pojo.LegalForm;
import com.headstrong.npi.raas.xml.pojo.Option;
import com.headstrong.npi.raas.xml.pojo.OwnershipType;
import com.headstrong.npi.raas.xml.pojo.Regulators;
import com.headstrong.npi.raas.xml.pojo.Regulators.Regulator;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile;
import com.headstrong.npi.raas.xml.pojo.WebsiteAddressType;

public class Utils {
	
	private static volatile Map<String, String> USERROLEGROUPMAP = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	
	public static AttributeBoolean getAttributeBooleanValue(Boolean value) {
		AttributeBoolean bo = null;
		if(value!= null ) {
			bo = new AttributeBoolean();
			bo.setValue((value.equals(Boolean.TRUE)) ? com.headstrong.npi.raas.cobs.xml.pojo.Boolean.YES : com.headstrong.npi.raas.cobs.xml.pojo.Boolean.NO);
		}
		return bo;
	}
	
	public static AttributeString getAttributeStringValue(CmAttributeString value) {
		AttributeString bo = null;
		String val = null;
		if(value != null ){
			if(value.getValue()!= null && !value.getValue().trim().isEmpty()) {
				val = value.getValue();
			} else {
				val = "";
			}
			bo = new AttributeString();
			bo.setValue(val);
			return bo;
		}
		return null;
	}
	
	public static AttributeString getAttributeStringValue(String value) {
		AttributeString bo = null;
		if(value != null  && !value.trim().isEmpty()){
			bo = new AttributeString();
			bo.setValue(value);
			return bo;
		}
		return null;
	}
	
	public static String getStringValueFromAttributeString(AttributeString value) {
		String val = null;
		if(value != null) {
			if(value.getValue() != null) {
				val = value.getValue();
			} else val = "";
		}
		return val;
	}
	
	public static AttributeDouble getAttributeDoubleValue(String value) {
		AttributeDouble bo = null;
		if(value != null  && !value.trim().isEmpty()){
			bo = new AttributeDouble();
			bo.setValue(Double.valueOf(value));
			return bo;
		}
		return null;
	}

	public static boolean areStringEqual(String first, String second) {
		boolean status = false;
		if (Utils.isEmpty(first) && Utils.isEmpty(second)) {
			status = true;
		} else if (Utils.isNotEmpty(first) && Utils.isEmpty(second)) {
			status = false;
		} else if (Utils.isEmpty(first) && Utils.isNotEmpty(second)) {
			status = false;
		} else if (first.trim().equalsIgnoreCase(second.trim())) {
			status = true;
		}
		return status;
	}

	public static String replaceTrueFalseByYesNo(String value) {
		if (Utils.isNotEmpty(value)) {
			if (value.equalsIgnoreCase("true")) {
				value = "Yes";
			} else if (value.equalsIgnoreCase("false")) {
				value = "No";
			}
		} else {
			value = "";
		}
		return value;
	}
	
	public static String replaceYesNoByTrueFalse(Boolean value) {
		String returnValue="";
		if (null !=value) {
			if (value) {
				returnValue= "Yes";
			} else if (!value) {
				returnValue=  "No";
			}
		} else {
			returnValue=  "";
		}
		return returnValue;
	}

	public static int[] stringArrayToIntArray(String[] strArray) {
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i].trim());
		}
		return intArray;
	}

	public static String[] intArrayToStringArray(int[] intArray) {
		String[] strArray = new String[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			strArray[i] = Integer.toString(intArray[i]);
		}
		return strArray;
	}

	public static String removeBlankSpaces(String name) {

		StringTokenizer st = new StringTokenizer(name, " ", false);
		StringBuffer completelyFormattedValue = new StringBuffer();
		while (st.hasMoreElements())
			completelyFormattedValue.append(st.nextElement());
		return completelyFormattedValue.toString();
	}

	public static String removeLastChar(String name, String removeCharacter) {

		while (name.endsWith(removeCharacter)) {

			name = name.substring(0, name.length() - 1);

		}

		return name;
	}

	public static String[] booleanArrayToStringArray(boolean[] booleanArray) {
		String[] strArray = new String[booleanArray.length];
		for (int i = 0; i < booleanArray.length; i++) {
			strArray[i] = Boolean.toString(booleanArray[i]);
		}
		return strArray;
	}

	public static boolean[] stringArrayToBooleanArray(String[] stringArray) {
		boolean[] booleanArray = new boolean[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			booleanArray[i] = Boolean.getBoolean(stringArray[i]);
		}
		return booleanArray;
	}

	public static HashMap<String, String> stringArrayToHashMap(String[] stringArray) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < stringArray.length; i++) {
			hashMap.put(stringArray[i], stringArray[i]);
		}
		return hashMap;
	}

	public static TreeMap<String, String> stringArrayToTreeMap(String[] stringArray) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		for (int i = 0; i < stringArray.length; i++) {
			treeMap.put(stringArray[i], stringArray[i]);
		}
		return treeMap;
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ne) {
			return false;
		}
		return true;
	}

	// method return the counter value at the end of the string
	public int getEndCounter(String s) {

		String counter = "-1";

		if ((s != null) && (!s.equals(""))) {

			counter = "";
			int at = s.length();
			String endStr = s.substring(at, 1);

			while (isInteger(endStr)) {
				counter = endStr + counter;
				if (at != 0) {
					endStr = s.substring(--at, 1);
				}
			} // while

		} // if
		return Integer.parseInt(counter);

	} // getEndCounter

	/**
	 * <p>
	 * String null check.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.trim().length() > 0;
	}

	/**
	 * <p>
	 * String null check.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return !(isNotEmpty(str));
	}

	/**
	 * <p>
	 * Return trim, non-null representation of object.
	 * </p>
	 * 
	 * @param obj
	 *            Object
	 * @return String
	 */
	public static boolean checkStringValue(Object obj) {
		String str = String.valueOf(obj);
		if (str == null || str.equals("null") || str.length() < 1) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Return trim, non-null representation of object.
	 * </p>
	 * 
	 * @param obj
	 *            Object
	 * @return String
	 */
	public static String checkString(Object obj) {
		String str = String.valueOf(obj);
		if (str == null || str.equals("null") || str.length() < 1) {
			str = "";
		}
		return str.trim();
	}

	public static String[] checkStringArray(Object[] obj) {
		String[] strArray = new String[obj.length];
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = checkString(obj[i]);
		}
		return strArray;
	}

	/**
	 * <p>
	 * Check for valid string, no special chars including: "#","&","^","%","*","/","\\","(",")"
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isValidString(String str) {
		boolean valid = true;
		if (valid) {
			String invalid[] = { "~", "`", "!", "@", "$", "?", "#", "&", "^", "%", "*", "/", "\\", "(", ")" };
			for (int i = 0; i < invalid.length; i++) {
				if (str.indexOf(invalid[i]) >= 0) {
					valid = false;
				}
			}
		}
		return valid;
	}

	/**
	 * <p>
	 * Check for valid string - trim special characters
	 * </p>
	 * 
	 * 
	 */

	public static String getValidString(String str) {
		String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int strLength = str.length();
		char charArray[] = new char[strLength];
		for (int x = 0; x < strLength; x++) {
			charArray[x] = str.charAt(x);
			if (validChars.indexOf(charArray[x]) == -1) {
				charArray[x] = '\'';
			}
		}
		String finalStr = new String(charArray);
		finalStr = finalStr.replaceAll("\'", "");
		return finalStr.trim();
	}

	public static boolean validateString(String str) {
		boolean validate = false;
		String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789:_-";
		int strLength = str.length();
		char charArray[] = new char[strLength];
		for (int x = 0; x < strLength; x++) {
			charArray[x] = str.charAt(x);
			if (validChars.indexOf(charArray[x]) == -1) {
				validate = true;
			}
		}
		return validate;
	}

	/**
	 * <p>
	 * Check for valid string representation of number.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isValidNumber(String str) {
		boolean valid = true;

		try {
			Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return valid;
	}

	

	// M I S C E L L A N E O U S
	/**
	 * <p>
	 * Print collection contents.
	 * </p>
	 * 
	 * @param col
	 *            Collection
	 * @param type
	 *            String
	 * @return String
	 */
	public static String col2Str(Collection<? extends Object> col, String type) {
		StringBuffer str = new StringBuffer();
		if (col != null && !col.isEmpty()) {
			str.append(" Num of " + type + ": " + col.size() + " |");
			Iterator<? extends Object> itr = col.iterator();
			while (itr.hasNext()) {
				Object obj = itr.next();
				str.append(" " + obj.toString());
			}
		} else {
			str.append(type + ": [null]");
		}
		return str.toString();
	}

	/**
	 * <p>
	 * Get HTPP method- POST or GET. This is used to debug the query string.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getHttpMethod() {
		return "POST";
	}

	public static String[] insertSection(int index, String insertStr, String[] strArray) {
		// strArray==null assign a new array
		strArray = strArray != null ? strArray : new String[0];

		Vector<String> arrayVector = new Vector<String>(Arrays.asList(strArray));
		arrayVector.add(index, insertStr);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}

	public static String[] insertSection(String insertStr, String[] strArray) {
		// strArray==null assign a new array
		strArray = strArray != null ? strArray : new String[0];

		Vector<String> arrayVector = new Vector<String>(Arrays.asList(strArray));
		arrayVector.add(insertStr);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}

	public static String[] deleteSection(int index, String[] strArray) {
		Vector<String> arrayVector = new Vector<String>(Arrays.asList(strArray));
		arrayVector.remove(index);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}

	public static String[] vectorToStringArray(Vector<String> vec) {
		String[] returnStr = vec != null ? vec.toArray(new String[0]) : new String[0];
		return returnStr;
	}

	public static String delimateStrings(String[] str) {
		String names = "";
		for (int i = 0; i < str.length; i++) {
			names = i > 0 ? (names + ", ") : names;
			names += str[i];
		} // for
		return names;
	}

	public static int rate(String target, String expression) {
		int score = 0;
		int HIGH_SCORE = 999;
		// do regular expression match
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(target);
		boolean matched = matcher.matches();
		if (matched) {
			if (expression.equals(target)) {
				score = HIGH_SCORE;
			} else {
				score = expression.length();
			} // if
		}

		return score;
	} // rate

	public static String isEmptyThenReturn(String value, String assignStr) {
		String returnValue;

		if (isEmpty(value)) {
			returnValue = assignStr;
		} else {
			returnValue = value.trim();
		}
		return returnValue;

	}

	public static String escapeSpecialCharacters(String result) {

		Pattern newLinePattern = Pattern.compile("\\r\\n|\\r|\\n");
		Matcher newLineMatcher = newLinePattern.matcher(result);
		result = newLineMatcher.replaceAll("<br>");
		Pattern singleQuotePattern = Pattern.compile("'");
		Matcher singleQuoteMatcher = singleQuotePattern.matcher(result);
		result = singleQuoteMatcher.replaceAll("");
		return result;

	}

	public static String getParsedString(String str) {
		String finalStr = str;
		if (str.indexOf(":") != -1) {
			finalStr = str.substring(0, str.indexOf(":"));
		}
		return finalStr;
	}

	public static HashMap<String, String> getParseStrList(String parseString, String searchStr) {

		HashMap<String, String> strMap = new HashMap<String, String>();

		try {

			StringTokenizer st = null;
			String strToken = null;

			// parse tsavalid status using StringTokenizer
			if (Utils.isNotEmpty(parseString)) {
				st = new StringTokenizer(parseString, searchStr);
			}
			// construct list
			while (st.hasMoreTokens()) {
				strToken = st.nextToken();
				strMap.put(strToken.toLowerCase(), strToken.toLowerCase());
			}

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return strMap;
	}

	public static boolean isValidDouble(String doubleValue) {

		boolean isValid = true;
		int count = 0;
		int index = 0;

		// Loop round all characters in the input or until invald character
		// detected
		while (index < doubleValue.length() && isValid) {
			char c = doubleValue.charAt(index);
			// Check if it's a decimal point
			if (c == 46) {
				count++;
				// Invalid if there's been more than one
				if (count > 1) {
					isValid = false;
				}

				// Check if it's less than the ASCII for '0' or greater than the
				// ASCII for '9'
			} else if (c < 48 || c > 57) {
				isValid = false;
			}

			index++;
		}
		return isValid;
	}

	public static String setEmptyIfNull(String value) {
		return value == null ? "" : value.trim();
	}

	public static ArrayList<String> getArrayListFromEnum(String[] posArray) {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < posArray.length; i++) {
			array.add(posArray[i].toString());
		}
		return array;
	}

	public static String getQuotedString(String str) {
		StringBuilder string = new StringBuilder();
		string.append("\"" + Utils.setEmptyIfNull(str) + "\"");
		return string.toString();
	}

	public static String getQuotedString(int str) {
		StringBuilder string = new StringBuilder();
		string.append("\"" + Utils.setEmptyIfNull(Integer.toString(str)) + "\"");
		return string.toString();
	}

	public static int setEmptyStringZeroInt(String value) {
		int returnValue = 0;
		//findbugfix
		if (value == null || value.equals("") || value.length() == 0) {
			returnValue = 0;

		} else if (!Utils.isInteger(value)) {
			returnValue = -1;
		}
		return returnValue;
	}

	public static List<String> delimitedStringToList(String str, String delimiter) {
		List<String> sellItems = new ArrayList<String>();
		if (Utils.isNotEmpty(str) && Utils.isNotEmpty(delimiter)) {
			sellItems = Arrays.asList(str.split(delimiter));
		}
		return sellItems;
	}

	
	public static <T> boolean contains(final T[] array, final T v) {
		for (final T e : array)
			if (e == v || v != null && v.equals(e))
				return true;

		return false;
	}
	public static boolean setBooleanToFalseIfNull(Boolean obj){
		if (obj ==null){
			obj =false;
		}
		return obj;
	} 

	public static String convertBooleanToString(Boolean obj) {

		if (null != obj) {
			if (obj) {
				return "Yes";
			} else {
				return "No";
			}
		} else {
			return "No";
		}
	}

	public static <T> Number findMedian(List<? extends Number> list) {

		if (list.size() % 2 == 1) {
			return list.get(list.size() / 2).doubleValue();
		} else {
			return (((list.get(list.size() / 2 - 1)).doubleValue() + (list.get(list.size() / 2)).doubleValue()) / 2);
		}
	}

	/**
	 * Generate random password
	 * 
	 * @return
	 */
	public static String generateRandomPassword() {
		return RandomStringUtils.random(8, "0987654321QWERTYUIOPLKJHGFDSAZXCVBNM");
	}

	/**
	 * Generate an encrypted string using SHA one-way hashing
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String generateEncryptedPassword(String password) throws Exception {
		MessageDigest messageDigest = null;
		String encryptedPassword = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA");

			messageDigest.update(password.getBytes("UTF-8"));

			byte rawBytes[] = messageDigest.digest();

			encryptedPassword = new String(Base64.encodeBase64(rawBytes));

		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		return encryptedPassword;
	}

	
	
	

	public static String setEmptyIfNull(CmAttributeCountry attrCountry) {
		if(null != attrCountry && null != attrCountry.getValue()) {
			return attrCountry.getValue().value();
		}
		return "";
	}

	public static String setEmptyIfNull(CmAttributeString attrString) {
		if(null != attrString && null != attrString.getValue()) {
			return attrString.getValue();
		}
		return "";
	}

	public static String getValue(CmAttributeString attrString) {
		if(null != attrString && null != attrString.getValue()) {
			return attrString.getValue();
		}
		return "";
	}

	public static String getValue(CmAttributeCountry attrCountry) {
		if(null != attrCountry && null != attrCountry.getValue()) {
			return attrCountry.getValue().value();
		}
		return "";
	}
	
	public static String getValue(CmAttributeDate attrDate) {
		if(null != attrDate && null != attrDate.getValue()) {
			return DateConversion.getDisplayDate(attrDate.getValue().toGregorianCalendar().getTime());
		}
		return "";
	}

	public static String getValue(CmAttributeLegalForm attrLegalForm) {
		if(null != attrLegalForm && null != attrLegalForm.getValue()) {
			return attrLegalForm.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeOwnershipType attrOwnershipType) {
		if(null != attrOwnershipType && null != attrOwnershipType.getValue()) {
			return attrOwnershipType.getValue().value();
		}
		return "";
	}

	public static boolean getValue(CmAttributeBoolean attrBool) {
		if(null != attrBool) {
			return attrBool.isValue();
		}
		return false;
	}

	public static String getValue(CmAttributeMiFIDClassifications miFIDClassifications) {
		if(null != miFIDClassifications && null != miFIDClassifications.getValue()) {
			return miFIDClassifications.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeWebsiteAddressType websiteAddressType) {
		if(null != websiteAddressType && null != websiteAddressType.getValue()) {
			return websiteAddressType.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeDateMonthDay dateMonDay) {
		if(null != dateMonDay && null != dateMonDay.getValue()) {
			return DateConversion.getMmD(dateMonDay.getValue().toGregorianCalendar().getTime());
		}
		return "";
	}

	public static String getValue(CmAttributeEntityType entityType) {
		if(null != entityType && null != entityType.getValue()) {
			return entityType.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeGender attrString) {
		if(null != attrString && null != attrString.getValue()) {
			return attrString.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeOption attrOption) {
		if(null != attrOption && null != attrOption.getValue()) {
			return attrOption.getValue().value();
		}
		return "";
	}

	public static String getValue(CmAttributeCurrency attrCrncy) {
		if(null != attrCrncy && null != attrCrncy.getValue()) {
			return attrCrncy.getValue().value();
		}
		return "";
	}
	
	public static CmAttributeDate getCmAttrDate(String dateStr) {
		if(null != dateStr && !dateStr.trim().isEmpty()) {
			Date date = DateConversion.getDateFromString(dateStr);
			if(null != date) {
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				XMLGregorianCalendar xmlGregorianCalendar;
				try {
					xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
					return null;
				}
				CmAttributeDate cmAttributeDate = new CmAttributeDate();
				cmAttributeDate.setValue(xmlGregorianCalendar);
				
				return cmAttributeDate;
			}
		}
		return null;
	}

	public static CmAttributeBoolean getCmAttrBoolean(String boolStr) {
		boolean bool = false;
		if("Yes".equalsIgnoreCase(boolStr)) {
			bool = true;
		} else {
			bool = Boolean.parseBoolean(boolStr);
		}
		
		CmAttributeBoolean attributeBoolean = new CmAttributeBoolean();
		attributeBoolean.setValue(bool);
		return attributeBoolean;
	}

	public static CmAttributeOption getCmAttrOption(String optStr) {
		if(null != optStr && !optStr.trim().isEmpty()) {
			try {
				Option opt = Option.fromValue(optStr);
				CmAttributeOption option = new CmAttributeOption();
				option.setValue(opt);
				
				return option;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static CmAttributeCountry getCmAttrCountry(String cntryStr) {
		if(null != cntryStr && !cntryStr.trim().isEmpty()) {
			try {
				Country cntry = Country.fromValue(cntryStr);
				CmAttributeCountry country = new CmAttributeCountry();
				country.setValue(cntry);
				
				return country;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static CmAttributeString getCmAttrString(String string) {
		if(null != string && !string.trim().isEmpty()) {
			CmAttributeString attributeString = new CmAttributeString();
			attributeString.setValue(string);
			
			return attributeString;
		}
		return null;
	}

	public static CmAttributeLegalForm getCmAttrLegalForm(String legalFormStr) {
		if(null != legalFormStr && !legalFormStr.trim().isEmpty()) {
			try {
				LegalForm legalForm = LegalForm.fromValue(legalFormStr);
				CmAttributeLegalForm legalFormAttr = new CmAttributeLegalForm();
				legalFormAttr.setValue(legalForm);
				
				return legalFormAttr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static CmAttributeGender getCmAttributeGender(String genderStr ) {
		if(null != genderStr && !genderStr.trim().isEmpty()) {
			try {
				GenderType genderType = GenderType.fromValue(genderStr);
				CmAttributeGender genderTypeAttr = new CmAttributeGender();
				genderTypeAttr.setValue(genderType);
				
				return genderTypeAttr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	public static CmAttributeOwnershipType getCmAttrOwnerType(String ownershipTypeStr) {
		if(null != ownershipTypeStr && !ownershipTypeStr.trim().isEmpty()) {
			try {
				OwnershipType ownershipType = OwnershipType.fromValue(ownershipTypeStr);
				CmAttributeOwnershipType ownershipTypeAttr = new CmAttributeOwnershipType();
				ownershipTypeAttr.setValue(ownershipType);
				
				return ownershipTypeAttr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static CmAttributeDateMonthDay getCmAttrDateMonthDay(String monthDayStr) {
		if(null != monthDayStr  && !monthDayStr.trim().isEmpty()) {
			Date date = DateConversion.getDateFromMmDString(monthDayStr);
			if(null != date) {
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				XMLGregorianCalendar xmlGregorianCalendar;
				try {
					xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
					xmlGregorianCalendar.setMonth(cal.get(Calendar.MONTH) + 1);
					xmlGregorianCalendar.setDay(cal.get(Calendar.DAY_OF_MONTH));
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
					return null;
				}
				CmAttributeDateMonthDay cmAttributeDateMonthDay = new CmAttributeDateMonthDay();
				cmAttributeDateMonthDay.setValue(xmlGregorianCalendar);
				
				return cmAttributeDateMonthDay;
			}
		}
		return null;
	}

	public static CmAttributeWebsiteAddressType getCmAttrWebsiteAddressType(String websiteAddressTypeStr) {
		if(null != websiteAddressTypeStr && !websiteAddressTypeStr.trim().isEmpty()) {
			try {
				WebsiteAddressType websiteAddressType = WebsiteAddressType.fromValue(websiteAddressTypeStr);
				CmAttributeWebsiteAddressType websiteAddressTypeAttr = new CmAttributeWebsiteAddressType();
				websiteAddressTypeAttr.setValue(websiteAddressType);
				
				return websiteAddressTypeAttr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static CmAttributeEntityType getCmAttrEntityType(String entityTypeStr) {
		if(null != entityTypeStr && !entityTypeStr.trim().isEmpty()) {
			try {
				EntityType entityType = EntityType.fromValue(entityTypeStr);
				CmAttributeEntityType entityTypeAttr = new CmAttributeEntityType();
				entityTypeAttr.setValue(entityType);
				
				return entityTypeAttr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static CmAttributeCurrency getCmAttrCurrency(String currStr) {
		if(null != currStr && !currStr.trim().isEmpty()) {
			try {
				Currency curr = Currency.fromValue(currStr);
				CmAttributeCurrency currency = new CmAttributeCurrency();
				currency.setValue(curr);
				
				return currency;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static CmAttributeString update(CmAttributeString stringAttr, String newValue) {
		if(null == stringAttr) {
			stringAttr = Utils.getCmAttrString(newValue);
		} else {
			stringAttr.setValue(newValue);
		}
		
		return stringAttr;
	}

	public static CmAttributeDate update(CmAttributeDate dateAttr, String newValue) {
		CmAttributeDate cmAttrDate = Utils.getCmAttrDate(newValue);
		if(null == dateAttr) {
			dateAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				dateAttr.setValue(cmAttrDate.getValue());
			} else {
				dateAttr.setValue(null);
			}
		}
		
		return dateAttr;
	}

	public static CmAttributeDateMonthDay update(CmAttributeDateMonthDay dateAttr, String newValue) {
		CmAttributeDateMonthDay cmAttrDate = Utils.getCmAttrDateMonthDay(newValue);
		if(null == dateAttr) {
			dateAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				dateAttr.setValue(cmAttrDate.getValue());
			} else {
				dateAttr.setValue(null);
			}
		}
		
		return dateAttr;
	}

	public static CmAttributeLegalForm update(CmAttributeLegalForm legalFormAttr, String newValue) {
		CmAttributeLegalForm cmAttrDate = Utils.getCmAttrLegalForm(newValue);
		if(null == legalFormAttr) {
			legalFormAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				legalFormAttr.setValue(cmAttrDate.getValue());
			} else {
				legalFormAttr.setValue(null);
			}
		}
		
		return legalFormAttr;
	}

	public static CmAttributeGender update(CmAttributeGender genderAttr, String newValue) {
		CmAttributeGender cmAttrDate = Utils.getCmAttributeGender(newValue);
		if(null == genderAttr) {
			genderAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				genderAttr.setValue(cmAttrDate.getValue());
			} else {
				genderAttr.setValue(null);
			}
		}
		
		return genderAttr;
	}

	
	public static CmAttributeCountry update(CmAttributeCountry countryAttr, String newValue) {
		CmAttributeCountry cmAttrDate = Utils.getCmAttrCountry(newValue);
		if(null == countryAttr) {
			countryAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				countryAttr.setValue(cmAttrDate.getValue());
			} else {
				countryAttr.setValue(null);
			}
		}
		
		return countryAttr;
	}

	public static CmAttributeBoolean update(CmAttributeBoolean booleanAttr, String newValue) {
		CmAttributeBoolean cmAttrDate = Utils.getCmAttrBoolean(newValue);
		if(null == booleanAttr) {
			booleanAttr = cmAttrDate;
		} else {
			if(null != cmAttrDate) {
				booleanAttr.setValue(cmAttrDate.isValue());
			} else {
				booleanAttr.setValue(false);
			}
		}
		
		return booleanAttr;
	}

	public static CmAttributeOwnershipType update(CmAttributeOwnershipType ownershipAttr, String newValue) {
		CmAttributeOwnershipType cmAttrOwnerType = Utils.getCmAttrOwnerType(newValue);
		if(null == ownershipAttr) {
			ownershipAttr = cmAttrOwnerType;
		} else {
			if(null != cmAttrOwnerType) {
				ownershipAttr.setValue(cmAttrOwnerType.getValue());
			} else {
				ownershipAttr.setValue(null);
			}
		}
		
		return ownershipAttr;
	}

	public static CmAttributeEntityType update(CmAttributeEntityType entityTypeAttr, String newValue) {
		CmAttributeEntityType cmAttrEntityType = Utils.getCmAttrEntityType(newValue);
		if(null == entityTypeAttr) {
			entityTypeAttr = cmAttrEntityType;
		} else {
			if(null != cmAttrEntityType) {
				entityTypeAttr.setValue(cmAttrEntityType.getValue());
			} else {
				entityTypeAttr.setValue(null);
			}
		}
		
		return entityTypeAttr;
	}

	public static CmAttributeOption update(CmAttributeOption optionAttr, String newValue) {
		CmAttributeOption cmAttrOption = Utils.getCmAttrOption(newValue);
		if(null == optionAttr) {
			optionAttr = cmAttrOption;
		} else {
			if(null != cmAttrOption) {
				optionAttr.setValue(cmAttrOption.getValue());
			} else {
				optionAttr.setValue(null);
			}
		}
		
		return optionAttr;
	}

	public static CmAttributeCurrency update(CmAttributeCurrency currAttr, String newValue) {
		CmAttributeCurrency cmAttrCurr = Utils.getCmAttrCurrency(newValue);
		if(null == currAttr) {
			currAttr = cmAttrCurr;
		} else {
			if(null != cmAttrCurr) {
				currAttr.setValue(cmAttrCurr.getValue());
			} else {
				currAttr.setValue(null);
			}
		}
		
		return currAttr;
	}
	
}

	