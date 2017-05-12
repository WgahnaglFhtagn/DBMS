package Entities;

public class Book {
    private int id;
    private int sectionId;
    private String name;
    private String description;
    private int costPrice;
    private int authorId;
    private int userId;

    public Book(int id, int sectionId, String name, String description, 
            int costPrice, int authorId, int userId) {
        this.id = id;
        this.sectionId = sectionId;
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.authorId = authorId;
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
