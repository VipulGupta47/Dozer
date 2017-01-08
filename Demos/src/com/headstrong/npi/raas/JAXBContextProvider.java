package com.headstrong.npi.raas;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;




import com.headstrong.npi.raas.cobs.xml.pojo.Case;
import com.headstrong.npi.raas.cobs.xml.pojo.ChallengeCase;
import com.headstrong.npi.raas.cobs.xml.pojo.FormationCase;
//import com.headstrong.npi.raas.cobs.xml.pojo.CobCmData;
import com.headstrong.npi.raas.xml.pojo.RemediationFile;
import com.headstrong.npi.raas.xml.pojo.RemediationProfile;
//import com.headstrong.npi.raas.xml.pojo.RemediationResponse;

/**
 * Singleton implementation of JaxbContext for RemediationFile and
 * RemediationProfile.
 * 
 * @author 400216765
 * 
 */
public enum JAXBContextProvider {

	REMEDIATIONFILE_INSTANCE(RemediationFile.class), 
	REMEDIATIONPROFILE_INSTANCE(RemediationProfile.class),
	COBCMDATA_INSTANCE(Case.class);

	private JAXBContext context;

	JAXBContextProvider(Class classToCreate) {
		try {
			this.context = JAXBContext.newInstance(classToCreate);
		} catch (JAXBException ex) {
			throw new IllegalStateException(
					"Unbale to create JAXBContextSingleton for RemediationFile");
		}
	}

	public JAXBContext getContext() {
		return context;
	}

}
