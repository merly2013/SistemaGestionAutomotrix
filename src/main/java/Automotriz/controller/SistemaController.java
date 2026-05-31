
package Automotriz.controller;

public class SistemaController {
    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private OrdenService ordenService;
    private MecanicoService mecanicoService;
    private LoginController loginController;
    
    public SistemaController() {
        loginController = new LoginController();
        mecanicoService = new MecanicoService(loginController.getUsuarios());
        clienteService = new ClienteService();
        vehiculoService = new VehiculoService();
        ordenService = new OrdenService();
    }
    
    public ClienteService getClienteService() { return clienteService; }
    public VehiculoService getVehiculoService() { return vehiculoService; }
    public OrdenService getOrdenService() { return ordenService; }
    public MecanicoService getMecanicoService() { return mecanicoService; }
    public LoginController getLoginController() { return loginController; }

    
    public void iniciarAplicacion() {
       
        Automotriz.modelo.Mecanico meca1 = new Automotriz.modelo.Mecanico("Juan Perez", 101, 5, true);
        
        
        this.mecanicoService.crear(meca1);


        
        java.awt.EventQueue.invokeLater(() -> {
            new Automotriz.view.LoginFrame(this).setVisible(true);
        });
    }

    
    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();
        sistema.iniciarAplicacion();
    }

}