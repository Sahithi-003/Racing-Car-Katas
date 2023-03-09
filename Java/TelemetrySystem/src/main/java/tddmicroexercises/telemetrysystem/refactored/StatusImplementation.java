package tddmicroexercises.telemetrysystem.refactored;

import tddmicroexercises.telemetrysystem.TelemetryClient;

public class StatusImplementation {
    private final TelemetryClient telemetryClient;

    public StatusImplementation(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public boolean getOnlineStatus()
    {
        return telemetryClient.getOnlineStatus();
    }
}
