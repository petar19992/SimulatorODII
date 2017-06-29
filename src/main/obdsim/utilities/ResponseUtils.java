package main.obdsim.utilities;


public class ResponseUtils {

    public static String buildOBDResponse(String mode, String command, String value) {
        String responseMode = convertRequestModeToResponseMode(mode);
        //todo za svaki slicaj sam morao da stavim ovo jer iz nekog razloga na client strani ne moze da parsuje poruku
        if(value.length()==3&&command.equals("0C"))
        {
        	value="0"+value.toUpperCase();
        	value=value.substring(0,2)+" "+value.substring(2,4);
        }
//        value=makeReadebleValue(value);

        String response = responseMode + " " + command + " " + value;

        return response;
//        return mode + command + "\r\r\n" + response + "\r\n";
    }

    public static String buildOBDEndResponse() {
        return ">";
    }

    private static String convertRequestModeToResponseMode(String requestMode) {
        return requestMode.replace("0", "4");
    }
    public static String makeReadebleValue(String value)
    {
    	return value.replaceAll("..", "$0 ");
    }

}
