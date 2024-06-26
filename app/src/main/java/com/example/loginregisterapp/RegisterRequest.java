package com.example.loginregisterapp;

public class RegisterRequest {

        private String fullName;
        private String email;
        private String password;
        private String role;
        private int isGoogleAuth=0;

        // Getter and Setter methods for fullName
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        // Getter and Setter methods for email
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Getter and Setter methods for password
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Getter and Setter methods for role
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        // Getter and Setter methods for isGoogleAuth
        public int getIsGoogleAuth() {
            return isGoogleAuth;
        }

        public void setIsGoogleAuth(int isGoogleAuth) {
            this.isGoogleAuth = isGoogleAuth;
        }


}
