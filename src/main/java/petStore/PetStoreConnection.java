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

    /**
     * Construye y devuelve una conexión HttpURLConnection utilizando el endpoint proporcionado.
     *
     *  @param endPoint El endpoint de la API.
     *  @return La conexión HttpURLConnection (conexión establecida)
     *  @throws IOException
     */
    public HttpURLConnection buildHttpURLConnection(String endPoint) throws IOException, MalformedURLException, ProtocolException {
        URI uri = URI.create(apiUrl + endPoint);
        HttpURLConnection urlConnection = (HttpURLConnection) uri.toURL().openConnection();
        return urlConnection;
    }

    /**
     * Realiza una solicitud POST a la API utilizando la conexión proporcionada y el objeto JSON de entrada.
     * @param urlConnection La conexión HttpURLConnection.
     * @param userEntry     El objeto JSON de entrada.
     * @throws IOException
     */
    public void doPOST(HttpURLConnection urlConnection, JSONObject userEntry) throws IOException {
        urlConnection.setRequestMethod("POST");

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
        out.write(userEntry.toString());
        out.close();
    }

    /**
     * Realiza una solicitud GET a la API utilizando la conexión proporcionada.
     *   @param urlConnection La conexión HttpURLConnection.
     *   @throws ProtocolException
     */
    public void doGET(HttpURLConnection urlConnection ) throws ProtocolException {
        urlConnection.setRequestMethod("GET");

    }

}
