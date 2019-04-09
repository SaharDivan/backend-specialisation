package at.nacs.agent.ui;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Displayer {

  public void display(Integer price, List<String> listOfHandShake){
       System.out.print("For the secret sign: "+ price+", ");
       System.out.print("shows:");
       System.out.println(listOfHandShake);
   }
}
