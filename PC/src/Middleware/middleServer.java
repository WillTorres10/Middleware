
package Middleware;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class middleServer extends javax.swing.JFrame{
    
    public static String ipSoma; 
    public static String ipMultiplicacao;
    public String sta,sta2;

    public middleServer() {
        initComponents();
        setSize(570,450);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        middle = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        ip = new javax.swing.JPanel();
        ipSomaa = new javax.swing.JTextField();
        ipso = new javax.swing.JLabel();
        ipmul = new javax.swing.JLabel();
        ipMultiplicacaoo = new javax.swing.JTextField();
        status = new javax.swing.JPanel();
        midstatus = new javax.swing.JTextField();
        midstatus1 = new javax.swing.JTextField();
        midstatus2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        middle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        middle.setText("MIDDLEWARE");
        getContentPane().add(middle);
        middle.setBounds(240, 50, 80, 30);

        entrar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        entrar.setText("ENTRAR");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar);
        entrar.setBounds(230, 240, 90, 20);

        ip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10))); // NOI18N
        ip.setLayout(null);

        ipSomaa.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        ipSomaa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip.add(ipSomaa);
        ipSomaa.setBounds(170, 30, 200, 20);

        ipso.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        ipso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ipso.setText("SERVIDOR SOMA:");
        ip.add(ipso);
        ipso.setBounds(70, 30, 100, 20);

        ipmul.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        ipmul.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ipmul.setText("SERVIDOR MULTIPLICAÇÃO:");
        ip.add(ipmul);
        ipmul.setBounds(20, 70, 150, 20);

        ipMultiplicacaoo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        ipMultiplicacaoo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip.add(ipMultiplicacaoo);
        ipMultiplicacaoo.setBounds(170, 70, 200, 20);

        getContentPane().add(ip);
        ip.setBounds(50, 100, 450, 120);

        status.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10))); // NOI18N
        status.setLayout(null);

        midstatus.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        midstatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        midstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midstatusActionPerformed(evt);
            }
        });
        status.add(midstatus);
        midstatus.setBounds(30, 20, 350, 20);

        midstatus1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        midstatus1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        midstatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midstatus1ActionPerformed(evt);
            }
        });
        status.add(midstatus1);
        midstatus1.setBounds(30, 80, 350, 19);

        midstatus2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        midstatus2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        midstatus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midstatus2ActionPerformed(evt);
            }
        });
        status.add(midstatus2);
        midstatus2.setBounds(30, 50, 350, 19);

        getContentPane().add(status);
        status.setBounds(70, 270, 410, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        
        ipSoma = ipSomaa.getText();
        ipMultiplicacao = ipMultiplicacaoo.getText();
        
        midstatus.setText("[Middleware Server] Ouvindo a porta 8000");
        midstatus2.setText(sta2);
        midstatus1.setText(sta);
        
        
    }//GEN-LAST:event_entrarActionPerformed

    private void midstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midstatusActionPerformed

    private void midstatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midstatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midstatus1ActionPerformed

    private void midstatus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midstatus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midstatus2ActionPerformed

    
    @SuppressWarnings("resource")
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new middleServer().setVisible(true);
            }
        });
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
	//System.out.print("Ip do Servidor de Soma: ");
	//pSoma = reader.nextLine();
	//System.out.print("Ip do Servidor de Multiplicação: ");
	//ipMultiplicacao = reader.nextLine();
	try {
		ServerSocket servidor = new ServerSocket(8000);
		//System.out.println("[Middleware Server] Ouvindo a porta 8000");
		while(true){
                    Socket cliente = servidor.accept();
                    thread th = new thread(cliente, ipSoma, ipMultiplicacao);
                    Thread t = new Thread(th);
                    t.start();
		}
	}
	catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
	}
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JPanel ip;
    private javax.swing.JTextField ipMultiplicacaoo;
    private javax.swing.JTextField ipSomaa;
    private javax.swing.JLabel ipmul;
    private javax.swing.JLabel ipso;
    private javax.swing.JLabel middle;
    private javax.swing.JTextField midstatus;
    private javax.swing.JTextField midstatus1;
    private javax.swing.JTextField midstatus2;
    private javax.swing.JPanel status;
    // End of variables declaration//GEN-END:variables
}
