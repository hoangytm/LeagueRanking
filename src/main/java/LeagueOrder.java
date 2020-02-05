import java.util.*;

/**
 * @author PhanHoang
 * 2/5/2020
 */
public class LeagueOrder {
    public static void main(String[] args) {
        int number = 6;
        int[][] games = new int[][]
                {{0, 5, 2, 0},
                        {1, 4, 2, 2},
                        {2, 3, 1, 3},
                        {1, 5, 0, 0},
                        {2, 0, 2, 1},
                        {3, 4, 3, 1}};


//        List<TeamResult> teamResults = getMapResult(games, String.valueOf(5));
        List<TeamTableRanking> listResultNoRanking = new ArrayList<TeamTableRanking>();
        for (int i = 0; i < number; i++) {
            List<TeamResult> teamResults = getMapResult(games, String.valueOf(i));
            TeamTableRanking teamTableRanking = teamTableRanking(teamResults);
            listResultNoRanking.add(teamTableRanking);
        }
        List<TeamTableRanking> finalResult = sortRanking(listResultNoRanking);
        int rankingResult[] = new int[number];
        for (int j = 0; j < number; j++) {
            for (TeamTableRanking teamTableRanking : finalResult) {
                if (String.valueOf(j).equals(teamTableRanking.getName())) rankingResult[j] = teamTableRanking.getRank();

            }
            System.out.println(rankingResult[j]);
        }
        System.out.println("success");
    }

    // home result and away result of team A
    public static List<TeamResult> getMapResult(int[][] resultList, String teamName) {
        List<TeamResult> teamResults = new ArrayList<TeamResult>();
        for (int[] result : resultList) {
            TeamResult teamResult = new TeamResult();
            if (teamName.equals(String.valueOf(result[1]))) {
                teamResult.setName(String.valueOf(result[1]));
                teamResult.setGoal(result[3]);
                teamResult.setAgainstGoal(result[2]);
                teamResults.add(teamResult);
            }
            if (teamName.equals(String.valueOf(result[0]))) {
                teamResult.setName(String.valueOf(result[0]));
                teamResult.setGoal(result[2]);
                teamResult.setAgainstGoal(result[3]);
                teamResults.add(teamResult);
            }

        }
        return teamResults;
    }

    public static TeamTableRanking teamTableRanking(List<TeamResult> teamResults) {
        TeamTableRanking teamTableRanking = new TeamTableRanking();
        int point = 0;
        int gd = 0;
        int goal = 0;
        int goalAgainst = 0;
        for (TeamResult teamResult : teamResults) {
            teamTableRanking.setName(teamResult.getName());
            if (teamResult.getGoal() > teamResult.getAgainstGoal()) point += 2;
            if (teamResult.getGoal() == teamResult.getAgainstGoal()) point += 1;
            goal = goal + teamResult.getGoal();
            gd = gd + teamResult.getGoal() - teamResult.getAgainstGoal();


        }
        teamTableRanking.setForAgainst(String.valueOf(goal) + ":" + String.valueOf(goalAgainst));
        teamTableRanking.setPoint(point);
        teamTableRanking.setGd(gd);
        return teamTableRanking;
    }

    public static List<TeamTableRanking> sortRanking(List<TeamTableRanking> teamTableRankings) {
        List<TeamTableRanking> newTeamTableRankings = new ArrayList<TeamTableRanking>();
        for (TeamTableRanking teamTableRanking : teamTableRankings) {
            teamTableRanking.setRank(1);

            for (TeamTableRanking teamTableRanking1 : teamTableRankings) {
                if (teamTableRanking.getName() != teamTableRanking1.getName()) {
                    if (teamTableRanking.getPoint() < teamTableRanking1.getPoint())
                        teamTableRanking.setRank(teamTableRanking.getRank() + 1);
                    if (teamTableRanking.getPoint() == teamTableRanking1.getPoint()) {
                        if (teamTableRanking.getGd() < teamTableRanking1.getGd())
                            teamTableRanking.setRank(teamTableRanking.getRank() + 1);
                    }
                }
            }
            newTeamTableRankings.add(teamTableRanking);
//            teamTableRankings.remove(teamTableRanking);

        }

        return newTeamTableRankings;
    }

}
