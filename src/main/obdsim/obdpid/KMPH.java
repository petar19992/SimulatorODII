package main.obdsim.obdpid;

import java.util.Random;

import main.obdsim.utilities.ResponseUtils;

public class KMPH implements IOBDPID {

    // Set standard values
    private final String unit = "km/h";
    private final String code = "0D";
    private final String minValue = "0";
    private final String maxValue = "250";

    // Set random value
    private final Integer value = /*4000*/100;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String generateResponse(String mode) {
    	int kmph=new Random().nextInt(255);
    	String kmphStr=Integer.toHexString(kmph);
    	if(kmphStr==null)
    		return "41 0D FF";
    	else if(kmphStr.length()==1)
    		kmphStr="0"+kmphStr;
    	
    	return "41 0D "+kmphStr.toUpperCase();
//        return ResponseUtils.buildOBDResponse(mode, getCode(), Integer.toHexString(value));
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public String getMinValue() {
        return minValue;
    }

    @Override
    public String getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return "Vehicle Speed";
    }
}
