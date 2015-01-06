package de.illilli.opengis.odk.bo;

/**
 * Sample Data:
 * 
 * <pre>
 * var data = [
 *     {
 *         "value": 300,
 *         "color":"#F7464A",
 *         "highlight": "#FF5A5E",
 *         label: "Red"
 *     },
 *     {
 *         value: 50,
 *         color: "#46BFBD",
 *         highlight: "#5AD3D1",
 *         label: "Green"
 *     },
 *     {
 *         value: 100,
 *         color: "#FDB45C",
 *         highlight: "#FFC870",
 *         label: "Yellow"
 *     }
 * ]
 * </pre>
 *
 */
public class EinwohnerNachAltersgruppenBo {

	private double value;
	private String color;
	private String highlight;
	private String label;

	public EinwohnerNachAltersgruppenBo(double value, String color,
			String highlight, String label) {

		this.value = value;
		this.color = color;
		this.highlight = highlight;
		this.label = label;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "EinwohnerNachAltersgruppenBo [value=" + value + ", color="
				+ color + ", highlight=" + highlight + ", label=" + label + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EinwohnerNachAltersgruppenBo other = (EinwohnerNachAltersgruppenBo) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (highlight == null) {
			if (other.highlight != null)
				return false;
		} else if (!highlight.equals(other.highlight))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
	}

}
