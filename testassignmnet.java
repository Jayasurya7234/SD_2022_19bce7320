package q3;
import java.util.*;
public class testassignmnet {
String A,B;
String platmorf[][];
Scanner sc;
Map<String,ArrayList<Integer>>pos_A;
Map<String,ArrayList<Integer>>pos_B;
testassignmnet(String C,String D)
{
this.A=C;
this.B=D;
platmorf = new String[5][5];
pos_A = new HashMap<>();
pos_B = new HashMap<>();
for(String []value:platmorf)
{
Arrays.fill(value,"-");
}
}
public void get_pawn_A()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
platmorf[4][i] ="A"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>coordinates = new ArrayList<>();
coordinates.add(4);
coordinates.add(i);
pos_A.put(platmorf[4][i],coordinates);
}
// System.out.println(posA);
}
public void get_Pawn_B()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
platmorf[0][i] ="B"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>cood = new ArrayList<>();
cood.add(0);
cood.add(i);
pos_B.put(platmorf[0][i],cood);
}
}
public boolean Amove(String play)
{
int indexColon = play.indexOf(':');
String entry = play.substring(0,indexColon);
entry = "A-"+entry;
char move =Character.toUpperCase(play.charAt(indexColon+1));
// System.out.println(move);
if(!pos_A.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = pos_A.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updX =x;
int updY=y;
if(move=='F')
{
updX--;
}
else if(move=='B')
{
updX++;
}
else if(move=='L')
{
updY--;
}
else if(move=='R')
{
updY++;
}
else
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updX>=5 || updX<0 || updY>=5||updY<0)
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
String current_position = platmorf[x][y];
String updated_position = platmorf[updX][updY];
if(updated_position.charAt(0)=='A')
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updated_position.equals("-"))
{
platmorf[updX][updY] = entry;
platmorf[x][y]="-";
coordinates.set(0,updX);
coordinates.set(1,updY);
pos_A.put(entry,coordinates);
// return true;
}
else if(updated_position.charAt(0)=='B')
{
pos_B.remove(updated_position);
System.out.println(platmorf[updX][updY]+" got attacked!!");
platmorf[updX][updY] = entry;
platmorf[x][y]="-";
coordinates.set(0,updX);
coordinates.set(1,updY);
pos_A.put(entry,coordinates);
}
return true;
}
public boolean Bmove(String playerMove)
{
int indexColon = playerMove.indexOf(':');
String entry = playerMove.substring(0,indexColon);
//entry = "B-"+entry;
char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
if(!pos_B.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = pos_B.get(entry);
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
String currentPosition = platmorf[x][y];
String updatedPosition = platmorf[updateX][updateY];
if(updatedPosition.charAt(0)=='B')
{
System.out.println("Invalid Move3!!\nPlease Enter Again:");
return false;
}
if(updatedPosition.equals("-"))
{
platmorf[updateX][updateY] = entry;
platmorf[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
pos_B.put(entry,coordinates);
// return true;
}
else if(updatedPosition.charAt(0)=='A')
{
pos_A.remove(updatedPosition);
System.out.println(platmorf[updateX][updateY]+" got attacked!!");
platmorf[updateX][updateY] = entry;
platmorf[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
pos_A.put(entry,coordinates);
// return true;
}
return true;
}
public void display()
{
for(int i=0;i<5;i++)
{
for(int j=0;j<5;j++)
{
System.out.print(platmorf[i][j]+"\t\t");
}
System.out.println();
}
}




public boolean level3(String playerMove)
{
int indexColon = playerMove.indexOf( ':');
String entry = playerMove.substring(0,indexColon);
// String entry ="H3";
entry= "A-"+entry;
String move =playerMove.substring(indexColon+1).toUpperCase();
// System.out.println(move);
if(!pos_A.containsKey(entry))
{
	System.out.println("Invalid Pawn Selected!!\n Try Again");
	return false;
}
ArrayList<Integer> coordinates = pos_A.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updatex =x;
int updateY=y;
if(move.equals("LF"))
{
	updatex-=2;
updateY-=1;
}

else if(move.equals ("LB"))
{
	updatex+=2;
	updateY-=1;
}

else if (move.equals("RF"))
{
	updatex-=2;
	updateY+=1;
}
else if (move.equals("RB"))
{
	updatex+=2;
	updateY+=1;
}else
{
System.out.println("Innvalid Move1!!\nPlease Enter Again:");
return false;
}
if(updatex>=5 || updatex<0 || updateY>=5||updateY<0)

{
System.out.println("Invalid Move2!!\nPlease Enter Again:");
return false;
	

}

String currPos = platmorf [x][y];
String updatePos = platmorf[updatex] [updateY];
if(updatePos.charAt( 0)=='A')
{
System.out.println("Invalid Move3!!\nPlease Enter Again:");
return false;
}

if(updatePos.equals("-")) {
platmorf[updatex][updateY] = entry;
platmorf [x][y]="-";
coordinates.set(0,updatex);
coordinates.set(1,updateY);
pos_A.put(entry, coordinates);
// return true;
}
else if (updatePos.charAt(0)=='B')
{
pos_A.remove(updatePos);
System.out.println(platmorf [updatex] [updateY]+" got attacked!!");
platmorf[updatex][updateY]= entry;
platmorf[x][y]="-";
}
return true;
}




public boolean level1 (String playerMove)
{

int colon = playerMove.indexOf(':');
String entry = playerMove.substring(0,colon);

// String entry ="H1";
entry = "A-"+entry;


char move = Character.toUpperCase(playerMove.charAt(colon+1));
// System.out.println(move);
if(!pos_A.containsKey(entry)) {
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = pos_A.get (entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updatex =x;
int updateY=y;
if(move=='F')
{
	updatex-=2;
}
else if(move=='B')
{
	updatex+=2;
}
else if(move=='L')

{
updateY-=2;

}
else if(move=='R')
{
updateY+=2;

}
else
{
	System.out.println("Invalid Move1!!\nPlease Enter Again:");
return false;
}if(updatex>=5 || updatex<0 || updateY>=5||updateY<0)

{
System.out.println("Innvalid Move2!! \nPlease Enter Again:");
return false;




}
String currPos = platmorf [x][y];
String updatedposition = platmorf[updatex] [updateY];
if(updatedposition.charAt( 0)=='A')
{
System.out.println("Invalid Move3!! \nPlease Enter Again:");
return false;
}
if(updatedposition.equals("-")) {
platmorf [updatex][updateY] = entry;
platmorf [x][y]="-";
coordinates.set( 0, updatex);
coordinates.set( 1,updateY);
pos_B.put(entry, coordinates);
// return true;
}
else if (updatedposition.charAt(0)=='B')
{
pos_B.remove(updatedposition);
System.out.println(platmorf [updatex][updateY]+" got attacked!!");
platmorf [updatex][updateY] = entry;
platmorf [x][y]="-";
coordinates.set( 0,updatex);
coordinates.set( 1,updateY);
pos_B.put(entry, coordinates);
//return true;
}
return true;
}




public boolean level2 (String playerMove)
{
int colon = playerMove.indexOf(':');
String make_a_move = playerMove.substring(0, colon);
// String entry ="H1";
make_a_move = "B-"+make_a_move;
char move =Character.toUpperCase(playerMove.charAt(colon+1));
//System.out.println(move);
if(!pos_B.containsKey(make_a_move))
{
	System.out.println("Invalid Pawn Selected!!\n Try Again");
	return false;
}
ArrayList<Integer> coordinates = pos_B.get(make_a_move);
int x =coordinates.get( 0);
int y = coordinates.get( 1);
int update_X =x;
int update_Y=y;
if(move=='F')
{
	update_X+=2;
}
else if (move=='B')
{
	update_X-=2;
}
else if (move=='L')
{
	update_Y-=2;
}


else if (move=='R')
{
	update_Y+=2;


}


else
{
System.out.println("Invalid Move1!!\nPlease Enter Again:");
return false;
}

if(update_X>=5 || update_X<0 || update_Y>=5|| update_Y<0)
{
System.out.println("Innvalid Move2!!\nPlease Enter Again:");
return false;
}
String currPos = platmorf [x][y];
String newposition = platmorf[update_X] [update_Y];
if(newposition.charAt( 0)=='B')
{
System.out.println("Invalid Move3!! \nPlease Enter Again:");
return false;
}
if(newposition.equals("-")) {
platmorf [update_X][update_Y] = make_a_move;
platmorf [x][y]="-";
coordinates.set( 0, update_X);
coordinates.set( 1,update_Y);
pos_B.put(make_a_move, coordinates);
// return true;
}
else if (newposition.charAt(0)=='A')
{
pos_A.remove(newposition);
System.out.println(platmorf [update_X][update_Y]+" got attacked!!");
platmorf [update_X][update_Y] = make_a_move;
platmorf [x][y]="-";
coordinates.set( 0,update_X);
coordinates.set( 1,update_Y);
pos_B.put(make_a_move, coordinates);
//return true;
}
return true;
}
}
