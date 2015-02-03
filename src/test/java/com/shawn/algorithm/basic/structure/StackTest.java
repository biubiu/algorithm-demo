package com.shawn.algorithm.basic.structure;

import com.google.common.collect.ImmutableMap;
import com.shawn.algorithm.helper.StdIn;
import junit.framework.TestCase;
import org.junit.Test;

public class StackTest extends TestCase {



    @Test
    public void testStackUsedForSimpleArithmetic(){
         Stack<Operator> operators = new Stack<>();
         Stack<Double> values = new Stack<>();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals(Operator.left.getOperatorString())) ;
            else if(Operator.operators.containsKey(s)){
                operators.push(Operator.operators.get(s));
            } else if (s.equals(Operator.right.getOperatorString())) {
                Operator operator = operators.pop();
                double value = values.pop();
                value = operator.operation(value, values.pop());
                values.push(value);
            }  else {
                values.push(Double.parseDouble(s));
            }

        }
    }

}

enum Operator{
    plus("+") {
        @Override
        double operation(Double value, Double value0) {
            return value + value0;
        }
    },subtract("-") {
        @Override
        double operation(Double value, Double value0) {
            return value - value0;
        }
    },multiply("*") {
        @Override
        double operation(Double value,Double value0) {
            return value * value0;
        }
    },divide("/") {
        @Override
        double operation(Double value, Double value0) {
            return value / value0;
        }
    },right("("),left(")");

    String operator;
    Operator(String operator){
    }

    public String getOperatorString(){
        return operator;
    }

    public static ImmutableMap<String,Operator> operators = ImmutableMap.of("+",plus,"-",subtract,"*",multiply,"/",divide);

    double operation(Double value, Double value0){ return 0;};
}