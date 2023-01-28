package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.DoubleBuffer;

public class Panel extends  JPanel{


    JButton conversorBtn = new JButton("Procesar");
    JLabel titleConversor = new JLabel("Conversor De Monedas");
    String listMonedas[] = {"Soles","Dolares","Euros","Libras Esterlinas","Yen Japones","Won sul-coreano"};

    JLabel monto = new JLabel("Monto - Soles");
    JTextField inputUser = new JTextField();

    JLabel moneda = new JLabel("Convertir a");

    JComboBox<String> listOptions = new JComboBox<String>(listMonedas);

    JLabel tagResultado = new JLabel("Resultado :");
    JLabel resultado = new JLabel("");

    String valorResultado = "";

    Evento eventoProcesar = new Evento(resultado, inputUser, listOptions);

    public Panel(int ancho, int alto){
        setBounds(0,0,ancho, alto);
        setLayout(null);

        titleConversor.setBounds(350,50,500,50);
        titleConversor.setFont(new Font("Calibri", Font.BOLD, 30));
        add(titleConversor);


        add(monto);
        monto.setFont(new Font("Calibri", Font.BOLD, 25));
        monto.setBounds(50,150,200,50);

        add(inputUser);
        inputUser.setFont(new Font("Calibri", Font.BOLD, 25));
        inputUser.setBounds(250,150,200,50);

        add(moneda);
        moneda.setFont(new Font("Calibri", Font.BOLD, 25));
        moneda.setBounds(50,250,200,50);

        listOptions.setSelectedIndex(2);
        listOptions.setFont(new Font("Calibri", Font.BOLD, 25));
        listOptions.setBounds(250,250,200,50);
        add(listOptions);

        conversorBtn.addActionListener(eventoProcesar);
        conversorBtn.setFont(new Font("Calibri", Font.BOLD, 25));
        conversorBtn.setBounds(250,350,200,50);
        add(conversorBtn);


        add(tagResultado);
        tagResultado.setFont(new Font("Calibri", Font.BOLD, 25));
        tagResultado.setBounds(50,450,200,50);

        add(resultado);
        resultado.setFont(new Font("Calibri", Font.BOLD, 25));
        resultado.setBounds(250,450,500,50);
    }




    static class Evento implements ActionListener {

        JLabel resultado;
        JTextField entrada;
        JComboBox<String> combo;
        Double total =0.0 ;
        Double valorUser;
        String textoResultado = "";
        String resultadoFinal;


        public Evento(JLabel resultado, JTextField entrada, JComboBox<String> combo){
            super();
            this.resultado = resultado;
            this.entrada = entrada;
            this.combo = combo;
        }

        public void actionPerformed(ActionEvent e) {

            String a =  (String)combo.getSelectedItem();
            try{
                valorUser =  Double.parseDouble( entrada.getText());
                resultadoFinal = VeritemSelected(a, valorUser);
                resultado.setText(resultadoFinal);
            }catch(Exception q) {
                System.out.println("Invalid data");
            }
        }

        public String VeritemSelected(String option, Double cantidad){
            if(option == "Soles"){
                total = cantidad;
                textoResultado = total + " Soles.";
            }
            if(option == "Dolares"){
               total = cantidad * 0.26;
                textoResultado = total + " Dolares.";
            }
            if(option == "Euros"){
                total = cantidad * 0.24;
                textoResultado = total + " Euros.";
            }
            if(option == "Libras Esterlinas"){
                total = cantidad * 0.21;
                textoResultado = total + " Libras Esterlinas.";
            }
            if(option == "Yen Japones"){
                total = cantidad * 33.96;
                textoResultado = total + " Yen Japones.";
            }
            if(option == "Won sul-coreano"){
                total = cantidad * 321.62;
                textoResultado = total + " Won sul-coreano.";
            }

            return textoResultado;
        }
    }

}


