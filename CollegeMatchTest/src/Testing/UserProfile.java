package Testing;

public class UserProfile {
    float GPA;
    int ACT;
    int SAT;
    String desired_location;
    int budget;
    String desired_major;

    public UserProfile(float GPA, int ACT, int SAT, String desired_location,int budget,String desired_major){
        this.GPA = GPA;
        this.ACT = ACT;
        this.SAT = SAT;
        this.desired_location = desired_location;
        this.budget = budget;
        this.desired_major = desired_major;
        if (!(1.0f < this.GPA < 4.0f) || this.GPA == null) {
            throw new Exception("GPA must be between 1.0 and 4.0");
        }
        if (!(0 < this.ACT < 36) || this.ACT == null) {
            throw new Exception("ACT must be between 0 and 36");
        }
        if (!(400 < this.SAT < 1600) || this.SAT == null){
            throw new Exception("SAT score must be between 400 and 1600");
        }
        if (this.budget < 0 || this.budget == null) {
            throw new Exception("Budget must be greater than 0")
        }
        if (!(this.desired_location.length() > 0) || this.desired_location == null) {
            throw new Exception("Location must not be blank")
        }
        if (!(this.desired_major.length() > 0) || this.desired_major == null) {
            throw new Exception("Major must not be blank")
        }
    }
}
