package exm.retama.game3.data;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Entity
public class Step extends StepDto {
    @Id
    @GeneratedValue
    protected long id;

    private String player;


    public Step() {
    }

    public Step(Person person, int step, int result) {
        super(step, result);
        player = person.toString();
    }

    public Step (StepDto step) {
        this(Person.HUMAN, step.getStep(), step.getResult());
    }

    public long getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Step step = (Step) o;
        return id == step.id &&
                Objects.equals(player, step.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, player);
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", player='" + player + '\'' +
                "} " + super.toString();
    }
}
