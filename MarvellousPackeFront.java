import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarvellousPackFront extends Template implements ActionListener
{
    JButton SUBMIT ,PREVIOUS;
    jLabel label1l,label2,title;
    final JTextField text1;


    public MarvellousPackFront()
    {
        setDefultCloseOpertion(WindowConstants.DISPOSE_ON_CLOSE);

        title= new jLabel("Marvellous Packing portal");
        Dimension size=title.getPreferredSize();
        title.setBounds(40,50,size.width +60,size.height);
        title.setFont(new Font("Century",Font.BOLD,17));
        title.setBackground(Color.blue);

        label1= new jLabel();
        label1.setText("Directory Name");
        label1.setBackground(Color.white);
        label1.setBounds(350,50,size.width,size.height);

        text1= new JTextField(15);
        Dimension size=text1.getPreferredSize();
        text1.setBounds(500,50,size.width,size.height);
        text1.setToolTiptext("Enter name of directory");

        label2= new jLabel();
        label2.setText("Destination File Name");
        label2.setBackground(Color.white);
        label2.setBounds(350,100,size.width + 60,size.height);

        text2= new JTextField(15);
        text2.setBounds(500,50,size.width,size.height);
        text2.setToolTiptext("Enter Destination File Name");

        SUBMIT= new JButton("SUBMIT");
        Dimension bsize=SUBMIT.getPreferredSize();
        SUBMIT.setBounds(500,50,size.width,size.height);
        SUBMIT.addActionListener(this);
        
        PREVIOUS= new JButton("PREVIOUS");
        Dimension b2size=PREVIOUS.getPreferredSize();
        PREVIOUS.setBounds(500,200,size.width,size.height);
        PREVIOUS.addActionListener(this);

        _header.add(title);
        _content.add(label1);
        _content.add(label2);
        _content.add(text1);
         _content.add(text2);
        _content.add(SUBMIT);
        _content.add(PREVIOUS);

        this.setSize(1000,400);
        this.setResizable(false);
        this.setVisible(true);
        text1.requestFocusInWindow();
    }

     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            this.setVisible(false);
            System.exit(0);

        }
        if(ae.getSource()==minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource()==SUBMIT)
        {
            
            try
            {
                MarvellousUnpacker obj= new MarvellousUnpacker(text1.getText());
                this.dispose();
                NextPage t= new NextPage("MarvellousAdmin");
            }
            
            catch(Exception e){}
        }
        if(ae.getSource()==PREVIOUS)
        {
            this.setVisible(false);
            this.dispose();
            NextPage t= new NextPage("MarvellousAdmin");

        }
    }
}    