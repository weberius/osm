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

}
