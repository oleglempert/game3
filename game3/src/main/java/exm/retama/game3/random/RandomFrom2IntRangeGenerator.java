package exm.retama.game3.random;


import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;
import java.util.Random;

public class RandomFrom2IntRangeGenerator implements RandomGenerator{
    private final static int MIN = 2;

    private int max;

    public RandomFrom2IntRangeGenerator(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomFrom2IntRangeGenerator that = (RandomFrom2IntRangeGenerator) o;
        return max == that.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max);
    }

    @Override
    public String toString() {
        return "RandomFrom2IntRangeGenerator{" +
                "max=" + max +
                '}';
    }

    @Override
    public int generate() {
        return new Random().nextInt((max - MIN) + 1) + MIN;
    }
}
