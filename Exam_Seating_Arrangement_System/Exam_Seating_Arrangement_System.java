import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
class Exam_Seating_Arrangement_System extends WindowAdapter implements ActionListener , MouseListener {
    static Frame f=new Frame("Exam Seating Arrangement System");
    static Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");
    static Label l1,l2,roll,name,gender,course,sroll,nofstulabel;
    static TextField t1,t2,roll1,name1,course1,sroll1,ta,nofstufield;
    static Button add_stu,search_stu,submit,reset,ssubmit,sreset,all_stu;
    static Checkbox male,female;
    static CheckboxGroup cbg=new CheckboxGroup();
    static Panel padd,psea,res;
        public static Dialog dialog;
        static String Gender="";
        static TextArea result;
        static ArrayList<String[]> data;
        static int room=1;
        static int total=0;
        static int seat=0;
        static Label gl1,gl2,gl3,gl4,gl5,gl6,gl7,gl8,gl9,gl10,gl11,gl12,gl13,gl14;
        static GridLayout gl=new GridLayout(7,2);
        static Image bg;
        static int addzero=1,totalzero=2,noroll=3,wrongroll=4;
        public Exam_Seating_Arrangement_System(){
            
        padd=new Panel();
        psea=new Panel();
        res=new Panel();
        add_stu=new Button("ADD A STUDENT");
        search_stu=new Button("SEARCH");
        all_stu=new Button("ALL REPORT");
        t1=new TextField();
        l1=new Label();
        roll=new Label("Roll Number : ");
        name=new Label("Name :");
        gender=new Label("Gender : ");
        course=new Label("Course Name : ");
        roll1=new TextField();
        sroll1=new TextField();
        name1=new TextField();
        course1=new TextField();
        male=new Checkbox("Male",cbg,false);
        female=new Checkbox("Female",cbg,false);
        submit=new Button("SUBMIT");
        reset=new Button("RESET");
        result=new TextArea(10,30);
        sroll=new Label("Roll Number");
        ssubmit=new Button("SUBMIT");
        sreset=new Button("RESET");
        nofstulabel=new Label("Total Number Of Students : ");
        nofstufield=new TextField();
        gl1=new Label();
        gl2=new Label();
        gl3=new Label();
        gl4=new Label();
        gl5=new Label();
        gl6=new Label();
        gl7=new Label();
        gl8=new Label();
        gl9=new Label();
        gl10=new Label();
        gl11=new Label();
        gl12=new Label();
        gl13=new Label();
        gl14=new Label();
        add_stu.setBounds(60,260,150,30);
        roll.setBounds(50,50,100,30);
        name.setBounds(50,100,100,30);
        gender.setBounds(50,150,100,30);
        course.setBounds(50,200,100,30);
        reset.setBounds(50,250,100,30);
        submit.setBounds(200,250,100,30);
        roll1.setBounds(200,50,120,25);
        name1.setBounds(200,100,120,25);
        male.setBounds(200,150,80,30);
        female.setBounds(280,150,80,30);
        course1.setBounds(200,200,120,25);
        padd.setBounds(70,310,400,400);
        search_stu.setBounds(250,260,80,30);
        psea.setBounds(70,310,400,200);
        sroll.setBounds(50,50,100,30);
        sroll1.setBounds(200,50,120,25);
        sreset.setBounds(50,100,100,30);
        ssubmit.setBounds(200,100,100,30);
        all_stu.setBounds(365,260,100,30);
        result.setBounds(600,500,400,300);
        nofstulabel.setBounds(55,203,220,20);
        nofstufield.setBounds(300,200,70,30);
        res.setBounds(600,260,300,230);
        padd.add(l1);
        padd.add(roll);
        padd.add(name);
        padd.add(gender);
        padd.add(course);
        padd.add(roll1);
        padd.add(name1);
        padd.add(male);
        padd.add(female);
        padd.add(course1);
        padd.add(submit);
        padd.add(reset);
        f.add(res);
        res.setLayout(gl);
        res.add(gl1);
        res.add(gl2);
        res.add(gl3);
        res.add(gl4);
        res.add(gl5);
        res.add(gl6);
        res.add(gl7);
        res.add(gl8);
        res.add(gl9);
        res.add(gl10);
        res.add(gl11);
        res.add(gl12);
        res.add(gl13);
        res.add(gl14);
        psea.add(sroll);
        psea.add(sroll1);
        psea.add(sreset);
        psea.add(ssubmit);
        add_stu.addActionListener(this);
        search_stu.addActionListener(this);
        add_stu.addMouseListener(this);
        search_stu.addMouseListener(this);
        all_stu.addActionListener(this);
        all_stu.addMouseListener(this);
        f.addWindowListener(this);  
        reset.addActionListener(this);
        nofstufield.setForeground(Color.red);
        res.setBackground(Color.orange);
        padd.setBackground(Color.gray);
        psea.setBackground(Color.gray);
        submit.setBackground(Color.blue);
        reset.setBackground(Color.red);
        ssubmit.setBackground(Color.blue);
        sreset.setBackground(Color.red);
        submit.setForeground(Color.white);
        ssubmit.setForeground(Color.white);
        sreset.setForeground(Color.white);
        reset.setForeground(Color.white);
        result.setBackground(Color.green);
        all_stu.setBackground(Color.white);
        search_stu.setBackground(Color.white);
        add_stu.setBackground(Color.white);
        f.setBackground(Color.pink);
        result.setEditable(false);
        f.setFont(new Font("Arial", Font.PLAIN, 15));           //font frame
        res.setFont(new Font("Arial", Font.BOLD, 20));           //font res
        nofstulabel.setFont(new Font("Arial", Font.BOLD, 17));           //font total 
        nofstufield.setFont(new Font("Arial", Font.BOLD, 20));           //font total box
        reset.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            roll1.setText("");
            name1.setText("");
            course1.setText("");
        }
    });
    sreset.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            sroll1.setText("");
        }
    });
    ssubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String rol = sroll1.getText();
            int tot=Integer.valueOf(nofstufield.getText());
            if(tot==0){
                check(2);
            }
            if(Integer.valueOf(rol)==0){showdialog(f,"Enter roll number","Roll Error");}
            if(rol!=null){
                System.out.println("Roll Number = "+rol+" Searched.");
            searchStu(rol);
            }
            sroll1.setText("");
        }
    });
    data=new ArrayList<String[]>();
    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String n1 = name1.getText();
            String r1 = roll1.getText();
            String c1 = course1.getText();
            boolean b=male.getState()||female.getState();
            String g1 = b?"Male":"Female";
            String[] student = {n1,r1,g1,c1};
            data.add(student);
            System.out.println("Name: " + n1);
            System.out.println("Roll Number: " + r1);
            System.out.println("Course: " + c1);
            System.out.println("Gender: " + g1);
            System.out.println("Data stored.");
            if(n1.length()!=0&&r1.length()!=0&&c1.length()!=0&&b!=false){showdialog(f,"Data Stored With Roll Number "+r1,"Done");}
            else{showdialog(f,"Please Fill out all the details.","FILL DETAILS");}
            name1.setText("");
            roll1.setText("");
            course1.setText("");
        }});}

