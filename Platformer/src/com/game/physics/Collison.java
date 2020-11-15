package com.game.physics;
import com.game.objects.Block;
import com.game.objects.MovingBlocks;

import java.awt.*;

public class Collison {
    public static boolean playerBlock(Point p, Block b){
        return b.contains(p);
    }

    public static  boolean playerMovingBlock(Point p, MovingBlocks b){
        return b.contains(p);
    }
}
