package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.Tag;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Skin_Detect extends AppCompatActivity {
    private class Data{
        String label;

    }


    private static final String Tag = "Skin_Detect";

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    Bitmap bitmap;
    android.net.Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_detect);


        imageView = findViewById(R.id.imageView);
        Button pickPhotoButton = findViewById(R.id.pickPhotoButton);
        Button predict = findViewById(R.id.predict);
        TextView result = findViewById(R.id.result);

        pickPhotoButton.setOnClickListener(view -> openImagePicker());
        predict.setOnClickListener(view -> {
//            result.setText("actinic keratoses and intraepithelial carcinomae(Cancer)");

            String path = getImagePathFromUri(imageUri);


//            File imageFile = new File("file://device/IMG-20231101-WA0016.jpg");
            File imageFile = new File(path);
//            File file = new File("/storage/0000-CCD4/Actinic.png");
            if (imageFile.exists()) {
                System.out.println("File exists");
                // File exists, proceed with the network request
            } else {
                System.out.println("File not exists");

                // File doesn't exist, handle accordingly
//                Log.e(Tag, "File does not exist at the specified location");
            }

//            Toast.makeText(this, "HK: "+imageUri, Toast.LENGTH_SHORT).show();

            // Create a RequestBody instance from the file
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("image", "image.png",
                            RequestBody.create(MediaType.parse("image/png"), imageFile))
                    .build();

            // Create the OkHttp client
            OkHttpClient client = new OkHttpClient
                    .Builder()
                    .connectTimeout(50, TimeUnit.SECONDS) // Adjust the connection timeout
                    .readTimeout(50, TimeUnit.SECONDS)    // Adjust the read timeout
                    .build();

            // Create the request
            Request request = new Request.Builder()
                    .url("http://192.168.0.124:5000/upload") // Replace with your API endpoint
                    .post(requestBody)
                    .build();

            // Execute the request asynchronously
            client.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    // Handle failure
                    Log.e(Tag, "Network error: " + e.getMessage());
//                    Toast.makeText(Skin_Detect.this, "No responce", Toast.LENGTH_SHORT).show();
                    System.out.println("HK respponse is: no "+e);

                }

                @Override
                public void onResponse(okhttp3.Call call, Response response) throws IOException {
//                    Toast.makeText(Skin_Detect.this, "get responce", Toast.LENGTH_SHORT).show();
                    System.out.println("HK respponse is: yes ");

                    if (response.isSuccessful()) {
//                        String json = loadJsonFromAsset("data.json");
//                        String label = LabelExtractor.extractLabel(json);
//                        Log.d("Label", label);
                        // Handle success
                        String responseBody = response.body().string();
                        Skin_Detect.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {



                                Gson gson = new Gson();

                                // Convert JSON string to Java object
                                Data myObject = gson.fromJson(responseBody, Data.class);

//                                JSONObject jsonObject = new JSONObject(responseBody);
//                                String hk =  jsonObject.getString("label");
                                result.setText("HK "+myObject.label);
//                                Toast.makeText(Skin_Detect.this, "", Toast.LENGTH_SHORT).show();
                            }
                        });
//                        Log.d(Tag, "Response: " + responseBody);
                    } else {
                        // Handle failure
//                        Log.e(Tag, "Error: " + response.message());
                    }
                }
            });

//            ImageUploadTask uploadTask = new ImageUploadTask("http://192.168.0.124:5000/upload", bitmap, this);
//            uploadTask.execute();
        });
    }
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the selected image URI

            imageUri = data.getData();

            // Decode the URI into a Bitmap
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    private String getImagePathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(
                this,
                uri,
                projection,
                null,
                null,
                null
        );

        Cursor cursor = cursorLoader.loadInBackground();

        String imagePath = null;
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            imagePath = cursor.getString(columnIndex);
            cursor.close();
        }

        return imagePath;
    }







//    it's temp
    private static class ImageUploadTask extends AsyncTask<Void, Void, String> {


        private final Context context;
        private final String serverUrl;
        private final Bitmap imageBitmap;

        public ImageUploadTask(String serverUrl, Bitmap imageBitmap, Context context) {
            this.serverUrl = serverUrl;
            this.imageBitmap = imageBitmap;
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... params) {
//            Toast.makeText(context, "msg", Toast.LENGTH_SHORT).show();

            try {
                URL url = new URL(serverUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "image/jpeg");

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                connection.setRequestProperty("Content-Length", String.valueOf(byteArray.length));

                DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.write(byteArray);
                outputStream.flush();
                outputStream.close();

                int responseCode = connection.getResponseCode();
                String msg = connection.getResponseMessage();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream is = connection.getInputStream();
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    // Read the response, assuming it's JSON data
                    // Use a BufferedReader or similar for reading data from the InputStream
                    // ...

                    // For demonstration purposes, just returning a success message
                    return "Upload successful";
                } else {
                    return "Error: " + responseCode;
                }
            } catch (Exception e) {
//                Log.e(Tag, "Error during image upload", e);
                return "Error: " + e.getMessage();
            }
        }
    }
}