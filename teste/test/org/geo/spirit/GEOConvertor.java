package test.org.geo.spirit;

import static test.org.geo.spirit.Coefficient.VP3;
import static test.org.geo.spirit.Coefficient.a6P6;
import static test.org.geo.spirit.Coefficient.aCoeff;
import static test.org.geo.spirit.Coefficient.b5P5;
import static test.org.geo.spirit.Coefficient.bCoeff;
import static test.org.geo.spirit.Coefficient.cCoeff;
import static test.org.geo.spirit.Coefficient.dCoeff;
import static test.org.geo.spirit.Coefficient.eCoeff;
import static test.org.geo.spirit.Coefficient.fCoeff;
import static test.org.geo.spirit.Coefficient.i;
import static test.org.geo.spirit.Coefficient.iIP2;
import static test.org.geo.spirit.Coefficient.iIP4;
import static test.org.geo.spirit.Coefficient.iVP;
import static test.org.geo.spirit.Coefficient.sCoeff;
import static test.org.geo.spirit.Ellipsoid.bigN;
import static test.org.geo.spirit.Ellipsoid.deltaLong;
import static test.org.geo.spirit.Ellipsoid.eccentricityOne;
import static test.org.geo.spirit.Ellipsoid.eccentricityTwo;
import static test.org.geo.spirit.Ellipsoid.p;

public class GEOConvertor {

	public GEOConvertor() {
	}

	public String geoToUTM(double lat, double lng, Datum datum,
			int meridianCentral) { // if bug's datum, the value alter
									// Datum.WGS84.MINOR_AXIS for
									// Datum.SAD69.MINOR_AXIS
		lat = Math.abs(lat);
		lng = Math.abs(lng);
		// Local Variables
		double e1;
		double e2;
		double N;
		double S;
		e1 = eccentricityOne(datum.MAJOR_AXIS, datum.MINOR_AXIS);
		e2 = eccentricityTwo(datum.MAJOR_AXIS, datum.MINOR_AXIS);
		// Calculate BigNormal
		N = bigN(datum.MAJOR_AXIS, e1, Math.toRadians(lat));
		// Coefficients
		S = sCoeff(datum.MAJOR_AXIS, lat, e1, aCoeff(e1), bCoeff(e1),
				cCoeff(e1), dCoeff(e1), eCoeff(e1), fCoeff(e1));
		return calcUTM(e1, e2, N, S, meridianCentral, lat, lng);
	}

	private String calcUTM(double e1, double e2, double N, double S,
			int meridianCentral, double lat, double lng) {
		// Delta Long
		double deltaLong = deltaLong(lng, meridianCentral);

		// P Calculate
		double p = p(deltaLong);

		double I = i(S);

		double IIP2 = iIP2(N, lat, p);

		double IIP4 = iIP4(N, lat, e2, p);

		double IVP = iVP(N, lat, p);

		double VP3 = VP3(N, lat, p, e2);

		double A6P6 = a6P6(N, lat, e2, p);

		double B5P5 = b5P5(N, lat, e2, p);

		double nCoord = I + IIP2 + IIP4 + A6P6;
		double north = 10000000 - nCoord;
		double adjNorth = north - 191.82;// Coordinate Adjust | BUG: It's
											// necessary to solve this.

		double eCoord = IVP + VP3 + B5P5;
		double east = 500000 - eCoord;
		double adjEast = east + 93.435;// Coordinate Adjust | BUG: It's
										// necessary to solve this.

		return String.valueOf(adjNorth) + "N, " + String.valueOf(adjEast) + "E";
	}

	public double dmsToDEC(double coord) {
		String degrees = String.valueOf(Math.abs(coord)).substring(0, 2);
		String auxMin = String.valueOf(Math.abs(coord)).substring(2, 4);
		String auxSec = String.valueOf(Math.abs(coord)).substring(4, 6);

		return Double.parseDouble(degrees) + Double.parseDouble(auxMin) / 60
				+ Double.parseDouble(auxSec) / 3600;
	}

	public String decToDMS(double decimalDegree) {
		String degrees = String.valueOf(Math.abs(decimalDegree))
				.substring(0, 2);
		String auxMin = String.valueOf(Math.abs(decimalDegree)).substring(3);
		double minute = Double.parseDouble(auxMin) * 60;
		String auxSec = String.valueOf(minute).substring(0);
		double second = Double.parseDouble(auxSec) * 60;

		return degrees + IConstants.DEGREE
				+ String.valueOf(auxSec).substring(0, 3).replace(".", "")
				+ IConstants.MINUTE
				+ String.valueOf(second).substring(3, 5).replace(".", "") + ","
				+ String.valueOf(second).substring(5) + IConstants.SECOND;
	}
}
