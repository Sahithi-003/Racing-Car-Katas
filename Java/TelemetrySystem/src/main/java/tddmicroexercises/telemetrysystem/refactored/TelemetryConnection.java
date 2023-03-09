package tddmicroexercises.telemetrysystem.refactored;

public interface TelemetryConnection {
    public void connect(String telemetryServerConnectionString);
    public void disconnect();
}
