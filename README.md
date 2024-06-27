# OOP: File Transfer Application

This application is designed to facilitate file transfers from a server to a local machine using a graphical user
interface (GUI) built with Swing. The application allows users to select a file from a server, specify a destination
directory on their local machine, and transfer the file.

## Main Components

- **FileTransferApp**: The entry point of the application, initializing the main JFrame and adding the primary panels.
- **FileTransferPanel**: Manages the UI components related to file transfer, including destination selection and the
  transfer button.
- **FileTreePanel**: Handles the display and interaction with the hierarchical file structure.
- **FileTransferService**: Contains the logic for transferring files over HTTP.

## Features

- Select files from a server using a JTree component.
- Choose a local destination directory to save the selected files.
- Transfer files from the server to the local destination.
- Display server response and transfer status in a JTextArea.

## Installation and Setup

### Clone the Repository

- Clone the repository from GitHub:

```
git clone https://github.com/abbas-abdelrhman/oop-file-transfer-app
```

- Navigate to the project directory:

```
cd oop-file-transfer-app`
```

### Compile the Project

1. Open a terminal and navigate to the `src` directory:
    ```
    cd src
    ```

2. Compile the Java files:
    ```
    javac /main/java/com/oopbackend/App.java
   ```
   ```
    javac com/oopbackend/Frontend.java
    ```

### Run the Application

- Use your IDE:
  - Open the project in your IDE. 
  - Locate the `App` and `Frontend` class. 
  - Right-click on the `App` first and select run
  - Then right-click on the `Frontend` class and select `Run`.



## Documentation
### Source Code Documentation
#### `Frontend.java`

The `Frontend` class represents the main UI for the File Transfer Application. It extends `JFrame` and provides a graphical interface for selecting files from a server and specifying a destination on the local machine.

**Attributes:**
- `serverResponseArea`: A `JTextArea` to display server responses and status messages.
- `fileTree`: A `JTree` to display the server file structure.
- `destinationField`: A `JTextField` to input the local destination directory.
- `sendButton`, `selectDestButton`, `saveButton`: `JButton` instances for user interactions.

**Methods:**
- `Frontend()`: Constructs a new `Frontend` object and initializes the UI components.
- `transferFile(String urlString, String destinationFolder)`: Transfers the file from the specified URL to the destination folder.
- `createFileTreeNodes()`: Creates and returns the root node for the file tree.
- `main(String[] args)`: The main method that sets up and displays the `Frontend` UI.

**Inspiration and References:**
- UI Design inspired by various Swing tutorials and examples.
  - [Java Swing Components](https://docs.oracle.com/javase/tutorial/uiswing/components/index.html)
  - [Java Swing Tutorial](https://www.javatpoint.com/java-swing)





## Class: FileTransferApp

### Responsibilities

- Initializes the main JFrame.
- Sets up the primary panels (`FileTransferPanel` and `FileTreePanel`).
- Launches the application.

### Methods

- `public static void main(String[] args)`: The main method, which starts the application.
- `private void start()`: Initializes the JFrame and adds the primary panels.

## Class: FileTransferPanel

### Responsibilities

- Manages UI components related to file selection, destination selection, and the file transfer button.
- Provides a text area to display server responses.

### Constructor

- `public FileTransferPanel()`: Initializes the UI components and sets up event listeners for the buttons.

### Methods

- `public JPanel getPanel()`: Returns the main panel containing the file transfer UI components.
- `public JTextArea getServerResponseArea()`: Returns the text area used for displaying server responses.

## Class: FileTreePanel

### Responsibilities

- Displays a hierarchical file structure using a JTree.
- Manages the interaction with the file tree.

### Constructor

- `public FileTreePanel()`: Initializes the JTree and its surrounding panel.

### Methods

- `private DefaultMutableTreeNode createFileTreeNodes()`: Creates and returns the root node of the file tree.
- `public JPanel getPanel()`: Returns the main panel containing the file tree.

## Class: FileTransferService

### Responsibilities

- Encapsulates the logic for transferring files over HTTP.
- Manages HTTP connections, request building, and response handling.

### Constructor

- `public FileTransferService(JTextArea serverResponseArea)`: Initializes the service with a reference to the server
  response area.

### Methods

- `public void transferFile(String urlString, String destinationFolder)`: Transfers a file from the specified


---
## Acknowledgments

This project documentation includes guidance and assistance from discussions with ChatGPT, an AI language model, providing insights on building the File Transfer Application.

ChatGPT provided assistance on writing Markdown documentation, compiling and running Java applications, and structuring the README.md file.

---
