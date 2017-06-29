package main.obdsim;


import java.util.ArrayList;
import java.util.List;

import main.obdsim.obdpid.EngineRpm;
import main.obdsim.obdpid.IOBDPID;
import main.obdsim.obdpid.IntakeManifoldAbsolutePressure;
import main.obdsim.obdpid.KMPH;


public class OBDProtocol {

    private final List<IOBDPID> supportedPIDS;

    public OBDProtocol() {
        supportedPIDS = new ArrayList<IOBDPID>();

        // Add some PIDs
        supportedPIDS.add(new IntakeManifoldAbsolutePressure());
        supportedPIDS.add(new EngineRpm());
        supportedPIDS.add(new KMPH());
    }

    public String processInput(String inputLine) {

        if(inputLine != null && inputLine.length() == 5) {
            final String mode = getModeFromRequest(inputLine);
            final String code = getCodeFromRequest(inputLine);

            System.out.println("Received Command: " + inputLine);

            for(IOBDPID pid : supportedPIDS) {
                if(pid.getCode().equals(code)) {
                    //simulateDelay(500);
                	String answer=pid.generateResponse(mode);
                	System.out.println("Send Answer: " + answer);
                    return answer/*"41 0C 0F A0"*/;
                }
            }
        }

        return null;
    }

    private void simulateDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getModeFromRequest(String inputLine) {
        return inputLine.substring(0, 2);
    }

    private String getCodeFromRequest(String inputLine) {
        return inputLine.substring(3, 5);
    }
}
