package com.cat;

public class Users {
    private class Adress {
        private String phone;
        private String website;

        @Override
        public String toString() {
            return "Adress{" +
                    "phone='" + phone + '\'' +
                    ", website='" + website + '\'' +
                    '}';
        }
    }

    private class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    private int id;
    private String name;
    private String username;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Company company;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", adress=" + adress +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
