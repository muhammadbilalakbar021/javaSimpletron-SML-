import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileReader;
import javafx.stage.FileChooser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectInputStream;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Font;
import java.io.InputStream;
import java.util.Scanner;
import java.lang.Integer;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.lang.reflect.Method;
import java.util.Optional;

public class Simpletron extends Application
{
	
	static int[] Array=new int[100];
	private static TextArea text=new TextArea();
	static int a=0;
	
	final int read=10;
	final int write=11;
	final int load=20;
	final int store=21;
	final int add=30;
	final int subtract=31;
	final int divide=32;
	final int multiply=33;
	final int brach=40;
	final int brachneo=41;
	final int branchZero=42;
	final int halt=43;
	
	int accumulator=0;
	int instructionCounter=0;
	int instructionRegister=0;
	int opcode=0;
	int oprand=0;
	static Scanner input;
	
	
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("SimpleTron");
		
		TextField txt1=new TextField();
		TextField txt2=new TextField();
		TextField txt3=new TextField();
		TextField txt4=new TextField();
		TextField txt5=new TextField();
		
		Label lab1=new Label("Accumulator");
		Label lab2=new Label("InstCounter");
		Label lab3=new Label("InstReg");
		Label lab4=new Label("OpCode");
		Label lab5=new Label("Operand");
		
		HBox hBoxTop=new HBox(2,lab1,txt1,lab2,txt2,lab3,txt3,lab4,txt4,lab5,txt5);
		
		Button btn1=new Button();
		btn1.setText("   Load Program    ");
		Button btn2=new Button();
		btn2.setText("   Execute Next instruction    ");
		
		HBox hBoxBottom=new HBox(2,btn1,btn2);		
		
		BorderPane borderPane=new BorderPane();
		
		borderPane.setTop(hBoxTop);
		borderPane.setCenter(text);
		borderPane.setBottom(hBoxBottom);
		
		Scene scene=new Scene(borderPane,1050,500);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		FileChooser fileChooser = new FileChooser();
		
		btn1.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event) 
				{
					File file=fileChooser.showOpenDialog(primaryStage);
					String read;
					try
					{
						input=new Scanner(Paths.get(file.getPath()));
						if (input == null)
							System.out.println("input is null\n");
					}
					catch(IOException iOException)
					{
						System.err.println("IOException");
					
					}
					text.setFont(Font.font("Verdana", 20));
					readFile();
					printTextArea();
				}
			});
			
			btn2.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						instructionRegister=Array[instructionCounter];
						opcode=instructionRegister/100;
						oprand=instructionRegister/100;
						switch(opcode)
						{
							case read:
							{
								TextInputDialog dialog= new TextInputDialog("");
								dialog.setTitle("Input");
								dialog.setHeaderText("taking input from user");
								dialog.setContentText("enter any number");
								
								Optional <String> input= dialog.showAndWait();
								if(input.isPresent())
								{
									System.out.println("your name: " + input.get());
									int count3=0;
									count3=Integer.parseInt(input.get());
									Array[oprand]=count3;
									
								}
								break;
							}	
							case write:
							{
								break;
							}
							
							case load:
							{
								accumulator=Array[oprand];
								break;
							}
							
							case store:
							{
								Array[oprand]=accumulator;
								break;
							} 
							case add:
							{
								accumulator=accumulator+Array[oprand];
								break;
							}
							
							case subtract:
							{
								accumulator=accumulator-Array[oprand];
								break;
							}
							
							case divide:
							{
								accumulator=accumulator/Array[oprand];
								break;
							}
							case multiply:
							{
								accumulator=accumulator*Array[oprand];
								break;
							}
							case brach:
							{
								instructionCounter=oprand;	
								break;
							}
							case brachneo:
							{
								if(accumulator<0)
									instructionCounter=oprand;
								
								break;
							}
							case branchZero:
							{
								if(accumulator==0)
									instructionCounter=oprand;
									
							}
							
						}
						printTextArea();
					}
				
			}
			
			);
	}
	
	public static void readFile()
	{		
		try
		{
			while(input.hasNext())
			{
				Array[a]=Integer.parseInt(input.nextLine());
				System.out.printf("%d\t",Array[a]);
				a++;
			}
		}
		catch(NoSuchElementException noSuchElementException)
		{
			System.err.println("NO such element found exception");
		}
		catch(IllegalStateException illegalStateException)
		{
			System.err.println("Illegal State exception");
		}
		
	}
	
	public static void printTextArea()
	{
		String topheading="   0  1      2      3      4      5      6      7      8      9";
		
		int count1=0;
		
		//String nextline=null;
		
		//topheading = topheading + nextline;
		for(int count2=0;count2<Array.length;count2++)
		{
			if(count2%10==0)
			{	
				topheading = topheading + "\n  " +count1+"  " ;
				count1=count1+10;
			}
			if(Array[count2]==0)
			{
				topheading=topheading+"0000  ";
			}
			else 
			{
				topheading=topheading+Array[count2]+"   ";
			}
		}
		
		text.setText(topheading);
	}
	
}