package main.otus.functional;


import java.util.Arrays;
import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {

        Optional<String> emptyOptional = Optional.empty();
        Optional<String> optionalWithValue = Optional.of("someValue");

        Optional<String> optionalWithNull = Optional.ofNullable(null);
        Optional<String> optionalWithNullMakesMoreNPE = Optional.of(null);

        if(emptyOptional.isPresent()){
            System.out.println("emptyOptional has value inside");
        }
        if(optionalWithValue.isPresent()){
            System.out.println("optionalWithValue has value inside");
        }
        if(optionalWithNull.isPresent()){
            System.out.println("optionalWithNull has value inside");
        }
// bring even more NPEs
//        if(optionalWithNullMakesMoreNPE.isPresent()){
//            System.out.println("optionalWithNull has value inside");
//        }

        Arrays.asList("John", "Ann", "John").stream().filter(name->name.length() > 4)
                .findFirst().orElse("kek");

//        Arrays.asList("John", "Ann", "John").stream().filter(name->name.length() > 14)
//                .findFirst()
//                .orElseThrow(RuntimeException::new);

        User user = new User(new Location("St Lenina"));

        if(user != null){
            if(user.getLocation() != null){
                if(user.getLocation().getAddress() != null){
                    System.out.println("finally I'm  not null!");
                }
            }
        }

        Optional.ofNullable(user).map(User::getLocation).map(Location::getAddress)
                .ifPresent(location-> System.out.println(location));

    }

    private static class User {
        Location location;

        public Location getLocation() {
            return location;
        }

        public User(Location location) {
            this.location = location;
        }
    }

    private static class Location {
        private String address;

        public String getAddress() {
            return address;
        }

        public Location(String address) {
            this.address = address;
        }
    }

}
