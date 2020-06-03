package exm.retama.game3.data;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Stream.of;

public enum Person {

    COMPUTER("computer"),
    HUMAN("human");

    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public PersonDto toDto () {
        return valueOf(PersonDto.class, this.name());
    }

    public static Person fromString (String name) {
        return Optional
                .ofNullable(FORMAT_MAP.get(name))
                .orElseThrow(() -> new IllegalArgumentException(name));
    }

    private static Map<String, Person> FORMAT_MAP = of(Person.values())
            .collect(Collectors.toMap(s -> s.toString(), Function.identity()));
}
