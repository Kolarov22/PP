package Lab8;

import java.time.LocalDateTime;

public class SensorEvent {
    private Integer source;
    private String type;
    private LocalDateTime timestamp;

    public SensorEvent(Integer source, String type, LocalDateTime timestamp) {
        this.source = source;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
