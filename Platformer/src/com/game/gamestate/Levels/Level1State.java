package com.game.gamestate.Levels;

import com.game.entities.Player;
import com.game.gamestate.Game.GameState;
import com.game.gamestate.Game.GameStateManager;
import com.game.mapping.Map;

import java.awt.Graphics;

import static com.game.entities.Player.level_counter;

public class Level1State extends GameState {

    private Player player;
    private Map map;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        if (level_counter == 1)
            map = new Map("/res/Maps/map1.map");
        else if (level_counter == 2)
            map = new Map("/res/Maps/map2.map");

            player = new Player(30, 30);
            xOffset = 0;
            yOffset = 0;
    }

    @Override
    public void tick() {

        player.tick(map.getBlocks());
    }

    @Override
    public void draw(Graphics g) {
        map.draw(g);
        player.draw(g);
    }

    @Override
    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        player.keyReleased(k);
    }
}
