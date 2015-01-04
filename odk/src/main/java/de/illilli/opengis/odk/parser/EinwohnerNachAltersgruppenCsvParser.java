package de.illilli.opengis.odk.parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class EinwohnerNachAltersgruppenCsvParser implements
		CsvParser<EinwohnerNachAltersgruppen> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenCsvParser.class);

	private ObjectReader objectReader;

	final static CsvSchema SIMPLE_SCHEMA = CsvSchema.builder() //
			.addColumn("nr") //
			.addColumn("stadtteil") //
			.addColumn("einwohnerInsgesamt") //
			.addColumn("a0_2") //
			.addColumn("a3_5") //
			.addColumn("a6_14") //
			.addColumn("a15_17") //
			.addColumn("a18_20") //
			.addColumn("a21_34") //
			.addColumn("a35_59") //
			.addColumn("a60_64") //
			.addColumn("a65_74") //
			.addColumn("a75_79") //
			.addColumn("a80undAelter") //
			.build();

	public EinwohnerNachAltersgruppenCsvParser() {

		ObjectMapper mapper = new CsvMapper();
		objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader
				.withType(EinwohnerNachAltersgruppen.class);
	}

	@Override
	public EinwohnerNachAltersgruppen getObject(String line)
			throws JsonProcessingException, UnsupportedEncodingException,
			IOException {
		return objectReader.readValue(line.getBytes("UTF-8"));
	}

}
