package com.example.cuentabancoborrar

class Cuenta(val nombre:String, val apellido:String,val cedula:String
,var saldo:Float=45f) {

    fun depositar(cantidad:Float){
        saldo +=cantidad
    }
    fun retirar(cantidad:Float):Boolean{
        var retiro=false
        if(cantidad<saldo){
            saldo -=cantidad
            return true
        }
        return retiro
    }
    fun mostrarInformacion():String{
        return "Nombre: $nombre Apellido:$apellido saldo :$saldo"

    }
}