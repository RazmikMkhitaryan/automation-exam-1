package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import pages.BasePage;

import java.io.IOException;
import java.util.ArrayList;

public class ApiClient {
    private static String ACCESS_TOKEN = null;

    public static JsonObject login(String email, String password) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"username\":\"" + email + "\",\"password\":\"" + password + "\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response;
        String jsonString;
        JsonObject object = null;
        try {
            response = client.newCall(request).execute();
            jsonString = response.body().string();
            object = JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ACCESS_TOKEN = object.get("auth_token").getAsString();
        return object;
    }

    public static JsonObject CreateProject(String name,String tokken) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"is_private\": false, \"creation_template\": 2, \"name\": \""+name+"\", \"description\": \"Test\"}\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .method("POST", body)
                .addHeader("Authorization", tokken)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();

        return JsonParser.parseString(jsonString).getAsJsonObject();

    }

    public static void deleteProject(JsonObject jsonObject) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects/"+jsonObject.get("id").getAsString())
                .method("DELETE", body)
                .addHeader("Authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrMKq:B-GhNZMD2bkcoPfzqzylNgH_07g")
                .build();
        Response response = client.newCall(request).execute();
    }


    public static JsonArray getAllProjects() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects?member=481061&order_by=user_order")
                .method("GET", null)
                .addHeader("Authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrMKq:B-GhNZMD2bkcoPfzqzylNgH_07g")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonArray asJsonArray = JsonParser.parseString(jsonString).getAsJsonArray();

        return asJsonArray;
    }

    public static JsonObject deleteBookmark() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/wiki-links/95997")
                .method("DELETE", body)
                .addHeader("Authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrMKq:B-GhNZMD2bkcoPfzqzylNgH_07g")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();

        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    public static void addBookmark(JsonObject jsonObject) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"project\":"+jsonObject.get("id").getAsString()+",\"title\":\"Test\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/wiki-links?=")
                .method("POST", body)
                .addHeader("Authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjo0ODEwNjF9:1lrMKq:B-GhNZMD2bkcoPfzqzylNgH_07g")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

    }

}
