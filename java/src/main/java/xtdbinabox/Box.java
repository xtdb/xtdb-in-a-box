package xtdbinabox;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import xtdb.api.IXtdb;
import xtdb.api.IXtdbDatasource;
import xtdb.api.ICursor;
import xtdb.api.XtdbDocument;
import xtdb.api.TransactionInstant;
import xtdb.api.tx.Transaction;

class Box {
    public static void main(String[] args) {
        try (IXtdb node = IXtdb.startNode(new File("config.json"))) {
            System.out.println("Xtdb Started.");

            // submitTx example:
            HashMap<String, Object> data = new HashMap<>();
            data.put("user/name", "zig");
            XtdbDocument document = XtdbDocument.create("hi2u", data);
            TransactionInstant transaction = node.submitTx(Transaction.buildTx(tx -> {
                tx.put(document);
            }));
            System.out.println(data.toString());

            // query example:
            node.awaitTx(transaction, null);
            String query = "{:find [e] :where [[e :user/name \"zig\"]]}";
            IXtdbDatasource db = node.db();
            Collection<List<?>> results = db.query(query);
            for (List l : results) {
                System.out.println(l.toString());
            }
            db.close();
            node.close();
        }
        catch (IOException e) {
            // ...
        }
    }
}
