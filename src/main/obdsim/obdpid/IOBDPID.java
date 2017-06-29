package main.obdsim.obdpid;

public interface IOBDPID {

    String getCode();

    String generateResponse(String mode);

    String getUnit();

    String getMinValue();

    String getMaxValue();
}
