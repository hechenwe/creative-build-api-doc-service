package com.sooncode.creative_build_api_doc_service.util;

public class InterfacNumberBuilder {

	private static int BASE_NUMBER = 1000;

	public static int getInterfaceNumber() {
		BASE_NUMBER++;
		return BASE_NUMBER;
	}
}
