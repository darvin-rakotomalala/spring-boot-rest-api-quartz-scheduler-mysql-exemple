package com.poc.contrainte.error;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public enum ErrorsEnum  implements AppErrors {

	ERR_MCS_ES_NO_ID("ERR_MCS_GEOCODE_000001", "No ID were provided", true, false, HttpStatus.SC_BAD_REQUEST),
	ERR_MCS_ES_SAVE_ERROR("ERR_MCS_GEOCODE_000003", "Error occurred while saving", true, false,HttpStatus.SC_INTERNAL_SERVER_ERROR),
	
	ERR_PRODUCT_INVALID("ERR_PRODUCT_INVALID", "Product not valid.", Boolean.TRUE, Boolean.FALSE,HttpStatus.SC_BAD_REQUEST),
	
	;
	private final String errorCode;
	private final String errorMessage;
	private final Boolean error;
	private final Boolean warning;
	private final Integer httpCode;

	/**
	 * liste de correspondance entre un enum et errorCode
	 */
	private static final Map<String, ErrorsEnum> BYID = new HashMap<String, ErrorsEnum>();

	static {
		for (ErrorsEnum e : ErrorsEnum.values()) {
			if (BYID.put(e.getErrorCode(), e) != null) {
				throw new IllegalArgumentException("duplicate id: " + e.getErrorCode());
			}
		}
	}

	private ErrorsEnum(String errorCode, String errorMessage, Boolean error, Boolean warning, Integer httpCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.error = error;
		this.warning = warning;
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "ErrorCode : " + errorCode + " errorMessage : " + errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Boolean isError() {
		return error;
	}

	@Override
	public Boolean isWarning() {
		return warning;
	}

	@Override
	public Integer getHttpCode() {
		return httpCode;
	}

	public static ErrorsEnum getById(String id) {
		return BYID.get(id);
	}

	public Boolean getError() {
		return error;
	}

	public Boolean getWarning() {
		return warning;
	}
}
