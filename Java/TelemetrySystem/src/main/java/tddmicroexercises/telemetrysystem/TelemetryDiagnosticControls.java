package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.refactored.*;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private Status status;
    private TelemetryConnection telemetryConnection;
    private TelemetryClientTransmission telemetryClientTransmission;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(Status status, TelemetryConnection telemetryConnection, TelemetryClientTransmission telemetryClientTransmission)
    {
        this.status = status;
        this.telemetryConnection = telemetryConnection;
        this.telemetryClientTransmission = telemetryClientTransmission;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        telemetryConnection.disconnect();

        int retryLeft = 3;
        while (!status.getOnlineStatus() && retryLeft > 0)
        {
            telemetryConnection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(status.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        telemetryClientTransmission.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClientTransmission.receive();
    }
}
