package com.oopbackend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Frontend extends JFrame {
    private JTextArea serverResponseArea;

    public Frontend() {
        super("Test Client Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel panel = new JPanel(new GridLayout(3, 1));
        serverResponseArea = new JTextArea();
        JButton sendButton = new JButton("Send URL");

        // Add components to panel
        panel.add(new JLabel("Test Client"));
        panel.add(sendButton);

        // Add panel and server response area to frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(serverResponseArea), BorderLayout.CENTER);

        // Action listener for the send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the URL from the text field
                String urlString = "http://localhost:8000/host/OOP/Group1/Exercise01/exercise01.txt";

                try{
                    // create URL object
                    URL url = new URL(urlString);

                    //create HttpURLConnection
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    //Set request mode to GET
                    connection.setRequestMethod("GET");

                    //get response code
                    int responseCode = connection.getResponseCode();

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

                    //Display server response
                    serverResponseArea.setText("Response code: " + responseCode + "\n" + response.toString());

                    // Disconnect the connection
                    connection.disconnect();

                } catch(IOException ex){
                    //Display error message if an exeption occurs
                    serverResponseArea.setText("Error: " + ex.getMessage());

                }

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frontend().setVisible(true);
            }
        });
    }
}
