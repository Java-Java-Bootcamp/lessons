package main.otus.functional;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
// simple
        List<String> users = Arrays.asList("James", "Ann");
        List<String> shortUsersWithPrefix = users.stream()
                .map(user -> "mr" + user)
                .filter(userWithPrefix -> userWithPrefix.length() <= 5)
                .collect(Collectors.toList());

        System.out.println(shortUsersWithPrefix);
// flatMap

        UserWrapper userWrapper1 = new UserWrapper(Arrays.asList("John", "Ann", "John"));
        UserWrapper userWrapper2 = new UserWrapper(Arrays.asList("Peter", "James"));
        List<UserWrapper> wrappers = Arrays.asList(userWrapper1, userWrapper2);

        List<String> names = wrappers.stream()
                .flatMap(wrapper->wrapper.getUsers().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(names);

        List<Integer> numbers = Arrays.asList(1,2);
        Integer sum = numbers.stream().reduce(10, (integer, integer2) -> integer + integer2);
        System.out.println("sum with default 10");

    }

    public static class UserWrapper {
        List<String> users;

        public UserWrapper(List<String> users) {
            this.users = users;
        }

        public List<String> getUsers() {
            return users;
        }

        public void setUsers(List<String> users) {
            this.users = users;
        }
    }
}
