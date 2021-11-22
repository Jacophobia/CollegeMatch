package Testing;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<College> colleges = new ArrayList<>();

        ArrayList<String> majors = new ArrayList<>();
        majors.add("Computer Science");
        majors.add("English");
        College college1 = new College("BYU", 4.0f, 36, 1431, majors, 123456.0f, "West Coast");
        colleges.add(college1);

        ArrayList<String> majors2 = new ArrayList<>();
        majors.add("French");
        majors.add("Spanish");
        College college2 = new College("BYU Idaho", 2.0f, 10, 1000, majors2, 123456.0f, "West Coast");
        colleges.add(college2);

        SearchBar filter = new SearchBar(colleges);
        System.out.println(filter.getCollegeRecomendations(4.0f, 36, 1435, "West Coast", 1000000000, "French"));
        System.out.println(filter.getCollegeRecomendations(5.0f, 36, 1435, "West Coast", 1000000000, "Computer Science"));

    }
}
