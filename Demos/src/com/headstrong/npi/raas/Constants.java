package com.headstrong.npi.raas;


public class Constants {
	
	//Activiti
	
	public final static String COBS_CM_PROCESS_KEY = "process_cobs_cm";
	
	public final static String SAMPLING_PROCESS_KEY="samplingProcess";
	public final static String DOCUMENT_TRANSLATION_PROCESS_KEY="documentTranslate";
	
	public final static String TASK_DE = "Data Enrichment";
	public final static String TASK_REQUEST_INFO = "On Hold";
	public final static String TASK_CS = "Screening";
	public final static String TASK_DD = "Due Diligence";
	public final static String TASK_QA = "QA";
	public final static String TASK_PR = "Profile Remediated";
	public final static String TASK_SAMPLING = "Sampling";

	public final static String TASK_PRE_ENRICH = "Pre Enrichment";
	// TODO: Use existing TASK_DE?
	public final static String TASK_BASIC_ENRICH = "Basic Enrichment";
	public final static String TASK_HIERARCHY_ENRICH = "Hierarchy Enrichment";
	public final static String TASK_ADDITIONAL_ENRICH = "Additional Enrichment";
	public final static String TASK_CLIENT_OUTREACH = "Client Outreach";
	
	public final static String ASSIGNEE = "assignee";
	public final static String OWNER = "owner";
	public final static String CANDIDATE = "candidate";
	public final static String ASSIGNEE_INFO = "assigneeInfo";
	public final static String USER_ID = "userId";
	public final static String ANALYST = "analyst";
	public final static String LEADER = "Leader";
	public final static String PRIMARY_GROUP_MEMBER_ID = "primaryGroupId";
	public final static String LIST_OF_LINKED_MEMBERS = "listOFLinkedCaseId";

	public final static String REMEDIATION_BATCH_ID = "batchId";
	
	public final static String EXCULIVE_GATE_DECISION_REQUEST_INFO="requestInfo";
	public final static String EXCUSLIVE_GATE_DECISION_DUPLICATE="duplicateInd";
	public final static String EXCULIVE_GATE_DECISION_REPROCESS="reProcess";
	public final static String DATA_ENRICHMENT_TASK_OUTCOME="requestInfo";
	public final static String DATA_ENRICHMENT_TASK_OUTCOME_DUPLICATE="true";
	public final static String DATA_ENRICHMENT_TASK_OUTCOME_NOT_DUPLICATE="false";
	public final static String DATA_SCREENING_TASK_OUTCOME="screeningOutcome";
	public final static String PROCESS_RISK_VARIABLE="performDueDeligence";
	public final static String DUE_DILLIGENCE_TASK_OUTCOME="dDOutcome";
	public final static String QA_TASK_COMPLETE_OUTCOME="translationRequired";
	public final static String POSSIBLE_OUTCOME_TRANSLATION_REQUIRED="true";
	public final static String POSSIBLE_OUTCOME_TRANSLATION_NOT_REQUIRED="fasle";
	public final static String QA_TASK_OUTCOME="reProcess";
	public final static String PROFILE_REMEDIATED_TASK_OUTCOME="reopen";
	public final static String PROFILE_REMEDIATED_TASK_REOPEN="true";
	public final static String PROFILE_REMEDIATED_TASK_COMPLETE="false";
	public final static String POSSIBLE_OUTCOME_REJECT="reject";
	public final static String POSSIBLE_OUTCOME_DEFAULT="false";
	public final static String POSSIBLE_OUTCOME_COMPLETE="true";
	public final static String POSSIBLE_OUTCOME_ONHOLD="true";
	public final static String POSSIBLE_OUTCOME_REWORK_DE="DE";
	public final static String POSSIBLE_OUTCOME_REWORK_CS="CS";
	public final static String POSSIBLE_OUTCOME_REWORK_DD="DD";
	public final static String SAMPLING_SET_ID="semaplingSetId";
	public final static String SAMPLING_TASKOPEN="Sampling";
	public final static String SAMPLING_TASKPASS="PASS";
	public final static String SAMPLING_TASKFAIL="FAIL";
	public final static Integer SAMPLING_FINDING_CATEGORY_REGUALTROY=1;
	public final static Integer SAMPLING_FINDING_CATEGORY_DATA=2;
	public final static Integer SAMPLING_FINDING_CATEGORY_PROCESS=3;
	public final static Integer SAMPLING_FINDING_CATEGORY_NO_FINDING=4;
	public final static String SAMPLING_DECION_TASK_OUTCOME="decisionStatus";
	public final static String SAMPLING_DECION_COMMENTS="samplingComments";
	public final static String DOCUMENT_TRANS_INITIALISATION_PROCESS_VAR="noOfLanguagesToTranslate";	
	public final static String DOCUMENT_TRANSALTION_LANGUAGE_VARIABLE="translationLanguage";
	public final static String DOCUMENT_TRANSLATION_OUTCOME_PROCESS_VARIABLE="docTranslationReworkRequired";
	public final static String DOCUMENT_TRANSLATION_OUTCOME="optionSelected";
	public final static String DOCUMENT_TRANSLATION_CHECK_OUTCOME_REWORK="rework";
	public final static String DOCUMENT_TRANSLATION_CHECK_OUTCOME_COMPLETE="complete";
	public static final String VARIABLE_SUBMIT_OPTION = "submitOptionSelected";
	
