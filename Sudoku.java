
// Author: P. Sai Mounika
// Roll Number: 1710110290
// this code has three modes of taking in the input question.
// through a grid where each cell has to be typed out
// by adding csv file, output is displayed immediately in the matrix
// by using textarea
// while adding questions
// empty cells can be leaved as it is.
// or in the form of text. The text should be separated by single space: " ".
// empty values in text area could be denoted by a 0 or a '.'
// a sample row for the text: 0 0 9 0 6 5 4 3 0  

// the strategy of how the sudoku works is explained along with their respective classes in the file
// there is a print statement : print(matrix) in the sudukoAlgo method, 
//for complex sudokus this might cause delay as it prints all intermediate states.
// comment the print statement if required.
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;


public class Sudoku_1710110290 {
    static JFrame frame= new JFrame("Sudoku");
    // creating a tab to add the two options of adding input
    static JTabbedPane tabPane= new JTabbedPane();
    // to take the input of the matrix
    static JTextField[][] gridField= new JTextField[9][9];
    // take the input of the matrix in the form of text
    static JTextArea textArea= new JTextArea(12,22);
    // main panel
    static JPanel pane=new JPanel();
    // panel in the matrix tab
    static JPanel matrixPane=new JPanel();
    // a grid for the text field in the matrix tab
    static JPanel gridPane= new JPanel();
    // panel in the text tab
    static JPanel textPane= new JPanel();
    // button for solving the sudoku
    static JButton sudokuIt = new JButton("Sudoku It!");
    // button to exit the program
    static JButton exit = new JButton("Exit");
    // button to clear the input in the fields
    static JButton clear = new JButton("Clear Input");
    // button to take input in the form of csv file
    static JButton addCSV = new JButton("Add CSV");
    // matrix for storing the input
    static int[][] matrix = new int[9][9];
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        // To get the look and feel  of the computer we are using
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame.add(pane);
        // adding tabPane to the main pane
        pane.add(tabPane);
        tabPane.setFont(tabPane.getFont().deriveFont(40f));
        
        FlowLayout flow= new FlowLayout(FlowLayout.TRAILING);
        GridLayout grid= new GridLayout(9,9);
        
        matrixPane.setLayout(flow);
        tabPane.add("Matrix",matrixPane);
        matrixPane.add(gridPane);
        gridPane.setLayout(grid);
        
        textPane.setLayout(flow);
        tabPane.add("Text",textPane);
        textArea.setFont(textArea.getFont().deriveFont(30f));
        textPane.add(textArea);
        
        // set font for all 3 buttons
        sudokuIt.setFont(sudokuIt.getFont().deriveFont(30f));
        clear.setFont(clear.getFont().deriveFont(30f));
        addCSV.setFont(addCSV.getFont().deriveFont(30f));
        exit.setFont(exit.getFont().deriveFont(30f));
        
        // add all three button to the main pane
	pane.add(sudokuIt);      
        pane.add(clear);
        pane.add(addCSV);
        pane.add(exit);
       
        
         addCSV.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    // a variable used later to check if an exception has occured.
                    int a=0;
                    
                    JFileChooser filePath = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    // selection mode is set so that all types of files could be chosed
                    filePath.setFileSelectionMode(JFileChooser.FILES_ONLY); 
                    int path = filePath.showOpenDialog(null); 
                    
                    if (path== JFileChooser.APPROVE_OPTION) { 
                // printin the directory of the selected path
                        System.out.println(filePath.getSelectedFile().getAbsolutePath()); 
            } 
            // in case the user cancels the operation
            else
                        System.out.println("The operation has been cancelled by the user");
                    
