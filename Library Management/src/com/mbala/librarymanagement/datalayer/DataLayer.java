package com.mbala.librarymanagement.datalayer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.model.Library;
import com.mbala.librarymanagement.model.Members;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Book> bookList = new ArrayList<>();
    private List<Members> memberList = new ArrayList<>();
    private Library librarySetup;
    private List<BorrowReturnBook> borrowBook = new ArrayList<>();


    public List<BorrowReturnBook> getBorrowBookList() {
        return borrowBook;
    }

    public void setBorrowBook(BorrowReturnBook borrowBook) {
        this.borrowBook.add(borrowBook);
    }

    public Library getLibrarySetup() {
        return librarySetup;
    }

    public void setLibrarySetup(Library libraryDetails) {
        this.librarySetup=libraryDetails;
    }

    public static DataLayer getInstance() {
        if (dataLayer == null) {
            dataLayer = new DataLayer();
        }
        return dataLayer;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book searchBookByName(String name) {
        String bookName = name.toLowerCase();
        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(bookName)) {
                return book;
            }
        }
        return null;
    }
    public boolean isNewBook(Book book) {
        for (Book check : bookList) {
            if (check.getName().equals(book.getName()) && check.getVolume() == book.getVolume()) {
                return false;
            }
        }
        bookList.add(book);
       new File("booklist.json").delete();
        setBookListJson();
        return true;
    }

    public boolean isNewMember(Members members) {
        for (Members check : memberList) {
            if (check.getName().equals(members.getName()) && check.getId() == members.getId()) {
                return false;
            }
        }
        memberList.add(members);
        new File("memberlist.json").delete();
        setMemberListJson();
        return true;
    }

    public List<Members> getMemberList() {
        return memberList;
    }

    public void removeMembers(int id) {
        for (Members members : memberList) {
            if (members.getId() == id) {
                memberList.remove(members);
                new File("memberlist.json").delete();
                setMemberListJson();
                break;
            }
        }
    }

    //Object Mapper


    ObjectMapper mapper = new ObjectMapper();


    public void setBookListJson() {
        try {
            mapper.writeValue(  new File("booklist.json"), bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBookListJson() {
        if(new File("booklist.json").exists() && new File("booklist.json").canRead()){
            try {
                bookList.addAll(mapper.readValue(  new File("booklist.json"), new TypeReference<List<Book>>() {}));
            } catch (IOException e) {
                System.err.println("Error reading book list from JSON: " + e.getMessage());
            }
    
        }else{
            try{
                new File("booklist.json").createNewFile();
            }catch(IOException e){
                System.err.println("Error reading book list from JSON: " + e.getMessage());
            }  
        }
            }
    public void setMemberListJson()  {
        try {
            mapper.writeValue(new File("memberlist.json"), memberList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMemberListJson() {
        if(new File("memberlist.json").exists() && new File("memberlist.json").canRead()){
            try {
                memberList.addAll( mapper.readValue(new File("memberlist.json"), new TypeReference<List<Members>>() {
               }));
           } catch (IOException e) {
               e.printStackTrace();
           }
        }else{
            try{
                new File("memberlist.json").createNewFile();
            }catch(IOException e){
                System.err.println("Error reading book list from JSON: " + e.getMessage());
            }
           
        }
        
    }

   public void setLibraryJson(){
        try {
            mapper.writeValue(new File("library.json"), librarySetup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadLibraryJson() {
        if(new File("library.json").exists() && new File("library.json").canRead()){
            try {
                librarySetup = mapper.readValue(new File("library.json"), new TypeReference<Library>() {});
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
         
        }else{
            try{
                new File("library.json").createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void setBorrowBookListJson(){
        try {
            mapper.writeValue(new File("borrowBooklist.json"), borrowBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBorrowBookListJson()  {
        if(new File("borrowBooklist.json").exists() && new File("borrowBooklist.json").canRead()){
            try {
                borrowBook.addAll(mapper.readValue(new File("borrowBooklist.json"), new TypeReference<List<BorrowReturnBook>>() {}));
              } catch (IOException e) {
                  e.printStackTrace();
              }
        }else{
            try{
                new File("borrowBooklist.json").createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
       
    }

}
