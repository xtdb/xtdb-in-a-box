package cruxinabox;

import java.io.File;
import java.io.IOException;
import crux.api.Crux;
import crux.api.ICruxAPI;

class Box {
    public static void main(String[] args) {
        try(ICruxAPI cruxNode = Crux.startNode(new File("config.json"))) {
            System.console().writer().println("Started.");
        }
        catch (IOException e) {
            // ...
        }
    }
}