                    try{
                        // read the contents of the csv file and add them to the 2d array matrix
                    File file = new File(filePath.getSelectedFile().getAbsolutePath());
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    int k=0;
                    while (line != null) {
                      
                        String[] attributes = line.split(",");
                        for(int i=0; i<9;i++){
                            matrix[k][i]=Integer.valueOf(attributes[i]);
                        }
                        k++;
                        line = reader.readLine();
                        
                    }
                   
            System.out.println(); 
                    }catch(Exception e1){
                        a=1;
                        JOptionPane.showMessageDialog(null, "Not able to read file");
			                    }
                  
                    
                    //start the sudoku algorithm on the matrix inputed from csv file
                    if(a==0)
                    { Sudoku.start(matrix);
                // stringbuffer to store the result of the final sudoku
		StringBuffer result = new StringBuffer();
		for(int q = 0; q < 9; q++){
		for(int w = 0; w < 9; w++){
                int t=Sudoku.sudokuSolution()[q][w];
		gridField[q][w].setText( t+ "");
		result.append(t+ " ");
                }
		result.append('\n');
		}
                // set the result in the matrix and text area in gui 
                String resultString= result.toString();
		textArea.setText(resultString);
                }
                }});
         
        // add action listener for the exit button
        exit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){exit(0);}});
        
        // add action listener for the clear input button
        // sets the text in all text field to ""
       	clear.addActionListener(new ActionListener(){
        	@Override
                public void actionPerformed(ActionEvent e){
                    textArea.setText("");
		for(int i = 0; i < 9; i++){
		for(int j = 0; j < 9; j++){
		gridField[i][j].setText("");
                }}}
		});
		
        
       // adding 9*9 that is 81 text field in the pane 
        
      int i,j=0;
        for(i=0; i<9; i++){
            for(j=0;j<9;j++){
                gridField[i][j]=new JTextField(2);
                gridField[i][j].setFont(gridField[i][j].getFont().deriveFont(35f));
                gridPane.add(gridField[i][j]);
            }
            
        }
       // adding action listener 
    sudokuIt.addActionListener(new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            try{
                    int i=0;
                    int j=0;
		
                if(tabPane.getSelectedIndex() == 0){
                for( i = 0; i < 9; i++){
                for( j = 0; j < 9; j++){
                int len=gridField[i][j].getText().length();
                if(len > 1){throw new Exception();} 
                    
                
		else if(gridField[i][j].getText().equals(".") || gridField[i][j].getText().equals(" ") || gridField[i][j].getText().equals(""))
                {matrix[i][j] = 0;}
                else{
                    matrix[i][j] = Integer.parseInt(gridField[i][j].getText());}
                }}}                  
                
                if(tabPane.getSelectedIndex()==1){
		String[] ii = textArea.getText().split("\n");
		for(i = 0; i < 9; i++){
                    // trim the trailing and leading white spaces in the text area
		ii[i].trim();
		String[] jj = ii[i].split(" ");
		for(j = 0; j < 9; j++){
                    
                if(jj[j].equals("{")||jj[j].equals("}")|| jj[j].equals(","))
                    {continue;}
                else if(jj[j].equals("  ")||jj[j].equals("0")||jj[j].equals(".") || jj[j].equals("") )
                    {matrix[i][j] = 0;}
		else
                    {matrix[i][j] = Integer.parseInt(jj[j]);}}
		}
		}
					
                
                Sudoku.start(matrix);
                //
		StringBuffer result = new StringBuffer();
		for(i = 0; i < 9; i++){
		for(j = 0; j < 9; j++){
                    int t=Sudoku.sudokuSolution()[i][j];
		gridField[i][j].setText( t+ "");
		result.append(t+ " ");
                }
		result.append('\n');
		}
                String resultString= result.toString();
		textArea.setText(resultString);
	}
            // this catches any sort of exception, arrayindes out of bound, any incorrect data type input etc.
         catch(Exception exception){
          System.out.println(exception);
         JOptionPane.showMessageDialog(null, "Not valid Input for the sudoku");
			}
			}
		});
        
        
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
	frame.setVisible(true);    
    }
    
    
    static class Sudoku{
        // count is a variable used to show the intermediate states in the code.
        static int count;
        // stores the current content of the matrix
        static int[][] matrix = new int[9][9];
        // a 2d array to store the final content of the matrix above.
	static int[][] solution = new int[9][9];
     // this method copies the question into a 2D array called matrix and also calls the sudokuAlgo   
	public static void start(int[][] question){
		for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++)
		matrix[i][j] = question[i][j];}
		
                // a variable to keep a count of the number of recursions taking place.
                // this variable has been used to show the intermediate states of the matrix.
                count=0;
                // we start the sudoku algorithm with row 0 and column 0
                sudokuAlgo(0, 0);
		
	}
	
        // a class to return the final matrix after being solved. 
	public static int[][] sudokuSolution(){
		return solution;
	}
	
        // class to print the matrix, we can print both the current matrix and the final result using this.
	public static void print(int[][] input){
		System.out.println("...........................................................");
		for(int i = 0; i < 9; i++){
		for(int j = 0; j < 9; j++){
			if(input[i][j] == 0){
			System.out.print(" _");
                        }
                        else{
			System.out.print(" " + input[i][j]);
                        }
			}
		System.out.println();
		}
		
                
	}
	
	public static void sudokuAlgo(int row, int column){
            // count has been used to to show intermediate states in the code.
            count=count+1;
            // we first check the values of row and column if they have reached their maximum of 9.
            // the counter for the column is reset to 0 after it reaches 9 and the row is simply incremented. Nothing else is checked.
		if(column >=9){
                row++;
		column = 0;
			// if the row has also reached 9, it means that the entire matrix has been filled ( row 0-8) 
                        // the content of the matrix is copied to the result matrix.
		if(row >= 9){
		for(int i = 0; i < 9; i++){
		for(int j = 0; j < 9; j++)
                    solution[i][j] = matrix[i][j];}            
                // since we have now got the result matrix, we return.
		return;	}
		}
               
               // if the current cell is 0, then it is checked if a value satisfies the constraint and adds it to the matrix
		if(matrix[row][column] == 0){
			for(int a = 1; a <=9; a++){
				if(constraint(a,row, column)){
					matrix[row][column] = a;
                                        // after assigning a value to the cell, the function jumps to the next column in the same row.
                                        if(count<=100 & count>0 & count%10==0)
                                       print(matrix);
                                       if(count<=1000& count>100 & count%100==0)
                                       print(matrix);
                                       if(count<=10000 & count>1000 & count%1000==0)
                                       print(matrix);
                                       if(count<=100000 & count>10000 & count%10000==0)
                                       print(matrix);    
					sudokuAlgo(row, column + 1);
                                        
                                        
                                                                         
                                        
                                      // if the value does not satisfy, its value is set to 0, it goes through the process again until cell gets the correct value.
                                      matrix[row][column] = 0;
				}
			}
		}
                // if the matrix is already filled, that is a pre- fixed value is present then it simply skips that cell and goes to the next one.
                else{
			sudokuAlgo(row, column + 1);
		}
                
                
	}
	
	private static boolean constraint(int value, int row, int column){
            int i=0;
            int j=0;
             //  check in the respective 3*3 box, if the value of v is present 
		int rowBox = 3*(row/3);
		int columnBox = 3*(column/3);
		for(i = rowBox; i < rowBox+3; i++){
			for(j = columnBox; j < columnBox+3; j++){
				if(matrix[i][j] == value)
					return false;
				}}
            // check the entire column the value 
		for(i = 0; i < 9; i++){
			if(matrix[row][i] == value)
                            return false;
			
		}
            // check the entire row the value 
		for(i = 0; i < 9; i++){
			if(matrix[i][column] == value)
				return false;
			}
               
                // if the value fails at any of the conditions above then it return false
                //if it reches till here, it means that the values has not been used yet and thus returns true.
		return true;
	}
    }    
}
