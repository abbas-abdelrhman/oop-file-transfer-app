package com.oopbackend;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class FileTransferService {
    /**
     * Transfers a file from the given URL to the specified destination folder.
     *
     * @param urlString The URL of the file to transfer.
     * @param destinationFolder The local folder where the file will be saved.
     * @param serverResponseArea The server logs
     */
    public void FileTransferService(String urlString, String destinationFolder, JTextArea serverResponseArea) {
        try {
            // create URL object
            URL url = new URL(urlString);

            //create HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Set request mode to GET
            connection.setRequestMethod("GET");

            //get response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                //Read response from input stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()
                ));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();


                serverResponseArea.setText("File transferred successfully to " + destinationFolder);
            } else {
                serverResponseArea.setText("Error: Server responded with code " + responseCode);
            }

            connection.disconnect();
        } catch (IOException ex) {
            serverResponseArea.setText("Error: " + ex.getMessage());
        }
    }
}
