/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.Carro_Bean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class Exportar_Resultados {
    
   public void exportar(List<Carro_Bean> carritos) throws IOException {
       
       
        String outputFile = "G:/Mi unidad/Digital_Balance_TB/Base_carro_busco/bd_caracteristicas_carro_busco.csv";

     boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File bd_detalle_10 = new File(outputFile);
            bd_detalle_10.delete();
        }
       
    CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');   
       
    csvOutput.write("Id_aviso");
        csvOutput.write("Precio");
        csvOutput.write("Moneda");
        csvOutput.write("Pais");
        csvOutput.write("Tipo");
        csvOutput.write("Condicion");
        csvOutput.write("Marca");
        csvOutput.write("Modelo");
        csvOutput.write("Anio");
    
        csvOutput.endRecord();
        
        
        for (Carro_Bean carrito: carritos) {
           
            
        csvOutput.write(carrito.getId()+"");
        csvOutput.write(carrito.getPrecio()+"");
        csvOutput.write(carrito.getMoneda());
        csvOutput.write(carrito.getPais());
        csvOutput.write(carrito.getTipo());
        csvOutput.write(carrito.getCondicion());
        csvOutput.write(carrito.getMarca());
        csvOutput.write(carrito.getModelo());
        csvOutput.write(carrito.getAnio()+"");
    
        csvOutput.endRecord();
            
            
            
            
       }
        
        
        
        
         csvOutput.close();
       
       
   }
    
    
    
    
}
