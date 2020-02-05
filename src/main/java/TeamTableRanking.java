import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 2/5/2020
 */

public class TeamTableRanking {
    int rank;
    String name;
    String forAgainst;
    int Gd;
    int point;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForAgainst() {
        return forAgainst;
    }

    public void setForAgainst(String forAgainst) {
        this.forAgainst = forAgainst;
    }

    public int getGd() {
        return Gd;
    }

    public void setGd(int gd) {
        Gd = gd;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
