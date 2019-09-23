package com.example.algorithms.math;

public enum Roman {

    I("I"),V("V"),X("X"),L("L"),C("C"),D("D"),M("M")
    ,IV("IV"),IX("IX"),XL("XL"),XC("XC"),CD("CD"),CM("CM");

    private String roman;

    //枚举类型的构造函数默认为private，因为枚举类型的初始化要在当前枚举类中完成。
    Roman (String roman){
        this.roman= roman;
    }

    public String getRoman(){
        return roman;
    }
}
