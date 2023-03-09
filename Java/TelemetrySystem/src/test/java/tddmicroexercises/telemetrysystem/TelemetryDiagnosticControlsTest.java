package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tddmicroexercises.telemetrysystem.refactored.*;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mock;

public class TelemetryDiagnosticControlsTest
{
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String diagnosticInfo="test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        TelemetryConnection connectionService = mock(TelemetryConnectionImplementation.class);
        Status status = mock(Status.class);
        Mockito.when(status.getOnlineStatus()).thenReturn(true);
        TelemetryClientTransmission transmissionService = mock(TelemetryClientTransmissionImpl.class);
        Mockito.when(transmissionService.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(status, connectionService, transmissionService);
        telemetryDiagnosticControls.setDiagnosticInfo(diagnosticInfo);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
    }

}
