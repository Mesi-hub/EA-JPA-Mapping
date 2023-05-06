package domain;

import jakarta.persistence.*;



@Entity
public class Book extends Product{
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
