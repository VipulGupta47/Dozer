package com.headstrong.npi.raas.engine.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	private static final String REMEDIATIONPROPERTYFILE = System.getProperty("user.home") + File.separator + "cobs" + File.separator + "processconfig.properties";

	private static Properties props = null;
	
	public static String getProperty(String property) {
		String propertyValue = null;
		FileInputStream fis = null;
		if (null == props) {
			try {
				File propFile = new File(REMEDIATIONPROPERTYFILE);
				if (propFile.exists()) {
					Properties prop = new Properties();
					fis = new FileInputStream(REMEDIATIONPROPERTYFILE);
					prop.load(fis);
					props = prop;
				}
			} catch (IOException e) {
				LOGGER.error("Could not load remediation config", e);
			} finally {
				try {
					if (fis != null)
						fis.close(); //findbugfix
				} catch (IOException e) {
					LOGGER.error("Could not load remediation config", e);
				}
			}
		}
		if (null != props) {
			propertyValue = props.getProperty(property);
		}
		return propertyValue;
	}

}