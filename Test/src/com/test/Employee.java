package com.test;

import java.util.HashMap;
import java.util.Map;

public  class Employee {

	private final long eId;
	private final String eName;
	private final Map<String, String> eAddress;

	public Employee(long eId, String eName, Map<String, String> eAddress) {
		this.eId = eId;
		this.eName = eName;

		Map<String, String> newMap = new HashMap<String, String>(eAddress);

		this.eAddress = newMap;
	}

	public Map<String, String> geteAddress() {
		Map<String, String> newMap = new HashMap<String, String>(eAddress);

		return newMap;
	}

	public long geteId() {
		return eId;
	}

	public String geteName() {
		return eName;
	}
}
