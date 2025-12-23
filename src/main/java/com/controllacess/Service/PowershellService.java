package com.controllacess.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowershellService{

    public String executeCommand(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("powershell", "-Command", command);
        Process process = builder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))){
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        }
    }

    public void createThread() {
    new Thread(() -> {
        try {
            String comandoPS = "Register-WmiEvent -Class Win32_ProcessStartTrace -SourceIdentifier ProcessStarted " +
                               "-Action { Write-Host $Event.SourceEventArgs.NewEvent.ProcessName; [Console]::Out.Flush() }";

            ProcessBuilder builder = new ProcessBuilder("powershell.exe", "-NoExit", "-Command", comandoPS);
            
            builder.redirectErrorStream(true);

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linha;

            System.out.println("Monitoramento iniciado... (Aguardando processos)");

            while ((linha = reader.readLine()) != null) {
                System.out.println("PS: " + linha);

                if (linha.contains("Access denied") || linha.contains("Acesso negado")) {
                     System.out.println("ERRO CRÍTICO: Você precisa rodar o VS Code como ADMINISTRADOR.");
                }

                if (!linha.trim().isEmpty() && !linha.startsWith("PS")) {
                    String processoDetectado = linha.trim();
                    System.out.println("--> PROCESSO DETECTADO: [" + processoDetectado + "]");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
}



}
