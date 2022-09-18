//package com.infobyte;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Book{
//    public String name, author;
//    public Book(String name, String author) {
//        this.name = name;
//        this.author = author;
//    }
//    @Override
//    public String toString(){
//        return "Book{" + "name='" + name + "\'" + ", author='" + author + "\'" + '}';
//    }
//}
//class MyLibrary{
//    public ArrayList <com.infobyte.Book> books;
//    public MyLibrary(ArrayList <com.infobyte.Book> books){
//        this.books = books;
//    }
//    public void addBook(com.infobyte.Book book){
//        System.out.println("The book has been added to the library");
//        this.books.add(book);
//    }
//    public void issueBook(com.infobyte.Book book, String issued_to){
//        System.out.println("The book has been issued from the library to " + issued_to);
//        this.books.remove(book);
//    }
//    public void returnBook(com.infobyte.Book b){
//        System.out.println("The book has been returned");
//        this.books.add(b);
//    }
//}
//
//public class Task5_DigitalLibraryManagement {
//    public static void main(String[] args) {
//        ArrayList<Book> bk = new ArrayList<>();
//        Book b1 = new Book("Algorithms1", "CLRS1");
//        bk.add(b1);
//        Book b2 = new Book("Algorithms2", "CLRS2");
//        bk.add(b2);
//        Book b3 = new Book("Algorithms3", "CLRS3");
//        bk.add(b3);
//        Book b4 = new Book("Algorithms4", "CLRS4");
//        bk.add(b4);
//        MyLibrary l = new MyLibrary(bk);
//
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("Welcome to the Oasis_InfoByte library. Enter your choice to continue");
//            System.out.println("1. Display Books");
//            System.out.println("2. Add a Books");
//            System.out.println("3. Issue a Books");
//            System.out.println("4. Return a Books");
//
//            int user_choice = sc.nextInt();
//
//            if (user_choice == 1) {
//                System.out.println(l.books);
//            }
//            else if (user_choice == 2) {
//                System.out.println("Enter the name of the book you want to add: ");
//                String a = sc.next();
//                System.out.println("Enter your name");
//                String b = sc.nextLine();
//                l.addBook(new Book(a, b));
//                System.out.println(l.books);
//            }
//            else if (user_choice == 3) {
//                System.out.println("Enter the index of the book, which you want to issue: ");
//                int a = sc.nextInt();
//                System.out.println("Enter your name");
//                String b = sc.nextLine();
//                l.issueBook(bk.get(a), b);
//                System.out.println(l.books);
//            }
//            else if (user_choice == 4) {
//                System.out.println("Enter the name of the book you want to return: ");
//                String a = sc.nextLine();
//                l.returnBook(a);                    // ******** yha error show kar rha h ********
//            }
//            else{
//                System.out.println("Not a valid option");
//            }
//            System.out.println("Press q to quit and c to continue");
//            String user_choice2 = "";
//            while(user_choice2 != "c" && user_choice2 != "q") {
//                user_choice2 = sc.next();
//                if (user_choice2 == "q") {
//
//                }
//                else if (user_choice2 == "c") {
//                    continue;
//                }
//            }
//        }
//    }
//}































package com.infobyte;

import java.util.ArrayList;
import java.util.Scanner;
class User{
    String name;
    int issueBookPos;
    public User(String name , int pos){
        this.name = name;
        this.issueBookPos = pos;
    }
    @Override
    public String toString(){
        return "User{" + "name='" + name + '}';
    }
}
class Book{
    public String name, author;
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    @Override
    public String toString(){
        return "Book{" + "name='" + name + "\'" + ", author='" + author + "\'" + '}';
    }
}
class MyLibrary{
    public ArrayList <Book> books;
    public ArrayList<User> users;
    public ArrayList <Boolean> isBookPresent;
    public MyLibrary(ArrayList <Book> books){
        this.books = books;
        isBookPresent = new ArrayList<>();
        users = new ArrayList<>();
        for(int i = 0 ; i < books.size() ; i++){
            isBookPresent.add(true);
        }
    }
    public void addBook(Book book){
        this.books.add(book);
        this.isBookPresent.add(true);
        System.out.println("The book has been added to the library");
    }
    public void issueBook(int position , String issued_to){
        if(position <= books.size() && position >= 0){
            if(isBookPresent.get(position-1)){
                System.out.println("The book has been issued from the library to " + issued_to);
                User user = new User(issued_to,position);
                users.add(user);
                isBookPresent.set(position-1,false);
            }
            else{
                System.out.println("Sorry book is already issued..!");
            }
        }
        else{
            System.out.println("Please Enter the correct Serial No.");
        }
    }
    public void returnBook(String bookName){
        int counter = 0;
        for(Book book : books){
            if(book.name.equals(bookName)){
                if(!isBookPresent.get(counter)){
                    System.out.println(users);
                    for(User user : users){
                        if(user.issueBookPos == counter+1){
                            System.out.println("Thank you :"+user.name+" for returning the Book");
                            users.remove(user);
                            isBookPresent.set(counter,true);
                            return;
                        }
                        else{
                            System.out.println("hello");
                        }
                    }
                }
                else{
                    System.out.println("Sorry this is not our Library book");
                    return;
                }
            }
            counter++;
        }
        System.out.println(("wrong book name..!"));
    }
    public void showBooks(){
        for(int i = 0 ; i < books.size() ; i++){
            System.out.println(" S.No. " +(i+1) + " --> Book Name : " +books.get(i).name + "Author Name : " + books.get(i).author+ " , status = " + (isBookPresent.get(i)?"present":"issued"));
        }
    }
}

public class Task5_DigitalLibraryManagement {
    public static void main(String[] args) {
        ArrayList<Book> bk = new ArrayList<>();
        Book b1 = new Book("Algorithms1", "CLRS1");
        bk.add(b1);
        Book b2 = new Book("Algorithms2", "CLRS2");
        bk.add(b2);
        Book b3 = new Book("Algorithms3", "CLRS3");
        bk.add(b3);
        Book b4 = new Book("Algorithms4", "CLRS4");
        bk.add(b4);
        MyLibrary l = new MyLibrary(bk);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to the Oasis_InfoByte library. Enter your choice to continue");
            System.out.println("1. Display Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");

            int user_choice = sc.nextInt();

            if (user_choice == 1) {
                l.showBooks();
            }
            else if (user_choice == 2) {
                System.out.println("Enter the name of the book you want to add: ");
                String a = sc.next();
                System.out.println("Enter your name");
                String b = sc.next();
                l.addBook(new Book(a, b));
                System.out.println(l.books);
            }
            else if (user_choice == 3) {
                System.out.println("Enter the S.No. of the book, which you want to issue: ");
                int pos = sc.nextInt();
                System.out.println("Enter your name");
                sc.nextLine();
                String name = sc.nextLine();
                l.issueBook(pos, name);
            }
            else if (user_choice == 4) {
                System.out.println("Enter the name of the book you want to return: ");
                sc.nextLine();
                String bookName = sc.nextLine();
                ArrayList<Book> books = l.books;
                l.returnBook(bookName);
            }
            else{
                System.out.println("Not a valid option");
            }
            Boolean exit = false;
            while(true){
                System.out.println("Press q to quit and c to continue");
                char user_choice2 = sc.next().charAt(0);
                if(user_choice2 == 'c'){
                    break;
                }
                else if(user_choice2 == 'q'){
                    exit = true;
                    break;
                }
                else {
                    System.out.println(("Wrong input"));
                }
            }
            if(exit) break;
        }
    }
}