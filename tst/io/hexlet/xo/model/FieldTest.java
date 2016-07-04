package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;
import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final Field field = new Field();

        assertEquals(3,field.getSize());
    }
    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }

    @Test
    public void GetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }
    @Test
    public void GetFigureWhenFigureXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        try{
            field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }
    @Test
    public void GetFigureWhenFigureYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        try{
            field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }
    @Test
    public void GetFigureWhenFigureXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize()+1,0);
        try{
            field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }
    @Test
    public void GetFigureWhenFigureYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize()+1);
        try{
            field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}
    }
}











