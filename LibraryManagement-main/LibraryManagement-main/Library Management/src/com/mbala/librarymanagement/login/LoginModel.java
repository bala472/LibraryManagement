package com.mbala.librarymanagement.login;

 class LoginModel {
    public LoginView loginView;
        LoginModel(LoginView loginView){
            this.loginView= loginView;
        }
    public String validateUser(String userName,String password){
        if(validateUserName(userName)){
            if(validatePassword(password)){
                return "Logged in Sucessfully";
            }else{
                return "Invalid Password";
            }
        }
            return "Invalid User Name";
    }
    private boolean validateUserName(String userName){
        return userName.equals("bala472");
    }
    private boolean validatePassword(String password){
        return password.equals("123456789");
    }
}
