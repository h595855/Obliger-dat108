"use strict"
class DiceController {
    constructor(id) {
        this.root = id;
        this.run = this.run.bind(this);
        this.rollDice = this.rollDice.bind(this);
        //konstruere ny terning
        this.dice = new Dice(1);
    }



    run() {
        let btRef = document.getElementById(this.root).getElementsByTagName("button")[0];
        btRef.addEventListener("click", this.rollDice, true);
    }

    rollDice() {
        this.dice.roll();

        this.diceoutput = document.getElementById(this.root).querySelector("*[data-diceoutput]");

        this.diceoutput.innerText = this.dice.dice;
    }

}

const controller = new DiceController("root");
document.addEventListener("DOMContentLoaded", controller.run, true);