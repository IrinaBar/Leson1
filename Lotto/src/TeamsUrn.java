import java.util.Random;

public class TeamsUrn {

    private final String name;
    private TeamFlag[] teamFlags = new TeamFlag[0];
    private final Random random = new Random();

    public TeamsUrn(String name) {
        this.name = name;
    }
    
    void enterTeamFlags(TeamFlag... teamFlags) {
        TeamFlag[] flags = this.teamFlags;
        this.teamFlags = new TeamFlag[this.teamFlags.length + teamFlags.length];
        System.arraycopy(flags, 0, this.teamFlags, 0, flags.length);
        System.arraycopy(teamFlags, 0, this.teamFlags, flags.length, teamFlags.length);
    }
    
    TeamFlag drawTeamFlag() {
        if (teamFlags.length == 0) {
            return null;
        }
        int randomIndex = random.nextInt(teamFlags.length);
        TeamFlag flag = teamFlags[randomIndex];
        TeamFlag[] flags = teamFlags;
        teamFlags = new TeamFlag[teamFlags.length - 1];
        if (randomIndex > 0) {
            System.arraycopy(flags, 0, teamFlags, 0, randomIndex);
        }
        System.arraycopy(flags, randomIndex + 1, teamFlags, randomIndex, flags.length - 1 - randomIndex);
        return flag;
    }
    
    public int getNumberOfTeamFlags() {
        return this.teamFlags.length;
    }
    
}
