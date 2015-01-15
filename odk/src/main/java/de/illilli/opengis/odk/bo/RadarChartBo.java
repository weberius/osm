package de.illilli.opengis.odk.bo;

import java.util.Arrays;

public class RadarChartBo {

	private String[] labels;
	private RadarChartDatasets[] datasets;

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public RadarChartDatasets[] getDatasets() {
		return datasets;
	}

	public void setDatasets(RadarChartDatasets[] datasets) {
		this.datasets = datasets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(datasets);
		result = prime * result + Arrays.hashCode(labels);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadarChartBo other = (RadarChartBo) obj;
		if (!Arrays.equals(datasets, other.datasets))
			return false;
		if (!Arrays.equals(labels, other.labels))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RadarChartBo [labels=" + Arrays.toString(labels)
				+ ", datasets=" + Arrays.toString(datasets) + "]";
	}

}
