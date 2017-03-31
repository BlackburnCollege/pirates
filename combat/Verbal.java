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
public class Verbal implements Action{
    private double multiplier;
    
    private String[] insults;
    private Random randNum;

    public Verbal(double multiplier) {
        String[] insults = {"Go VERB yourself, you ADJECTIVE NOUN"};
        this.insults = insults;
        this.randNum = new Random();
        this.multiplier = multiplier;
    }

    public String generateInsult() {
        String finalInsult = "";
        int adjective = 0;
        int verb = 0;
        int noun = 0;
        int insult = 0;
        
        insult = this.randNum.nextInt(this.insults.length);
        
        finalInsult = this.insults[insult];
        while(finalInsult.contains("VERB")){
            verb = this.randNum.nextInt(Verbs.values().length);
            finalInsult = finalInsult.replaceFirst("VERB", Verbs.values()[verb].toString().toLowerCase());
        }
        while(finalInsult.contains("ADJECTIVE")){
            adjective = this.randNum.nextInt(Adjectives.values().length);
            finalInsult = finalInsult.replaceFirst("ADJECTIVE", Adjectives.values()[adjective].toString().toLowerCase());
        }
        while(finalInsult.contains("NOUN")){
            noun = this.randNum.nextInt(Nouns.values().length);
            finalInsult = finalInsult.replaceFirst("NOUN", Nouns.values()[noun].toString().toLowerCase());
        }
        return finalInsult;
    }
    
    @Override
    public void affect(Entity entity){
        
    }
}
