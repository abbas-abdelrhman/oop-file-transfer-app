package com.oopbackend;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;


public class Frontend extends JFrame {
    private JTextArea serverResponseArea;
    private JTree fileTree;
    private JTextField destinationField;
    private JButton sendButton, selectDestButton, saveButton;

    public Frontend() {
        super("File Transfer Application");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Add panels to the frame
        add(topPanel(), BorderLayout.NORTH);
        add(treePanel(), BorderLayout.WEST);
        add(new JScrollPane(serverResponseArea), BorderLayout.CENTER);


        // Action listener for the select destination button
        selectDestButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                destinationField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        // Action listener for the send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TreePath selectedPath = fileTree.getSelectionPath();
                if (selectedPath == null) {
                    JOptionPane.showMessageDialog(com.oopbackend.Frontend.this, "Please select a file from the server.");
                    return;
                }

                String destinationFolder = destinationField.getText();
                if (destinationFolder.isEmpty()) {
                    JOptionPane.showMessageDialog(com.oopbackend.Frontend.this, "Please select a destination folder.");
                    return;
                }


                // Get the URL from the text field
                Object[] pathComponents = selectedPath.getPath();
                StringBuilder urlBuilder = new StringBuilder("http://localhost:8000");

                for (Object component : pathComponents) {
                    urlBuilder.append("/").append(component.toString());
                }
                String urlString = urlBuilder.toString();

                FileTransferService transferFile = new FileTransferService();
                transferFile.FileTransferService(urlString, destinationFolder, serverResponseArea);

            }
        });
    }

    public JPanel topPanel() {
        // Create components for top panel & logs area
        serverResponseArea = new JTextArea();
        sendButton = new JButton("Save File");
        selectDestButton = new JButton("Select Destination");
        destinationField = new JTextField(30);

        // Add components to the top panel
        JPanel destinationPanel = new JPanel(new FlowLayout());
        destinationPanel.add(selectDestButton);
        destinationPanel.add(destinationField);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Select a file from the server and destination on local machine:"), BorderLayout.NORTH);
        topPanel.add(destinationPanel, BorderLayout.CENTER);
        topPanel.add(sendButton, BorderLayout.SOUTH);

        return topPanel;
    }

    public JPanel treePanel() {
        DefaultMutableTreeNode root = createFileTreeNodes();
        fileTree = new JTree(root);
        JScrollPane treeView = new JScrollPane(fileTree);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Select a file from the server"), BorderLayout.NORTH);
        panel.add(treeView, BorderLayout.CENTER);
        return panel;
    }


    private DefaultMutableTreeNode createFileTreeNodes() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("host");

        DefaultMutableTreeNode oop = new DefaultMutableTreeNode("OOP");
        root.add(oop);

        DefaultMutableTreeNode group1 = new DefaultMutableTreeNode("Group1");
        oop.add(group1);

        DefaultMutableTreeNode exercise01Group1 = new DefaultMutableTreeNode("Exercise01");
        group1.add(exercise01Group1);
        exercise01Group1.add(new DefaultMutableTreeNode("data.txt"));
        exercise01Group1.add(new DefaultMutableTreeNode("exercise01.txt"));

        DefaultMutableTreeNode exercise02Group1 = new DefaultMutableTreeNode("Exercise02");
        group1.add(exercise02Group1);
        exercise02Group1.add(new DefaultMutableTreeNode("data.txt"));
        exercise02Group1.add(new DefaultMutableTreeNode("exercise02.txt"));

        DefaultMutableTreeNode group2 = new DefaultMutableTreeNode("Group2");
        oop.add(group2);

        DefaultMutableTreeNode exercise01Group2 = new DefaultMutableTreeNode("Exercise01");
        group2.add(exercise01Group2);
        exercise01Group2.add(new DefaultMutableTreeNode("data.txt"));
        exercise01Group2.add(new DefaultMutableTreeNode("exercise01.txt"));

        DefaultMutableTreeNode exercise02Group2 = new DefaultMutableTreeNode("Exercise02");
        group2.add(exercise02Group2);
        exercise02Group2.add(new DefaultMutableTreeNode("data.txt"));
        exercise02Group2.add(new DefaultMutableTreeNode("exercise02.txt"));

        return root;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new com.oopbackend.Frontend().setVisible(true);
            }
        });
    }
}
