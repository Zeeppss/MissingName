package dev.zeeppss.missingname;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

public class Main extends JavaPlugin {
    public Main() {
    }

    public void onEnable() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team team = board.registerNewTeam("Team");
        team.allowFriendlyFire();
        team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
        new Listeners(this, team, board);
    }
}
