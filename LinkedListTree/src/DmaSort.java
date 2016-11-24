/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Brian Martinez
 */
public class DmaSort {
    private static class DMA
    {
        int AreaCode;
        String Region;
        String State;
    }
    
    public static void main(String[] args)
    {
        LinkedListTree llt = new LinkedListTree();
        String filename = "dma.txt", str = "";
        
        try
        {
            Scanner inFile = new Scanner(new FileReader(filename));
            
            // using area code as key
            long start = System.currentTimeMillis();
            
            while (inFile.hasNext())
            {
                str = inFile.nextLine();
                StringTokenizer st = new StringTokenizer(str, ",");
        
                DMA dma = new DMA();
                while (st.hasMoreTokens())
                {
                    dma.AreaCode = Integer.parseInt(st.nextToken());
                    dma.Region = st.nextToken();
                    dma.State = st.nextToken();
                    llt.insert(dma.AreaCode, dma);
                }
            }
            long time = System.currentTimeMillis()- start;
            
            System.out.println("Using area code as key...");
            System.out.println("Load complete, execution time: " + time + " ms");
            System.out.println("Total nodes inserted: " + llt.countNodes());
            System.out.println("Number of balances:   " + llt.GetBalanceCount());
            System.out.println("Nodes, preorder traversal:");
            llt.preorder();
            System.out.println("\nNodes, inorder traversal:");
            llt.inorder();
            
            // using region as key
            inFile = new Scanner(new FileReader(filename));
            llt.clear();
            
            start = System.currentTimeMillis();
            
            while (inFile.hasNext())
            {
                str = inFile.nextLine();
                StringTokenizer st = new StringTokenizer(str, ",");
        
                DMA dma = new DMA();
                while (st.hasMoreTokens())
                {
                    dma.AreaCode = Integer.parseInt(st.nextToken());
                    dma.Region = st.nextToken();
                    dma.State = st.nextToken();
                    llt.insert(dma.Region, dma);
                }
            }
            time = System.currentTimeMillis()- start;
            
            System.out.println("\n\nUsing region as key...");
            System.out.println("Load complete, execution time: " + time + " ms");
            System.out.println("Total nodes inserted: " + llt.countNodes());
            System.out.println("Number of balances:   " + llt.GetBalanceCount());
            System.out.println("Nodes, preorder traversal:");
            llt.preorder();
            System.out.println("\nNodes, inorder traversal:");
            llt.inorder();
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
