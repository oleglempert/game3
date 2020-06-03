package exm.retama.game3.data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class StepDto implements Serializable {

    @Min(value = -1, message = "wrong step parameter . Value should more than -1")
    @Max(value = 1, message = "wrong step parameter . Value should less than 1")
    private int step;
    private int result;

    public StepDto() {
    }

    public StepDto(int step, int result) {
        this.step = step;
        this.result = result;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepDto stepDto = (StepDto) o;
        return step == stepDto.step &&
                result == stepDto.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, result);
    }

    @Override
    public String toString() {
        return "StepDto{" +
                "step=" + step +
                ", result=" + result +
                '}';
    }
}
