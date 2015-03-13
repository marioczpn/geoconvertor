package test.org.geo.spirit;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoPoint/*ou GeoCordenada*/ {
	// Encontrar algumas transformações já feitas para escrever os casos de
	// teste pode ajudar. Melhor é prever as conbinações de casos extremos em 0s
	// 1s e
	// infinitos. Exemplo: lat=0,lng=0; lat=1; lng=1; lat =180;lng=180;
	// lng=360;....
	// Bom pensar em uma mascará para mostrar [ABREV]##D ##M ###S //ABREV:==[N,S,L,O]
	
	/*"Os tipos de coordenadas utilizadas associadas a cada um dos referenciais são:
		Córrego Alegre (1961): latitude / longitude e UTM (E, N).
     	Córrego Alegre (1970+1972): latitude / longitude e UTM (E, N).
     	SAD69 Rede Clássica: latitude / longitude e UTM (E, N).
     	SAD69/96 Rede Clássica: latitude / longitude e UTM (E, N).
     	SAD69 Técnica Doppler/GPS: latitude / longitude / altura geométrica, Cartesianas (X, Y, Z) e UTM (E, N).
     	SIRGAS2000: latitude / longitude / altura geométrica, Cartesianas (X, Y, Z), e UTM (E, N).
	" - IBGE em http://www.ibge.gov.br/home/geociencias/geodesia/param_transf/default_param_transf.shtm
	
	*/
	private double latitudeDecimalDegress = 60.12349768171855;
	private double longitudeDecimalDegress = 6.186332702636719;
	private GeoPoint ponto = new GeoPoint(latitudeDecimalDegress,
			longitudeDecimalDegress);

	@Test
	public void degress_Minutes_Seconds() {
		Assert.assertEquals("N60 07 24, E6 11 10", ponto.toDMS());
	}

	@Test
	public void gps() {
		Assert.assertEquals("N60 07.410, E6 11.180", ponto.toGPS());
	}

	@Test
	public void UTM() {
		Assert.assertEquals("N32 343677 6668494", ponto.toUTM(Datum.WGS84));
	}
}