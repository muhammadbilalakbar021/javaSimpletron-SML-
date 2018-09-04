import java.util.Scanner;
import java.io.*;
public class Simpletron {
	

	public static void main(String[] args) 
	{
		System.out.println("*** Welcome to the Simpletron ***");
		System.out.println("*** Please  Enter your program one Instruction ***");
		System.out.println("*** (or Data word ) at a time .I will Display  ***");
		System.out.println("*** the location number and a queston mark (?) ***");
		System.out.println("*** You then type the word for that location   ***");
		System.out.println("*** type -9999 to Terminate your program       ***");
		System.out.println("---------------------------------------------------");
		
		if(args.length==7)
		{
				Scanner input =new Scanner(System.in);
			int [] Ram =new int[100];
			for(int i=0;i<args.length;i++)
			{
				Ram[i] = Integer.parseInt(args[i]);
			}
			
			for(int i=0;i<args.length;i++)
			{
				System.out.printf("%d     ?   +%d%n",i,Ram[i]);
			}
			System.out.println("Program Loading Completed");
			System.out.println("Program Execution Begins");
			System.out.println();
			int Accumulator;
			int InstructionCounter=0;
			int InstructionRegister;
			int operationCode;
			int operand;
			final int READ=10, WRITE=11,LOAD=20,STORE=21,ADD=30,SUB=31,DIV=32,MUL=33,BRANCH=40,BRANCHNEG=41,BRANCHZERO=42,HALT=43;
			System.out.println();
			System.out.println("-------------------------LOADING-----------------------");
			System.out.println("---------------------------WAIT------------------------");
			System.out.println("------------------------Almost Done--------------------");
			System.out.println();
			Accumulator=0;
			while(InstructionCounter!=99)
			{
			InstructionRegister=Ram[InstructionCounter];
			operationCode=InstructionRegister/100;
			operand=InstructionRegister%100;
			
			System.out.println();
			System.out.printf("Registors :%n");
			System.out.printf("Accumulator         =%d%n",Accumulator);
			System.out.printf("InstructionCounter  =%d%n",InstructionCounter);
			System.out.printf("InstructionRegister =%d%n",InstructionRegister);
			System.out.printf("operationCode       =%d%n",operationCode);
			System.out.printf("operand             =%d%n",operand);
			System.out.println();
			System.out.println();
			
			
			
			
			
			
				
				switch(operationCode)
				{
				case READ:
				{
					System.out.println("Enter an integer ");
					Ram[operand]=input.nextInt();
				System.out.println(Ram[operand]);
					break;
				}
				case WRITE:
				{
					System.out.printf(" Operation Code is = %d",Ram[operand]);	
					break;
				}
				case LOAD:
				{
					Accumulator=Ram[operand];
					break;
				}
				case STORE:
				{
					Ram[operand]=Accumulator;
					break;
				}
				case ADD:
				{
					Accumulator +=Ram[operand];
					break;
				}
				case SUB:
				{
					Accumulator -=Ram[operand];
					break;
				}
				case DIV:
				{
					Accumulator /=Ram[operand];
					break;
				}
				case MUL:
				{
					Accumulator *=Ram[operand];
					break;
				}
				case BRANCH:
				{
					InstructionCounter=operand;
					break;
				}
				case BRANCHNEG:
				{
					if(Accumulator<0)
					{
						InstructionCounter=operand;	
					}
					
					break;
				}
				case BRANCHZERO:
				{
					if(Accumulator==0)
					{
						InstructionCounter=operand;	
					}
					break;
				}
				case HALT:
				{
					break;
				}
			}
				InstructionCounter++;
			
				
			
			}
			

			System.out.println();
			System.out.println();
			for(int i=0;i<99;i++)
			{
				
					System.out.printf("%d     ?   +%d%n",i,Ram[i]);
				
			
			}
			
			
			
		}
		else
		{
			System.out.println();
			System.out.println("Error !");
			System.out.println("Please Enter 7 decimal values ");
		}System.out.println();
		
		
		
	System.out.println();
	System.out.println("Program Execution Completed");
	System.out.println("Thanks for Using Simpletron :)");
	System.out.println();
	}
	
}
