package br.com.cit.dojo.diamond;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DiamondBuilderTest {
    protected DiamondBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new DiamondBuilder();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBuildWithCharA() {
        assertEquals("A", builder.build('A'));
        assertEquals("A", builder.build('a'));
    }
    
    @Test
    public void testBuildWithCharB() {
        String diamond = " A"  + String.format("%n") +
        		         "B B" + String.format("%n") +
        		         " A";
                
        assertEquals(diamond, builder.build('B'));
        assertEquals(diamond, builder.build('b'));
    }
    
    @Test
    public void testBuildWithCharE() {
        String diamond = "    A"  + String.format("%n") +
                         "   B B" + String.format("%n") +
                         "  C   C" + String.format("%n") +
                         " D     D" + String.format("%n") +
                         "E       E" + String.format("%n") +
                         " D     D" + String.format("%n") +
                         "  C   C" + String.format("%n") +
                         "   B B" + String.format("%n") +
                         "    A";
        
        assertEquals(diamond, builder.build('E'));
        assertEquals(diamond, builder.build('e'));
    }
    
    @Test
    public void testDistanceToRootLetter() {
        assertEquals(0, builder.distanceToRootLetter('A'));
        assertEquals(0, builder.distanceToRootLetter(builder.ROOT_LETTER));
        assertEquals(1, builder.distanceToRootLetter('B'));
        assertEquals(2, builder.distanceToRootLetter('C'));
        assertEquals(3, builder.distanceToRootLetter('D'));
        assertEquals(4, builder.distanceToRootLetter('E'));
        assertEquals(5, builder.distanceToRootLetter('F'));        
    }
    
    @Test
    public void testSpacesInTheMiddle() {
        assertEquals(0, builder.getNumberOfSpacesBetweenLetter('A'));
        assertEquals(0, builder.getNumberOfSpacesBetweenLetter(builder.ROOT_LETTER));
        assertEquals(1, builder.getNumberOfSpacesBetweenLetter('B'));
        assertEquals(3, builder.getNumberOfSpacesBetweenLetter('C'));
        assertEquals(5, builder.getNumberOfSpacesBetweenLetter('D'));
        assertEquals(7, builder.getNumberOfSpacesBetweenLetter('E'));
        assertEquals(9, builder.getNumberOfSpacesBetweenLetter('F'));
    }
    
    @Test
    public void testSpacesBeforeRootLetter() {
        assertEquals(0, builder.getNumberOfSpacesBeforeRootLetter('A'));
        assertEquals(0, builder.getNumberOfSpacesBeforeRootLetter(builder.ROOT_LETTER));
        assertEquals(1, builder.getNumberOfSpacesBeforeRootLetter('B'));
        assertEquals(2, builder.getNumberOfSpacesBeforeRootLetter('C'));
        assertEquals(3, builder.getNumberOfSpacesBeforeRootLetter('D'));
        assertEquals(4, builder.getNumberOfSpacesBeforeRootLetter('E'));
        assertEquals(5, builder.getNumberOfSpacesBeforeRootLetter('F'));     
    }
    
    @Test
    public void testGetSpaces() {
        assertEquals("", builder.getSpaces(0));
        assertEquals(" ", builder.getSpaces(1));
        assertEquals("  ", builder.getSpaces(2));
        assertEquals("   ", builder.getSpaces(3));
        assertEquals("          ", builder.getSpaces(10));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testWithNumber() {
        builder.build('3');
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testWithSpecialCharacter() {
        builder.build('É');
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testWithSymbol() {
        builder.build('É');
    }
}
