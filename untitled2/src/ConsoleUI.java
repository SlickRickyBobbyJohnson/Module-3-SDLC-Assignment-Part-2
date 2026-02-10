import java.util.Scanner;

// ConsoleUI class handles user interaction
public class ConsoleUI {
    // Scanner
    private final Scanner scanner;
    // LibraryManager to manage patrons
    private final LibraryManager manager;

    // cpnstructor
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        manager = new LibraryManager();
    }

    // show menu
    public void showMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Load File");
        System.out.println("2. Save File");
        System.out.println("3. Add Patron");
        System.out.println("4. Remove Patron");
        System.out.println("5. View All Patrons");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // scans user input
    public String getInput() {
        return scanner.nextLine();
    }

    // start the program
    public void start() {
        boolean running = true;

        System.out.println("Welcome to the Library Management System!");

        // the main loop as you requested dr macon
        while (running) {
            showMenu();
            String choice = getInput().trim();

            // user choice ui
            if (choice.equals("1")) {
                // load file
                System.out.print("Enter filename to load: ");
                String loadFilename = getInput().trim();
                manager.loadFile(loadFilename);
            } else if (choice.equals("2")) {
                // save
                System.out.print("Enter filename to save: ");
                String saveFilename = getInput().trim();
                manager.saveFile(saveFilename);
            } else if (choice.equals("3")) {
                // add
                System.out.print("Enter 7-digit ID: ");
                String id = getInput().trim();

                System.out.print("Enter name: ");
                String name = getInput();

                System.out.print("Enter address: ");
                String address = getInput();

                System.out.print("Enter fine amount ($0-$250): ");
                double fine = Double.parseDouble(getInput().trim());

                Main newPatron = new Main(id, name, address, fine);
                manager.addPatron(newPatron);
            } else if (choice.equals("4")) {
                // remove patron
                System.out.print("Enter ID of patron to remove: ");
                String removeId = getInput().trim();
                manager.removePatron(removeId);
            } else if (choice.equals("5")) {
                // all patrons
                manager.viewAll();
            } else if (choice.equals("6")) {
                // Exit
                System.out.println("Exiting program. Goodbye!");
                running = false;

            } else {
                // If a file path was pasted at the main menu, load it directly.
                if (!choice.isEmpty()) {
                    manager.loadFile(choice);
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }

        scanner.close();
    }

    //runs the program
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
