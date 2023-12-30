package org.uv.Abarrotes;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uv.Abarrotes.servicio.RolService;

@SpringBootApplication
public class AbarrotesApplication {

	@Autowired
    private RolService rolService;

	public static void main(String[] args) {
		SpringApplication.run(AbarrotesApplication.class, args);
	}

	//Metodo para crear el rol=Empleado por defecto
    @PostConstruct
    public void init() {
        rolService.init();
    }
}