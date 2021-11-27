import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    String bookName, authorName, publishDate,manufacturerName;
    int price;

    public Book(String bookName, String authorName, String publishDate, String namufacturerName, int price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.manufacturerName = namufacturerName;
        this.price = price;
    }

    public Book() {

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String namufacturerName) {
        this.manufacturerName = namufacturerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", namufacturerName='" + manufacturerName + '\'' +
                ", price=" + price +
                '}';
    }
    public void display (){
        System.out.println(this);//goi tostring
    }

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ten sach:");
        bookName=scan.nextLine();
        System.out.println("Nhap ten tac gia:");
        authorName=scan.nextLine();
        System.out.println("Nhap ngay xuat ban (dd/MM/yyyy");
        publishDate=scan.nextLine();
        System.out.println("Nhap ten nha xuat ban");
        manufacturerName=scan.nextLine();
        System.out.println("Nhap gia:");
        price= Integer.parseInt(scan.nextLine());


    }
    public String getFileLine(){
        return bookName+","+authorName+","+price+","+publishDate+","+manufacturerName+","+price+"\n";
    }

}
