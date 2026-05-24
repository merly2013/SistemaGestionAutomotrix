package com.mycompany.sistemagestionautomotrix;
// @author Huber Herrera

import java.util.ArrayList;

public class ClienteService implements GestionCliente {

    private ArrayList<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(int id) {

        for(Cliente c : clientes){
            if(c.getId() == id){

                return c;

            }
        }

        return null;
    }

    @Override
    public void modificar(Cliente cliente) {

        Cliente encontrado = buscar(cliente.getId());

        if(encontrado != null){

            encontrado.setNombre(cliente.getNombre());
            encontrado.setCorreo(cliente.getCorreo());
            encontrado.setTelefono(cliente.getTelefono());

        }

    }

    @Override
    public void eliminar(int id) {

        Cliente cliente = buscar(id);

        if(cliente != null){
            clientes.remove(cliente);
        }

    }

    public ArrayList<Cliente> consultar() {
        return clientes;
    }
}


