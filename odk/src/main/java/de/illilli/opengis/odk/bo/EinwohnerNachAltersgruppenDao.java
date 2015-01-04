package de.illilli.opengis.odk.bo;

import java.util.ArrayList;
import java.util.List;

import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class EinwohnerNachAltersgruppenDao {

	private List<EinwohnerNachAltersgruppenBo> boList;

	public EinwohnerNachAltersgruppenDao(
			EinwohnerNachAltersgruppen einwohner) {

		boList = new ArrayList<EinwohnerNachAltersgruppenBo>();

		EinwohnerNachAltersgruppenBo bo = new EinwohnerNachAltersgruppenBo(
				einwohner.getA0_2(),
				EinwohnerNachAltersgruppen.Head.a0_2.color(),
				EinwohnerNachAltersgruppen.Head.a0_2.highlight(),
				EinwohnerNachAltersgruppen.Head.a0_2.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA3_5(),
				EinwohnerNachAltersgruppen.Head.a3_5.color(),
				EinwohnerNachAltersgruppen.Head.a3_5.highlight(),
				EinwohnerNachAltersgruppen.Head.a3_5.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA6_14(),
				EinwohnerNachAltersgruppen.Head.a6_14.color(),
				EinwohnerNachAltersgruppen.Head.a6_14.highlight(),
				EinwohnerNachAltersgruppen.Head.a6_14.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA15_17(),
				EinwohnerNachAltersgruppen.Head.a15_17.color(),
				EinwohnerNachAltersgruppen.Head.a15_17.highlight(),
				EinwohnerNachAltersgruppen.Head.a15_17.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA18_20(),
				EinwohnerNachAltersgruppen.Head.a18_20.color(),
				EinwohnerNachAltersgruppen.Head.a18_20.highlight(),
				EinwohnerNachAltersgruppen.Head.a18_20.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA21_34(),
				EinwohnerNachAltersgruppen.Head.a21_34.color(),
				EinwohnerNachAltersgruppen.Head.a21_34.highlight(),
				EinwohnerNachAltersgruppen.Head.a21_34.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA35_59(),
				EinwohnerNachAltersgruppen.Head.a35_59.color(),
				EinwohnerNachAltersgruppen.Head.a35_59.highlight(),
				EinwohnerNachAltersgruppen.Head.a35_59.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA60_64(),
				EinwohnerNachAltersgruppen.Head.a60_64.color(),
				EinwohnerNachAltersgruppen.Head.a60_64.highlight(),
				EinwohnerNachAltersgruppen.Head.a60_64.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA65_74(),
				EinwohnerNachAltersgruppen.Head.a65_74.color(),
				EinwohnerNachAltersgruppen.Head.a65_74.highlight(),
				EinwohnerNachAltersgruppen.Head.a65_74.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(einwohner.getA75_79(),
				EinwohnerNachAltersgruppen.Head.a75_79.color(),
				EinwohnerNachAltersgruppen.Head.a75_79.highlight(),
				EinwohnerNachAltersgruppen.Head.a75_79.key());
		boList.add(bo);
		bo = new EinwohnerNachAltersgruppenBo(
				einwohner.getA80undAelter(),
				EinwohnerNachAltersgruppen.Head.a80undAelter.color(),
				EinwohnerNachAltersgruppen.Head.a80undAelter.highlight(),
				EinwohnerNachAltersgruppen.Head.a80undAelter.key());
		boList.add(bo);
	}

	public List<EinwohnerNachAltersgruppenBo> getBoList() {
		return boList;
	}

}
