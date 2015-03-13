package test.org.geo.spirit;

final class Ellipsoid {
	private Ellipsoid() {
	}

	// Calcs normally can not be method, are functions.
	// Functions are statics.
	// fi POO in methods removal parameters of calculus. For example majorAxis
	// and minorAxis are const relative the Datum, in Datum's to be conts. If
	// single calc rapid process.
	// non user in GeoConvert
	final static double flattening(double majorAxis, double minorAxis) {
		return (majorAxis - minorAxis) / majorAxis;
	}

	final static double eccentricityOne(double majorAxis, double minorAxis) {
		return (Math.sqrt(Math.pow(majorAxis, 2) - Math.pow(minorAxis, 2)))
				/ majorAxis;
	}

	final static double eccentricityTwo(double majorAxis, double minorAxis) {
		return (Math.sqrt(Math.pow(majorAxis, 2) - Math.pow(minorAxis, 2)))
				/ minorAxis;
	}

	final static double bigN(double majorAxis, double eccentricityOne,
			double latRadian) {
		return majorAxis
				/ Math.sqrt((1 - Math.pow(eccentricityOne, 2)
						* Math.pow(Math.sin(latRadian), 2)));
	}

	final static double deltaLong(double lngDecimal, int meridianCentral) {
		return (lngDecimal - meridianCentral) * 3600;// what is 3600 60*60?
	}

	final static double p(double deltaLong) {
		return 0.0001 * deltaLong;// what is 0.0001, magical number!
	}

}
