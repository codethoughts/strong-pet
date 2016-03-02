package Model.Enums;

public enum GenderType {
    male("male"), female("female");
    private String gender;
    private GenderType(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
