package de.illilli.opengis.odk.bo;

import java.util.Arrays;

public class RadarChartDatasets {
	private String label;
	private String fillColor;
	private String strokeColor;
	private String pointColor;
	private String pointStrokeColor;
	private String pointHighlightFill;
	private String pointHighlightStroke;
	private double[] data;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}

	public String getPointColor() {
		return pointColor;
	}

	public void setPointColor(String pointColor) {
		this.pointColor = pointColor;
	}

	public String getPointStrokeColor() {
		return pointStrokeColor;
	}

	public void setPointStrokeColor(String pointStrokeColor) {
		this.pointStrokeColor = pointStrokeColor;
	}

	public String getPointHighlightFill() {
		return pointHighlightFill;
	}

	public void setPointHighlightFill(String pointHighlightFill) {
		this.pointHighlightFill = pointHighlightFill;
	}

	public String getPointHighlightStroke() {
		return pointHighlightStroke;
	}

	public void setPointHighlightStroke(String pointHighlightStroke) {
		this.pointHighlightStroke = pointHighlightStroke;
	}

	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result
				+ ((fillColor == null) ? 0 : fillColor.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((pointColor == null) ? 0 : pointColor.hashCode());
		result = prime
				* result
				+ ((pointHighlightFill == null) ? 0 : pointHighlightFill
						.hashCode());
		result = prime
				* result
				+ ((pointHighlightStroke == null) ? 0 : pointHighlightStroke
						.hashCode());
		result = prime
				* result
				+ ((pointStrokeColor == null) ? 0 : pointStrokeColor.hashCode());
		result = prime * result
				+ ((strokeColor == null) ? 0 : strokeColor.hashCode());
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
		RadarChartDatasets other = (RadarChartDatasets) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (fillColor == null) {
			if (other.fillColor != null)
				return false;
		} else if (!fillColor.equals(other.fillColor))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (pointColor == null) {
			if (other.pointColor != null)
				return false;
		} else if (!pointColor.equals(other.pointColor))
			return false;
		if (pointHighlightFill == null) {
			if (other.pointHighlightFill != null)
				return false;
		} else if (!pointHighlightFill.equals(other.pointHighlightFill))
			return false;
		if (pointHighlightStroke == null) {
			if (other.pointHighlightStroke != null)
				return false;
		} else if (!pointHighlightStroke.equals(other.pointHighlightStroke))
			return false;
		if (pointStrokeColor == null) {
			if (other.pointStrokeColor != null)
				return false;
		} else if (!pointStrokeColor.equals(other.pointStrokeColor))
			return false;
		if (strokeColor == null) {
			if (other.strokeColor != null)
				return false;
		} else if (!strokeColor.equals(other.strokeColor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Datasets [label=" + label + ", fillColor=" + fillColor
				+ ", strokeColor=" + strokeColor + ", pointColor=" + pointColor
				+ ", pointStrokeColor=" + pointStrokeColor
				+ ", pointHighlightFill=" + pointHighlightFill
				+ ", pointHighlightStroke=" + pointHighlightStroke + ", data="
				+ Arrays.toString(data) + "]";
	}

}
