package com.poc.contrainte.error;

public abstract class AbstractException extends RuntimeException {

	private String jsonErrorObject;
    private AppErrors appErrors;

    public AbstractException(AppErrors appErrors, Exception e) {
        super(e);
        this.appErrors = appErrors;
    }

    public AbstractException(AppErrors appErrors) {
        super(appErrors.getErrorMessage());
        this.appErrors = appErrors;

    }

    public String getJsonErrorObject() {
        return jsonErrorObject;
    }

    public void setJsonErrorObject(String jsonErrorObject) {
        this.jsonErrorObject = jsonErrorObject;
    }

    public AppErrors getErrorsEnum() {
        return appErrors;
    }

    public void setErrorsEnum(AppErrors appErrors) {
        this.appErrors = appErrors;
    }
}
