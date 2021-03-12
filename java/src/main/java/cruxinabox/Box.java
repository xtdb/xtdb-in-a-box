package cruxinabox;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import crux.api.Crux;
import crux.api.ICruxAPI;
import crux.api.CruxDocument;
import crux.api.TransactionInstant;
import crux.api.tx.Transaction;

class Box {
    public static void main(String[] args) {
        try (ICruxAPI node = Crux.startNode(new File("config.json"))) {
            System.out.println("Started.");

            // submitTx example:
            HashMap<String, Object> data = new HashMap<>();
            data.put("user/name", "zig");
            CruxDocument document = CruxDocument.create("hi2u", data);
            TransactionInstant transaction = node.submitTx(Transaction.buildTx(tx -> {
                tx.put(document);
            }));

            // query example:

        }
        catch (IOException e) {
            // ...
        }
    }
}
