
package Views;
import javax.swing.*;

public class Ventana extends JFrame {

    Panel nuevo= new Panel(1000,700);

    public Ventana(){
        setVisible(true);
        setBounds(300,150,1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(nuevo);
    }

}
