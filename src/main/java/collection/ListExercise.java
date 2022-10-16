package collection;

import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    private List<String> students = new ArrayList<>();

    public ListExercise() {
        this.students.add("최승철");
    }

    public List<String> getStudents() {
        return this.students;
    }
}
