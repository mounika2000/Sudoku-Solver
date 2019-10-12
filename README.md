# Sudoku-Solver
This java code produces a GUI, onto which you can input the the sudoku question. By clicking on the Sudoku it Button the empty spaces are filled. 
There are 3 wayas of adding input to this Sudoku.
1. Directly add the question in the GUI(matrix)
<img width="339" alt="grid" src="https://user-images.githubusercontent.com/46564084/66695977-34434300-ece5-11e9-86d7-97d69cbe50a5.PNG">
2. By typing out the contents of the sudoku in the text tab
<img width="340" alt="text" src="https://user-images.githubusercontent.com/46564084/66696007-8a17eb00-ece5-11e9-8106-356dcafb8ddd.PNG">
the input here can be in two form:
--> Using 0 instead of the blank cells<br/>

0 0 9 0 6 5 4 3 0 <br/>
0 0 7 0 0 0 8 0 0 <br/>
6 0 0 1 0 8 0 2 0 <br/>
0 0 3 0 9 0 0 0 2 <br/>
5 0 1 4 0 3 9 6 0 <br/>
8 0 4 0 0 0 1 0 0 <br/>
0 3 0 5 0 9 0 0 7 <br/>
0 5 6 0 8 0 0 0 0 <br/>
0 7 0 2 4 0 0 9 0 <br/>

--> Using . instead of the blank cells<br/>
1 2 . 4 . . 3 . .<br/>
3 . . . 1 . . 5 .<br/>
. . 6 . . . 1 . .<br/>
7 . . . 9 . . . .<br/>
. 4 . 6 . 3 . . .<br/>
. . 3 . . 2 . . .<br/>
5 . . . 8 . 7 . .<br/>
. . 7 . . . . . 5<br/>
. . . . . . . 9 8<br/>
only these two format of input would display the results.<br/>

3. We can also add the input by choosing the location of the csv(excel file) of the sudoku.<br/>
<img width="87" alt="csv" src="https://user-images.githubusercontent.com/46564084/66696077-525d7300-ece6-11e9-8fa2-fbe017829e90.PNG">
After inputting the sudoku into the frame, click on sudoku it button.<br/>
<img width="99" alt="sudoku" src="https://user-images.githubusercontent.com/46564084/66696078-525d7300-ece6-11e9-91ab-f458248736d3.PNG">


Both the matrix and the text tabs in the gui are filled with the solution of the given question.<br/>
Ex:the following has been input in the text tab.<br/>
<img width="340" alt="1" src="https://user-images.githubusercontent.com/46564084/66696135-e4fe1200-ece6-11e9-9850-b3798a731dad.PNG">

After clicking on sudoku it. Solution appears in both tabs.<br/>
<img width="340" alt="2" src="https://user-images.githubusercontent.com/46564084/66696172-445c2200-ece7-11e9-8efb-2d7a16b2c7c6.PNG">
<img width="337" alt="3" src="https://user-images.githubusercontent.com/46564084/66696173-44f4b880-ece7-11e9-8627-bdce6739abcb.PNG">

Note: The spacing between the numbers in text tab is very important for the sudoku to work.
