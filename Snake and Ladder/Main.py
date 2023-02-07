''' 
Snake and Ladder Game
'''

import random
from turtle import *
import time
class Board:
    def __init__(self,size):
        self.size = size
        self.x_cor = [-288,-224,-170,-96,-32,32,96,165,224,288]
        self.y_cor = [-279,-217,-155,-93,-31,31,93,155,217,279]
        self.snake = Snake()
        self.ladder = Ladder()
        self.dice = Dice()
        self.no_of_players = 2#int(input("Enter Number of players"))
        self.createPlayers()
        self.index=0
        
        
    def createPlayers(self):
        self.players =[Player("deekshith","blue"),Player("Basha","red")]
        self.setpos()
        self.players[0].setheading(90)
        self.players[1].setheading(-90)

    def play(self,x=0,y=0):
        self.dice.onclick(None)
        
        print("start game")
        currPlayer =self.players[self.index]
        outcome =self.dice.roll()
        if(outcome[-1] !=6):
            self.index +=1
            if(self.index== 2):
                self.index=0
        self.move(currPlayer,sum(outcome))
        nextplayer =self.players[self.index]
        color= nextplayer.colur
        self.dice.color("black",color)
        if(currPlayer.position ==100):
            print(currPlayer.name ,"is winner")
            time.sleep(3)
            window.clear()
            self.dice.clear()
            self.dice.goto(0,0)
            self.dice.write(currPlayer.name+" is the winner" ,align="center",font=("Arial",15,'normal'))
        self.dice.onclick(self.play)
       
        
        

    def move(self,currPlayer,total):
        currPos=currPlayer.position
        targetPos = currPos+total
        if(targetPos<100):
           self.move_player(currPlayer,targetPos)
        if(self.snake.isSnake(targetPos)):
            currPlayer.position =self.snake.snakeEnd(targetPos)
        elif(self.ladder.isLadder(targetPos)):
            currPlayer.position=self.ladder.ladderEnd(targetPos)
        elif(targetPos<=100):
            currPlayer.position = targetPos
        self.move_player(currPlayer,currPlayer.position)
     
    def setpos(self):
        #set all players at initial position
        inital_x = -310
        inital_y = -310
        for player in self.players:
            player.goto(inital_x,inital_y)
        self.dice.color("black",self.players[0].colur)
            
    def move_player(self,player,pos):
        #move the player to the target position
        print(pos,player.name)
        rows_left = [20,40,60,80,0]
        if((pos-1)//10)*10 in rows_left:
           #print("left side indexz starts")
           x_index = (pos-1)%10
           y_index = (pos-1)//10
        else:
           #print("index starts form right")
           x_index = -(pos)%10
           y_index = (pos-1)//10
        x_pos = self.x_cor[x_index]
        y_pos = self.y_cor[y_index]

        player.goto(x_pos, y_pos)

class Snake:
    def __init__(self):
        self.snakes = [[16,6],[46,25],[49,11],[62,19],[64,60],[74,53],[89,68],[92,88],[95,75],[99,80]]
        self.snakeBitted = []
        self.no_of_snakes =len(self.snakes)
    def isSnake(self, position):
        for i in range(self.no_of_snakes):
            if self.snakes[i][0]==position:
                self.snakeBitted = self.snakes[i]
                return True
        return False

    def snakeEnd(self, position):
        #currPlayer.position = targetPos
        tail = self.snakeBitted[1]
        self.snakeBitted = []
        print("Snake byted at :",position)
        return tail

class Ladder:
    def __init__(self):
        self.ladder = [[2,38],[7,14],[8,31],[15,26],[21,42],[28,84],[36,44],[51,67],[71,91],[78,98],[87,94]]
        self.ladderClimb = []
        self.no_of_ladders =len(self.ladder)
    def isLadder(self,position):
        for i in range(self.no_of_ladders):
   
            if self.ladder[i][0]== position:
                self.ladderClimb= self.ladder[i]
                return True
        return False
    
    def ladderEnd(self, position):
        top = self.ladderClimb[1]
        self.ladderClimb = []
        print("Climbed ladder at",position)
        return top

class Dice(Turtle):
    def __init__(self):
        Turtle.__init__(self,shape = "square")
        self.color("black","white")
        self.up()
        self.goto(380,0)
        #self.onclick(self.hello)
        self.dices =1# int(input("Enter number of dices"))
        self.value =[]
        self.write("click me to roll")
    
    def roll(self):
        count = 0
        for i in range(self.dices):
            self.value.append(random.randint(1,6))
        outcomes =self.value
        self.clear()
        self.write(" value is "+str(sum(outcomes)),move=False,align="center",font=("Arial",15,'normal'))
        time.sleep(1)
        self.value=[]
        return outcomes
   
    def over_lucky(self):
     self.clear()
     self.write("too lucky something is fishy",move= False, align="center")


class Player(Turtle):
    def __init__(self,name,color):
        Turtle.__init__(self,shape = "turtle")
        self.up()
        self.position=0
        self.name = name
        self.color(color,color)
        self.colur=color
        
       
if __name__=="__main__":
    window = Screen()
    window.setup(width=1.0, height=1.0, startx=None, starty=None)
    window.bgpic("board.gif")
    b=Board(100)
    b.dice.onclick(b.play)
    mainloop()

