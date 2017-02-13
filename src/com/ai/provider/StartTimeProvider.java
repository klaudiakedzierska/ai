package com.ai.provider;

import java.time.LocalDateTime;
import java.util.List;

import com.ai.DataLoader;
import com.ai.exception.StartTimeMissingException;
import com.ai.utils.CreateDateFromDataLoader;

public class StartTimeProvider {

	private static final String DATA_TXT = "data.txt";
	private DataLoader loader = new DataLoader(DATA_TXT);

	public LocalDateTime provide() {
		List<String> read = loader.read();
		
		String dateTimeString = read.stream()
		.filter(s -> s.contains(DataLoaderAlias.STARTTIME.toString().toLowerCase()))
		.findFirst().orElseThrow(StartTimeMissingException::new);
		
		String[] result = dateTimeString.split("-");
		
		return CreateDateFromDataLoader.createDate(result);

	}
}
