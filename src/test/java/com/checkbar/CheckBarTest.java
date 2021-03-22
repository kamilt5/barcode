package com.checkbar;

import static org.junit.Assert.*;
import java.lang.Character;

import org.junit.Test;
import com.main.checkbar.CheckBar;


public class CheckBarTest 
{

    /**
     * Check if Barcode is correct
     */
    @Test
    public void CheckBarCode() {
        
        CheckBar check = new CheckBar();
        Character[] expected = {'2', 'Y', '2', 'D'};
        assertEquals(check.check("01632532948375"), expected[0]);
        assertEquals(check.check("01631234567890"), expected[1]);
        assertEquals(check.check("01632532948375"), expected[2]);
        assertEquals(check.check("06219912345678"), expected[3]);
    }
}
