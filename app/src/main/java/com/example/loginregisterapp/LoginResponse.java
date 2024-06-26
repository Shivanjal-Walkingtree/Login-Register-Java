package com.example.loginregisterapp;

import java.io.Serializable;

public class LoginResponse implements Serializable {

        private String status;
        private int statusCode;
        private String message;
        private Data data;

        // Getter and Setter methods for status
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        // Getter and Setter methods for statusCode
        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        // Getter and Setter methods for message
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        // Getter and Setter methods for data
        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public static class Data implements Serializable {
            private String userId;
            private String fullName;
            private String email;
            private String role;

            // Getter and Setter methods for userId
            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

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

            // Getter and Setter methods for role
            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }
}
