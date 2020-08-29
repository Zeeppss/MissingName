package dev.zeeppss.missingname;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Listeners implements Listener {
    private Team team;
    private Scoreboard board;

    public Listeners(Main main, Team team, Scoreboard board) {
        Bukkit.getPluginManager().registerEvents(this, main);
        this.team = team;
        this.board = board;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        this.team.addEntry(e.getPlayer().getName());
        e.getPlayer().setScoreboard(this.board);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        this.team.removeEntry(e.getPlayer().getName());
    }
}
