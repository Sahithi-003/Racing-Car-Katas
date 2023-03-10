package tddmicroexercises.telemetrysystem.refactored;

public interface TelemetryClientTransmission {
    public void send(String message);
    public String receive();
}
