
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kmjit04
 */
public class jFrame_1 extends javax.swing.JFrame {

    /**
     * Creates new form jFrame_1
     */
    public jFrame_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Test Koneksi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Test Koneksi");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // mongodb://<dbuser>:<dbpassword>@ds161059.mlab.com:61059/koplaksystem
        try {
            /*      MongoClient mongoClient = new MongoClient(new MongoClientURI("
            mongodb://admin1:admin@ds161059.mlab.com:61059"));
            DB database = mongoClient.getDB("koplaksystem");
            DBCollection collection = database.getCollection("masterdata");
            DB db = mongoClient.getDB("koplaksystem");
            Set<String> collections = db.getCollectionNames();
            System.out.println(collections);  */
            String mongoUserName;
            String mongoPassword;
            String dbName;
            mongoUserName = "admin1";
            mongoPassword = "admin";
            dbName = "koplaksystem";
            ServerAddress addr = new ServerAddress("ds161059.mlab.com", 61059);
            MongoCredential credential = MongoCredential.createCredential(mongoUserName, dbName, mongoPassword.toCharArray());

            MongoClient mongoClient = new MongoClient(addr, Arrays.asList(credential), null);
            //DB db =  (DB) mongoClient.getDatabase();
            //Set<String> collections = db.getCollectionNames();
            //  System.out.println(collections);
            List<String> collections = mongoClient.getDatabaseNames(); //db.getCollectionNames();
            System.out.println(collections);
        } catch (com.mongodb.MongoCommandException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String mongoUserName;
        String mongoPassword;
        String dbName;
        mongoUserName = "admin1";
        mongoPassword = "admin";
        dbName = "koplaksystem";
      //  ServerAddress addr = new ServerAddress("ds161059.mlab.com", 61059);
       // MongoCredential credential = MongoCredential.createCredential(mongoUserName, dbName, mongoPassword.toCharArray());

        //MongoClient mongoClient = new MongoClient(addr, Arrays.asList(credential), null);
         Mongo mongo = new Mongo("admin1:admin@ds161059.mlab.com", 61059);
        DB db = mongo.getDB("koplaksystem");
        DBCollection collection = db.getCollection("User");
    BasicDBObject document = new BasicDBObject();
	    document.put("id", 100);
	    document.put("name", "simple name");
	    document.put("message", "simple message");
	    

	    // save it into collection named "myCollection"
	    collection.insert(document);
             BasicDBObject searchQuery = new BasicDBObject();
	    searchQuery.put("id", 100);

	    DBCursor cursor = collection.find(searchQuery);

	    // loop over the cursor and display the result
	    while (cursor.hasNext()) {
		System.out.println(cursor.next());
	    }

    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
