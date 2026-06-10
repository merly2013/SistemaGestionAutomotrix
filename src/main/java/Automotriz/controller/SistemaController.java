
package Automotriz.controller;
import Automotriz.modelo.Inventario;
import Automotriz.modelo.Orden;
import Automotriz.persistencia.ArchivoUtil;
import java.util.List;

public class SistemaController {
    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private OrdenService ordenService;
    private MecanicoService mecanicoService;
    private Inventario inventario;
    private LoginController LoginController;
    private java.util.Map<String, Double> preciosServicios;
    private static final String ARCHIVO_PRECIOS = "precios.dat";
    
    public SistemaController() {
        LoginController = new LoginController();
        mecanicoService = new MecanicoService(LoginController.getUsuarios());
        clienteService = new ClienteService();
        vehiculoService = new VehiculoService();
        ordenService = new OrdenService();
        inventario = new Inventario();
        
        
        preciosServicios = new java.util.HashMap<>();

        preciosServicios.put("Cambio de Aceite", 80000.0);
        preciosServicios.put("Revision de Frenos", 50000.0);
        preciosServicios.put("Revision General", 60000.0);
        preciosServicios.put("Cambio de Repuesto", 0.0);
        
    }
    
    public ClienteService getClienteService() { return clienteService; }
    public VehiculoService getVehiculoService() { return vehiculoService; }
    public OrdenService getOrdenService() { return ordenService; }
    public MecanicoService getMecanicoService() { return mecanicoService; }
    public LoginController getLoginController() { return LoginController; }
    public Inventario getInventario() { return inventario;}
    
    public void setPrecioServicio(String tipo, double precio) {
        preciosServicios.put(tipo, precio);
        //ArchivoUtil.guardarDatos(preciosServicios, ARCHIVO_PRECIOS);
    }
    
    public double getPrecioServicio(String tipo) {
        return preciosServicios.getOrDefault(tipo, 0.0);
    }
    
    public List<Orden> getOrdenes() {
        return ordenService.consultar();
    }
}