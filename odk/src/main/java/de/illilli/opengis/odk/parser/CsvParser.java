package de.illilli.opengis.odk.parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CsvParser<T> {

	T getObject(String line) throws JsonProcessingException,
			UnsupportedEncodingException, IOException;
}