	public final static String PROCESS_VAR_ENTRY_DO_PRE_ENRICH = "preEnrich";
	public final static boolean PROCESS_VAR_VAL_ENTRY_DO_PRE_ENRICH_YES = true;
	public final static boolean PROCESS_VAR_VAL_ENTRY_DO_PRE_ENRICH_NO = false;
	public static final String PROCESS_VAR_VAL_PRE_ENRICH_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_BASIC_ENRICH_OUTCOME = "basicEnrichOutcome";
	public final static String PROCESS_VAR_VAL_BASIC_ENRICH_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_VAL_BASIC_ENRICH_OUTCOME_MORE_INFO = "moreInfo";
	public final static String PROCESS_VAR_VAL_BASIC_ENRICH_OUTCOME_SEND_BACK = "sendBack";
	public final static String PROCESS_VAR_HIERARCHY_ENRICH_OUTCOME = "hierarchyEnrichOutcome";
	public final static String PROCESS_VAR_VAL_HIERARCHY_ENRICH_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_VAL_HIERARCHY_ENRICH_OUTCOME_MORE_INFO = "moreInfo";
	public final static String PROCESS_VAR_VAL_HIERARCHY_ENRICH_OUTCOME_SEND_BACK = "sendBack";
	public final static String PROCESS_VAR_ADDITIONAL_ENRICH_OUTCOME = "addEnrichOutcome";
	public final static String PROCESS_VAR_VAL_ADDITIONAL_ENRICH_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_VAL_ADDITIONAL_ENRICH_OUTCOME_MORE_INFO = "moreInfo";
	public final static String PROCESS_VAR_VAL_ADDITIONAL_ENRICH_OUTCOME_SEND_BACK = "sendBack";
	public final static String PROCESS_VAR_QA_OUTCOME = "qaOutcome";
	public final static String PROCESS_VAR_VAL_QA_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_VAL_QA_OUTCOME_REDO_PRE_ENRICH = "redoPreEnrich";
	public final static String PROCESS_VAR_VAL_QA_OUTCOME_REDO_BASIC_ENRICH = "redoBasicEnrich";
	public final static String PROCESS_VAR_VAL_QA_OUTCOME_REDO_ADDITIONAL_ENRICH = "redoAddEnrich";
	public final static String PROCESS_VAR_CLIENT_OUTREACH_OUTCOME = "clientOutreachOutcome";
	public final static String PROCESS_VAR_VAL_CLIENT_OUTREACH_OUTCOME_COMPLETE = "complete";
	public final static String PROCESS_VAR_VAL_CLIENT_OUTREACH_OUTCOME_SEND_BACK = "sendback";
	
	public final static int TASK_PRIORITY_HIGH=1;
	public final static int TASK_PRIORITY_MEDIUM=2;
	public final static int TASK_PRIORITY_LOW=3;
	public final static String TASK_NAME="status";
	public final static String TASK_STATUS_COMPLETE="COMPLETE";
	public final static String TASK_STATUS_CANT_REOPEN="COMPLETE";
	public final static String TASK_COMPLETE_AND_CONTIUE="completeAndContinue";
	public final static String TASK_MOVE_TO_PREVIOUS_TASK="moveToPreviousTask";
	public final static String TASK_STATUS_NEED_INFO="NEED INFO";
	public final static String TASK_STATUS_CANCEL="CANCEL";
	public final static String TASK_STATUS_OPEN="OPEN";
	public final static String TASK_STATUS_REJECTED="REJECTED";
	public final static String TASK_STATUS_REWORK="REWORK";
	public final static String TASK_STATUS_REOPEN="REOPEN";
	public final static String TASK_STATUS_REMEDIATED="REMEDIATED";
	public final static String TASK_STATUS_DUPLICATE="DUPLICATE";
	
	public final static String MISSING_ATTRIBUTES = "Attributes";
	public final static String MISSING_DOCUMENTS = "documents";
	public final static String CYCLE_TIME="cycleTime";
	public final static String CYCLE_TIME_HIGH_RISK="cycleTimeHighRisk";
	public final static String TOUCH_TIME="touchTime";
	public final static String TOUCH_TIME_HIGH_RISK="touchTimeHighRisk";
	public final static String CYCLE_TIME_LIST="cycleTimeList";
	public final static String CYCLE_TIME_HIGH_RISK_LIST="cycleTimeHighRiskList";
	public final static String TOUCH_TIME_LIST="touchTimeList";
	public final static String TOUCH_TIME_HIGH_RISK_LIST="touchTimeHighRiskList";
	
	//Remediation
	public final static String PROCESS_ENGINE_NAME = "default";
	public final static String TASK_ASSIGNED_DATE = "assignedDate";
	public final static String SUCCESS = "success";
	public final static String FAILURE = "failure";
	public final static String STATUS_VALIDATED = "validated";
	public final static String STATUS_COMPLETED = "completed";
	public final static String STATUS_INPROGRESS = "inProgress";
	public final static String STATUS_REJECTED = "rejected";
	public final static String STATUS_ASSIGNED = "assigned";
	public final static String STATUS_DUPLICATE = "duplicate";
	public final static String STATUS_NEW="new";
	public final static String STATUS_ALL="all";
	public final static String PROCESS_FILE_PATH = "process.file.path";
	public final static String DEPLOY_PROCESS = "deploy.process";
	public final static String TRUE_STRING = "true";
	
