package helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ApiHelper {

    public static JsonObject logIn() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "\n\t\"password\": \"Raz123mik\",\n\t\"username\": \"razo96@gmail.com\"\n}\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return JsonParser.parseString(jsonString).getAsJsonObject();

    }

}
