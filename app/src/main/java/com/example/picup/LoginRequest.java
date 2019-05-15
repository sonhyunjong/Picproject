package com.example.picup;

 public class LoginRequest {

      private final  String userId;

private final String userPassword;

     public LoginRequest(String userId, String userPassword) {
         this.userId = userId;
         this.userPassword = userPassword;
     }


         public String getUserId() {
            return userId;
        }
        public String getUserPassword() {
         return userPassword;
     }



        @Override
        public String toString() {
            return "ID:"+this.getUserId()+" , PASSWORD: "+ this.getUserPassword();
        }


        public static class LoginActivity {
        }
}
