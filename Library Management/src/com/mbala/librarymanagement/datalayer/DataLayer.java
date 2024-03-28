package com.mbala.librarymanagement.datalayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.model.Library;
import com.mbala.librarymanagement.model.Members;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Book> bookList = new ArrayList<>();
    private List<Members> memberList = new ArrayList<>();
    private List<Library> librarySetup = new ArrayList<>();
    private List<BorrowReturnBook> borrowBook = new ArrayList<>();


    public List<BorrowReturnBook> getBorrowBookList() {
        return borrowBook;
    }

    public void setBorrowBook(BorrowReturnBook borrowBook) {
        this.borrowBook.add(borrowBook);
    }

    public List<Library> getLibrarySetup() {
        return librarySetup;
    }

    public void setLibrarySetup(Library libraryDetails) {
        librarySetup.add(libraryDetails);
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

    public Book searchBookById(int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
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
       file.delete();
        setBookListJson(bookList);
        return true;
    }

    public boolean isNewMember(Members members) {
        for (Members check : memberList) {
            if (check.getName().equals(members.getName()) && check.getId() == members.getId()) {
                return false;
            }
        }
        memberList.add(members);
        new File("member.json").delete();
        setMemberListJson(memberList);
        return true;
    }

    public List<Members> getMemberList() {
        return memberList;
    }

    public void removeMembers(int id) {
        for (Members members : memberList) {
            if (members.getId() == id) {
                memberList.remove(members);
                new File("member.json").delete();
                setMemberListJson(memberList);
                break;
            }
        }
    }
    //Object Mapper
    ObjectMapper mapper = new ObjectMapper();
    File file = new File("book.json");
    public void setBookListJson(List<Book> bookList) {
        try {
            mapper.writeValue( file, bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBookListJson() {
        try {
            List<Book> temp = mapper.readValue( file, new TypeReference<List<Book>>() {
            });
            bookList.addAll(temp);
        } catch (IOException e) {
            System.err.println("Error reading book list from JSON: " + e.getMessage());
        }
    }
    public void setMemberListJson(List<Members> memberList)  {
        try {
            mapper.writeValue(new File("member.json"), memberList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMemberListJson() {
        try {
             List<Members> temp =mapper.readValue(new File("member.json"), new TypeReference<List<Members>>() {
            });
             memberList.addAll(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLibraryListJson(ArrayList<Library> libraryList) throws IOException {
        try {
            String jsonData = mapper.writeValueAsString(libraryList);
            mapper.writeValue(file, jsonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Library> getLibraryListJson() throws IOException {
        try {
            return mapper.readValue(file, new TypeReference<List<Library>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Handle empty list or error
        }
    }

    public void setBorrowBookListJson(List<BorrowReturnBook> borrowBook){
        try {
            mapper.writeValue(new File("borrowBook.json"), borrowBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBorrowBookListJson()  {
        if(new File("borrowBook.json").length()==0)
            bookList.add(new Book());
        try {
          borrowBook.addAll(mapper.readValue(new File("borrowBook.json"), new TypeReference<List<BorrowReturnBook>>() {}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
