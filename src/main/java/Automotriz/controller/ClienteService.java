package Automotriz.controller;
// @author Huber Herrera

import Automotriz.modelo.Cliente;
import Automotriz.persistencia.ArchivoUtil;
import java.util.ArrayList;

public class ClienteService implements GestionCliente {

    private static final String ARCHIVO = "clientes.dat";

    private ArrayList<Cliente> clientes;

    public ClienteService() {
        clientes = ArchivoUtil.cargarDatos(ARCHIVO);
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
        ArchivoUtil.guardarDatos(clientes, ARCHIVO);
    }

    @Override
    public Cliente buscar(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void modificar(Cliente cliente) {
        Cliente encontrado = buscar(cliente.getId());

        if (encontrado != null) {
            encontrado.setNombre(cliente.getNombre());
            encontrado.setCorreo(cliente.getCorreo());
            encontrado.setTelefono(cliente.getTelefono());

            ArchivoUtil.guardarDatos(clientes, ARCHIVO);
        }
    }

    @Override
    public void eliminar(int id) {
        Cliente cliente = buscar(id);

        if (cliente != null) {
            clientes.remove(cliente);
            ArchivoUtil.guardarDatos(clientes, ARCHIVO);
        }
    }

    public ArrayList<Cliente> consultar() {
        return clientes;
    }
}

