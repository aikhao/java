package com.whiskdev.my.properties;


public class Users extends PropertiesProvider {

    public static User customer = new User();

    static {
        customer.setLogin(getUserLogin("customer"));
        customer.setPassword(getUserPassword("customer"));
    }

    public static class User {
        public String login;
        public String password;

        private void setLogin(String login) {
            this.login = login;
        }

        private void setPassword(String password) {
            this.password = password;
        }

        private String getLogin() {
            return this.login;
        }

        private String getPassword() {
            return this.password;
        }
    }
}
