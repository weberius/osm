package de.illilli.opengis.odk.parser;

import java.io.IOException;

import org.apache.log4j.Logger;

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
public class EnergieSchulenKoelnCsvParser {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EnergieSchulenKoelnCsvParser.class);

	private EnergieSchuleKoeln energieSchulenKoeln;

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

	public EnergieSchulenKoelnCsvParser(final String line) throws IOException {
		ObjectMapper mapper = new CsvMapper();
		ObjectReader objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader.withType(EnergieSchuleKoeln.class);
		energieSchulenKoeln = objectReader.readValue(line.getBytes("UTF-8"));
	}

	public EnergieSchuleKoeln getEnergieSchulenKoeln() {
		return energieSchulenKoeln;
	}

}
