package main.otus.annotations.usage;

import main.otus.annotations.Email;
import main.otus.annotations.Immutable;
import main.otus.annotations.NonEmpty;
import main.otus.annotations.Unfinished;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"ResultOfMethodCallIgnored", "UnusedReturnValue"})
@Deprecated                                       //ElementType.TYPE
@Unfinished(
        priority = Unfinished.Priority.LOW,
        value = "too old to rock too young to die",
        lastChanged = "2018-07-26",
        lastChangedBy = "tully"
)
public class Main<T extends @Email String> {                        //ElementType.TYPE_USE
    @SuppressWarnings({"unused", "FieldCanBeLocal"})                //ElementType.FIELD
    private final int size;

    @Deprecated                                                     //ElementType.CONSTRUCTOR
    public Main(int size) {
        this.size = size;
    }

    @Deprecated                                                     //ElementType.METHOD
    public static void main(@Immutable String... args) {            //ElementType.PARAMETER
        @Immutable List<String> list =                              //ElementType.LOCAL_VARIABLE
                new @NonEmpty ArrayList<>();                        //ElementType.TYPE_USE

        Main.<@Email String>cast(list);                             //ElementType.TYPE_USE
    }

    private static <@Immutable E> E cast(Object object) {           //ElementType.TYPE_PARAMETER
        //noinspection unchecked
        return (E) object;
    }
}
