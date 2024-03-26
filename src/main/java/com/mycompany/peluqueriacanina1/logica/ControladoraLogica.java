
package com.mycompany.peluqueriacanina1.logica;

import com.mycompany.peluqueriacanina1.persistencia.ControladoraPersistencia;
import java.util.List;


public class ControladoraLogica {
    
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void guardar(String nombre, String area, String celDuenio, String color, String NombreDuenio, 
                        String raza, String alergico, String especial) {
       
        // creamos a Duenio y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(NombreDuenio);
        
        // creamos Mascota y asignamos sus valores
        Mascota masco =new Mascota();
        masco.setAlergico(alergico);
        masco.setAtencion_especial(especial);
        masco.setColor(color);
        masco.setNombre(nombre);
        masco.setRaza(raza);
        masco.setObservaciones(area);
        masco.setDuenio(duenio);
    
        controlPersi.guardar(duenio,masco);
        
    }

    public List<Mascota> traerMascotas() {
        
       return controlPersi.traerMacotas();
        
    }

    public void borrarMascota(int num_cliente) {
      
        controlPersi.borrarMascota(num_cliente);
    
    }

    public Mascota traerMascota(int num_cliente) {
        
        return controlPersi.traerMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco, String nombre, String area, String celDuenio, 
                                 String color, String NombreDuenio, String raza, String alergico, String especial) {
  
        masco.setAlergico(alergico);
        masco.setAtencion_especial(especial);
        masco.setColor(color);
        masco.setNombre(nombre);
        masco.setObservaciones(alergico);
        masco.setRaza(raza);
        // modifico mascota
        controlPersi.modificarMascota(masco);
        
        //seteo nuevos valores de duenio
        Duenio dueno = this.buscarDuenio(masco.getDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(NombreDuenio);
        //llamar al modificar de duenio
        this.modificarDuenio(dueno);
    
    }

    private Duenio buscarDuenio(int id_duenio) {
  
         return controlPersi.traerDuenio(id_duenio);   
    
    }

    private void modificarDuenio(Duenio dueno) {
          controlPersi.modificarDuenio(dueno);
        
    }

    
        
   

     

    
}
