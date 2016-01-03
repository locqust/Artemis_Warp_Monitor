/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artemis_warp_monitor;

/**
 *
 * @author Andy
 */

import java.io.IOException;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.dhleong.acl.enums.Console;
import net.dhleong.acl.iface.ArtemisNetworkInterface;
import net.dhleong.acl.iface.ConnectionSuccessEvent;
import net.dhleong.acl.iface.DisconnectEvent;
import net.dhleong.acl.iface.Listener;
import net.dhleong.acl.iface.ThreadedArtemisNetworkInterface;
import net.dhleong.acl.protocol.ArtemisPacket;
import net.dhleong.acl.protocol.core.setup.ReadyPacket;
import net.dhleong.acl.protocol.core.setup.SetConsolePacket;
import net.dhleong.acl.protocol.core.GameMessagePacket;
import net.dhleong.acl.protocol.core.setup.SetShipPacket;

public class Artemis_Warp_Monitor {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: ArtemisClientDemo {host} [port]");
            return;
        }
        String host = args[0];
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 2010;

        try {
            new Artemis_Warp_Monitor(host, port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private ArtemisNetworkInterface server;

    public Artemis_Warp_Monitor(String host, int port) throws IOException {
        server = new ThreadedArtemisNetworkInterface(host, port);
        server.addListener(this);
        server.start();
    }

    @Listener
    public void onConnectSuccess(ConnectionSuccessEvent event) {
        server.send(new SetConsolePacket(Console.OBSERVER, true));
        server.send(new ReadyPacket());
        System.out.println(event);
    }

    @Listener
    public void onSetShipPacket (SetShipPacket pkt) {
            System.out.println(pkt);
}
    @Listener
    public void onGameMessagePacket(GameMessagePacket pkt) {
        if (pkt.getMessage().contains("play 15 second")) {
            System.out.println("notification to play video files" + pkt);
            try {
                Warp15.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 30 second")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp30.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 45 second")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp45.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 1 minute")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp60.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 2 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp120.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 3 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp180.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 4 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp240.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 5 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp300.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 6 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp360.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 8 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp480.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("play 10 minutes")) {
            System.out.println("notification to play video files" + pkt);
              try {
                Warp600.front();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (pkt.getMessage().contains("exit video")) {
            System.out.println("notification to close video player" + pkt);
              try {
                KillVLC.kill();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Artemis_Warp_Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else {
            System.out.println("Found unknown" + pkt);
        }
    }
    

        @Listener
    public void onDisconnect(DisconnectEvent event) {
        System.out.println("Disconnected: " + event.getCause());
    }
}