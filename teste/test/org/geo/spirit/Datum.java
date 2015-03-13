package test.org.geo.spirit;

public enum Datum {
	SAD69(6378160.0000, 6356774.7192), WGS84(6378137.0000, 6356752.31424518);
	double MAJOR_AXIS;
	double MINOR_AXIS;
	double FLATTENING;

	private Datum(double MAJOR_AXIS, double MINOR_AXIS) {
		this.MAJOR_AXIS = MAJOR_AXIS;
		this.MINOR_AXIS = MINOR_AXIS;
		FLATTENING = Ellipsoid.flattening(MAJOR_AXIS, MINOR_AXIS);
	}
}