	//Util
	public static long MILLISECINADAY = 24*60*60*1000;
	public static long MILLISECINAHOUR = 60*60*1000;
	public static long MILLISECINAMINUTE = 60*1000;
	public final static String DASHBOARD_DURATION="dashboradDuration";
	
	//Activiti Util
	public final static String DAYSSTRING = "days";
	public final static String HOURSSTRING = "hours";
	public final static String MINUTESSTRING = "minutes";
	
	//Rest
	public final static String REMEDIATION_FILES_STATUS_TO_LIST = "RemediationFileStatusTo";
	public final static String REMEDIATION_FILE_STRING = "remediationFileString";
	public final static String PROCESS_HISTORY="process_history";
	public final static String TASKLIST = "taskList";
	public final static String TASK_PRIORITY = "taskPriority";
	public final static String TASK_ASSIGNEE="taskAssignee";
	public final static String TASK_DUE_DATE="taskDueDate";
	public final static String USER_INFO="userInfo";
	
	//Feed patterns
	public final static String PATTERN_ASSIGN_TASK = "@TASK of case: @ID is assigned to @ASSIGNEE";
	public final static String PATTERN_UNASSIGNED_TASK = "@TASK of case: @ID has been unassigned";
	
	public final static String ATTRIBUTE_RISK="final_risk";
	
	public final static String ORIGINAL_RISK="original_risk";
	public final static String CALCULATED_RISK="calculated_risk";
	
	public final static String QA_REJECT_REASON = "reject_reason";
	
	public final static String MY_INBOX_JSF = "myInbox.jsf";
	
	// Document repository
/*	public final static String RAASDOCSSTR = "RAAS_DOCS_2";
	public final static String DOC_FOLDER = "Files";*/
	public final static String RAASDOCS_KEY = "repository.folder";
	public final static String RAASDOCSFILE_KEY = "repository.files";
	public final static String FALSESTR = "false";
	public final static String CONTENTTYPESTR = "Content-type";
	public final static String PROPERTYDEFINITIONIDSTR = "propertyDefinitionId"; 
	public final static String HSCOMMENTSTRING ="hs:comments";

	public final static String HSSOURCESTRING ="hs:source";
	public final static String HSLANGUAGESTRING ="hs:language";
	public final static String HSDOCUMENTFORMATSTRING ="hs:documentFormat";
	public final static String HSPUBLISHERSTRING ="hs:publisher";
	public final static String HSRELATEDTOATTRIBUTE = "hs:RelatedToAttribute";
	public final static String HSLINKEDDOCID = "hs:linkedDocId";
	public final static String HSLINKEDDOCTYPE = "hs:linkedDocType";
	
	public final static String HSEFFECTIVEDATESTRING ="hs:effectiveDate";
	public final static String HSEXPIRYDATESTRING ="hs:expiryDate";
	public final static String HSDOCNAMESTRING ="hs:docName";
	public final static String HSDOCCATEGORYSTRING ="hs:docCategory";
	public final static String HSDOCTYPESTRING ="hs:docType";
	public final static String HSRAADIDSTRING ="hs:raasId";
	public final static String HSCMISNAMESTRING ="cmis:name";
	public final static String CMISPROPERTYSTRING ="cmis:propertyString";
	public static final String CMISPROPERTIES = "cmis:properties";

	public final static String DOC_METADATA = "META_DATA.txt";
	
	public final static String RESP_PACKAGE_PROP_FILE_DESCRIPTION = "FILE_DESCRIPTION";
	
	public final static String HS_RESP_GEN_TIME ="hs:genTime";
	public final static String HS_RESP_NUM_PROFILES ="hs:numProfiles";
	public final static String HS_RESP_NUM_DOCS ="hs:numDocuments";
	public final static String HS_RESP_NUM_MISSING_INFO ="hs:numMissingInfo";
	public final static String HS_RESP_DATE_FILTER_FROM ="hs:dateFilterFrom";
	public final static String HS_RESP_DATE_FILTER_TO = "hs:dateFilterTo";
	public final static String HS_RESP_COUNT_FILTER = "hs:countFilter";
	public final static String HS_RESP_STATUS_FILTER = "hs:statusFilter";
	
	// End Document repository
	
	// General Rest
	public final static String REST_CLIENT_ERROR_STRING = "Failed : HTTP error code : ";
	public final static String APPLICATION_JSON_STRING = "application/json";
	public final static String POST_REQUEST_STRING = "POST";
	public final static String GET_REQUEST_STRING = "GET";
	public final static String DELETE_REQUEST_STRING = "DELETE";
	public final static String PUT_REQUEST_STRING = "PUT";

	public final static String CONTENT_TYPE_APPLICATION_OCTET_STREAM = "application/octet-stream";
	public final static String HTTP_HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public final static String HTTP_HEADER_ACCEPT = "accept";
	
	// Rules Rest
	public final static String MAP_CLIENT_ID="clientId";
	public final static String MAP_RISK_CALCULATION="riskCalcualtion";
	public final static String BLANK_VALUE_IN_TABLE = "Data not avialable";
	
	public final static String GET_RISK_RESULT="getRiskRuleResult";
	public final static String VALIDATE_MANDATORY_PARAMETERS="validateMandatoryParameters";
	public final static String GET_DOCUMENT_LIST = "getRequiredDocumentList";
	public final static String GET_ADDITIONAL_ATTRIBUTES_LIST = "getAdditionalAttributesList";
	
