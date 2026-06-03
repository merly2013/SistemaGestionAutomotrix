
package Automotriz.controller;
import Automotriz.modelo.Inventario;

public class SistemaController {
    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private OrdenService ordenService;
    private MecanicoService mecanicoService;
    private Inventario inventario;
    private LoginController LoginController;
    private java.util.Map<String, Double> preciosServicios;
    
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
        preciosServicios.put("Cambio de Repuesto", 0.0); // depende del repuesto
        
        
    }
    
    public ClienteService getClienteService() { return clienteService; }
    public VehiculoService getVehiculoService() { return vehiculoService; }
    public OrdenService getOrdenService() { return ordenService; }
    public MecanicoService getMecanicoService() { return mecanicoService; }
    public LoginController getLoginController() { return LoginController; }
    public Inventario getInventario() { return inventario;}
    
    
    public double getPrecioServicio(String tipo) {
        return preciosServicios.getOrDefault(tipo, 0.0);
    }

    public void setPrecioServicio(String tipo, double precio) {
        preciosServicios.put(tipo, precio);
    }

}