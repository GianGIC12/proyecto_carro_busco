/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zpruebas;

import archivos.Exportar_Resultados;
import gestion.Querys;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Ejecucion_Carro_Busco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here

        Querys q = new Querys();

        q.conseguir_moviles();
        q.conseguir_condicion();
        q.conseguir_marca();
        q.conseguir_modelo();
        q.conseguir_anio();

        System.out.println("*********************************************************");
        System.out.println("***********************************************");

        q.mostrar_resultados();

        Exportar_Resultados e = new Exportar_Resultados();

        e.exportar(q.getCarros());

    }

}
