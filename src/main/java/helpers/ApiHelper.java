package helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ApiHelper {

    public static JsonObject logIn() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"username\":\"razo96@gmail.com\",\n    \"password\":\"Raz123mik\",\n    \"type\":\"normal\"\n}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return JsonParser.parseString(jsonString).getAsJsonObject();

    }

}
