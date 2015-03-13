package org.geoconvertor.ellipsoid;
/**
 * @(#)AbstractCoefficient.java	0.1 07/05/2010 
 * 
 * This program is free software; you can redistribute it and/or                
 * modify it under the terms of the GNU General Public License                  
 * as published by the Free Software Foundation; either version 3               
 * of the License, or (at your option) any later version.
 * 
 * <p>
 * This class is part of the GEOConvertor package. Visit the <a
 * href="http://code.google.com/p/geoconvertor/">GEOConvertor</a> website for more
 * information.
 * </p>
 * 
 * <p>
 * Abstract Class determination of coefficient.
 * <p>
 * Coefficients: A, B, C, D, E, F
 * </p>
 * <p>
 * Coefficients to (North) and (East): I, S, IIP2, IIP4, IVP, VP3, A'6P6, B'5P5.
 * </p>
 * </p>
 * 
 * 
 * @author Mario C. Ponciano | a.k.a Razec - mrazec@gmail.com
 * @version 0.1 - 07/05/2010
 * @since 0.1
 */
import org.geoconvertor.utm.IConstants;

public abstract class AbstractCoefficient {

	protected double aCoeff(double eccentricityOne){
		return (1 + 3/4 * Math.pow(eccentricityOne, 2) + 45/64 *
				Math.pow(eccentricityOne, 4) + 175/256 *
				Math.pow(eccentricityOne, 6) + 11025/16384 *
				Math.pow(eccentricityOne, 8) + 43656/65536 *
				Math.pow(eccentricityOne, 10));
	}

	protected double bCoeff(double eccentricityOne){
		return (3/4 * Math.pow(eccentricityOne, 2) + 15/16 *
				Math.pow(eccentricityOne, 4) + 525/512 *
				Math.pow(eccentricityOne, 6) + 2205/2048 *
				Math.pow(eccentricityOne, 8) + 72765/65536 *
				Math.pow(eccentricityOne, 10));
	}
	protected double cCoeff(double eccentricityOne){
		return (15/64*Math.pow(eccentricityOne, 4) + 105/256 *
				Math.pow(eccentricityOne, 6) + 2205/4096 *
				Math.pow(eccentricityOne, 8) + 10395/16384 *
				Math.pow(eccentricityOne, 10));	
	}
	protected double dCoeff(double eccentricityOne){
		return (35/512 * Math.pow(eccentricityOne, 6) + 315/2048 *
				Math.pow(eccentricityOne, 8) + 31185/131072 *
				Math.pow(eccentricityOne, 10));
	}
	protected double eCoeff(double eccentricityOne){
		return (315/16384*Math.pow(eccentricityOne, 8) + 3465/65536 * 
				Math.pow(eccentricityOne, 10));
	}
	protected double fCoeff(double eccentricityOne){
		return(639/131072*Math.pow(eccentricityOne, 10));
	}

	/**
	 * Method calculate (S) the meridional arc, the distance along the earth's surface from the equator.
	 * 
	 * @param majorAxis
	 * @param lat
	 * @param eccentricityOne
	 * @param aCoeff
	 * @param bCoeff
	 * @param cCoeff
	 * @param dCoeff
	 * @param eCoeff
	 * @param fCoeff
	 * @return
	 */
	protected double sCoeff(double majorAxis, double lat, double eccentricityOne, double aCoeff, double bCoeff, double cCoeff,
			double dCoeff, double eCoeff, double fCoeff){
		return  ((majorAxis)*(1-Math.pow(eccentricityOne, 2)) * 
				(aCoeff * (lat * Math.PI / 180) - 1/2 * 
						bCoeff * Math.sin(2 * Math.toRadians(lat)) + 1/4 *
						cCoeff * Math.sin(4 * Math.toRadians(lat)) - 1/6 * 
						dCoeff * Math.sin(6 * Math.toRadians(lat)) + 1/8 *
						eCoeff * Math.sin(8 * Math.toRadians(lat)) - 1/10 *
						fCoeff * Math.sin(10 * Math.toRadians(lat))
				)
		);
	}
	protected double i(double sCoeff){
		return IConstants.K0 * sCoeff;
	}
	protected double iIP2(double n, double lat, double p){
		return (n * Math.sin(Math.toRadians(lat)) * Math.cos(Math.toRadians(lat)) * Math.pow(IConstants.SIN_ONE_SECOND, 2)/2* 
				Math.pow(IConstants.K0*10, 8) * Math.pow(p, 2));	
	}
	protected double iIP4(double n, double lat, double eccentricityTwo, double p){
		return (Math.pow(IConstants.SIN_ONE_SECOND, 4) * n * Math.sin(Math.toRadians(lat)) * Math.pow(Math.cos(Math.toRadians(lat)), 3) / 24) *
		(5-(Math.pow(Math.tan(Math.toRadians(lat)), 2))+ 9 * Math.pow(eccentricityTwo, 2) * Math.pow(Math.cos(Math.toRadians(lat)), 2) + 4 * Math.pow(eccentricityTwo, 4) *
				Math.pow(Math.cos(Math.toRadians(lat)), 4)) * IConstants.K0 * Math.pow(10, 16) * Math.pow(p, 4);
	}
	protected double iVP(double n, double lat, double p){
		return (n * Math.cos(Math.toRadians(lat)) * IConstants.SIN_ONE_SECOND * IConstants.K0 * Math.pow(10, 4))* p;
	}
	protected double VP3(double n, double lat, double p, double  eccentricityTwo){
		return (Math.pow(IConstants.SIN_ONE_SECOND, 3)* n * Math.pow(Math.cos(Math.toRadians(lat)), 3)/6)*
		(1-(Math.pow(Math.tan(Math.toRadians(lat)),2) + Math.pow(eccentricityTwo, 2)*
				Math.pow(Math.cos(Math.toRadians(lat)),2)) * IConstants.K0) * Math.pow(10, 12)*Math.pow(p, 3);
	}
	protected double a6P6(double n, double lat, double eccentricityTwo, double p){ 
		return ((Math.pow(IConstants.SIN_ONE_SECOND, 6) * n * Math.sin(Math.toRadians(lat)) * Math.pow(Math.cos(Math.toRadians(lat)), 5) / 720) * 
				(61 - 58 * Math.pow(Math.tan(Math.toRadians(lat)), 2) + Math.pow(Math.tan(Math.toRadians(lat)), 4) + 270 * Math.pow(eccentricityTwo, 2) * Math.pow(Math.cos(Math.toRadians(lat)), 2) - 330 *
						Math.pow(eccentricityTwo, 2) * Math.pow(Math.sin(Math.toRadians(lat)), 2) * IConstants.K0) * Math.pow(10, 24))* Math.pow(p, 6);
	}
	protected double b5P5(double n, double lat, double eccentricityTwo, double p){
		return (Math.pow(IConstants.SIN_ONE_SECOND, 5)*n*Math.pow(Math.cos(Math.toRadians(lat)), 5)/120)*
		(5 - 18 * Math.pow(Math.tan(Math.toRadians(lat)), 2)+ Math.pow(Math.tan(Math.toRadians(lat)), 4) + 14*
				Math.pow(eccentricityTwo,2)* Math.pow(Math.cos(Math.toRadians(lat)), 2)-58 * Math.pow(eccentricityTwo, 2) * Math.pow(Math.sin(Math.toRadians(lat)),2))*IConstants.K0*Math.pow(10, 20)*Math.pow(p, 5);
	}


}



