package exm.retama.game3.data;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public enum PersonDto {
    COMPUTER("computer"),
    HUMAN("human");

    String name;

    PersonDto(String name) {
        this.name = name;
    }

    private static Map<String, PersonDto> FORMAT_MAP = of(PersonDto.values())
            .collect(Collectors.toMap(s -> s.toString(), Function.identity()));

    @JsonCreator
    public static PersonDto fromString(String string) {
        return Optional
                .ofNullable(FORMAT_MAP.get(string))
                .orElseThrow(() -> new IllegalArgumentException(string));
    }

    @Override
    public String toString() {
        return name;
    }

    public Person toData () {
        return valueOf(Person.class, this.name());
    }
}
