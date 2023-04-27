package farewellworkflow;

import org.apache.commons.lang3.StringEscapeUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GreetingActivitiesImpl implements GreetingActivities {

    public String greetInSpanish(String name){
        return callService("get-spanish-greeting", name);
    }

    /* TODO: Implement the Activity method that was defined in the
     * GreetingActivities interface. This method should call the microservice to
     * get a farewell message in Spanish. It will be identical to the
     * method above, except the first argument to the callService
     * method will be "get-spanish-farewell". The name of method needs to 
     * be the same as in the GreetingActivities interface
    */
    
    // utility method for making calls to the microservices
    String callService(String stem, String name){

        StringBuilder sb = new StringBuilder();
        String baseUrl = String.format("http://localhost:9999/%s?name=%s", stem, StringEscapeUtils.escapeHtml4(name));

        try {
            URL url = new URL(baseUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
