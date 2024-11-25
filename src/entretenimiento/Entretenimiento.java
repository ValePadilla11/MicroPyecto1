
package entretenimiento;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Entretenimiento {

    public static void main(String[] args) {
        
        // Carga el archivo de lenguaje de control difuso 'FCL'
        String fileName = "src/entretenimiento/FCL_Entretenimiento.fcl";
        FIS fis = FIS.load(fileName, true);
        
        // En caso de error
        if (fis == null) {
            System.err.println("No se puede cargar el archivo: '" + fileName + "'");
            return;
        }
        
        // Establecer las entradas del sistema
        fis.setVariable("Disponibilidad_de_Tiempo", 120);
        fis.setVariable("Duracion_del_Contenido", 112);
        fis.setVariable("Epoca_de_Emision", 1);
        // Inicia el funcionamiento del sistema
        fis.evaluate();

        // Muestra los gráficos de las variables de entrada y salida
        //JFuzzyChart.get().chart(fis.getFunctionBlock("Entretenimiento"));
        

             
        // Imprime el valor concreto de salida del sistema
        double salida = fis.getVariable("Nivel_de_Compatibilidad_de_Tiempo").getLatestDefuzzifiedValue();
        
        System.out.println("Para los valores de entrada el Nivel_de_Compatibilidad_de_Tiempo es: " + String.format("%.1f", salida) + "\n");
 
        double salida2 = fis.getVariable("Posibilidad_de_Consumo_Completo").getLatestDefuzzifiedValue();
        System.out.println("Para los valores de entrada la Posibilidad_de_Consumo_Completo es: " + String.format("%.1f", salida2) + "\n");

        // Muestra las reglas y el valor de salida de cada una despues de aplicar las operaciones lógicas
        fis.getFunctionBlock("Entretenimiento").getFuzzyRuleBlock("No1").getRules().forEach(r -> {
            System.out.println(r);
        });
        System.out.println();

    }
    
}