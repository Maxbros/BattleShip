package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;

/**
 * Created by gkwh on 06/04/2016.
 */

enum Column { UNKNOW,  A, B, C , D , E, F, G, H, I, J, K, L;
    public static Column fromInt(int i)
    {
        return Column.values()[i];
    }
};

enum Row { UNKNOW, ONE, TWO, THREE ,FOUR , FIVE, SIX, SEVEN, EIGHT,NINE, TEN, ELEVEN,TWELVE;
    public static Row fromInt(int i)
    {
        return Row.values()[i];
    }
};

public class Position
{
    private Column x;
    private Row y;


    Position( Position thePosition )
    {
        y = thePosition.y;
        x = thePosition.x;
    }

    Position( Row theRow, Column theColumn )
    {
        y = theRow;
        x = theColumn;
    }


    Position( String  strPosition )
    {
        try {
            y = Row.values()[(Integer.parseInt(strPosition.substring(1, 2)))];
            x = Column.valueOf(strPosition.substring(0, 1));
        }catch ( IllegalArgumentException e  ){
            x = Column.UNKNOW;
            y = Row.UNKNOW;
        }
    }

    public Row getRow()
    {
        return  y;
    }

    public Column getColumn()
    {
        return  x;
    }


    void setPosition( Position thePosition )
    {
        x =  thePosition.x;
        y = thePosition.y;
    }

    Position getPosition()
    {
        return new Position(y,x);
    }

    public boolean isPositionUnknow()
    {
        return  x == Column.UNKNOW || y == Row.UNKNOW;
    }

    static List<Position> generateIntermediatePositions( Position From, Position To )
    {
        List<Position> thePositions = new ArrayList<>();

        int x = From.getRow().ordinal();
        int y = From.getColumn().ordinal();
        int dx = From.getColumn().ordinal() -  To.getColumn().ordinal();
        int dy = From.getRow().ordinal() -  To.getRow().ordinal();

        int distance = (int) From.distanceTo( To );

        for( int i=1; i<distance; ++i)
        {
            x += dx;
            y += dy;
            Position cellPath = new Position( Row.fromInt( x ), Column.fromInt( y )  );
            thePositions.add( cellPath );
        }

        return thePositions;
    }





    public String toString()
    {
        if( isPositionUnknow() ) return "UNKNOW";

        return "" + x + (y.ordinal());
    }

    public boolean equals(Object object2)
    {
        if( object2 == null )
            return false;
        if( object2 == this )
            return true;
        if( object2.getClass() != getClass() )
            return false;

        Position position = (Position) object2;

        return toString().equals( ((Position)object2).toString());
    }

    public int hashCode(){ return toString().hashCode(); }

}



