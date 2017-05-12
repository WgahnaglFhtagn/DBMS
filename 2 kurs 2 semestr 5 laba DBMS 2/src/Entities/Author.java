package Entities;

public class Author {
    private int id;
    private String fullName;
    private String contactNumber;
    private String address;
    private int numberOfWorks;

    public Author(int id, String fullName, String contactNumber, String address, 
            int numberOfWorks) {
        this.id = id;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.numberOfWorks = numberOfWorks;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfWorks() {
        return numberOfWorks;
    }

    public void setNumberOfWorks(int numberOfWorks) {
        this.numberOfWorks = numberOfWorks;
    }
}
