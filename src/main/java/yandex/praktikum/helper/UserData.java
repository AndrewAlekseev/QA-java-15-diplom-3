package yandex.praktikum.helper;

import yandex.praktikum.Constructor.User;

public class UserData {
    public static User defaultUserData() {
        return new User("Andrey", "andrey_15@gmail.com", "121314");
    }
    public static User defaultUserLogin() {
        return new User("andrey_15@gmail.com","121314");
    }
    public static User userDataIncorrectPassword() {
        return new User("Andrey", "andrey_15@gmail.com", "123");
    }
    public static User userDataNullName() {
        return new User(null, "andrey_15@gmail.com", "121314");
    }
    public static User userDataNullEmail() {
        return new User("Andrey", null, "121314");
    }
    public static User userDataNullPassword() {
        return new User("Andrey", "andrey_15@gmail.com", null);
    }
}
