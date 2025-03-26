package Refugeoly;

public class LoseAction extends Action{

    @Override
    public void act(Refugee refugee) {
        refugee.reduceLife();
        System.out.println("Game Over!\nΟ παίκτης " + refugee.getName() + " έχασε!");
    }
    
}
