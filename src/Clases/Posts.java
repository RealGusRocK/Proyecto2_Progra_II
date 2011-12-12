/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 *
 * @author Gustavo
 */
public class Posts {
    RandomAccessFile f;
    RandomAccessFile postInicio;
    File p;
    static int cont=0;
    String a;
    
    public Posts(String correo){
        try{
            a=correo;
            f=new RandomAccessFile("Users\\"+correo+"\\posts.fbn","rw");
            p=new File("Users\\"+correo+"\\posts.fbn");
            
        }catch(IOException e){
            System.out.println("Errore:"+e.getMessage());
        }
    }
    
    public void agregarPost(String post){
        try {
            f.seek(0);
            String g;
            if(f.length()==0){
                g="";
            }else{
                g=f.readUTF();
            }
                
                p.delete();
                p.createNewFile();
                f.seek(0);
                f.writeUTF(post+g);
            
        } catch (IOException ex) {
            System.out.println("ajajajaja"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public String getPosts(){  
        try {
            f.seek(0);
            if(f.length()==0){
                return "";
            }
            String g=f.readUTF();
            return g;
        } catch (IOException ex) {
            System.out.println("Errooor:"+ex.getMessage());
        }
        return "";
        
    }
    
    public void agegarPostInicio(String correo,String nombre,String msj){
        
        try{
            postInicio=new RandomAccessFile("Users\\"+correo+"\\postsInicio.fbn","rw");
            File pf=new File("Users\\"+correo+"\\postsInicio.fbn");
            
            postInicio.seek(0);
            String g;
            if(postInicio.length()==0){
                g="";
            }else{
                g=postInicio.readUTF();
            }
            pf.delete();
            pf.createNewFile();
            postInicio.seek(0);
            postInicio.writeUTF(nombre+" comento: \n"+msj+"\n"+g);
            postInicio.close();
            
        } catch(IOException e){
            System.out.println("Errrrrir: "+e.getMessage());
        }
        
    }
    
    public String getPostIn(){
        
        try{
            postInicio=new RandomAccessFile("Users\\"+a+"\\postsInicio.fbn","rw");
            postInicio.seek(0);
            if(postInicio.length()==0){
                return "";
            }
            String g=postInicio.readUTF();
            postInicio.close();
            return g;
            
        }catch(IOException e){
            System.out.println("Error Inicio: "+e.getMessage());
        }
        return "";
    }
    
    public void cerrar() throws IOException{
        f.close();
        if(postInicio!=null){
            postInicio.close();
        }
    }
    
}
