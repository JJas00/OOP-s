package assignment;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chaitanyajerripothula
 */
public class Arithmetic implements Serializable{
    private final double operator1;
    private final double operator2;
    private final String operand;
    private int result;

    public Arithmetic(double o1, double o2, String op) {
        this.operator1 = o1;
        this.operator2 = o2;
        this.operand = op;
    }
    
    public double getResult() {
        
        try {
            switch(this.operand) {
                case "+" :
                    return this.operator1 + this.operator2;
                case "-" :
                    return this.operator1 - this.operator2;
                case "*" :
                    return this.operator1 * this.operator2;
                case "/" :
                    return this.operator1 / this.operator2;
            }
        } catch(Exception e) {
            return 0;
        }
        return 0;
    }
}
