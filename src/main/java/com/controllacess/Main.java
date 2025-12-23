package com.controllacess;

import com.controllacess.Service.PowershellService;

public class Main {
    public static void main(String[] args) {
        PowershellService power = new PowershellService();
        power.createThread();
    }
}