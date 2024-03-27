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
        return true;
    }

    public List<Members> getMemberList() {
        return memberList;
    }

    public void removeMembers(int id) {
        for (Members members : memberList) {
            if (members.getId() == id) {
                memberList.remove(members);
                break;
            }
        }
    }
    //Object Mapper
    ObjectMapper mapper = new ObjectMapper();
    File file = new File("C:\\Users\\zoho\\IdeaProjects\\Library Management\\data.json");
    public void setBookListJson(List<Book> bookList) {
        try {
         //   ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(bookList);
            mapper.writeValue( new File("C:\\Users\\zoho\\IdeaProjects\\Library Management\\data.json"), jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBookListJson() {
        try {
          //  ObjectMapper mapper = new ObjectMapper();
           // mapper.writeValue(new File("C:\\Users\\zoho\\IdeaProjects\\Library Management\\data.json"),);
            List<Book> temp = mapper.readValue( new File("C:\\Users\\zoho\\IdeaProjects\\Library Management\\data.json"), new TypeReference<List<Book>>() {
            });
            bookList.addAll(temp);
        } catch (IOException e) {
            System.err.println("Error reading book list from JSON: " + e.getMessage());
        }
    }
    public void setMemberListJson(ArrayList<Members> memberList) throws IOException {
        try {
            String jsonData = mapper.writeValueAsString(memberList);
            mapper.writeValue(file, jsonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Members> getMemberListJson() throws IOException {
        try {
            return mapper.readValue(file, new TypeReference<List<Members>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Handle empty list or error
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

    public void setBorrowReturnBookListJson(ArrayList<BorrowReturnBook> borrowReturnBooksList) throws IOException {
        try {
            String jsonData = mapper.writeValueAsString(borrowReturnBooksList);
            mapper.writeValue(file, jsonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<BorrowReturnBook> getBorrowReturnBookListJson() throws IOException {
        try {
            return mapper.readValue(file, new TypeReference<List<BorrowReturnBook>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Handle empty list or error
        }
    }

}
