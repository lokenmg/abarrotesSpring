/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import javax.persistence.Column;

@Entity
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidad_medida_id_unidad_med_seq")
    @SequenceGenerator(name = "unidad_medida_id_unidad_med_seq", sequenceName = "unidad_medida_id_unidad_med_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_unidad_med")
    private Long idUnidadMed;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "unidadMedida")
    private List<Producto> productos;

    public UnidadMedida(Long idUnidadMed, String nombre, List<Producto> productos) {
        this.idUnidadMed = idUnidadMed;
        this.nombre = nombre;
        this.productos = productos;
    }

    public UnidadMedida() {
    }

    public Long getIdUnidadMed() {
        return idUnidadMed;
    }

    public void setIdUnidadMed(Long idUnidadMed) {
        this.idUnidadMed = idUnidadMed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
}
