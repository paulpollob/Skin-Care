package com.example.skinsenty.skindetect;
import com.google.gson.annotations.SerializedName;

public class Info {


    // Adjust the field names based on your actual API response
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    // Add getters and setters as needed

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
