package com.ai.enjoy;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GenerateTextFromTextInput {


    public static void main(String[] args) {
//        final String GOOGLE_API_kEY

        // The client gets the API key from the environment variable `GEMINI_API_KEY`.

//        Client client = new Client();
        Client client = Client.builder().apiKey("").build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3-flash-preview",
                        "Explain how AI works in a few words",
                        null);

        System.out.println(response.text());
    }
}

