package exm.retama.game3.data;

import java.util.Objects;

public class Start {

    private boolean flag;
    private PersonDto person;

    public Start(boolean flag, PersonDto person) {
        this.flag = flag;
        this.person = person;
    }

    public boolean isFlag() {
        return flag;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Start start = (Start) o;
        return flag == start.flag &&
                person == start.person;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, person);
    }

    @Override
    public String toString() {
        return "Start{" +
                "flag=" + flag +
                ", person=" + person +
                '}';
    }
}
