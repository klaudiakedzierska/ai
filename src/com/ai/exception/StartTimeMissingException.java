package com.ai.exception;

public class StartTimeMissingException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -61559259981032799L;

	public StartTimeMissingException(){
		super("Start Time is missing, please adjust data.txt");
	}
}
