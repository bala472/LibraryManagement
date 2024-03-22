package com.mbala.librarymanagement.librarysetup;
import  com.mbala.librarymanagement.model.Library;
import com.mbala.librarymanagement.datalayer.DataLayer;
public class LibrarySetupModel {
    private LibrarySetupView librarySetupView;

    
   LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView = librarySetupView;
    }
    public void startSetup() {
        
           if(DataLayer.getInstance().getLibrarySetup().size()==0) {
            librarySetupView.initiateSetup();
           }
        else {
            librarySetupView.onSetupComplete();
        }
    }
    public void addLibraryList(Library object){
        DataLayer.getInstance().setLibrarySetup(object);
    }
}
