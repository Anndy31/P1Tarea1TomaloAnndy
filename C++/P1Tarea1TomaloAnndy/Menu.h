#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED
#include <iostream>
#include <string.h>
using namespace std;
void leer();
void Ingresonotas();
void leerPromedio();
void encabezado(){//encabezado de los datos
    cout<<"****************************************************"<<endl;
string enca[4] ={"Universidad de las Fuerzas Armadas", "Anndy Tomalo", "Docente: Veronica Martinez", "Periodo:24-25"};

    for (int i = 0; i < 4; i++) {
        cout << enca[i] << endl;
    }
}

void menu (){//Menu de opciones
    int Tomaloopcion;
    do{

cout<<"****************************************************"<<endl;
cout<<"1.- Ingreso de las notas"<<endl;
cout<<"2.- Leer los promedios"<<endl;
cout<<"3.-Salir                "<<endl;
cout<<"****************************************************"<<endl;
cout<<"Ingrese una opcion      "<<endl;
cin>>Tomaloopcion;

switch(Tomaloopcion){
case 1:

 Ingresonotas();//funcines llamadas

    break;
case 2:
     leer();//funcines llamadas

    break;
case 3:
    cout<<"Saliendo......"<<endl;
    break;

    default: cout<<"Error! Ingrese otra vez.."<<endl;

}
    }while(Tomaloopcion !=3);//salida del bucle
}









#endif // MENU_H_INCLUDED
