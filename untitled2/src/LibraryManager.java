import java.io.*;
import java.util.ArrayList;
    public class LibraryManager {
        //stores all patrons
        private final ArrayList<Main> patrons;

        // constructor
        public LibraryManager() {
            patrons = new ArrayList<>();
        }

        // load patrons from a file
        public void loadFile(String filename) {
            File file = new File(filename);

            if (!file.exists() && !file.isAbsolute() && !filename.contains(File.separator)) {
                file = new File("src", filename);
            }

            if (!file.exists()) {
                System.out.println("Error loading file." + file.getAbsolutePath());
                System.out.println("Current working directory: " + System.getProperty("user.dir"));
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // reads each line
                while ((line = reader.readLine()) != null) {
                    String trimmed = line.trim();
                    if (trimmed.isEmpty() || trimmed.equalsIgnoreCase("UNKNOWN")) {
                        continue;
                    }

                    // splits the data into parts (id-name-address-fine)
                    String[] parts = trimmed.split("-");
                    if (parts.length != 4) {
                        continue;
                    }

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String address = parts[2].trim();
                    double fine = Double.parseDouble(parts[3].trim());

                    // create dataset
                    Main p = new Main(id, name, address, fine);
                    patrons.add(p);
                }

                System.out.println("File loaded successfully! " + patrons.size() + " patrons loaded.");

            } catch (Exception e) {
                System.out.println("Error loading file: " + e.getMessage());
            }
        }

        // save patrons to a file
        public void saveFile(String filename) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));


                for (Main p : patrons) {
                    writer.write(p.getId() + "-" + p.getName() + "-" + p.getAddress() + "-" + p.getFine());
                    writer.newLine();
                }

                writer.close();
                System.out.println("File saved successfully! " + patrons.size() + " patrons saved.");

            } catch (Exception e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }

        // adds
        public void addPatron(Main patron) {
            patrons.add(patron);
            System.out.println("patron addeded");
        }

        // removes
        public void removePatron(String id) {
            boolean found = false;

            // search for the patron with matching id and remove them
            for (int i = 0; i < patrons.size(); i++) {
                if (patrons.get(i).getId().equals(id)) {
                    patrons.remove(i);
                    found = true;
                    System.out.println("patron removed");
                    break;
                }
            }

            if (!found) {
                System.out.println("Patron not found.");
            }
        }

        // all patrons
        public void viewAll() {
            if (patrons.isEmpty()) {
                System.out.println("no patrons to be found");
            } else {
                System.out.println("\nall patrons below");
                for (Main patron : patrons) {
                    System.out.println(patron);
                }
                System.out.println("all patrons above\n");
            }
        }
    }
