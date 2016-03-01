
package com.manh.webscoket.client.listener;

import javax.websocket.*;

public interface MessageModesClientListener {
    public void setConnected(boolean isConnected, CloseReason cr);
    public void reportMessage(String message);
    public void reportConnectionHealth(long millis);
}
