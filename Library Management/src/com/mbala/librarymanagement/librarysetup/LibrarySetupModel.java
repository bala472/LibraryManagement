package com.mbala.librarymanagement.librarysetup;
import  com.mbala.librarymanagement.model.Library;
public class LibrarySetupModel {
    private LibrarySetupView librarySetupView;

    private Library libraryDetailsCheck = new Library();
   LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView = librarySetupView;
       // library.setLibraryName("Pennington Library");
       // library.setLibraryId(123);
    }
    public void startSetup() {
        if (libraryDetailsCheck.isFieldEmpty()) {
            librarySetupView.initiateSetup();
        } else {
            librarySetupView.onSetupComplete();
        }
    }
}
