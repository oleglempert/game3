package exm.retama.game3.data;

public class StepOutput extends Step {

    public StepOutput(Person person, int step, int result, long id) {
        super(person, step, result);
        this.id = id;
    }

    public StepOutput (Step step) {
        this(Person.fromString(step.getPlayer()), step.getStep(), step.getResult(), step. getId());
    }

    @Override
    public String toString() {
        return "StepOutput{} " + super.toString();
    }
}
