package learn.thymeleaf.webdev.model;

public class Book {
    String isbn;
    Double price;
    String bname;
    String publishing;
    String author;
    String picture;

    public Book(String isbn,Double price,String bname,String publishing,String author,String picture){
        super();
        this.isbn = isbn;
        this.price = price;
        this.bname = bname;
        this.publishing = publishing;
        this.author = author;
        this.picture = picture;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getBname(){
        return this.bname;
    }

    public String getPublishing(){
        return this.publishing;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getPicture(){
        return this.picture;
    }
}
