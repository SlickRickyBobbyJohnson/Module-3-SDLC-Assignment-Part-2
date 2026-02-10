@SuppressWarnings("unused")
public class Main {
    private String id;        // 7-digit ID number
    private String name;      // Patron's name
    private String address;   // Patron's address
    private double fine;      // Outstanding balance ($0-$250)

    // constructor
    public Main(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;

        // make sure fine is between $0 and $250
        if (fine < 0) { this.fine = 0;
        } else if (fine > 250) {
            this.fine = 250;
        } else {
            this.fine = fine;
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getFine() {
        return fine;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFine(double fine) {
        // Make sure fine is between $0 and $250
        if (fine < 0) {
            this.fine = 0;
        } else if (fine > 250) {
            this.fine = 250;
        } else {
            this.fine = fine;
        }
    }

    //print patron info
    @Override
    public String toString() {
        return "ID: " + id + " - Name: " + name + " - Address: " + address + " - Fine: $" + fine;
    }
}