	//Task Overview
	public final static String TASK_OVERVIEW_DE="DATA ENRICHMENT";
	public final static String TASK_OVERVIEW_SCREENING="SCREENING";
	public final static String TASK_OVERVIEW_QA="QA";
	public final static String TASK_OVERVIEW_DUE_DILIGENCE="DUE DILIGENCE";
	public final static String TASK_OVERVIEW_COMPLETED="COMPLETED";
	public final static String TASK_OVERVIEW_NEW="NEW";
	public final static String TASK_OVERVIEW_TOTAL="Total";
	public final static String TASK_OVERVIEW_REJECTED="REJECTED";
	public final static String TASK_OVERVIEW_ON_HOLD="ON HOLD";
	public final static String TASK_OVERVIEW_REWORK="REWORK";
	public final static String TASK_OVERVIEW_REOPEN="REOPEN";
	public static final String TASK_OVERVIEW_UNASSIGNED="UNASSIGNED";
	
	public final static String QA_ERR_ATTR_SEP_STR = ",";
	
	public final static String INVALID_FILENAME_CHARS = "[^a-zA-Z0-9\\-\\. _(),']";
	
	public final static String INVALID_CHARS_REPLACE_STRING = "_";

	
	//request submit constants
	public final static String LEGAL_FORM = "legalForm";
	public final static String BUSINESS_TYPE = "businessType";
	public final static String BUSINESS_CLASSIFICATION = "businessClassification";
	public final static String ENTITY_TYPE = "entityType";
	public final static String COUNTRY_OF_INCORPORATION = "countryOfIncorporation";
	public final static String STATE_OF_INCORPORATION = "stateOfIncorporation";
	public final static String DATE_OF_INCORPORATION = "dateOfIncorporation";
	public final static String DBA = "dba";
	public final static String REGULATOR = "regulator";
	public final static String SIC = "sic";
	public final static String SICVALUE = "sicValue";
	public final static String NAICS = "naics";
	public final static String NAICSVALUE = "naicsValue";
	public final static String OWNERSHIP_TYPE="ownershipType";
	
	public final static String TASK_IMI = "Missing Information Fulfillment";
	public final static String SAMPLING_TASK_ACTIONS="samplingTaskActions";
	public final static String UI_DATE_FORMAT = "yyyy/MM/dd";
	public final static String REMEDIATION_PROFILE_MAP_KEY="remediationProfile";
	public final static String TASK_ID_MAP_KEY="taskId";
	public final static String MISSING_INFORMATION="missingInformationObj";
	public final static String UPDATE_TASK="updateTask";
	public final static String CANCEL="cancel";
	public final static String CURRENT_USER="currentUser1";
	public final static String ASSIGN="assign";
	public final static String FILENAME="fileName";
	public final static String UPLOADEDFILE="uploadedFile";
	public final static String USER_NAME="userName";
	public final static String PROCESS_INSTANCE_ID="processInstanceId";
	public final static String BATCH_ID="bacthID";
	public final static String ANALYST_DASHBOARD="analystDashboard";
	public final static String LEAD_DASHBOARD="leadDashboard";
	public final static String METHOD_ARGUMENTS="methodArguments";
	public final static String CLIENTGROUP="ClientGroup";
	public final static String TASK_STATUS_ONHOLD="onhold";
	public final static String BPMTASKINFO="bpmtaskinfo";
	public final static String COMMENTS="Comments";
	public final static String USERLIST="userList";
	public final static String GROUP_ID="groupId";
	public final static String LINKED_CASES_PROFILE_MAP="linkedCasesProfile";
	public final static String ENTITY_ID="entityId";
	public final static String SEARCH_CRITERIA_MAP="searchCriteriaMap";
	public final static String SEARCH_SAMPLING_CASEIDS="searchSamplingCASEIDs";
	public final static String  PROCESSVARIABLEMAP="processVariableMap";
	public final static String OBJECT_ARRAYLIST="objectArrayList";
	public final static String SAMPLESETOBJ="samplesetobj";
	public final static String SETID="setId";
	public final static String INSERTSAMPLINGSETCASES="insertSamplingSetCases";
	public final static String DOCUMENT_TRANSLATE_COMMENTS="DocumentTranslateCommnets";
	public final static String TOUCH_TIME_LOG="touchTimeLog";
	public final static String REST_CURRENT_USER_INFO_OBJ="currentUserInfo";
	
	//UI Based
	public final static String TASK_SAVE_FOR_LATER ="save";
	public final static String TASK_NEED_MORE_INFO="moreInfo";
	public final static String TASK_ASSIGN_TO_ANALYST="assignToAnalyst"; 
	public final static String TASK_CANCEL="cancel";
	public final static String UI_LINK_PARAMTER_ON_HOLD="ONHOLD";
	public final static String UI_LINK_PARAMTER_SAMPLING="SAMPLING";
	public final static String UI_PAGELINK_DATA_ENRICHMENT="dataEnrichment.jsf";
	public final static String UI_PAGELINK_CONDUCT_SCREENING="screening.jsf";
	public final static String UI_PAGELINK_DUE_DILIGENCE="dueDiligence.jsf";
	public final static String UI_PAGELINK_QA="qualityAnalysis.jsf";
	public final static String UI_REGULATORY_FINDING_LIST="regulatoryFindingList";
	public final static String UI_DATA_FINDING_LIST="dataFindingList";
	public final static String UI_PROCESS_FINDING_LIST="processFindingList";
	public final static String UI_CATEGORY_FINDING_LIST="categoryFindingsList";
	public final static String UI_TOUCH_TIME_START_EVENT_TYPE="Start";
	public final static String UI_TOUCH_TIME_END_EVENT_TYPE="End";
	public final static String CURRENT_USER_SESSION_OBJ="currentUserObject";
	// Engine method name

