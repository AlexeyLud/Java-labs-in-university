package laba3;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass {
    public static void main(String[] args) {
        // Connect
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/transports";
        String username = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
            System.out.println("Connected to 'transports'");
            }
            else{
                System.out.println("Failed connection!");
            }
            menu(conn);
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    System.out.println("Connection close...");
                    conn.close();
                } 
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    public static void menu(Connection conn){
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet res = null;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("1)INSERT");
            System.out.println("2)SELECT");
            System.out.println("3)UPDATE");
            System.out.println("4)DELETE");
            System.out.println("5)SELECT and INSERT index");
            System.out.println("6)Transport City");
            System.out.println("0)Out");
            System.out.print("Input number: ");
            int n = in.nextInt();
            if(n < 0 || n > 6){
                System.out.println("You input error number!!!");
            }
            clearScreen();
            switch(n){
                case 1:
                    System.out.println("=================INSERT=================");
                    insert(conn, ps);
                    break;
                case 2:
                    System.out.println("=================SELECT=================");
                    select(conn, res, s);
                    break;
                case 3:
                    System.out.println("=================UPDATE=================");
                    update(conn, ps);
                    break;
                case 4:
                    System.out.println("=================DELETE=================");
                    delete(conn, ps);
                    break;
                case 5:
                    System.out.println("=================SELECT and INSERT index=================");
                    selins(conn, s, ps, res);
                    break;
                case 6:
                    System.out.println("=================Transport City=================");
                    transportCity(conn, s, ps, res);
                    break;
                case 0:
                    System.out.println("End the program...");
                    System.exit(0);
            }
        }
        while(true);
    }
    
    static void insert(Connection conn, PreparedStatement ps){
        try {
            // INSERT
            System.out.println("???????????? INSERT... tranname");
            String sql_ins2 = "INSERT INTO tranname (name, number) VALUES (?,?)";
            ps = conn.prepareStatement(sql_ins2);
            ps.setString(1, "??????????????");
            ps.setInt(2, 12);
            int rowsInserted2 = ps.executeUpdate();
            if (rowsInserted2 > 0) {
                System.out.println("?????????? ?????????????????? ???????????? ????????????????!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? INSERT... route");
            String sql_ins = "INSERT INTO route (startm, endm) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins);
            ps.setString(1, "????????????. ????????????");
            ps.setString(2, "??????????");
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("?????????? ?????????????? ???????????? ????????????????!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? INSERT... dateofintro");
            String sql_ins3 = "INSERT INTO dateofintro (data, count) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins3);
            ps.setString(1, "09.12.2021");
            ps.setInt(2, 6);
            int rowsInserted3 = ps.executeUpdate();
            if (rowsInserted3 > 0) {
                System.out.println("?????????? ???????? ???????????? ??????????????????!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? INSERT... worktime");
            String sql_ins4 = "INSERT INTO worktime (startw, endw) VALUES (?, ?)";
            ps = conn.prepareStatement(sql_ins4);
            ps.setString(1, "9:00");
            ps.setString(2, "21:40");
            int rowsInserted4 = ps.executeUpdate();
            if (rowsInserted4 > 0) {
                System.out.println("?????????? ?????????? ???????????? ???????????? ??????????????????!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void select(Connection conn, ResultSet res, Statement s){
        try {
            // SELECT
            System.out.println("???????????? SELECT... tranname");
            String sql_sel2 = "SELECT * FROM tranname";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int count2 = 0;
            while (res.next()){
                String name = res.getString(2);
                int number = res.getInt(3);
                System.out.println("???????????????? ????????????????????: " + name);
                System.out.println("?????????? ????????????????????: " + number);
                count2++;
            }
            System.out.println("???????????????????? ?????????????????????? = " + count2);
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? SELECT... route");
            String sql_sel = "SELECT * FROM route";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel);
            int count = 0;
            while (res.next()){
                String startm = res.getString(2);
                String endm = res.getString(3);
                System.out.println("???????????? ????????????????: " + startm);
                System.out.println("?????????? ????????????????: " + endm);
                count++;
            }
            System.out.println("???????????????????? ?????????????????? = " + count);
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? SELECT... dateofintro");
            String sql_sel3 = "SELECT * FROM dateofintro";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            int count3 = 0;
            while (res.next()){
                String data = res.getString(2);
                int coun = res.getInt(3);
                System.out.println("???????? ??????????????????????: " + data);
                System.out.println("?????????????????? ????????????: " + coun);
                count3++;
            }
            System.out.println("???????????????????? ?????? = " + count3);
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? SELECT... worktime");
            String sql_sel4 = "SELECT * FROM worktime";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int count4 = 0;
            while (res.next()){
                String startw = res.getString(2);
                String endw = res.getString(3);
                System.out.println("???????????? ?????????????? ????????????: " + startw);
                System.out.println("?????????? ?????????????? ????????????: " + endw);
                count4++;
            }
            System.out.println("???????????????????? ???????????????? ???????????? = " + count4);
            System.out.println("--------------------------------------------------------");
            System.out.println();

        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void update(Connection conn, PreparedStatement ps){
        try {
            // UPDATE
            System.out.println("???????????? UPDATE... tranname");
            String sql_up2 = "UPDATE tranname SET name=?, number=? WHERE name=?";
            ps = conn.prepareStatement(sql_up2);
            ps.setString(1, "??????????????????");
            ps.setInt(2, 3);
            ps.setString(3, "??????????????");
            int rowsUpdated2 = ps.executeUpdate();
            if (rowsUpdated2 > 0) {
                System.out.println("???????????? ???????????????????? ?????????????? ????????????????!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? UPDATE... route");
            String sql_up = "UPDATE route SET startm=?, endm=? WHERE id_r=?";
            ps = conn.prepareStatement(sql_up);
            ps.setString(1, "??????. ??????????????????????");
            ps.setString(2, "????. ????????????????");
            ps.setInt(3, 1);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("???????????? ?????????????? ?????????????? ????????????????!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void delete(Connection conn, PreparedStatement ps){
        try {
            // DELETE
            System.out.println("???????????? DELETE... dateofintro");
            String sql_del2 = "DELETE FROM dateofintro WHERE id_d=?";
            ps = conn.prepareStatement(sql_del2);
            ps.setInt(1, 1);
            int rowsDeleted2 = ps.executeUpdate();
            if (rowsDeleted2 > 0) {
                System.out.println("???????????? ???????? ?????????????? ??????????????!");
            }
            System.out.println("-----------------------------------");
            
            System.out.println("???????????? DELETE... worktime");
            String sql_del = "DELETE FROM worktime WHERE id_w=?";
            ps = conn.prepareStatement(sql_del);
            ps.setInt(1, 1);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("???????????? ?????????????? ?????????????? ??????????????!");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void selins(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try
        {
            String sql = "select count(*) from route";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            String sql_sel = "select id_r from route";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel);
            int route = 0;
            int[] r = new int[count];
            int i = 0;
            while (res.next()){
                route = res.getInt(1);
                r[i] = route;
                i++;
            }
            
            String sql_sel2 = "select id_d from dateofintro";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int data = 0;
            int[] d = new int[count];
            int j = 0;
            while (res.next()){
                data = res.getInt(1);
                d[j] = data;
                j++;
            }
            
            String sql_sel3 = "select id_w from worktime";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            int work = 0;
            int[] w = new int[count];
            int l = 0;
            while (res.next()){
                work = res.getInt(1);
                w[l] = work;
                l++;
            }
            
            String sql_sel4 = "select id_t from tranname";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            int tran = 0;
            int[] t = new int[count];
            int e = 0;
            while (res.next()){
                tran = res.getInt(1);
                t[e] = tran;
                e++;
            }
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                ps = conn.prepareStatement("insert into indexes(tran_id, data_id, route_id, work_id) values(?,?,?,?)");
                ps.setInt(1, t[p]);
                ps.setInt(2, d[p]);
                ps.setInt(3, r[p]);
                ps.setInt(4, w[p]);
                k = ps.executeUpdate(); 
            }
            if(k > 0){
                System.out.println("???????????? ???????????????? ?????????????? ??????????????????!");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void transportCity(Connection conn, Statement s, PreparedStatement ps, ResultSet res){
        try 
        {
            String sql = "select count(*) from route";
            s = conn.createStatement();
            res = s.executeQuery(sql);
            int count = 0;
            while(res.next()){
                count = res.getInt(1);
            }
            System.out.println("count = " + count);
            
            
            String sql_sel2 = "select data, count from dateofintro";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel2);
            int coun = 0;
            String data;
            int[] c = new int[count];
            String[] dat = new String[count];
            int j = 0;
            while (res.next()){
                data = res.getString("data");
                dat[j] = data;
                coun = res.getInt("count");
                c[j] = coun;
                j++;
            }
            
            System.out.println("data: " + Arrays.toString(dat));
            System.out.println("count: " + Arrays.toString(c));
            
            
            String sql_sel3 = "select startm, endm from route";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel3);
            String startmar;
            String endmar;
            String[] sm = new String[count];
            String[] em = new String[count];
            int l = 0;
            while (res.next()){
                startmar = res.getString("startm");
                sm[l] = startmar;
                endmar = res.getString("endm");
                em[l] = endmar;
                l++;
            }
            
            System.out.println("startmar: " + Arrays.toString(sm));
            System.out.println("endmar: " + Arrays.toString(em));
            
            
            String sql_sel4 = "select startw, endw from worktime";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel4);
            String starttime;
            String endtime;
            String[] st = new String[count];
            String[] et = new String[count];
            int q = 0;
            while (res.next()){
                starttime = res.getString("startw");
                st[q] = starttime;
                endtime = res.getString("endw");
                et[q] = endtime;
                q++;
            }
            
            System.out.println("startw: " + Arrays.toString(st));
            System.out.println("endw: " + Arrays.toString(et));
            
            String sql_sel5 = "select name, number from tranname";
            s = conn.createStatement();
            res = s.executeQuery(sql_sel5);
            String name;
            int number;
            String[] n = new String[count];
            int[] num = new int[count];
            int w = 0;
            while (res.next()){
                name = res.getString("name");
                n[w] = name;
                number = res.getInt("number");
                num[w] = number;
                w++;
            }
            
            System.out.println("name: " + Arrays.toString(n));
            System.out.println("number: " + Arrays.toString(num));
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                ps = conn.prepareStatement("insert into transp(name, number, data, count, startw, endw, startmar, endmar) values(?,?,?,?,?,?,?,?)");
                ps.setString(1, n[p]);
                ps.setInt(2, num[p]);
                ps.setString(3, dat[p]);
                ps.setInt(4, c[p]);
                ps.setString(5, st[p]);
                ps.setString(6, et[p]);
                ps.setString(7, sm[p]);
                ps.setString(8, em[p]);
                k = ps.executeUpdate();
            }
            
            if(k > 0){
                System.out.println("???????????? ?????????????? ??????????????????");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
