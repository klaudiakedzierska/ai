package com.ai.utils;

import java.time.LocalDateTime;

public class CreateDateFromDataLoader {

	public static LocalDateTime createDate(String[] result) {
		String dateTime = result[result.length - 1];
		
		int date = Integer.valueOf(dateTime.substring(0, 2));
		int month = Integer.valueOf(dateTime.substring(2, 4));
		int year = Integer.valueOf(dateTime.substring(4, 8));
		int hrs = Integer.valueOf(dateTime.substring(8, 10));
		int min = Integer.valueOf(dateTime.substring(10, 12));
		
		return LocalDateTime.of(year, month, date, hrs, min);
	}
}