	public final static String ENGINE_SAVE_DATA_COMPLETE_TASK="saveDataAndCompleteTask";
	public final static String COMPLETE_ON_HOLD_TASK="completeOnHoldTask";
	public final static String SAVE_UPLOADED_FILE_TASK="saveUploadedFile";
	public final static String UPDATE_CASE_INFORMATIO="updateCaseInformation";
	public final static String GET_FILE_STATUS_INFO="getRemedaitionFilesInfo";
	public final static String GET_REMEDIATION_FILE_PROFILES="getRemediationFileProfiles";
	public final static String ENIGNE_SET_DATA_ENRICHMENT="setDataEnrichmentData";
	public final static String ENIGNE_SAVE_REMEDIAITON_PROFILE="saveRemedaitionProfile";
	public final static String ENIGNE_GET_DATA_FOR_TASK="getTaskData";
	public final static String ENIGNE_GET_USER_TASK_LIST="getUserTaskList";
	public final static String ENIGNE_GET_USER_COMPLETED_TASK_LIST="getUserCompleteTaskList";
	public final static String ENIGNE_ASSIGN_TASK_WITH_PROCESS_INSTANE_ID="assignTaskWithProcessInstanceId";
	public final static String ENIGNE_GET_GROUP_INBOX="getGroupInbox";
	public final static String USER_INFO_LIST="getUserInfoList";
	public final static String DASHBOARD_DATA="getDashboardData";
	public final static String ANALYST_DASHBOARD_DATA="getAnalystDashboardData";
	public final static String AUTHENTICATE_USER="getAuthenticationResponse";
	public final static String DOWNLOAD_REMEDIATIED_FILE="getUpdatedRemediationFile";
	public final static String GET_PROCESS_HISTORY="getProcessHistory";
	public final static String UPDATE_CASE_INFORMATION = "updateCaseInformation";
	public final static String GET_USER_LIST="getUserList";
	public final static String USER_INFO_BY_USER_ID="getUserInfoListByUserID";
	public final static String GET_COMMENTS="getComments";
	public final static String GET_FILE_ELEMENTS="getFileElements";
	public final static String SAVE_COMMENTS="saveComments";
	public final static String SAVE_MISSING_INFORMATION="saveMissingInformationData";
	public final static String GET_MISSING_INFORMATION="getMissingInformationFulfilmentData";
	public final static String GET_TASK_INFO="getBPMTaskObj";
	public final static String GET_UNLCAIMED_TASK_LIST="getClaimTaskList";
	public final static String GET_ORIGINAL_REMDIATION_POFILE="getOriginalRemedaitionProfile";
	public final static String SAVE_DOCUMENT_SUMMARY="saveDocumentSummary";
	public final static String GET_DOCUMENT_SUMMARY="getDocumentSummary";
	public final static String SET_LINKED_CASES="setlinkCases";
	public final static String GET_LINKED_CASES="getlinkedCases";
	public final static String GET_PROCESSHISTORYAUDIT="getProcessHistoryForAudit";
	public final static String GET_PROCESSHISTORYREPORT="getProcessHistoryForReport";
	public final static String GET_REMEDIATION_PROFILE_INFO_BY_TASK_ID_AS_TASKLIST="getRemediationProfileInfoBytaskIdAsTaskList";
	public final static String ASSIGN_SAMPLING_CASE_INFORMATION="assignSamplingCaseInformation";
	public final static String GET_SAMPLING_INBOX="getSamplingInbox";
	public final static String GET_SAMPLING_SET_INFORMATION="getSamplingSetInformation";
	public final static String GET_SAMPLING_GROUP_INBOX="getSamplingGroupInbox";
	public final static String COMPLETE_SAMPLING_CASE_TASK="completeSamplingTask";
	public final static String GET_CATEGORY_AND_FINDINGS_LIST="getCategoryAndFindingList";
	public final static String SAVE_TASK_FINDINGS = "saveTaskFindings";
	public final static String GET_TASK_FINDINGS = "getTaskFindings";
	public final static String SEARCH_TASK="searchTask";
	public final static String GET_LEGAL_HIERARCHYINFO="getLegalHierarchyInformation";
	public final static String GET_ENTITYLIST="getEntityList";
	public final static String ADD_LEGALHIERARCHY="addLegalHierarchy";
	public final static String CREATESAMPLINGTASK="createSamplingTask";
	public final static String GET_SAMPLING_HEADER="getSamplingHeader";
	public final static String GET_SAMPLING_CASEMAPPING="getSamplingCaseMapping";
	public final static String INSERT_SAMPLING_CASEMAPPING="insertSamplingCaseMapping";
	public final static String GET_SAMPLING_SET_CASES_INFO="getSamplingSetInfoByCaseId";
	public final static String INSERT_COMPLETE_SAMPLING_CASEMAPPING="insertCompleteSamplingCaseMapping";
	public final static String COMPLETEDECISIONTASK="completeDecisionTask";
	public final static String SAMPLING_COMPLETE_DECISION_TASK="completeDecisionTask";
	public final static String SAMPLING_SAVE_DECISION_COMMENTS="saveSamplingDecisionComments";
	public final static String SAMPLING_COMPLETE_TAKE_ACTION="completeSamplingTakeAction";
	public final static String SAMPLING_GET_TASK_ACTION="getSamplingActions";
	public final static String SAMPLING_SAVE_TASK_ACTION="saveSamplingActions";
	public final static String REFERENCE_DATA_LIST_OF_EXCHANGE="getListOfExchange";
	public final static String COMPLETE_DOCUMENT_TRANSLATION_TASK="completeTranslationTask";
	public final static String GET_DOCUMENT_TRANSLATION_INBOX="getUserDocTranslationTaskList";
	public final static String SAVE_DOC_TRANS_TASK_COMMENTS="saveDocTranslationComments";
	public final static String GET_DOC_TRANS_TASK_COMMENTS="getDocTranslationComments";
	public final static String UNASSIGN_TASK="unassignTask";
	public final static String LOG_TOUCH_TIME="setTouchTimeLog";
	public final static String REOPEN_PROCESS="reopenProcess";
	public final static String TERMINATE_PROCESS="finalCompletionOfProcess";
	public static final String REMOVE_COMMENTS = "removeComments";
	public static final String ASSIGN_TASK_W_TASK_ID = "assignTaskWithTaskId";
	public static final String SET_TASK_DETAILS = "setTaskDetails";
	public static final String GET_TASK_DETAILS = "getTaskDetails";
	
