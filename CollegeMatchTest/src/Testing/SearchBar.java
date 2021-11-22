package Testing;

import java.util.ArrayList;
import java.util.Objects;

public class SearchBar {
    ArrayList<College> colleges;

    public SearchBar(ArrayList<College> colleges) {
        this.colleges = colleges;
    }

    public ArrayList<College> getCollegeReccomendations(UserProfile profile) {
        return getCollegeRecomendations(profile.GPA, profile.ACT, profile.SAT, profile.desired_location,profile.budget, profile.desired_major);
    }

    //This function will take parameters for the users GPA,ACT, SAT, desired location, budget, and desired major
    public ArrayList<College> getCollegeRecomendations(float GPA, int ACT, int SAT, String desired_location, int budget, String desired_major) {

// DataRetriever firebase = new DataRetriever();
// ArrayList<College> colleges_to_recommend = firebase.getCollegeList();

        ArrayList<College> colleges_to_recommend = colleges;
        // need to know the syntax for getting the list of colleges
        // we will have an arrayList called colleges_to_reccomend of objects called college.

        // removes colleges with .5 higher GPA than the user
        for (int i = colleges_to_recommend.size() - 1; i >= 0; i--) {
            if (colleges_to_recommend.get(i).getGPA() > (GPA + .3))
                colleges_to_recommend.remove(i);
        }
        if (colleges_to_recommend.size() == 0) {
            return colleges_to_recommend;
        }

        // removes colleges with 3 higher ACT score than the user
        for (int i = colleges_to_recommend.size() - 1; i >= 0; i--) {
            if (colleges_to_recommend.get(i).getACT() > (ACT + 3))
                colleges_to_recommend.remove(i);
        }
        if (colleges_to_recommend.size() == 0) {
            return colleges_to_recommend;
        }

        // removes colleges with 300 higher SAT score than the user
        for (int i = colleges_to_recommend.size() - 1; i >= 0; i--) {
            if (colleges_to_recommend.get(i).getSAT() > (SAT + 300))
                colleges_to_recommend.remove(i);
        }
        if (colleges_to_recommend.size() == 0) {
            return colleges_to_recommend;
        }

        // removes colleges that arent in the desried location that the user entered
        for (int i = colleges_to_recommend.size() - 1; i >= 0; i--) {
            if (!Objects.equals(colleges_to_recommend.get(i).getLocation(), desired_location))
                colleges_to_recommend.remove(i);
        }
        if (colleges_to_recommend.size() == 0) {
            return colleges_to_recommend;
        }

        // removes the colleges that are 1000 dollars over the per semester budget that
        // the user entered
        for (int i = colleges_to_recommend.size() - 1; i >= 0; i--) {
            if (colleges_to_recommend.get(i).getPPS() > (budget + 1000))
                colleges_to_recommend.remove(i);
        }
        if (colleges_to_recommend.size() == 0) {
            return colleges_to_recommend;
        }


        // removes the colleges that do not offer the desired major that the user enters
        for (int i = 0; i < colleges_to_recommend.size(); i++) {
            boolean found_major = false;
            ArrayList<String> majors = colleges_to_recommend.get(i).getMajors();
            for (String major : majors) {
                if (Objects.equals(desired_major, major)) {
                    found_major = true;
                }
            }
            if (!found_major) {
                colleges_to_recommend.remove(i);
            }
        }


        return colleges_to_recommend;
    }

}
