package q3;

import java.util.*;
public class game_assignment {
static Scanner in;
public static void main(String[] args) {
in = new Scanner(System.in);
System.out.println("Enter the Names of Player :");
System.out.println("Enter Player 1 Name :");
String A = in.next();
System.out.println("Enter Player 2 Name :");
String B = in.next();
Game ob = new Game(A,B);
LetsPlay(A,B);
}
public static void LetsPlay(String A,String B)
{
Game ob = new Game(A,B);
System.out.println("Enter the Pawn's of A ");
ob.apawn();
System.out.println("Enter the Pawn's of B ");
ob.bpawn();
// ob.display();
boolean AMove =false;
while(ob.A_pos.size()!=0 && ob.B_pos.size()!=0)
{
boolean isPossible=false;
System.out.println("Current Grid");
ob.disp();
while(!isPossible)
{
if(AMove)
{
System.out.println("Player A's Move : ");
String move =in.next();
isPossible=ob.aamove(move);
if(!isPossible)
{
continue;
}
AMove =!AMove;
}
else
{
System.out.println("Player B's Move : ");
String move =in.next();
isPossible=ob.bbmove(move);
if(!isPossible)
{
continue;
}
AMove =!AMove;
}
if(ob.A_pos.size()==0)
{
System.out.println("Congrats "+ob.B+" Won!!");
System.out.println("Press 1 To Play Again!!");
int choice =in.nextInt();
if(choice==1)
{
LetsPlay(A,B);
}
}
if(ob.B_pos.size()==0)
{
System.out.println("Congrats "+ob.A+" Won!!");
System.out.println("Press 1 To Play Again!!");
int choice =in.nextInt();
if(choice==1)
{
LetsPlay(A,B);
}
}
}
}
}
}