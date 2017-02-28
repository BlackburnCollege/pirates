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
    private String[] first;
    private String[] middle;
    private String[] last;
    private Random randNum;

    public Insult(String[] first, String[] middle, String[] last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.randNum = new Random();
    }
    
    private String createInsult(){
        String insult;
        
        int first = this.randNum.nextInt(this.first.length);
        int middle = this.randNum.nextInt(this.middle.length);
        int last = this.randNum.nextInt(this.last.length);
        
        insult = this.first[first] + " " + this.middle[middle] + " " + this.last[last];
        
        return insult;
    }
}
