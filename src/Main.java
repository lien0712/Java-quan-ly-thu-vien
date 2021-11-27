import java.io.*;
import java.util.*;

public class Main {
    static List<Book> bookList;
    static Scanner scan;

    public static void main(String[] args) {
        bookList= new ArrayList<>();
        scan=new Scanner(System.in);
        int choose;
        do{
            showMenu();
            choose= Integer.parseInt(scan.nextLine());
            switch(choose){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortByAuthorName();
                    break;
                case 4:
                    saveObjectFile();
                    break;
                case 5:
                    saveTextFile();
                    break;
                case 6:
                    readObjectFile();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Chon lai ");
                    break;
            }

        }while(choose!=7);

    }

    private static void readObjectFile() {
        FileInputStream fis=null;
        ObjectInputStream ois= null;
        try {
            fis=new FileInputStream("data.obj");
            ois=new ObjectInputStream(fis);
            List<Book> dataList= (List<Book>) ois.readObject();
            dataList.forEach(book -> bookList.add(book));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    private static void saveTextFile() {
        FileOutputStream fos =null;
        try {
            fos= new FileOutputStream("data.txt");
            for (Book book:bookList) {
                String line=book.getFileLine();
                byte[] data = line.getBytes("utf8");
                fos.write(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private static void saveObjectFile() {
        FileOutputStream fos= null;
        ObjectOutputStream oos= null;
        try {
            fos =new FileOutputStream("data.obj");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(bookList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!= null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static void sortByAuthorName() {
        Collections.sort(bookList,new Comparator<Book>(){

            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthorName().compareToIgnoreCase(o2.getAuthorName());
            }
        });
    }


    private static void display() {
        System.out.println("Hien thi thong tin sach:");
        for (Book book : bookList) {
            book.display();
        }

    }


    private static void input() {
        System.out.println("Nhap so sach can them n=");
        int n= Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Book b= new Book();
            b.input();
            bookList.add(b);

        }

    }


    static void showMenu(){
        System.out.println("1. Nhap n sach");
        System.out.println("2. Hien thi thong tin sach");
        System.out.println("3. Sap xep theo thong tin tac gia");
        System.out.println("4. Luu thong tin");
        System.out.println("5. Lu thong tin vao file");
        System.out.println("6. Doc du lieu ");
        System.out.println("7. Thoat");
        System.out.println("Chon");

    }


}
