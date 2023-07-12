package de.aittr.iocdemo;

import org.springframework.stereotype.Component;

public interface InterfaceTCPConnection {
    public void init();
    public void send();
    public void close();
}
