package newway.datareader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import newway.format.Format;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class DataReader<T extends Format> {
    public List<T> read(HttpClient client, Gson gson, String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), new TypeToken<List<T>>() {}.getType());
    }
}
