import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public final class SortStudentList {

    private SortStudentList() {
		

    }
	
	
 
    public static void sortIDIncrease(final ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(final Student o1, final Student o2) {
                return Integer.compare(o1.getID(), o2.getID());
            }
        });
    }


    public static void sortIDDecrease(final ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(final Student o1, final Student o2) {
                return Integer.compare(o2.getID(), o1.getID());
            }
        });
    }
	
	


    public static void sortScoreIncrease(final ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(final Student o1, final Student o2) {
                return Float.compare(o1.getMarks(), o2.getMarks());
            }

        });
    }


    public static void sortScoreDecrease(final ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(final Student o1, final Student o2) {
                return Float.compare(o2.getMarks(), o1.getMarks());
            }

        });
    }
}