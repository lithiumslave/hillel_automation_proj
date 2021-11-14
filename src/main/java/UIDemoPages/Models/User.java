package UIDemoPages.Models;

public class User {
    private String userName;
    private String userPassword;

    private User() { }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public static class UserBuilder {
        private String userName;
        private String userPassword;

        public UserBuilder withUsername(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder withPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public User build() {
            User user = new User();
            user.userName = this.userName;
            user.userPassword = this.userPassword;
            return user;
        }
    }
}
