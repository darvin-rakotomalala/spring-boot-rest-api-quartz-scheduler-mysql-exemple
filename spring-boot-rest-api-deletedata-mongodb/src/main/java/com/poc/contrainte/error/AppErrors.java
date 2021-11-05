package com.poc.contrainte.error;

public interface AppErrors {

	String getErrorCode();

	String getErrorMessage();

	Boolean isError();

	Boolean isWarning();

	Integer getHttpCode();

}