public static void showdialog(Frame owner,String s,String ti) {
    dialog = new Dialog(owner,ti, true);
    dialog.setLayout(new FlowLayout());
    Label label = new Label(s);
    Button close = new Button("OK");
    dialog.setLocation(500,300);
    label.setFont(new Font("Arial",Font.BOLD,20));
    close.setFont(new Font("Arial",Font.BOLD,20));
    close.setBounds(250,150,80,20);
    dialog.setLayout(new FlowLayout());
    close.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }});
    dialog.add(label);
    dialog.add(close);
    dialog.setSize(500, 150);
    dialog.setVisible(true);
    dialog.setFont(new Font("Arial",Font.BOLD,20));
}
public void check(int x){
    //addzero=1,totalzero=2,noroll=3,wrongroll=4
    switch(x){
        case 1:showdialog(f,"Add Student Details to see Report.","Report Error");break;
        case 2:showdialog(f,"Please Enter Total Students in a Room.","Total Error");break;
        case 3:showdialog(f,"Enter Roll number to search."," Empty Roll Number");break;
        case 4:showdialog(f,"Enter Correct Roll Number.","Wrong Roll Number");break;
    }
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()==add_stu){
        f.remove(psea);
        f.add(padd);  
        padd.setVisible(true);
    }
    if(e.getSource()==search_stu){
        f.remove(padd);
        padd.setVisible(false);
        f.add(psea);
    } 
    if(e.getSource()==all_stu){
        int c=0;
        result.setText("");
        for(String[] student : data){c++;}
        if(c==0){
            check(1);
        }
        else{
            f.add(result);
            for(String[] student : data){
                total=Integer.valueOf(nofstufield.getText());
                int ro=Integer.valueOf(student[1]);
                room = (ro - 1) / total + 1;
                seat = (ro - 1) % total + 1;
                result.append("Room Number   :    "+room+"\n");
                result.append("Seat Number      :    "+seat+"\n");
                result.append("Roll Number       :    " + student[1] + "\n");
                result.append("Name\t\t    :    " + student[0] + "\n");
                result.append("Gender\t  :    " + student[2] + "\n");
            result.append("Course\t  :    " + student[3] + "\n\n");
        } }}}
    void searchStu(String rollNumber) {
        result.setText("");
        int c=0;
        boolean found = false;
        int ro=Integer.valueOf(rollNumber);
        total=Integer.valueOf(nofstufield.getText());
                if(total==0){
                    check(2);
                }
                else if(ro==0){
                    check(3);
                }
                for (String[] student : data) {
                    ro=Integer.valueOf(student[1]);
            if (student[1].equals(rollNumber)) {
                total=Integer.valueOf(nofstufield.getText());
                room = (ro - 1) / total + 1;
                seat = (ro - 1) % total + 1;
                gl1.setText("         STUDENT");
                gl2.setText("   DETAILS");
                gl3.setText("  Room Number");gl4.setText(String.valueOf("        "+room));
                gl5.setText("  Seat Number");gl6.setText("        "+String.valueOf(seat));
                gl7.setText("  Roll Number");gl8.setText("        "+student[1]);
                gl9.setText("  Name");gl10.setText("    "+student[0]);
                gl11.setText("  Gender");gl12.setText("    "+student[2]);
                gl13.setText("  Course");gl14.setText("    "+student[3]);
                found = true;
            }
        }
        if(found==false) {
            check(4);
        }
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==add_stu){
            add_stu.setBackground(Color.orange);
            search_stu.setBackground(Color.white);
            all_stu.setBackground(Color.white);
            }
            if(e.getSource()==search_stu){
                search_stu.setBackground(Color.orange);
                add_stu.setBackground(Color.white);
                all_stu.setBackground(Color.white);
            }
            if(e.getSource()==all_stu){
                search_stu.setBackground(Color.white);
                add_stu.setBackground(Color.white);
                all_stu.setBackground(Color.orange);
            }
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void windowClosing (WindowEvent e) {    
            f.dispose();    
        }   
    public static void main(String args[]){
        new Exam_Seating_Arrangement_System();
        f.setIconImage(icon);
        f.add(add_stu);
        f.add(search_stu);
        f.add(all_stu);
        f.add(nofstulabel);
        f.add(nofstufield);
        f.setSize(1700,950);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Canvas bg=new Canvas(){
                public void paint(Graphics g)
                {
                try {
                BufferedImage img=ImageIO.read(new File("hal.jpg"));
                g.drawImage(img,0,0,this);
                }
                catch(IOException e)    {
                e.printStackTrace();
            }
        }       };
        bg.setBounds(250,0,1500,172);
        f.add(bg);
}
}
