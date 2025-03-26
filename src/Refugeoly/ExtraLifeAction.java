package Refugeoly;

public class ExtraLifeAction extends Action {
    
    @Override
    public void act(Refugee refugee){
        refugee.addLife();
    }
}
