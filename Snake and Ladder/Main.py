''' 
Snake and Ladder Game
'''

import random
from turtle import *
class Board:
    def __init__(self,size):
        self.size = size
        self.snake = Snake()
        self.ladder = Ladder()
        self.dice = Dice()
        self.no_of_players = int(input("Enter Number of players"))
        self.currPos=0
        
        self.createPlayers()
        self.startGame()
        

    def createPlayers(self):
        self.players =[]
        for i in range(self.no_of_players):
            self.players.append(Player(input("Enter Name"),"red"))
        
    def startGame(self):
        print("Start Game")
        index=0
        while(len(self.players)>index):
            self.currPlayer= self.players[index]
            self.outcome =self.dice.roll()
            self.total =0
            
            for i in range(len(self.outcome)):
                self.total +=self.outcome[i]
            self.move(self.currPlayer,self.currPlayer.position,self.total)
            print(self.currPlayer.name,self.currPlayer.position)
            if(self.currPlayer.position ==100):
                print(self.currPlayer.name ,"is winner")
                
                break
            else:
                index+=1
            if(index==len(self.players)):
                index=0
    def move(self,currPlayer,currPos,total):
        
        self.targetPos = self.currPos+total
        if(self.snake.isSnake(self.targetPos)):
            currPlayer.position =snakeEnd(self.targetPos)
        elif(self.ladder.isLadder(self.targetPos)):
            currPlayer.position=ladderEnd(self.targetPos)
            

        elif(self.targetPos<100):
            
            #position(currPlayer,currPlayer.position)
            currPlayer.position += self.targetPos
        

class Snake:
    def __init__(self):
        self.snakes = []
        self.snakeBitted = []
        self.no_of_snakes = int(input("Enter count of Snake"))
        for i in range(self.no_of_snakes):
            self.snakes.append(list(map(int,input("Enter head and tail seperated by space").split())))
    def isSnake(self, position):
        for i in range(self.no_of_snakes):
            if self.snakes[i][0]==position:
                self.snakeBitted = i
                return True
        return False

    def snakeEnd(self, position):
        tail = self.snakeBitted[1]
        self.snakeBitted = []
        print("Snake byted at :",position)
        return tail

class Ladder:
    def __init__(self):
        self.ladder = []
        self.ladderClimb = []
        self.no_of_ladders = int(input("Enter count of Ladder"))
        for i in range(self.no_of_ladders):
            self.ladder.append(list(map(int,input("Enter bottom and top seperated by space").split())))
    def isLadder(self,position):
        for i in range(self.no_of_ladders):
            if(self.ladder[i][0]== position):
                self.laddeClimb= i
                return True
        return False
    def ladderEnd(self, position):
        top = self.ladderClimb[1]
        self.ladderClimb = []
        print("Climbed ladder at",position)
        return top

class Dice(Turtle):
    def __init__(self):
        Turtle.__init__(self,shape = "circle")
        self.color("black","white")
        self.up()
        #self.goto()
       
        self.dices = int(input("Enter number of dices"))
        self.value =[]

    def roll(self):
       
        for i in range(self.dices):
            self.value.append(random.randint(1,6))
        getValue =self.value
        self.value=[]
        return getValue
    def is6(self):
        self.count=self.roll()
        for i in range(self.count):
            if(self.count[i]!=6):
                return False
        return True
    def isnextChance(self,count6):
        if (count6>2):
            print("Ooops! 3 sixes")
            return False
        return True
class Player(Turtle):
    def __init__(self,name,color):
        Turtle.__init__(self,shape = "circle")
        self.up()
        self.position=0
        self.name = name
    def position(self,currPlayer,targetPos):
        #self.= targetPos
        pass
        
if __name__=="__main__":
    Board(100)
