/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import java.util.Random;

/**
 *
 * @author arthur.levan
 */
public class Insult {
    private String[] adjective;
    private String[] verb;
    private String[] noun;
    private Random randNum;

    public Insult(String[] first, String[] middle, String[] last) {
        this.adjective = first;
        this.verb = middle;
        this.noun = last;
        this.randNum = new Random();
    }
    
    private String createInsult(){
        String insult;
        
        int first = this.randNum.nextInt(this.adjective.length);
        int middle = this.randNum.nextInt(this.verb.length);
        int last = this.randNum.nextInt(this.noun.length);
        
        insult = this.adjective[first] + " " + this.verb[middle] + " " + this.noun[last];
        
        return insult;
    }
}
