"use strict"
class Dice {
   constructor(dice) {
        this.dice = dice;
    }
    
     roll() {
       this.dice = 1 + Math.floor(Math.random() * (6));
        }  
    }