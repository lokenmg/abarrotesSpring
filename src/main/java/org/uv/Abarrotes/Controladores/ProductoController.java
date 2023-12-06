/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.servicio.ProductoService;

/**
 *
 * @author loken
 */
@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
}
