package com.company;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 20/02/2017.
 */


enum TypeShip { UNKNOW,  Portaviones, Acorazado, Patrulla;
    public static TypeShip fromInt(int dimension)
    {
        TypeShip theType = TypeShip.UNKNOW;

        switch (dimension)
        {
            case 5:
                theType = TypeShip.Portaviones;
            case 3:
                theType = TypeShip.Acorazado;
            case 1:
                theType = TypeShip.Patrulla;
        }

        return theType;
};

public class BattleShipPiece {
    boolean isAlive = false;
    PieceColor color = PieceColor.COLOR_UNKNOWN;
    List<Position> positions;
    String name;

    BattleShipPiece (PieceColor theColor,String theName,Position from,Position to){
        isAlive = True;
        color = theColor;
        name = theName;
        positions = Position.generateIntermediatePositions(from,to);
    }

    PieceColor getColor () {
        return color;
    }

    public String getName() {
        return name;
    }
   Boolean isSunken (){
        isAlive = true;

   }
}
