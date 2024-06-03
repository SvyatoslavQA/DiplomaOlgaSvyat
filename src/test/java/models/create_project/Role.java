package models.create_project;

public enum Role {

    NO_ACCESS(0,"No Access"),
    GLOBAL(1,"Global_Role"),
    READ_ONLY(2,"Read_Only"),
    TESTER(3,"Tester"),
    DESIGNER(4,"Designer"),
    LEAD(5,"Lead");

    private int id;
    private String title;

    Role(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
