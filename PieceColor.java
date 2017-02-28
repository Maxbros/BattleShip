package com.company;

public enum PieceColor { WHITE(){
    public String abbreviation(){ return "W"; }
},

    BLACK(){
        public String abbreviation(){ return "B"; }
    },

    COLOR_UNKNOWN(){
        public String abbreviation(){ return "D"; }
    };

    public abstract String abbreviation(  );
}
