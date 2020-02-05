import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 2/5/2020
 */


public class TeamResult {
    String name;
    int goal;
    int againstGoal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAgainstGoal() {
        return againstGoal;
    }

    public void setAgainstGoal(int againstGoal) {
        this.againstGoal = againstGoal;
    }
}
