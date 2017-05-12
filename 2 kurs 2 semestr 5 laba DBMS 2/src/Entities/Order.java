package Entities;

public class Order {
    private int id;
    private String date;
    private int number;
    private int totalPrice;
    private int bookid;

    public Order(int id, String date, int number, int totalPrice, int bookid) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.totalPrice = totalPrice;
        this.bookid = bookid;
    }
    
    @Override
    public String toString() {
        return getDate();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
