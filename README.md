# OOP: File Transfer Application

This application is designed to facilitate file transfers from a server to a local machine using a graphical user
interface (GUI) built with Swing. The application allows users to select a file from a server, specify a destination
directory on their local machine, and transfer the file.

## Main Components

- **Frantond**: 
  - The entry point of the application, initializing the main JFrame and adding the primary panels. 
  - Manages the UI components related to file transfer, including destination selection and the
  transfer button. 
  - Handles the display and interaction with the hierarchical file structure.
- **FileTransferService**: Contains the logic for transferring files over HTTP.
- **App**: Manage the back-end.


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

### To Compile the Project

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

### To Run the Application

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
- `sendButton`, `selectDestButton`: `JButton` instances for user interactions.

**Methods:**
- `topPanel()`: Creates and returns the top panel of the GUI, which contains components for file selection and destination directory.
- `treePanel()`: Creates and returns the tree panel of the GUI, which displays the server's file structure.
- `createFileTreeNodes()`: Creates and returns the root node for the file tree.
- `main(String[] args)`: The main method that sets up and displays the `Frontend` UI.



---
## Acknowledgments

This project documentation includes guidance and assistance from discussions with ChatGPT, an AI language model, providing insights on building the File Transfer Application.

ChatGPT provided assistance on writing Markdown documentation, compiling and running Java applications, and structuring the README.md file.

---
