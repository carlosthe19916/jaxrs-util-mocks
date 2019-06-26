package io.mocks.xavier.socket;

import io.mocks.xavier.ReportEvent;
import io.mocks.xavier.ReportEventType;
import io.mocks.xavier.model.Report;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@ServerEndpoint("/api/migration-analytics/report")
public class ReportSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session.getId());
    }

    @OnMessage
    public void onMessage(String message) {
//        broadcast(">> " + username + ": " + message);
    }

    public void observeAddedReports(@Observes @ReportEvent(value = ReportEventType.ADDED) Report report){
        broadcast(ReportEventType.ADDED, report);
    }

    public void observeModifiedReports(@Observes @ReportEvent(value = ReportEventType.MODIFIED) Report report){
        broadcast(ReportEventType.MODIFIED, report);
    }

    public void observeDeletedReports(@Observes @ReportEvent(value = ReportEventType.DELETED) Report report){
        broadcast(ReportEventType.DELETED, report);
    }

    private void broadcast(ReportEventType type, Report report) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("type", type.toString())
                .add("object", Json.createObjectBuilder()
                        .add("kind", "Report")
                        .add("metadata", Json.createObjectBuilder()
                                .add("id", report.getId())
                                .add("customerId", report.getCustomerId())
                                .add("fileName", report.getFileName())
                                .add("numberOfHosts", report.getNumberOfHosts())
                                .add("totalDiskSpace", report.getTotalDiskSpace())
                                .add("totalPrice", report.getTotalPrice())
                                .add("creationDate", report.getCreationDate())
                                .add("analysisStatus", report.getAnalysisStatus().toString())
                                .build()
                        )
                        .build()
                )
                .build();

        String message = jsonObject.toString();

        System.out.println(message);

        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }

}
