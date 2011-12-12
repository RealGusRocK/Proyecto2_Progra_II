/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Gustavo
 */
public class ManageFriends {
    RandomAccessFile f=null;
    String mail;
    Posts po;
    public  ManageFriends(String correo){
        try {
            f=new RandomAccessFile("Users\\"+correo+"\\manageFriends.fbn","rw");
            mail=correo;
            po=new Posts(mail);
            
        } catch (FileNotFoundException ex) {
            System.out.println("");
        }
    }
    
    public boolean enviarSolictud(String correoAmigo){
        try {
            if(!verificar(correoAmigo)){
                RandomAccessFile fa=new RandomAccessFile("Users\\"+correoAmigo+"\\manageFriends.fbn","rw");
                f.seek(f.length());
                fa.seek(fa.length());
                f.writeUTF(correoAmigo);
                f.writeBoolean(false);
                f.writeBoolean(false);
                f.writeBoolean(true);   //Tercer boolean es para determinar si yo si yo envie la solicitud o no.
                fa.writeUTF(mail);
                fa.writeBoolean(false);
                fa.writeBoolean(false);
                fa.writeBoolean(false);
                fa.close();
                return true;
            }
            
        } catch (IOException ex) {
            System.out.println("Archivo no Encontrado.IO");
        }
        return false;
    }
    /**
     * Verifica si el amigo a enviar Solicitud no se encuentra en mi lista de amigos.
     */
    public boolean verificar(String correo) throws IOException{
        f.seek(0);
        while(f.getFilePointer()<f.length()){
            if(f.readUTF().equals(correo)){
                return true;
            }else{
                f.readBoolean();
                f.readBoolean();
                f.readBoolean();
            }
        }
        return false;
    }
    
    public String[] getListadoSolicitudes(){
        String lista[];
        String fg[]={"",""};
        if(solicitudes()>0){
            lista=new String [solicitudes()];
        }else{
            return fg;
        }
        int cont=0;
        try {
            f.seek(0);
            while(f.getFilePointer()<f.length()){
                String m=f.readUTF();
                f.readBoolean();
                if(!f.readBoolean()){
                    if(!f.readBoolean()){
                        lista[cont]=m;
                        cont++;
                    }
                }else{
                    f.readBoolean();
                }
            }
            return lista;
        } catch (IOException ex) {
            System.out.println("Errrrrrrrrrrror! xD");
            ex.printStackTrace();
        }
        
        return fg;
    }
    
    public int cantAmigos(){
        try {
            RegistrarUsuario reg=new RegistrarUsuario();
            int cant=0;
            f.seek(0);
            while(f.getFilePointer()<f.length()){
                String nom=f.readUTF();
                boolean x=f.readBoolean();
                f.readBoolean();
                f.readBoolean();
                if(x && reg.verificarActivo(nom)){
                    cant++;
                }
            }
            return cant;
        } catch (IOException ex) {
            System.out.println("Nada");
            ex.printStackTrace();
        }
        return 0;
    }
    
    private int solicitudes(){
        try {
            int cant=0;
            f.seek(0);
            while(f.getFilePointer()<f.length()){
                f.readUTF();
                f.readBoolean();
                f.readBoolean();
                if(!f.readBoolean())
                    cant++;
            }
            return cant;
        } catch (IOException ex) {
            System.out.println("Nada");
        }
        return 0;
    }
    public boolean aceptarSolicitud(String correo){
        try {
            RandomAccessFile fa=new RandomAccessFile("Users\\"+correo+"\\manageFriends.fbn","rw");
            f.seek(0);
            fa.seek(0);
            while(f.getFilePointer()<f.length()){
                String g=f.readUTF();
                if(g.equals(correo)){
                    f.writeBoolean(true);
                    f.writeBoolean(true);
                    f.readBoolean();
                }else{
                    f.readBoolean();
                    f.readBoolean();
                    f.readBoolean();
                }
            }
            while(fa.getFilePointer()<fa.length()){
                if(fa.readUTF().equals(mail)){
                    fa.writeBoolean(true);
                    fa.writeBoolean(true);
                    fa.readBoolean();
                }else{
                    fa.readBoolean();
                    fa.readBoolean();
                    fa.readBoolean();
                }
            }
            fa.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Error Amigo");
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean rechazarSolicitud(String correo){
        try {
            RandomAccessFile fa=new RandomAccessFile("Users\\"+correo+"\\manageFriends.fbn","rw");
            f.seek(0);
            fa.seek(0);
            while(f.getFilePointer()<f.length()){
                if(f.readUTF().equals(correo)){
                    f.writeBoolean(false);
                    f.writeBoolean(true);
                    break;
                }else{
                    f.readBoolean();
                    f.readBoolean();
                    f.readBoolean();
                }
            }
            while(fa.getFilePointer()<fa.length()){
                if(fa.readUTF().equals(mail)){
                    fa.writeBoolean(false);
                    fa.writeBoolean(true);
                    break;
                }else{
                    fa.readBoolean();
                    fa.readBoolean();
                    fa.readBoolean();
                }
            }
            fa.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Error Amigo1");
        }
        return false;
    }
    
    public String listarAmigos(){
        String amigos="";
        try {
            RegistrarUsuario reg=new RegistrarUsuario();
            f.seek(0);
            while(f.getFilePointer()<f.length()){
                String nom=f.readUTF();
                boolean amigo=f.readBoolean();
                f.readBoolean();
                f.readBoolean();
                if(amigo && reg.verificarActivo(nom)){
                    Perfil p=new Perfil(nom);
                    amigos+=p.getNombre()+"\n"+nom+"\n\n";
                    p.close();
                }
            }
            return amigos;
        } catch (IOException ex) {
            
        }
        return "";
    }
    
    public String listarAmigosPendientes(){
        try{
            f.seek(0);
            String lista="";
            while(f.getFilePointer()<f.length()){
                String nom=f.readUTF();
                f.readBoolean();
                boolean t=f.readBoolean();
                if(!f.readBoolean() && !t){
                    Perfil p=new Perfil(nom);
                    lista+=p.getNombre()+"\n"+nom+"\n\n";
                    p.close();
                }
            }
            
            return lista;
        }catch(IOException e){
            System.out.println("Error Amigos Pendientes.");
        }
        return "";
    }
    
    public String [] getCorreoAmigos(){
        String n[]={"",""};
        String listado[];
        if(cantAmigos()>0){
            listado=new String [cantAmigos()];
            try {
                int cont=0;
                f.seek(0);
                while(f.getFilePointer()<f.length()){
                    RegistrarUsuario reg=new RegistrarUsuario();
                    String correoA=f.readUTF();
                    boolean t=f.readBoolean();
                    f.readBoolean();
                    f.readBoolean();
                    if(t && reg.verificarActivo(correoA)){
                        listado[cont]=correoA;
                        cont++;
                    }
                }
                return listado;
            } catch (IOException ex) {
                System.out.println("lasdollasd");
            }
            
        }
        return n;
    }
    
    public void agregarPostInicio(String nombre,String msj){
        try {
            f.seek(0);
            while(f.getFilePointer()<f.length()){
                String g=f.readUTF();
                boolean t=f.readBoolean();
                f.readBoolean();
                f.readBoolean();
                if(t){
                   po.agegarPostInicio(g,nombre , msj);                     
                }
            }
        } catch (IOException ex) {
            System.out.println("Blahh");
        }
        
    }
    public void cerrarConexion() throws IOException{
        f.close();
        po.cerrar();
    }
}
