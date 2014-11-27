package de.illilli.opengis.odk.parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;

public class SchuelerImStadtteilCsvParser {

	private static final Logger logger = Logger
			.getLogger(SchuelerImStadtteilCsvParser.class);

	private SchuelerImStadtteil schuelerImStadtteil = new SchuelerImStadtteil();;

	final static CsvSchema SIMPLE_SCHEMA = CsvSchema.builder() //
			.addColumn("nr") //
			.addColumn("stadtteil") //
			.addColumn("allgemeinbildende_schulen") //
			.addColumn("grundschule") //
			.addColumn("hauptschule") //
			.addColumn("realschule") //
			.addColumn("gymnasium") //
			.addColumn("gesamtschule") //
			.addColumn("foerderschule") //
			.build();

	public SchuelerImStadtteilCsvParser(final String line)
			throws JsonProcessingException, UnsupportedEncodingException,
			IOException {

		ObjectMapper mapper = new CsvMapper();
		ObjectReader objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader.withType(SchuelerImStadtteil.class);
		schuelerImStadtteil = objectReader.readValue(line.getBytes("UTF-8"));
	}

	public SchuelerImStadtteil getSchuelerImStadtteil() {
		return schuelerImStadtteil;
	}

}
