
package com.mycompany.peluqueriacanina1.persistencia;

import com.mycompany.peluqueriacanina1.logica.Duenio;
import com.mycompany.peluqueriacanina1.logica.Mascota;
import com.mycompany.peluqueriacanina1.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController duenioControl = new DuenioJpaController();
    MascotaJpaController mascotaControl = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
        //crear duenio en la BD
        duenioControl.create(duenio);
        
        //crear mascota en la BD
        mascotaControl.create(masco);
    
    
    }

    public List<Mascota> traerMacotas() {
        
        return mascotaControl.findMascotaEntities();
 
    
    }

    public void borrarMascota(int num_cliente) {
      
        try {
            mascotaControl.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Mascota traerMascota(int num_cliente) {
            return mascotaControl.findMascota(num_cliente);
    
    }

    

    public Duenio traerDuenio(int id_duenio) {
        return duenioControl.findDuenio(id_duenio);
   }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioControl.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaControl.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
