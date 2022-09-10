package q3;
import java.util.*;
public class Game {
String A,B;
String board[][];
Scanner sc;
Map<String,ArrayList<Integer>>A_pos;
Map<String,ArrayList<Integer>>B_pos;
Game(String A,String B)
{
this.A=A;
this.B=B;
board = new String[5][5];
A_pos = new HashMap<>();
B_pos = new HashMap<>();
for(String []v:board)
{
Arrays.fill(v,"-");
}
}
public void apawn()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
board[4][i] ="A"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>crd = new ArrayList<>();
crd.add(4);
crd.add(i);
A_pos.put(board[4][i],crd);
}
// System.out.println(posA);
}
public void bpawn()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
board[0][i] ="B"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>crd = new ArrayList<>();
crd.add(0);
crd.add(i);
B_pos.put(board[0][i],crd);
}
// System.out.println(posB);
}
public boolean aamove(String playerMove)
{
int indexColon = playerMove.indexOf(':');
String entry = playerMove.substring(0,indexColon);
entry = "A-"+entry;
char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
// System.out.println(move);
if(!A_pos.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = A_pos.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updateX =x;
int updateY=y;
if(move=='F')
{
updateX--;
}
else if(move=='B')
{
updateX++;
}
else if(move=='L')
{
updateY--;
}
else if(move=='R')
{
updateY++;
}
else
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
String currPos = board[x][y];
String updatePos = board[updateX][updateY];
if(updatePos.charAt(0)=='A')
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updatePos.equals("-"))
{
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
A_pos.put(entry,coordinates);
// return true;
}
else if(updatePos.charAt(0)=='B')
{
B_pos.remove(updatePos);
System.out.println(board[updateX][updateY]+" got attacked!!");
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
A_pos.put(entry,coordinates);
// return true;
}
return true;
}
public boolean bbmove(String playerMove)
{
int indexColon = playerMove.indexOf(':');
String entry = playerMove.substring(0,indexColon);
entry = "B-"+entry;
char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
// System.out.println(move);
if(!B_pos.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = B_pos.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updateX =x;
int updateY=y;
if(move=='F')
{
updateX++;
}
else if(move=='B')
{
updateX--;
}
else if(move=='L')
{
updateY--;
}
else if(move=='R')
{
updateY++;
}
else
{
System.out.println("Invalid Move1!!\nPlease Enter Again:");
return false;
}
System.out.println(updateX+" "+updateY);
if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
{
System.out.println("Innvalid Move2!!\nPlease Enter Again:");
return false;
}
String curp = board[x][y];
String updatePos = board[updateX][updateY];
if(updatePos.charAt(0)=='B')
{
System.out.println("Invalid Move3!!\nPlease Enter Again:");
return false;
}
if(updatePos.equals("-"))
{
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
B_pos.put(entry,coordinates);
// return true;
}
else if(updatePos.charAt(0)=='A')
{
A_pos.remove(updatePos);
System.out.println(board[updateX][updateY]+" got attacked!!");
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
A_pos.put(entry,coordinates);
// return true;
}
return true;
}
public void disp()
{
for(int i=0;i<5;i++)
{
for(int j=0;j<5;j++)
{
System.out.print(board[i][j]+"\t\t");
}
System.out.println();
}
}
}