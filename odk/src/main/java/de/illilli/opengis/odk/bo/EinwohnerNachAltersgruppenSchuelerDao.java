package de.illilli.opengis.odk.bo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class EinwohnerNachAltersgruppenSchuelerDao {

	private List<EinwohnerNachAltersgruppenBo> boList;

	public EinwohnerNachAltersgruppenSchuelerDao(
			EinwohnerNachAltersgruppen einwohner) {

		boList = new ArrayList<EinwohnerNachAltersgruppenBo>();

		int a0_5 = einwohner.getA0_2() + einwohner.getA3_5();
		Double quotient = new Double(a0_5)
				/ new Double(einwohner.getEinwohnerInsgesamt());
		String percent = NumberFormat.getPercentInstance(Locale.GERMAN).format(
				quotient);
		String label = EinwohnerNachAltersgruppen.Head.a0_5.key() + ": "
				+ percent;
		EinwohnerNachAltersgruppenBo bo = new EinwohnerNachAltersgruppenBo(
				a0_5, EinwohnerNachAltersgruppen.Head.a0_5.color(),
				EinwohnerNachAltersgruppen.Head.a0_5.highlight(), label);
		boList.add(bo);

		int a6_17 = einwohner.getA6_14() + einwohner.getA15_17();
		quotient = new Double(a6_17)
				/ new Double(einwohner.getEinwohnerInsgesamt());
		percent = NumberFormat.getPercentInstance(Locale.GERMAN).format(
				quotient);
		label = EinwohnerNachAltersgruppen.Head.a6_17.key() + ": " + percent;
		bo = new EinwohnerNachAltersgruppenBo(a6_17,
				EinwohnerNachAltersgruppen.Head.a6_17.color(),
				EinwohnerNachAltersgruppen.Head.a6_17.highlight(), label);
		boList.add(bo);

		int a18_65 = einwohner.getA18_20() + einwohner.getA21_34()
				+ einwohner.getA35_59() + einwohner.getA60_64();
		quotient = new Double(a18_65)
				/ new Double(einwohner.getEinwohnerInsgesamt());
		percent = NumberFormat.getPercentInstance(Locale.GERMAN).format(
				quotient);
		label = EinwohnerNachAltersgruppen.Head.a18_65.key() + ": " + percent;
		bo = new EinwohnerNachAltersgruppenBo(a18_65,
				EinwohnerNachAltersgruppen.Head.a18_65.color(),
				EinwohnerNachAltersgruppen.Head.a18_65.highlight(), label);
		boList.add(bo);

		int a65undAelter = einwohner.getA65_74() + einwohner.getA75_79()
				+ einwohner.getA80undAelter();
		quotient = new Double(a65undAelter)
				/ new Double(einwohner.getEinwohnerInsgesamt());
		percent = NumberFormat.getPercentInstance(Locale.GERMAN).format(
				quotient);
		label = EinwohnerNachAltersgruppen.Head.a65undAelter.key() + ": "
				+ percent;
		bo = new EinwohnerNachAltersgruppenBo(a65undAelter,
				EinwohnerNachAltersgruppen.Head.a65undAelter.color(),
				EinwohnerNachAltersgruppen.Head.a65undAelter.highlight(), label);
		boList.add(bo);
	}

	public List<EinwohnerNachAltersgruppenBo> getBoList() {
		return boList;
	}

}
