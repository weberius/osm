package de.illilli.opengis.odk.parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;

/**
 * Diese Klasse liest die Datei energie_schulen aus und überführt sie in eine
 * Liste aus EnergieSchulenKoeln Objekten.
 * 
 * @author wolfram
 *
 */
public class EnergieSchulenKoelnCsvParser implements
		CsvParser<EnergieSchuleKoeln> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EnergieSchulenKoelnCsvParser.class);

	private ObjectReader objectReader;

	public final static CsvSchema SIMPLE_SCHEMA = CsvSchema.builder()
			.addColumn("we") //
			.addColumn("objektbezeichnung") //
			.addColumn("adresse") //
			.addColumn("grundflaeche") //
			.addColumn("heizung_energietraeger") //
			.addColumn("heizung_ekw") //
			.addColumn("heizung_ekw_differenz_vorjahr") //
			.addColumn("heizung_ekw_differenz_vergleichswert") //
			.addColumn("strom_ekw") //
			.addColumn("strom_differenz_vorjahr") //
			.addColumn("strom_differenz_vergleichswert") //
			.addColumn("wasser_ekw") //
			.addColumn("wasser_ekw_differenz_vorjahr") //
			.addColumn("wasser_differenz_vergleichswert") //
			.addColumn("bemerkung") //
			.build();

	public EnergieSchulenKoelnCsvParser() throws IOException {
		ObjectMapper mapper = new CsvMapper();
		objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader.withType(EnergieSchuleKoeln.class);
	}

	@Override
	public EnergieSchuleKoeln getObject(final String line)
			throws JsonProcessingException, UnsupportedEncodingException,
			IOException {
		return objectReader.readValue(line.getBytes("UTF-8"));
	}

}
