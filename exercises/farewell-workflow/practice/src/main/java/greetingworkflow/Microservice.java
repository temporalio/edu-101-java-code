package greetingworkflow;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Microservice {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
        server.createContext("/get-spanish-greeting", new spanishGreetingHandler());
        server.createContext("/get-spanish-farewell", new spanishFarewellHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server is listening on port 9999");
    }

    static class spanishGreetingHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String name = "";
            String response = "";
            int code = 200;
            if (query != null) {
                Map<String, String> queryMap = queryToMap(query);
                name = queryMap.get("name");
            }
            if (name.equals("")) {
                response = "Missing required 'name' parameter.";
                code = 400;
            } else {
                response = String.format("Hola, %s!", name);
            }
            exchange.sendResponseHeaders(code, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class spanishFarewellHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String name = "";
            String response = "";
            int code = 200;
            if (query != null) {
                Map<String, String> queryMap = queryToMap(query);
                name = queryMap.get("name");
            }
            if (name.equals("")) {
                response = "Missing required 'name' parameter.";
                code = 400;
            } else {
                response = String.format("Adios, %s!", name);
            }
            exchange.sendResponseHeaders(code, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    private static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new java.util.HashMap<>();
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

}
