import java.util.Scanner;


public class MySudokuPuzzle
{


    private int myBoard [][];
    private int myStart[][];

    
    public MySudokuPuzzle()
    {
       
      
        myStart = new int [9][9];
        myBoard = new int [9][9];
    }
   
   
    public String toString()
    {
       
        
        String myPuzzleTable = "Row/Col\n    1 2 3 4 5 6 7 8 9\n";
       
       
        myPuzzleTable = myPuzzleTable+ "   --------------------------\n";
       
        
        for (int idx1=0; idx1<9; idx1++)
        {
            
            myPuzzleTable = myPuzzleTable + (idx1+1) + "|";
           
           
            for (int idx2=0; idx2<9; idx2++)
            {
                if (myBoard [idx1][idx2] == 0)
                   
                    
                    myPuzzleTable = myPuzzleTable + " " + ".|";
                else
                   
                    
                    myPuzzleTable = myPuzzleTable + " " +myBoard [idx1][idx2] + "|";
            }
           
            
            myPuzzleTable = myPuzzleTable + "\n";
           
            
            myPuzzleTable = myPuzzleTable + " |__|__|__|__|__|__|__|__|__|\n";
        }
       
        
        return myPuzzleTable;
    }
   
    
    public void addInitialValues(int pRow, int pCol, int pValue)
    {
       
        
        if (pRow>=0 && pRow<=9 && pCol >=0 && pCol <=9 && pValue >=1 && pValue <=9)
        {
           
            
            myStart [pRow][pCol] = pValue;
            myBoard [pRow][pCol] = pValue;
        }
    }
   
   
    public void addGuessValue(int pRow, int pCol, int pValue)
    {
       
        
        if (pRow>=0 && pRow<=9 && pCol >=0 && pCol <=9 && pValue >=1 && pValue <=9 && myStart [pRow][pCol] == 0)
        {
           
           
            myBoard [pRow][pCol]= pValue;
        }
    }
   
    
    public int getValueInBoard(int pRow, int pCol)
    {
       
        
        return myBoard[pRow][pCol];
    }
   
    
    public void puzzleTableReset()
    {
       
        
        for (int idx1=0;idx1<9;idx1++)
           
            
            for( int idx2=0;idx2<9;idx2++)
               
                
                myBoard[idx1][idx2] = myStart[idx1][idx2];
    }
   
   
    public boolean isTableFull()
    {
       
        
        boolean isFilled = true;
       
        
        for (int idx1=0;idx1<9;idx1++)
           
            
            for( int idx2=0;idx2<9;idx2++)
               
                
                isFilled = isFilled && myBoard[idx1][idx2]>0;
       
       
        return isFilled;
    }
   
    
    public boolean[] getAllowedTableValues(int pRow, int pCol)
    {
       
        
        int savedValue = myBoard[pRow][pCol];
        boolean resultant[] = new boolean[9];
       
        
        for (int pValue = 1; pValue <=9; pValue++)
        {
           
            
            myBoard [pRow][pCol] = pValue;
           
           
            resultant[pValue-1] = checkMyPuzzle();
        }
       
       
        myBoard [pRow][pCol] = savedValue;
       
       
        return resultant;
    }
   
   
    public boolean checkMyPuzzle()
    {
       
        
        boolean isGood = true;
       
        
        for (int idx1=0;idx1<9;idx1++)
        {
           
            
            isGood = isGood && checkTableRow(idx1);
            isGood = isGood && checkTableCol(idx1);
            isGood = isGood && checkTableSub(idx1);
        }
       
       
        return isGood;
    }
   
    
    public boolean checkTableRow(int pRow)
    {
       
      
        int counter[]= new int[10];
       
        
        for (int pCol=0;pCol<9;pCol++)
        {
            counter[myBoard[pRow][pCol]]++;
        }
       
        
        boolean isCounterOK = true;
       
        
        for(int idx1=1; idx1<=9; idx1++)
           
            
            isCounterOK = isCounterOK && (counter[idx1]<=1);
       
        
        return isCounterOK;
    }
   
  
    public boolean checkTableCol(int pCol)
    {
       
        
        int counter[] = new int[10];
       
       
        for(int pRow=0; pRow<9; pRow++)
        {
           
           
            counter[myBoard[pRow][pCol]]++;
        }
       
       
        boolean isCounterOK = true;
       
        
        for(int idx1=1; idx1<=9; idx1++)
           
            
            isCounterOK = isCounterOK && (counter[idx1]<=1);
       
        
        return isCounterOK;
    }
   
    
    public boolean checkTableSub(int tSub)
    {
       
        
        int counter[] = new int[10];
        int baseRow = (tSub/3) *3;
        int baseCol = (tSub%3) *3;
       
        
        for(int idx1=0; idx1<3; idx1++)
        {
           
            
            for(int idx2=0; idx2<3; idx2++)
            {
               
                
                counter[myBoard[baseRow+idx1][baseCol+idx2]]++;
            }
        }
       
       
        boolean isCounterOK = true;
       
        
        for(int idx1=1; idx1<=9; idx1++)
           
           
            isCounterOK = isCounterOK && (counter[idx1]<=1);
       
        
        return isCounterOK;
    }
   
    
    public static void puzzleInitialization(MySudokuPuzzle sp)
    {
        sp.addInitialValues(0,0,1);
        sp.addInitialValues(0,1,2);
        sp.addInitialValues(0,2,3);
        sp.addInitialValues(0,3,4);
        sp.addInitialValues(0,4,9);
        sp.addInitialValues(0,5,7);
        sp.addInitialValues(0,6,8);
        sp.addInitialValues(0,7,6);
        sp.addInitialValues(0,8,5);
        sp.addInitialValues(1,0,4);
        sp.addInitialValues(1,1,5);
        sp.addInitialValues(1,2,9);
        sp.addInitialValues(2,0,6);
        sp.addInitialValues(2,1,7);
        sp.addInitialValues(2,2,8);
        sp.addInitialValues(3,0,3);
        sp.addInitialValues(3,4,1);
        sp.addInitialValues(4,0,2);
        sp.addInitialValues(5,0,9);
        sp.addInitialValues(5,5,5);
        sp.addInitialValues(6,0,8);
        sp.addInitialValues(7,0,7);
        sp.addInitialValues(8,0,5);
        sp.addInitialValues(8,3,9);
    }
    @SuppressWarnings("static-access")
   
   
    public static void main(String[] args)
    {
       
        
        Scanner scannerObject = new Scanner(System.in);
       
        
        System.out.println("Sudoku Game: ");
       
      
        MySudokuPuzzle mypuzzle = new MySudokuPuzzle();
       
        
        mypuzzle.puzzleInitialization(mypuzzle);
       
        
        System.out.print("The puzzle is: \n" + mypuzzle);
       
        
        boolean finished = false;
       
       
        while(!finished)
        {
           
            
            System.out.println("What would you like to do? \n");
            System.out.println("Clear puzzle(C)");
            System.out.println("Set a square (S)");
            System.out.println("Get possible values (G)");
            System.out.println("Quit (Q)");
           
          
            String userResponse = scannerObject.next();
           
            
            userResponse = userResponse.toLowerCase();
           
            
            if(userResponse.equals("q"))
            {
               
               
                System.out.println("Thanks for playing.");
               
                
                finished = true;
            }
           
            
            else if(userResponse.equals("s"))
            {
               
                
                System.out.println("Which Row (1-9) and column (1-9) do you want to change?");
               
                
                int pRow = scannerObject.nextInt()-1;
               
                
                int pCol = scannerObject.nextInt()-1;
               
                
                System.out.println("What should the Value (1-9) be?");
               
                
                int pValue = scannerObject.nextInt();
               
                
                mypuzzle.addGuessValue(pRow, pCol, pValue);
            }
           
            
            else if(userResponse.equals("g"))
            {
               
                
                System.out.println("Which Row (1-9) and column (1-9) do you   want to get values for?");
               

                int pRow = scannerObject.nextInt()-1;
               
               
                int pCol = scannerObject.nextInt()-1;
               
                
                boolean validOne[] = mypuzzle.getAllowedTableValues(pRow, pCol);
               
                
                System.out.print("Allowed values are: ");
               

                for(int idx1=0; idx1<9; idx1++)
                {
                   
                    if(validOne[idx1])
                       
                        
                        System.out.print((idx1+1)+ " ");
                }
               
               
                System.out.println();
            }
           
            
            else if(userResponse.equals("c"))
            {
               
                
                mypuzzle.puzzleTableReset();
            }
           
            
            System.out.print("The puzzle is now: \n" + mypuzzle);
           
            
            if(!mypuzzle.checkMyPuzzle())
               
               
                System.out.println("You have made a mistake in the puzzle.");
           
           
            else if(mypuzzle.isTableFull())
               
                
                System.out.println("Congratulations, you have successfully completed the puzzle.");
        }
    }
}