	// Engine Rest Reference Data Method 
	
	public final static String GET_COUNTRY_REFERENCE_DATA="getCountryReferenceData";
	public final static String GET_STATE_REFERENCE_DATA="getStateReferenceData";
	public final static String GET_LEGAL_FORM_REFERENCE_DATA="getLegalFormReferencedata";
	public final static String GET_IDENTIFIER_REFERENCE_DATA="getIdentifierReferenceData";
	public final static String GET_REGULATOR_REFERENCE_DATA="getRegulatorReferenceData";
	public final static String GET_TRADING_EXCHANGE_REFERENCE_DATA="getTradingExchangeReferenceData";
	public final static String GET_OWNERSHIP_REFERENCE_DATA="getOwnershipReferenceData";
	public final static String GET_PARTY_DETAIL_REFERENCE_DATA="getPartyDetailReferenceData";
	public final static String GET_EVENT_DETAIL_REFERENCE_DATA="getEventDetailReferenceData";
	public final static String GET_PEP_TYPE_REFERENCE_DATA="getPepTypeReferenceData";
	public final static String GET_MIFID_CLASSIFICATIONS_REFERENCE_DATA="getMifidClassificationsRerferenceData";
	public final static String GET_PEP_EVENT_TYPE_REFERENCE_DATA="getPepEventTypeReferenceData";
	public final static String GET_HIERARCHAY_TYPE_REFERENCE_DATA="getHierarchyTypeReferenceData";
	public final static String GET_PARENT_TYPE_REFERENCE_DATA="getParentTypeReferenceData";
	public final static String GET_PEP_RELATE_TO_TYPE_REFERENCE_DATA="getPepRelatedToTypeReferenceData";
	public final static String GET_PEP_POSITION_REFERENCE_DATA="getPepPositionReferenceData";
	public final static String GET_NEWS_TYPE_REFERENCE_DATA="getNewsTypeReferenceData";
	public final static String GET_ATTRIBUTE_TYPE_REFERENCE_DATA="getAttributeTypeReferenceData";
	public final static String GET_POSITION_REFERENCE_DATA="getPositionReferenceData";
	public final static String GET_DOCUMENT_TYPE_REFERENCE_DATA="getDocumentTypeReferenceData";
	public final static String GET_BUSINESS_TYPE_REFERENCE_DATA="getBusinessTypeReferenceData";
	public final static String GET_ADDRESS_TYPE_REFERENCE_DATA="getAddressTypeReferenceData";
	public final static String GET_PRODUCT_LIST_REFERENCE_DATA="getProductListReferenceData";
	public final static String GET_MATCH_FINDINGS_REFERENCE_DATA="getMatchFindingsReferenceData";
	public final static String GET_ASSOCIATION_REFERENCE_DATA="getAssociationTypeReferenceData";
	public final static String GET_LANGUAGE_REFERENCE_DATA="getLanguageReferenceData";									   
	public final static String GET_CITI_CUSTOMER_CLASSIFICATION_REF_DATA="getCitiCustomerClassificationReferenceData";
	public final static String GET_CITI_OTC_DERIVATIVE_CLASSIFICATION="getCitiDerivativeClassification";
	public final static String GET_CITI_CUSTOMER_ANTICIPATE_REFERENCE_DATA="getCitiCustomerAnticipateActivityReferenceData";
	public final static String GET_CITI_CAPITAL_MARKET_SERVICE_REFERENCE_DATA="getCitiCapitalMarketServiceReferenceData";
	public final static String GET_CITI_CUSTOMER_TYPE_REFERENCE_DATA="getCitiCustomerTypeReferenceData";
	public final static String GET_CITI_ATTRIBUTES_REFERENCE_DATA="getCitiAttributeReferenceData";
	public final static String GET_CITI_ELEMENT_ATTRIBUTES_REFERENCE_DATA="getCitiElementAttributesReferenceData";
	public final static String GET_DOC_TYPE_NAME_MAPING="getDocTypeNameReferenceData";
	public final static String REGISTER_USER="registerUser";
	public final static String GET_ATTRIBUTE_ELEMENT_MAPING="getAttributeElementMapping";
	public final static String GET_MGGP_FORM ="getMggpForm";
	public final static String GET_RAAS_ATTR_MASTER_LIST = "getRaaSAttributeMasterList";
	
	
	// Engine Rest Reference Data Request Map Keys
	public final static String COMPLETE_COUNTRY_LIST_REQUIRED="completeCountryListRequired";
	
