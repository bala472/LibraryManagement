package com.mbala.librarymanagement.librarysetup;
import  com.mbala.librarymanagement.model.Library;
import com.mbala.librarymanagement.datalayer.DataLayer;
public class LibrarySetupModel {
    private LibrarySetupView librarySetupView;

    
   LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView = librarySetupView;
    }
    public void startSetup() {
        
           if(DataLayer.getInstance().getLibrarySetup()==null) {
            librarySetupView.initiateSetup();
           }
        else {
            librarySetupView.onSetupComplete();
        }
    }
    public void addLibraryList(Library library){
        DataLayer.getInstance().setLibrarySetup(library);
        DataLayer.getInstance().setLibraryJson(library);
    }
}
