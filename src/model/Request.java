
package model;

import java.time.LocalDateTime;

/**
 *
 * @author miguel
 */
public class Request {
    private String request;
    private LocalDateTime time;
    private LocalDateTime end;

    public Request () {
        this.time = LocalDateTime.now();
        this.end = this.time.plusHours(1);
    }
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Request{" + "request=" + request + ", time=" + time + ", end=" + end + '}';
    }
}
