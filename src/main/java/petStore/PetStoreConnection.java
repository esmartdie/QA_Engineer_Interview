package petStore;

import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;

public class PetStoreConnection {
    private static final String apiUrl = "https://petstore.swagger.io/v2";

    public HttpURLConnection buildHttpURLConnection(String endPoint) throws IOException, MalformedURLException, ProtocolException {
        URI uri = URI.create(apiUrl + endPoint);
        HttpURLConnection urlConnection = (HttpURLConnection) uri.toURL().openConnection();
        return urlConnection;
    }

    public void doPOST(HttpURLConnection urlConnection, JSONObject userEntry) throws IOException {
        urlConnection.setRequestMethod("POST");

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
        out.write(userEntry.toString());
        out.close();
    }

    public void doGET(HttpURLConnection urlConnection ) throws ProtocolException {
        urlConnection.setRequestMethod("GET");

    }

}
