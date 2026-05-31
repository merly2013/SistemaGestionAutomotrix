
package Automotriz.controller;

public class SistemaController {
    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private OrdenService ordenService;
    private MecanicoService mecanicoService;
    private LoginController LoginController;
    
    
    public SistemaController() {
        LoginController = new LoginController();
        mecanicoService = new MecanicoService(LoginController.getUsuarios());
        clienteService = new ClienteService();
        vehiculoService = new VehiculoService();
        ordenService = new OrdenService();
    }
    
    public ClienteService getClienteService() { return clienteService; }
    public VehiculoService getVehiculoService() { return vehiculoService; }
    public OrdenService getOrdenService() { return ordenService; }
    public MecanicoService getMecanicoService() { return mecanicoService; }
    public LoginController getLoginController() { return LoginController; }

}