	// required doc list messages
	
	public final static String REQUIRED_DOC_EMPTY_PARAM_MESSAGE = "";
	public final static String REQUIRED_DOC_EMPTY_FINALRISK_MESSAGE = "Please enter a valid value for 'Final Risk'.As this is the mandatory parameter for getting the document list. ";
	
	
	//response and request
	
	public final static String TASK_FINDINGS_LIST="taskFindings";
	//Rest - Engine
	public final static String HTTP_HEADER_CONTENT_LENGTH = "Content-Length";
	
	public final static String ENGINE_URL ="raasengine.url"; 
	public final static String RULE_ENGINE_URL ="ruleengine.url";

	public final static int COMMENTCOREINFORMATION=1;
	public final static int COMMENTOWNERSHIPINFORMATION=2;
	public final static int COMMENTSASSOCIATEDENTITIES=3;
	public final static int COMMENTSIDENTIFIERS=4;
	public final static int COMMENTSADDRESS=5;
	public final static int COMMENTSDOCUMENTREQUIREMENTS=6;
	public final static int COMMENTSNEGATIVENEWS=7;
	public final static int COMMENTSSANCTIONS=8;
	public final static int COMMENTSPEP=9;
	public final static int COMMENTSDUEDILIGENCEDETAILS=10;
	public final static int COMMENTSENHANCEDDUEDILIGENCEDETAILS=11;
	public final static int COMMENTSlINKEDCASEINFO=12;
	public final static int COMMENTSSCREENINGRICKPROFILE=13;
	public final static int COMMENTSDUEDILIGENCERICKPROFILE=14;
	public final static int COMMENTSDueDiligenceEDDDetails=15;
	public final static int COMMENTSMissingDocument=16;
	public final static int COMMENTSMissingAttributes=17;
	public final static int COMMENTSIdentifyMissingDocument=18;
	public final static int COMMENTSIdentifyMissingAttribute=19;
	public final static int COMMENTSFFIQuestionnaire=26;
	public final static int COMMENTSCOUNTRYSPECIFICCHECK=22;
	public final static int COMMENTSFIRMINTERNALCHECK=23;
	public final static int COMMENTSADDITIONALATTRIBUTE=24;
	public final static int COMMENTSLEGALHIERARCHY=25;
	//Rest - Rules
	
	public final static String REMEDIATIONDIR ="remediationfiledir";
	//Document Repository constants.

	public final static String HSPIISTRING ="hs:pii";
	public final static String HSCOPYTYPESTRING ="hs:copyType";
	public final static String GET_VALID_URL = "getValidURL";
	
	public final static String COUNTRY_OF_INCORPORATION_HDN = "countryOfIncorporationHiddenVal";
	public final static String COUNTRY_OF_PRIME_OPERATION_HDN = "countryOfprimaryOpHiddenVal";
	public final static String STATE_OF_INCORPORATION_HDN = "stateOfIncorporationHiddenVal";
	public final static String STATE_OF_INCORPORATION_INPUT = "stateOfIncorporationInput";
	
	public final static String COUNTRY_REF_DATA = "countryRefDataFATF";
	public final static String STATE_REF_DATA = "stateRefDataFATF";
	public final static String QUESTION12 = "question12ans";
	public final static String QUESTION13 = "question13ans";
	public final static String QUESTION14 = "selectedQuesAns14HiddenVal";
	public final static String QUESTION14IF = "question14desc";
	public final static String QUESTION15 = "question15ans";
	public final static String QUESTION15SUBANS = "question15subans";
	public final static String QUESTION15DESC = "question15desc";
	public final static String QUESTION16 = "question16ans";
	public final static String QUESTION16DESC = "question16desc";
	public final static String QUESTION17 = "question17ans";
	public final static String QUESTION17SUBANS = "question17subans";
	public final static String QUESTION17DESC = "question17desc";
	public final static String QUESTION24 = "question24ans";
	public final static String QUESTION24SUBANS = "question24subans";
	public final static String QUESTION25 = "question25ans";
	public final static String QUESTION25DESC = "question25desc";	
	public final static String QUESTION22 = "question22ans";
	public final static String QUESTION23 = "question23ans";
	
	public final static String GOVERNMENT_COUNTRY = "governmentCountryHiddenVal";
	public final static String GOVERNMENT_OWNERSHIP_PERCENTAGE ="governmentOwnershipPercentage";
	public final static String GOVERNMENT_OWN_CIRCUMSTANCES ="governmentOwnsershipCircumstances";
	public final static String GOVERNMENT_INVOLVED ="IsGovernmentInvolved";
	
