package farewellworkflow;

import java.io.IOException;

import org.rapidoid.http.Req;
import org.rapidoid.http.ReqRespHandler;
import org.rapidoid.http.Resp;
import org.rapidoid.setup.On;
import org.rapidoid.u.U;

import java.util.Map;

public class Microservice {

    // port number where this service will listen for incoming HTTP requests
    public static final int PORT_NUMBER = 9999;

    // IP address to which the service will be bound. Using a value of 0.0.0.0
    // will make it available on all available interfaces, but you could use
    // 127.0.0.1 to restrict it to the loopback interface
    public static final String SERVER_IP = "0.0.0.0";

    public static void main(String[] args) throws IOException {
        // Start the service on the specified IP address and port
        On.address(SERVER_IP).port(PORT_NUMBER);

        // Define the service endpoints and handlers
        On.get("/get-spanish-greeting").plain(new GreetingHandler());
        On.get("/get-spanish-farewell").plain(new FarewellHandler());

        // Also define a catch-all to return an HTTP 404 Not Found error if the URL
        // path in the request didn't match an endpoint defined above. It's essential
        // that this code remains at the end.
        On.req((req, resp) -> {
            String message = String.format("Error: Invalid endpoint address '%s'", req.path());
            return req.response().result(message).code(404);
        });
    }

    private static class GreetingHandler implements ReqRespHandler {

        @Override
        public Object execute(Req req, Resp resp) throws Exception {
            Map<String, String> params = req.params();

            if (!params.containsKey("name")) {
                String message = "Error: Missing required 'name' parameter!";
                return req.response().result(message).code(500);
            }

            String name = params.get("name");
            String response = String.format("¡Hola, %s!", name);
            return U.str(response);
        }

    }

    private static class FarewellHandler implements ReqRespHandler {

        @Override
        public Object execute(Req req, Resp resp) throws Exception {
            Map<String, String> params = req.params();

            if (!params.containsKey("name")) {
                String message = "Error: Missing required 'name' parameter!";
                return req.response().result(message).code(500);
            }

            String name = params.get("name");
            String response = String.format("¡Adiós, %s!", name);
            return U.str(response);
        }

    }
}
