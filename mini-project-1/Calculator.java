package org.example;
import java.util.Scanner;

public class Calculator{

    public double addNum(double x, double y){
        return x + y;
    }

    public double sbtrctNum(double x, double y){
        return x - y;
    }

    public double divideNum(double x, double y){

        if (x != 0 || y != 0){
            return x / y;
        }
        else {
            return -1;
        }

    }

    public double mltpyNum(double x, double y){
        return x * y;
    }

}