	public final static String CUSTOMER_NOTICE_MEDIUM = "customerNoticeMedium";
	public final static String CUSTOMER_NOTICE_MEDIUM_DESCRIPTION = "customerNoticeDescription";
	//public final static String FORM_COMPLETION_PURPOSE = "formCompletionPurpose";
	public final static String CLASS_CODE = "classCode";
	public final static String MAJOR_CLASS = "majorClassHidden";
	public final static String SUB_CLASS = "subClassHidden";
	public final static String DOING_BUSINESS_AS = "doingBusinessAs";
	public final static String ISSUING_AUTHORITY = "issuingAuthority";
	public final static String TAX_ID_AVAILABLE = "IsTaxIdAvailable";
	public final static String COUNTRY_OF_TAXATION = "countryOfTaxationHiddenVal";
	public final static String TAX_ID = "taxid";
	public final static String TAX_ID_TYPE = "taxIdType";
	public final static String TAX_ID_DATE = "taxIdDate";
	public final static String COUNTRY_OF_BUSINESS_HDN = "countryOfBusinessListHidden";
	public final static String LEGAL_NAME = "legalName";
	public final static String DELETE_MISSING_INFORMATION="deleteMissingInformationData";
	
	public final static String MISSING_DOC_INFO_SECTION = "section16";
	public final static String MISSING_ATTRIBUTE_INFO_SECTION = "section17";

	public final static String MISSING_INFO_ID = "missingInfoId";
	public final static String MISSING_INFO_TYPE = "missingInfoType";
	public final static String USER_DETAIL = "userDetail";

	public final static String CITI_COMPLIANCE_CLASSIFICATION="COMD,DLR,FBD,FBHC,ICA,ICLG,ILA,ILIM,IMA,IMMF,IMSA,MF,SI,ICLI,ICLG,ICLA,GOV,FUTR,FX,FC,FO,CTA,FBT,FBSL,FBP,FBOS,FBMS,FBCM,CPVT,MONY,QF,IF,IMHF,IMAL,ITBC,ITB,ILSL,ILMF,ILG,ICSL,ICMF,ICIM,ICG,ICLS,ICLM,TI,SGOV,SWF,PWM,PEF,PBF,PIT";
	public final static String CITI_COMPLIANCE_CLASSIFICATION_MARKED="GAME,EMB,ART,IND,VENT,VEH,TRAV,SPV,PHC,JWL,PAWM,NPR,NPE,NP,MONY";
	public final static String CITI_COMPLIANCE_COUNTERY_NOT_IN="AM,AN,AS,AT,AU,BB,BE,BL,BN,BQ,BT,BV,BW,CA,CC,CH,CL,CN,CR,CV,CX,CZ,DE,DK,DM,EE,ES,EU,FI,FK,FM,FO,FR,GD,GE,GF,GG,GL,GP,GS,GU,HK,HM,HR,HU,IE,IL,IM,IN,IO,IS,IT,JE,JM,JO,JP,KI,KN,KR,KV,LC,LS,LT,LU,MH,MK,MP,MQ,MT,MU,NC,NF,NL,NO,NZ,OM,PF,PL,PM,PN,PR,PT,QA,RE,RO,SB,SE,SG,SH,SI,SJ,SK,SV,TF,TK,TO,TV,TW,UK,UM,US,VA,VC,VI,WF,YT,ZA";
	
	public final static String OWNERSHIP_DESC ="ownershipDesc";
	public final static String ATTRLIST_FOR_ELEMENT = "attributeList";
	public final static String RESET_PASSWORD ="resetPassword";
	public final static String CHANGE_PASSWORD ="changePassword";
	public final static String REST_USERNAME_PROP = "rest.username";
	
	public final static String REST_PASSWORD_PROP = "rest.password";
	
	public final static String QA_ERROR_FINDINGS = "qaErrorFindings";
	public final static String QA_VERIFIED_FINDINGS = "qaVerifiedFindings";
	public final static String QA_ERROR_COUNT = "qaErrorCount";
	public final static String CHAR_SET_UTF8 = "UTF-8";

	//Risk Modal constants

	public final static String COUNTRY_RISK_MODAL = "country";
	public final static String COUNTRY_Of_BUSINESS = "countryOfBusiness";
	public final static String COUNTRY_Of_PHYSICAL_ADDRESS = "countryOfPhysicalAddress";
	public final static String COUNTRY_Of_MAILING_ADDRESS = "countryOfMailingAddress";
	public final static String COUNTRY_OF_HQ_ADDRESS = "countryOfHQAddress";
	public final static String COUNTRY_RULE_CRITERIA = "countryOfIncorporation,countryOfBusiness,countryOfPhysicalAddress,countryOfMailingAddress,countryOfHQAddress";
	public final static String PRODUCTS = "products";

	public final static String COUSTOMER_PROFILE_RISK_MODAL = "customerProfile";
	public final static String PRODUCT_RISK_MODAL = "product";
	public final static String IS_LISTED = "isListed";
	public final static String IS_REGULATED = "isRegulated";
	
	/**
	 *  Method name for creating a URI for API.
	 *  cob-cm.xml creation.
	 */
	public final static String GET_COB_CM_PROFILE_INFO="getCobCmFileProfileInfo";
	
}
