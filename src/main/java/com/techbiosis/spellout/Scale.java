package com.techbiosis.spellout;

import java.util.stream.Stream;

public enum Scale {
	//name,value, prevName, prevValue
	MILLION("million", 1000000, "thousand", 1000), BILLION("billion", 1000000000, "million", 1000000);

	private String name;
	private long value;
	private String prevName;
	private long prevValue;

	Scale(String name, long value, String prevName, long prevValue) {
		this.value = value;
		this.name = name;
		this.prevName = prevName;
		this.prevValue = prevValue;
	}

	public long getValue() {
		return value;
	}

	public String getPrevName() {
		return prevName;
	}

	public long getPrevValue() {
		return prevValue;
	}

	@Override public String toString() {
		return " " + name;
	}

	public static Scale valueOf(long value){
		return Stream.of(Scale.values()).filter(s -> s.getValue() == value).findFirst().get();
	}
}
