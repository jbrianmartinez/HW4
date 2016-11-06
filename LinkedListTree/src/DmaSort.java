/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Brian Martinez
 */
public class DmaSort {
    private class DMA
    {
        int AreaCode;
        String Region;
        String State;
    }
    
    public void main(String[] args)
    {
        LinkedListTree llt = new LinkedListTree();
        String filename = "dma.txt", str = "";
        
        try
        {
            Scanner inFile = new Scanner(new FileReader(filename));
            while (inFile.hasNext())
            {
                str = inFile.nextLine();
                DMA dma = new DMA();
                
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
