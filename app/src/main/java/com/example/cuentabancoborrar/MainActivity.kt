package com.example.cuentabancoborrar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cuentabancoborrar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cuenta: Cuenta
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.botonRegistrar.setOnClickListener {
            val nombre=binding.nombre.text.toString()
            val apellido=binding.apellido.text.toString()
            val cedula=binding.cedula.text.toString()


            cuenta=Cuenta(nombre,apellido,cedula)
            Toast.makeText(this,"usuario registrado con exito",Toast.LENGTH_SHORT).show()
            binding.nombre.setText("")
            binding.apellido.setText("")
            binding.cedula.setText("")
        }
        binding.botonIngresar.setOnClickListener {
            val cantidad=binding.ingresoValor.text.toString().toFloat()

            cuenta.depositar(cantidad)
            binding.aviso.setText("hola ${cuenta.nombre} tu saldo es ${cuenta.saldo}")
        }
        binding.botonRetirar.setOnClickListener {
            val cantidad=binding.ingresoValor.text.toString().toFloat()
            val retiro=cuenta.retirar(cantidad)
            if(retiro){
                binding.aviso.setText("hola ${cuenta.nombre} tu saldo actual  es: ${cuenta.saldo}")
            }else{
                binding.aviso.setText("hola ${cuenta.nombre} no puedes Retirar saldo insuficiente")
                binding.ingresoValor.setText("")
            }
        }
        binding.btnInformacion.setOnClickListener {
            binding.aviso.setText("Datos personales \nNombre: ${cuenta.nombre} \nApellido: ${cuenta.apellido}" +
                    "\nsaldo: ${cuenta.saldo}")
        }
    }
}