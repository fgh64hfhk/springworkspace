package com.web.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SystemUtils {
	static public Date toSqlDate(String dateString) {

		Date date = null;
		java.util.Date utilDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			utilDate = sdf.parse(dateString);
			date = new Date(utilDate.getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return date;
	}
}
