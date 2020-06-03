package exm.retama.game3.validator;

public enum FailedValue {
    STEP("Step"),
    RETURNED_VALUE("Result"),
    NA("NA");

    String name ;

    FailedValue (String name) {
        this.name = name;
    }


    public void throwException() {
        if (this == NA) return ;
        throw new IllegalArgumentException("Illegal value for " + this.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
