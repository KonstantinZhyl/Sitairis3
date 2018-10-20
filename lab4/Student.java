package XMLsaxParser;

public class Student {
    String firstname;
    String lastname;
    boolean form;
    int id;
    int mathMark;
    int physicsMark;
    int russianMark;

    @Override
    public String toString() {
        String ans = firstname + " " + lastname + ", группа "
                + Integer.toString(id);
        if (form) {
            ans += " бюджетник\n";
        }
        else {
            ans += " платник\n";
        }
        ans += "Математика: " + Integer.toString(mathMark) + "\n";
        ans += "Физика: " + Integer.toString(physicsMark) + "\n";
        ans += "Русский: " + Integer.toString(russianMark);
        return ans;
    }
}
