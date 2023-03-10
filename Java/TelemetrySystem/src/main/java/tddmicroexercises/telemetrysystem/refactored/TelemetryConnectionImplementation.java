package tddmicroexercises.telemetrysystem.refactored;

import tddmicroexercises.telemetrysystem.TelemetryClient;

public class TelemetryConnectionImplementation implements TelemetryConnection {
    private final TelemetryClient telemetryClient;

    public TelemetryConnectionImplementation(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }
    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = telemetryClient.getConnectionEventsSimulator().nextInt(10) <= 8;
        telemetryClient.setOnlineStatus(success);
    }

    public void disconnect()
    {
        telemetryClient.setOnlineStatus(false);
    }
}
