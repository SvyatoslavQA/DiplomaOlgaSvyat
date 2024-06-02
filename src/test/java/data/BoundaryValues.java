package data;

public enum BoundaryValues {

    EMPTY_NEGATIVE(0),
    START_POSITIVE(1),
    MIDDLE_POSITIVE(375),
    END_POSITIVE(750),
    RANGE_NEGATIVE(751);

    private int size;

    BoundaryValues(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
