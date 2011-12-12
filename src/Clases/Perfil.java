/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Perfil {
    RandomAccessFile f=null;
    String correo;
    RandomAccessFile fotoP;
    public Perfil(String direccion){
        correo=direccion;
        try {
            f=new RandomAccessFile("Users\\"+direccion+"\\profile.fbn","rw");
            fotoP=new RandomAccessFile("Users\\"+direccion+"\\foto.fbn","rw");
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found.");
        }
        
        
    }
    public String getNombre(){
            try{
                f.seek(0);
                String nombre=f.readUTF();
                return nombre;
            }catch(IOException e){
                System.out.println("Error: "+e.getMessage());
            }
            return "";
    }
    
    public int getTel(){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            f.readLong();
            int tel=f.readInt();
            return tel;
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
            return 0;
        }
    }
    public long getFechaNacimiento() {
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            long fecha=f.readLong();
            return fecha;
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return 0;
    }
    
    public long getFechaInicio(){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            f.readLong();
            f.readInt();
            return f.readLong();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public String getGenero(){
        try{
          f.seek(0);
          f.readUTF();
          char c=f.readChar();
          if(c=='M'){
              return "Masculino";
          }else if(c=='F'){
              return "Femenino";
          }
        }catch(IOException e){
            e.getMessage();
        }
        return "";
    }
    
    public String getEmail(){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            f.readLong();
            f.readInt();
            f.readLong();
            String e=f.readUTF();
            return e;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    

    public void cambiarTelefono(int c){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            f.readLong();
            f.writeInt(c);
        }catch(IOException e){
            e.getMessage();
        }
    }
    
    public void cambiarFecha(Date fecha){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            long fe=f.readLong();
            if(fe!=fecha.getTime()){
               fe=fecha.getTime();
               f.seek(f.getFilePointer()-8);
               f.writeLong(fe);
            }
            f.close();
            
        }catch(IOException e){
            System.out.println( e.getMessage());
           
        }
    }
    public void modificarPerfil(int t,Date fe){
        cambiarTelefono(t);
        cambiarFecha(fe);
    }
    
    public int getDia(){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            Date x=new Date(f.readLong());
            Calendar y=Calendar.getInstance();
            y.setTime(x);
            return y.get(Calendar.DAY_OF_MONTH);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int getMes(){
         try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            Date x=new Date(f.readLong());
            Calendar y=Calendar.getInstance();
            y.setTime(x);
            return y.get(Calendar.MONTH)+1;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int getAnio(){
        try{
            f.seek(0);
            f.readUTF();
            f.readChar();
            Date x=new Date(f.readLong());
            Calendar y=Calendar.getInstance();
            y.setTime(x);
            return y.get(Calendar.YEAR);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public void guardarFoto(String direcFoto){
        try {
            File a=new File("Users\\"+correo+"\\foto.fbn");
            if(fotoP.length()>0){
                a.delete();
                a.createNewFile();
            }
            fotoP.seek(0);
            fotoP.writeUTF(direcFoto);
            fotoP.close();
        } catch (IOException ex) {
            System.out.println("Errora:"+ex.getMessage());
        }
        
    }
    public String getFoto(){
        try {
            fotoP.seek(0);
            
            if(fotoP.length()==0){
                return "src\\Clases\\Imagenes\\perfil.jpg";
            }
            String dFoto=fotoP.readUTF();
            return dFoto;
        } catch (IOException ex) {
            System.out.println("Error foto");
            ex.printStackTrace();
        }
        return "";
    }
    
    public String fecha(Calendar c){
        String mes="";
        if(c.get(Calendar.MONTH)==0){
            mes="Enero";
        }else if(c.get(Calendar.MONTH)==1){
            mes="Febrero";
        }else if(c.get(Calendar.MONTH)==2){
            mes="Marzo";
        }else if(c.get(Calendar.MONTH)==3){
            mes="Abril";
        }else if(c.get(Calendar.MONTH)==4){
            mes="Mayo";
        }else if(c.get(Calendar.MONTH)==5){
            mes="Junio";
        }else if(c.get(Calendar.MONTH)==6){
            mes="Julio";
        }else if(c.get(Calendar.MONTH)==7){
            mes="Agosto";
        }else if(c.get(Calendar.MONTH)==8){
            mes="Septiembre";
        }else if(c.get(Calendar.MONTH)==9){
            mes="Octubre";
        }else if(c.get(Calendar.MONTH)==10){
            mes="Noviembre";
        }else if(c.get(Calendar.MONTH)==11){
            mes="Diciembre";
        }
        
        return c.get(Calendar.DATE) +" de "+mes+" del "+c.get(Calendar.YEAR);
    }
    
    public boolean buscarAmigo(String correo){
        try {
            RandomAccessFile b=new RandomAccessFile("Gerencia\\gerencia.fbn","rw");
            b.seek(0);
            while(b.getFilePointer()<b.length()){
                String g=b.readUTF();
                b.readUTF();
                boolean t =b.readBoolean();
                if(correo.equals(g) && t){
                    return true;
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Archivo not Found.");
        }
        return false;
    }
    
    public void cancelarCuenta(){
        try {
        fotoP.close();
        f.close();
        File fd=new File("Users\\"+correo);
        if(this.borrarDirectorio(fd)){
            RegistrarUsuario rg=new RegistrarUsuario();  
            rg.desactivarCuenta(correo);
        }
        } catch (IOException ex) {
            System.out.println("Error Desactivar.");
        }
    }
    public  boolean borrarDirectorio(File direc){
        if(direc.isDirectory()){
            File ficheros[]= direc.listFiles();
            for(int i=0;i<ficheros.length;i++){
                if(ficheros[i].isDirectory()){
                    borrarDirectorio(ficheros[i]);
                }
                ficheros[i].delete();
            }
            direc.delete();
            
            return true;
           // System.out.println("Se Borro el Directorio Exitosamente.");
        }else{
            System.out.println("Esta funcion solo sirve con directorios.");
        }
        return false;
    }
    
    public void close() throws IOException{
        f.close();
        fotoP.close();
    }
}
