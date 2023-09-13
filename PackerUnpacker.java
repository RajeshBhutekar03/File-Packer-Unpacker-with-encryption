

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.jLabel;

class MarvellousLogin extends Template implements ActionListener, Runnable
{
    JButton SUBMIT;
    jLabel label1,label2,label3,TopLabel;
    final JTextField text1,text2;
    private static int attemp=3;

    MarvellousLogin()
    {
        TopLabel=new jLabel();
        TopLabel.setText("Marvellous Packer unpacker : Login");
        TopLabel.setHorzontalAlignment(SwingConstants.CENTER);
        TopLabel.setForeground(Color.BLUE);

        Dimension topsize=TopLabel.getPreferredSize();
        TopLabel.setBounds(50,40,topsize.width,topsize.height);
        _header.add(TopLabel);

        label1=new jLabel();
        label1.setText("Username :");
        label1.setForeground(Color.white);

        Dimension size=label1.getPreferredSize();

        label1.setBounds(50,135,size.width,size.height);
        label1.setHorzontalAlignment(SwingConstants.CENTER);

        text1=new JTextField(15);
        Dimension tsize=text1.getPreferredSize();
        text1.setBounds(200,135,tsize.width,tsize.height);

        text1.setToolTiptext("ENTER USERNAME");

        label2=new JTextField();
        label2.setText("Password :");
        label2.setForeground(50,175,size.width,size.height);
        label2.setForeground(Color.white);
        label2.setHorzontalAlignment(SwingConstants.CENTER);

        text2= new JPasswordField(15);
        text2.setBounds(200.175.tsize.width,tsize.height);

        text2.setToolTiptext("Enter Password");

        text2.addFocusListener(new FocusListener()
        {
            public void focusLost(FocusEvent e)
            {

            }
            public void focusLost(FocusEvent e)
            {
                label3.setText("");
            }
        });

        SUBMIT=new JButton("SUBMIT");
        SUBMIT.setHorzontalAlignment(SwingConstants.CENTER);

        Dimension ssize=SUBMIT.getPreferredSize();

        SUBMIT.setBounds(50,200,ssize.width,ssize.height);

        label3=new jLabel();
        jLabel3.setText("");

        Dimension ssize=SUBMIT.getPreferredSize();

        label3.setForeground(Color.RED);
        label3.setBounds(50,250,l3size.width,l3size.height);

        Thread t =new Thread(this);
        t.start();

        _content.add(label1);
        _content.add(text1);

        _content.add(label2);
        _content.add(text2);
        
        _content.add(label3);
        _content.add(SUBMIT);

        pack();
        validate();

        ClockHome();
        setVisible(true);
        this.setSize(500,500);
        this.setResizable(false);
        setLocationRelativeTo(null);
        SUBMIT.addActionListener(this);
    }
    public boolean validate(String Username,String Password)
    {
        if((Username.length()<8)||(Password.length()<8))
        return false;
        else
        return true;
    }

    public void actionPerformed(ActionEvent ae)
    {
        String value1=text1.getText();
        String value2=text2.getText();

        if(ae.getSource()==exit)
        {
            this.setVisible(false);
            System.exit(0);
        }

        if(ae.getSource()==minimize)
        {
            this.setState9this.ICONIFIED();
        }

        if(ae.getSource()==SUBMIT)
        {
            if(validate(value1,value2)==false)
            {
                text1.setText("");
                text2.setText("");
                JOptionPane.showMassageDialog(this,"Short username","Marveellous packer unpaker",JOptionPane.ERROR_MESSAGE);
            }
            if(value1.equals("MarvellousAdmin")&& value2.equals("MarvellousAdmin"))
            {
                NextPage page=new NextPage(value1);
                this.setVisible(false);
                page.pack();
                page.setVisible(true);
                page.setVisible(500,500);
            }
            else
            {
                attemp--;

                if(attemp==0)
                {
                   JOptionPane.showMassageDialog(this,"Short username","Marveellous packer unpaker",JOptionPane.ERROR_MESSAGE);
                   this.dispose();
                   System.exit(0); 
                }

                JOptionPane.showMassageDialog(this,"Short username","Marveellous packer unpaker",JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    publiv void run()
    {
        for(;;)
        {
            if(text2.isFocusOwner())
            {
                if(Toolkit.getDefaultToolkit().getLockingKeyState(keyEvent.VK_CAPS_LOCK))
                {
                    text2.setToolTiptext("Warning :Caps lock is on");
                }
                else
                text2.setToolTiptext("");

                if(text2.getText()).length()<8
                label3.setText("Weak Passworrd");
                else
                label3.setText("");
            }
        }
    }
}

class MarveellousMain()
{
    public void static void main (String arg [])
    {
        try 
        {
            MarvellousLogin fname=new MarvellousLogin();
            fname.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMassageDialog(null,e.getMassage());
        }
    }
}
