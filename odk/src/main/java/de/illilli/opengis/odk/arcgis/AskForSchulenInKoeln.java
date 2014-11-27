package de.illilli.opengis.odk.arcgis;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

/**
 * Diese Klasse holt sich die Informationen zu den Schulen in Koeln. Dies kann
 * entweder direkt gegen von den offenen Daten Köln kommen oder von einer Datei.
 * Am besten wäre es, wenn zunächst der Offene Daten-Server konsultiert würde
 * und dann die Antwort ins File-System gelegt würde. Danach kann sie dann
 * eingelesen werden.
 * 
 * @author wolfram
 *
 */
public class AskForSchulenInKoeln {

	String schulenInKoelnUrl = "http://geoportal1.stadt-koeln.de/ArcGIS/rest/services/Stadtplanthemen/MapServer/6/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=objectid%20is%20not%20null&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=json";

	private static final Logger logger = Logger
			.getLogger(AskForSchulenInKoeln.class);
	private SchulenInKoeln schulenInKoeln;

	public AskForSchulenInKoeln() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {

		URL url1 = this.getClass().getClassLoader()
				.getResource("schulen-in-koeln.arcgis.json");
		File schulenInKoelnFile = new File(url1.toURI());

		ObjectMapper mapper = new ObjectMapper();
		schulenInKoeln = mapper.readValue(schulenInKoelnFile,
				SchulenInKoeln.class);
		logger.debug(schulenInKoeln.toString());
	}

	public SchulenInKoeln getSchulenInKoeln() {
		return schulenInKoeln;
	}

}
