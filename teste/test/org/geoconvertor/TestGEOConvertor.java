/*	Douglas Hiura Longo
 *	douglashiura@gmail.com
 *	java.inf.ufsc.br/dh
 *	Santa Catarina, 22 de Setembro de 2010, 19:50
 */
package test.org.geoconvertor;

import static org.junit.Assert.assertEquals;

import org.geoconvertor.datum.Datum;
import org.geoconvertor.utm.GEOConvertor;
import org.geoconvertor.utm.IConstants;
import org.junit.Test;

public class TestGEOConvertor implements IConstants {
	@Test
	public void testGeoToUTM() {
		GEOConvertor coord = new GEOConvertor();
		

		assertEquals("7577904.467869655N, 261928.92436282506E",
				coord.geoToUTM(21.88684199, 47.30414058, Datum.SAD69, 45));

		assertEquals("7577912.807043435N, 261929.7858704625E",
				coord.geoToUTM(21.88684199, 47.30414058, Datum.WGS84, 45));

	}

	@Test
	public void testDecToDMS() {
		GEOConvertor coord = new GEOConvertor();
		assertEquals("21" + DEGREE + "53" + MINUTE + "92,631164E11" + SECOND,
				coord.decToDMS(21.88684199));
	}

	@Test
	public void testDMStoDec() {
		GEOConvertor coord = new GEOConvertor();
		assertEquals(new Double(21.90888888888889d),
				new Double(coord.dmsToDEC(215392.631)));
	}

}
