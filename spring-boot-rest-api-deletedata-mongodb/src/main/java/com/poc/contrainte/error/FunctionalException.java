package com.poc.contrainte.error;

public class FunctionalException extends AbstractException {
	private static final long serialVersionUID = 1L;

	public FunctionalException(AppErrors appErrors, Exception e) {
		super(appErrors, e);
	}

	public FunctionalException(AppErrors appErrors) {
		super(appErrors);
	}

}
