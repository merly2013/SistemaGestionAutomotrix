package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

import Automotriz.controller.SistemaController;
import Automotriz.view.LoginFrame;

public class SistemaGestionAutomotriz {

    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame(sistema).setVisible(true);
        });
    }
}