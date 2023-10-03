package com.ocoder.restapi.util;

import java.util.Locale;

public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("tr").setRegion("TR").build();
	public static final Locale VIETNAM_LOCALE = new Locale.Builder().setLanguage("vi").setRegion("VN").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}