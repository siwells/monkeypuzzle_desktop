/*
 * CQFrame.java
 *
 * Created on 21 July 2006, 13:05
 */

/**
 *
 * @author  growe
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
public class CQFrame extends JDialog
{
  private Subtree scheme;
  private boolean okPressed;
  CheckBoxList cbList;
  JCheckBox[] checkBoxes;
  
  /** Creates new form CQFrame */
  public CQFrame(Frame owner)
  {
    super(owner);
    Araucaria.createIcon(owner);
    initComponents();
    setModal(true);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(d.width/2 - this.getSize().width/2,
      d.height/2 - this.getSize().height/2);
  }

  public Subtree getScheme()
  {
    return scheme;
  }

  public void setScheme(Subtree scheme)
  {
    this.scheme = scheme;
    cbList = new CheckBoxList();
    Vector<CQCheck> cqChecks = scheme.getCqChecks();
    checkBoxes = new JCheckBox[cqChecks.size()];
    for (int cq = 0; cq < cqChecks.size(); cq++)
    {
      CQCheck cqCheck = cqChecks.elementAt(cq);
      checkBoxes[cq] = new JCheckBox(cqCheck.getCqText());
      checkBoxes[cq].setSelected(cqCheck.isCqAnswered());
    }
    cbList.setListData(checkBoxes);
    cqScrollPane.setViewportView(cbList);
  }

  public boolean isOkPressed()
  {
    return okPressed;
  }

  public void setOkPressed(boolean okPressed)
  {
    this.okPressed = okPressed;
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
  private void initComponents()
  {
    cqScrollPane = new javax.swing.JScrollPane();
    okButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Critical questions");

    okButton.setText("OK");
    okButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        okButtonActionPerformed(evt);
      }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        cancelButtonActionPerformed(evt);
      }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(cqScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
      .add(layout.createSequentialGroup()
        .add(105, 105, 105)
        .add(okButton)
        .add(66, 66, 66)
        .add(cancelButton)
        .addContainerGap(145, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(cqScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(okButton)
          .add(cancelButton))
        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okButtonActionPerformed
  {//GEN-HEADEREND:event_okButtonActionPerformed
    Vector<CQCheck> cqChecks = scheme.getCqChecks();
    for (int cq = 0; cq < cqChecks.size(); cq++)
    {
      CQCheck cqCheck = cqChecks.elementAt(cq);
      if (checkBoxes[cq].isSelected())
      {
        cqCheck.setCqAnswered(true);
      } else {
        cqCheck.setCqAnswered(false);
      }
    }
    okPressed = true;
    setVisible(false);
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
  {//GEN-HEADEREND:event_cancelButtonActionPerformed
    okPressed = false;
    setVisible(false);
  }//GEN-LAST:event_cancelButtonActionPerformed
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JScrollPane cqScrollPane;
  private javax.swing.JButton okButton;
  // End of variables declaration//GEN-END:variables
  
}
