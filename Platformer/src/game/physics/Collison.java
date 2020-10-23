package com.game.physics;
import com.game.objects.Block;

import java.awt.*;

public class Collison {
    public static boolean playerBlock(Point p, Block b){
        return b.contains(p);
    }

}
