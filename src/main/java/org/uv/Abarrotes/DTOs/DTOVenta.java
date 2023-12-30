package org.uv.Abarrotes.DTOs;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.NotaVenta;


public class DTOVenta {

    private double numeronota;
    private String fecha;
    private double total;
    //datos de anticipo
    private BigDecimal monto;
    private BigDecimal resto;
    private String estadoPago;

    //datos de cliente
    private String nombreCliente;

    //datos de empleado
    private String nombreEmpleado;

    //datos de departamento
    private String nombredepartamento;

    //datos de detalle pedido
    private Date fechaEntrega;
    private Time horaEntrega;
    private String estadoPedido;

    //datos de detalle venta
    private java.util.List<DTODetallesVentas> detalleVenta = new java.util.ArrayList<>();
    
    //constructor vacio
    public DTOVenta() {
    }

    public DTOVenta(NotaVenta notaVenta){
        this.numeronota = notaVenta.getNumeroNota();
        this.fecha = notaVenta.getFecha().toString();
        this.total = notaVenta.getTotal().doubleValue();
        //anticipo
        this.monto = notaVenta.getAnticipo().getMonto();
        this.resto = notaVenta.getAnticipo().getResto();
        this.estadoPago = notaVenta.getAnticipo().getEstadoPago().getEstado();
        this.nombreCliente = notaVenta.getCliente().getNombre();
        this.nombreEmpleado = notaVenta.getEmpleado().getNombre();
        this.nombredepartamento = notaVenta.getDepartamento().getNombre();
        this.fechaEntrega = notaVenta.getDetallePedido().getFechaEntrega();
        this.horaEntrega = notaVenta.getDetallePedido().getHoraEntrega();
        this.estadoPedido = notaVenta.getDetallePedido().getEstadoPedido().getEstado();
        //detalle venta
        this.detalleVenta = obtenerDetallesVentas(notaVenta.getDetalleVenta());
    }
    //gettesrs y setters
    public double getNumeronota() {
        return numeronota;
    }

    public void setNumeronota(double numeronota) {
        this.numeronota = numeronota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getResto() {
        return resto;
    }

    public void setResto(BigDecimal resto) {
        this.resto = resto;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DTODetallesVentas> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DTODetallesVentas> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
    private List<DTODetallesVentas> obtenerDetallesVentas (List<DetalleVenta> detalleVentas ){
        List<DTODetallesVentas> detalles = new ArrayList<>();
        for (DetalleVenta detalleVenta : detalleVentas) {
            DTODetallesVentas detalle = new DTODetallesVentas();
            detalle.setCantidad(detalleVenta.getCantidad());
            detalle.setSubtotal(detalleVenta.getSubtotal());
            detalle.setCodigo(detalleVenta.getProducto().getCodigo());
            detalle.setNombre(detalleVenta.getProducto().getNombre());
            detalle.setExistencia(detalleVenta.getProducto().getExistencia());
            detalles.add(detalle);
        }
        return detalles;
    }
}
