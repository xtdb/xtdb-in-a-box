package cruxinabox;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import crux.api.Crux;
import crux.api.ICruxAPI;
import crux.api.ICruxDatasource;
import crux.api.ICursor;
import crux.api.CruxDocument;
import crux.api.TransactionInstant;
import crux.api.tx.Transaction;

class Box {
    public static void main(String[] args) {
        try (ICruxAPI node = Crux.startNode(new File("config.json"))) {
            System.out.println("Crux Started.");

            // submitTx example:
            HashMap<String, Object> data = new HashMap<>();
            data.put("user/name", "zig");
            CruxDocument document = CruxDocument.create("hi2u", data);
            TransactionInstant transaction = node.submitTx(Transaction.buildTx(tx -> {
                tx.put(document);
            }));
            System.out.println(data.toString());

            // query example:
            node.awaitTx(transaction, null);
            String query = "{:find [e] :where [[e :user/name \"zig\"]]}";
            ICruxDatasource db = node.db();
            ICursor<List<?>> results = db.openQuery(query);
            if (results.hasNext()) {
                List<?> result = results.next();
                System.out.println(result.toString());
            }
            db.close();
            node.close();
        }
        catch (IOException e) {
            // ...
        }
    }
}
