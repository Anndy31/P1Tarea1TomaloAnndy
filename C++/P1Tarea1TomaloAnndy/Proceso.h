#ifndef PROCESO_H_INCLUDED
#define PROCESO_H_INCLUDED
#include <iostream>
#include <fstream>
using namespace std;            //Variables Globales
int Tomalocantidad;
float Tomalonota1, Tomalonota2, Tomalonota3;
float Tomalopromedios[5];
void GuardarPromedio() ;
void Ingresonotas(){//funcion de solicitud de datos

while(Tomalocantidad <1 || Tomalocantidad >5){
cout<<"Cuantos Estudiantes va a Ingresar (1-5)"<<endl;
cin>>Tomalocantidad;
}
for(int i=0; i<Tomalocantidad; i++){
cout<<"Ingrese las notas para calcular el promedio #"<<i+1<<endl;
cout<<"Ingrese la Primer Nota: "<<endl;
cin>>Tomalonota1;
while(Tomalonota1<0 || Tomalonota1>20){
cout<<"La nota debe estar en el Rango de (0-20): ";
cin>>Tomalonota1;
}
cout<<"Ingrese la Segunda Nota: "<<endl;
cin>>Tomalonota2;
while(Tomalonota2<0 || Tomalonota2>20){
cout<<"La nota debe estar en el Rango de (0-20): ";
cin>>Tomalonota2;
}
cout<<"Ingrese la Tercer Nota: "<<endl;
cin>>Tomalonota3;
while(Tomalonota3<0 || Tomalonota3>20){
cout<<"La nota debe estar en el Rango de (0-20): ";
cin>>Tomalonota3;
}
  float TomaloNotafi=(Tomalonota1+Tomalonota2+Tomalonota3)/3;
  Tomalopromedios[i] = TomaloNotafi;
  cout<<"El Estado del Estudainte #" <<i+1<<" es :"<<endl;
if(TomaloNotafi <14){
cout<<"Reprovado con ";
}else{
cout<<"Aprovado con ";
}
cout<<TomaloNotafi<<endl;
}
 GuardarPromedio() ;//llamda a la funcion de guardar
}

void GuardarPromedio() {//se guarda en un archivo txt
    ofstream archivo("doc.txt");
    if (archivo.is_open()) {
        for (int i = 0; i < Tomalocantidad; i++) {
            archivo << "Estudiante #" << (i + 1) << ": Promedio = " << Tomalopromedios[i] << endl;
        }
        archivo.close();
        cout << "Se ha guardado correctamente." << endl;
    } else {
        cout << "Error al guardar los promedios." << endl;
    }
}

void leer() { //lee los datos que se guardo
    ifstream archivo("doc.txt");
    if (archivo.is_open()) {
        string linea;
        while (getline(archivo, linea)) {
            cout << linea << endl;
        }
        archivo.close();
        cout << "Correcto" << endl;
    } else {
        cout << "Error al leer el archivo" << endl;
    }
}
#endif // PROCESO_H_INCLUDED
