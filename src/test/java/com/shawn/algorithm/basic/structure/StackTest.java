package com.shawn.algorithm.basic.structure;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StackTest {



    @Test
    public void testArrayBasedStack(){
        stackOperation(new ArrayStack<>());
    }


    @Test
    public void testLinkedListBasedStack(){
        stackOperation(new LinkedListStack<>());
    }

    /**
     * test stacks for the basic operaitons ( push, pop, isEmpty and size)
     */
    public void stackOperation(Stack<Integer> stack) {
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, (int) stack.pop());
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }




    /**
     * test stack iterator,
     */
    @Test
    public void testStackIterator() {
        //ArrayStack<Integer> stack = new ArrayStack<>(10);
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            assertEquals(it.next(), stack.pop());
        }

        stack.push(10);
        stack.push(20);
        stack.push(30);
        for (Integer e : stack) {
            assertTrue(e > 0);
        }
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testFailIfOutOfBound() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.pop();
    }

    /**
     * using two stack to implement a simple arithmetic operation
     * <p/>
     * one stack for values and the other for operators
     * <p/>
     * when occurring a left parenthesize ,ignore and continue
     * when occurring a number or operator, put it in corresponding stacks
     * when occurring a right parenthesize, pause, pop two values and one operator, put result
     * back to the value stack, and continue.
     */
    @Test
    public void testStackUsedForSimpleArithmetic() {
        Stack<Operator> operators = new LinkedListStack<>();
        Stack<Double> values = new LinkedListStack<>();

        Iterator<String> str = getEquationData().iterator();

        while (str.hasNext()) {
            String s = str.next();
            if (s.equals(Operator.left.getOperatorString())) ;
            else if (Operator.operators.containsKey(s)) {
                operators.push(Operator.operators.get(s));
            } else if (s.equals(Operator.right.getOperatorString())) {
                Operator operator = operators.pop();
                double value = values.pop();
                value = operator.operation(value, values.pop());
                values.push(value);
            } else {
                values.push(Double.parseDouble(s));
            }

        }

        assertEquals(101.0, values.pop(), 0.1);
    }

    private Iterable<String> getEquationData() {
        String equation = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        //String equation = " (( 5 + 2 ) + 2 )";
        return Splitter.on(" ").split(equation);
    }

}

enum Operator {
    plus("+") {
        @Override
        double operation(Double value, Double value0) {
            return value + value0;
        }
    }, subtract("-") {
        @Override
        double operation(Double value, Double value0) {
            return value - value0;
        }
    }, multiply("*") {
        @Override
        double operation(Double value, Double value0) {
            return value * value0;
        }
    }, divide("/") {
        @Override
        double operation(Double value, Double value0) {
            return value / value0;
        }
    }, right(")"), left("(");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperatorString() {
        return operator;
    }

    public static ImmutableMap<String, Operator> operators = ImmutableMap.of("+", plus, "-", subtract, "*", multiply, "/", divide);

    double operation(Double value, Double value0) {
        return 0;
    }

    ;
}