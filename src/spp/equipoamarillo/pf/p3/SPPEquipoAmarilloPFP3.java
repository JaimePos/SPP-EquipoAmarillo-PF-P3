
package spp.equipoamarillo.pf.p3;
import java.util.*;
import javax.swing.*;
public class SPPEquipoAmarilloPFP3 {

    public static void main(String[] args) {
        int num1, num2, mcm, mcd;
        String[] opciones = {"MCD", "MCM", "Salir" };
 
        int opcion = JOptionPane.showOptionDialog(null, "Que desea hacer", "Menu", 
                                                    JOptionPane.DEFAULT_OPTION, 
                                                    JOptionPane.INFORMATION_MESSAGE, 
                                                    null, opciones, null);
 
        switch (opcion){
            case 0:
                JOptionPane.showMessageDialog(null, "Usted selecciono Maximo Comun Denominador");
                num1 = pedirnum("primer");
                num2 = pedirnum("segundo");
                mcd = calculo1(num1, num2);
                JOptionPane.showMessageDialog(null, "El Maximo Comun Denominador es " + mcd);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Usted selecciono Minimo Comun Multiplo");
                num1 = pedirnum("primer");
                num2 = pedirnum("segundo");
                mcm = calculo2(num1, num2);
                JOptionPane.showMessageDialog(null, "El Minimo Comun Multiplo es " + mcm);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Usted selecciono salir");
                break;
        }
    }
    
    public static int pedirnum (String x){
        String numeroP = "";
        int numero = 0;
        boolean flag;
        do{
            numeroP = JOptionPane.showInputDialog(null, "Introduce el " + x + " numero");
            try{
                numero = Integer.parseInt(numeroP);
                flag = false;
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error, el dato no es un numero");
                    flag = true;
                }
                } while (flag);
    return numero;
    }
    
    public static int calculo1 (int x, int y){
        if (y == 0){
            return x;
        } else return calculo1(y, x % y);         
    }
    
    public static int calculo2 (int x, int y){
        int min = Math.min(x, y);
        int mcm = 0;
        for (int i = 1; i <= min; i++){
            if (x%i == 0 && y%i == 0){
                int mcd = i;
                mcm = (x*y)/mcd;
            }
        }
        return mcm;
    }
}
