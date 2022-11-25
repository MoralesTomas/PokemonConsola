
package Clases;

import SubMenus.MenuPokemones;
import java.util.Scanner;

public class Menu {
    //Array para guardar usuarios
    String [] nombreUsuario = new String[4];
    //Array para guardar contrasenas
    String [] contraUsuario = new String[4];
    
    
    public Menu(){
        nombreUsuario[0] = "admin";
        contraUsuario[0] = "admin";
    }
        
    
    public void menu(){
        
        
        System.out.println("¿Que deseas hacer?\n");
        System.out.println("1 - Iniciar sesion");
        System.out.println("2 - Acerca de");
        System.out.println("3 - Ayuda\n");
        //lectuara de accion 
        Scanner ac = new Scanner(System.in);
        int accion = ac.nextInt();
        System.out.println("");
        Accion(accion);
    }
    
    public void Accion(int accion){
        switch (accion){
            case 1:
                iniciarSesion();
                break;
            case 2:
                acercaDe();
                break;
            case 3:
                ayuda();
                break;
        }
    }
    
    //Metodo para iniciar sesion
    public void iniciarSesion(){
        
        
        
        //Menu
        System.out.println("Selecciona una opcion:\n");
        System.out.println("1 - Ingresar (si ya tienes un usuario)");
        System.out.println("2 - Crear usuario");
        System.out.println("3 - Salir");
        Scanner validacion = new Scanner(System.in);
        int seleccion = validacion.nextInt();
        
        switch(seleccion){
            //Ingresar
            case 1:
                System.out.println("Ingresa tu nombre de usuario:");
                Scanner usuario = new Scanner(System.in);
                String nomUsu = usuario.nextLine();
                System.out.println("Ingresa tu clave:");
                Scanner clave = new Scanner(System.in);
                String contraUsu = clave.nextLine();
                
                boolean inicioExitoso = false;
                for(int i=0; i<nombreUsuario.length; i++ ){
                    if(nomUsu.equals(nombreUsuario[i])){
                        if(contraUsu.equals(contraUsuario[i])){
                            inicioExitoso = true;
                            System.out.println("Bienvenido "+nombreUsuario[i] + "\n");
                            inicioSesionExitoso();
                        }
                    }
                }
                //Comprobar inicio de sesion
                if(inicioExitoso == false){
                    System.out.println("Usuario o clave incorrecto");
                    iniciarSesion();
                }
                break;
            //Crear usuario
            case 2:
                if(nombreUsuario[3]==null){
                    System.out.println("Ingresa tu nuevo nombre de usuario:");
                    Scanner nombreNuevo = new Scanner(System.in);
                    String nombreNew = nombreNuevo.nextLine();
                    System.out.println("Ingresa tu nueva clave:");
                    String contraNew = nombreNuevo.nextLine();
                    
                    int i = 0;
                    while(i < nombreUsuario.length){
                        if(nombreUsuario[i] == null){
                            System.out.println(nombreNew +" fue registrado.");
                            nombreUsuario[i] = nombreNew;
                            contraUsuario[i] = contraNew;
                            break;
                        }else{
                            i++;
                        }
                    }
                }else{
                    System.out.println("Limite de usuario alcanzado");
                    iniciarSesion();
                }
                iniciarSesion();
                break;
            //opcion salir
            case 3: 
                menu();
                break;
            //No selecciono correctamente
            default:
                System.out.println("Opcion no disponible");
                break;
        }
    }
    
    //Luego de inicio de sesion exitoso
    public void inicioSesionExitoso(){
        int decision = 0;
        Scanner seleccion = new Scanner(System.in);
        System.out.println("Que deseas hacer:\n");
        System.out.println("1 - Jugar");
        System.out.println("2 - Menu de pokemons");
        System.out.println("3 - Salir");
        decision = seleccion.nextInt();
        PreJuego(decision);
    }
    
     //Opciones antes de batalla
    public void PreJuego(int seleccion){
        switch(seleccion){
            case 1:
                System.out.println("Iniciando a jugar.......");
                break;
            case 2:
                System.out.println("Manejo de pokemons.....");
                MenuPokemones men = new MenuPokemones();
                men.menuP();
                break;
            case 3: 
                menu();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
    
    //Acerca de 
    public void acercaDe(){
        System.out.println("Creado por:");
        System.out.println("Tomas Morales");
        System.out.println("Diego Morales");
    }
    
    //Ayuda 
    public void ayuda(){
        System.out.println("Reglas del juego:\n\n");
    }
    
}
