package test.org.geo.spirit;

public class GeoPoint {
	private final GEOConvertor CONVERTOR = new GEOConvertor();
	private double latitude;
	private double longitude;

	public GeoPoint(double latitudeDecimalDegress,
			double longitudeDecimalDegress) {
		this.latitude = latitudeDecimalDegress;
		this.longitude = longitudeDecimalDegress;
	}

	public String toDMS() {
		return CONVERTOR.decToDMS(latitude) + ", "
				+ CONVERTOR.decToDMS(longitude);
	}

	public String toGPS() {
		return null;
	}

	public String toUTM(Datum datum) {
		int descobrir = 32;
		return CONVERTOR.geoToUTM(latitude, longitude, datum, descobrir);
	}

}
