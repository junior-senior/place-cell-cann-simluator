package nodes;

public class Main {

    static int delay = 250;
//Based off Main from Theo's Game of Life
    public static void main(String[] args) {
        Run run = new Run();
        
        while (true) {
            run.ui.CANN.VbotAsInput();
            run.ui.CANN.environment.updateGridImage();
            try {
                Thread.sleep(delay);
                run.ui.CANN.updateGridImage();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
