package com.ai;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
	
	private String fileName;
	
	public DataLoader(String name){
		this.fileName = name;
	}
	
	public List<String> read() {
		List<String> lines = new ArrayList<>();
		try (FileReader fileReader = new FileReader(fileName)) {

			BufferedReader bufferReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferReader.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found! Please check fileName");
		} catch (IOException e) {
			throw new IllegalArgumentException("illegal argument eception");
		}
		
		return lines;
	}
}
