package de.illilli.opengis.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.RadarChartBo;
import de.illilli.opengis.odk.bo.RadarChartDatasets;
import de.illilli.opengis.odk.bo.SchulenImStadtteil;

public class SchuelerImStadtteilRadarChartDataFacade {

	private final static Logger logger = Logger
			.getLogger(SchuelerImStadtteilRadarChartDataFacade.class);

	String jsonString = "{}";
	private RadarChartBo radarChartBo;
	private RadarChartDatasets[] datasets;

	public SchuelerImStadtteilRadarChartDataFacade(int stadtteilnr) {
		readFromData(stadtteilnr);
		// readFromFile();
	}

	/**
	 * get GeoJson - String
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getString() {

		return jsonString;
	}

	void readFromData(int stadtteilnr) {

		radarChartBo = new RadarChartBo();
		datasets = new RadarChartDatasets[1];
		try {
			AskForSchulenInKoeln askFor = new AskForSchulenInKoeln();
			SchulenImStadtteil schulen = new SchulenImStadtteil(
					askFor.getSchulenInKoeln());
			List<String> schulartList = schulen.getSchulartList();
			String[] schulartArray = new String[schulartList.size()];
			double[] anteilSchulartJeStadtteilArray = new double[schulartList
					.size()];
			for (int index = 0; index < schulartList.size(); index++) {
				String schulart = schulartList.get(index);
				schulartArray[index] = schulart;
				double anteilSchulartJeStadtteil = schulen
						.getAnteilSchulartJeStadtteil(stadtteilnr, schulart);
				anteilSchulartJeStadtteilArray[index] = anteilSchulartJeStadtteil;
			}
			datasets[0] = new RadarChartDatasets();
			datasets[0].setLabel("Schulen");
			datasets[0].setFillColor("rgba(220,220,220,0.2)");
			datasets[0].setPointColor("rgba(220,220,220,1)");
			datasets[0].setPointHighlightFill("#fff");
			datasets[0].setPointHighlightStroke("rgba(220,220,220,1)");
			datasets[0].setPointStrokeColor("#fff");
			datasets[0].setStrokeColor("rgba(220,220,220,1)");
			datasets[0].setData(anteilSchulartJeStadtteilArray);

			datasets[1] = new RadarChartDatasets();
			datasets[1].setLabel("Schüler");
			datasets[1].setFillColor("rgba(220,220,220,0.2)");
			datasets[1].setPointColor("rgba(220,220,220,1)");
			datasets[1].setPointHighlightFill("#fff");
			datasets[1].setPointHighlightStroke("rgba(220,220,220,1)");
			datasets[1].setPointStrokeColor("#fff");
			datasets[1].setStrokeColor("rgba(220,220,220,1)");
			datasets[1].setData(anteilSchulartJeStadtteilArray);

			radarChartBo.setDatasets(datasets);
			radarChartBo.setLabels(schulartArray);
			jsonString = new Gson().toJson(radarChartBo);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Nur für Anschauungszwecke
	 * 
	 * @deprecated
	 */
	@Deprecated
	void readFromFile() {

		StringBuffer sb = new StringBuffer();
		String fileName = "radarChartData.json";
		URL url1 = this.getClass().getClassLoader().getResource(fileName);
		try {
			File file = new File(url1.toURI());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (URISyntaxException e) {
			logger.error(e);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		jsonString = sb.toString();

	}

}
