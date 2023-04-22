package refactoring.service.datareader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import refactoring.model.format.Format;
import refactoring.model.format.FormatMono;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class DataReader<T extends Format> {
    public List<T> read(HttpClient client, Gson gson, String uri, Type type) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), type);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
