package com.example.botoneslocos12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Queue

class MainActivity : AppCompatActivity() {

    lateinit var tvTiempoRestante:TextView
    lateinit var tvJugadaTotales:TextView
    lateinit var tvMaxJugada:TextView
    lateinit var tvRegistro:TextView
    lateinit var etNombre:EditText

    lateinit var btn01:Button
    lateinit var btn02:Button
    lateinit var btn03:Button
    lateinit var btn04:Button
    lateinit var btn05:Button
    lateinit var btn06:Button
    lateinit var btn07:Button
    lateinit var btn08:Button
    lateinit var btn09:Button
    lateinit var btn10:Button
    lateinit var btn11:Button
    lateinit var btn12:Button


    lateinit var btnJugar:Button
    lateinit var btnReset:Button

    var tiempo:Int = 0
    var contador:Int = 0
    var max:Int = 0

    var registro:String = " "
    var registro1:String = " "
    var registro2:String = " "
    var registro3:String = " "
    var registro4:String = " "
    var registro5:String = " "
    var ultimaJugada:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponent()
        initListener()
        inicio()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponent(){
        tvTiempoRestante = findViewById(R.id.tvTiempoRestante)
        tvJugadaTotales = findViewById(R.id.tvJugadaTotales)
        tvMaxJugada = findViewById(R.id.tvMaxJugada)
        tvRegistro = findViewById(R.id.tvRegistros)

        etNombre = findViewById(R.id.etNombre)

        btnJugar = findViewById(R.id.btnJugar)
        btnReset = findViewById(R.id.btnReset)


        btn01 = findViewById(R.id.btn01)
        btn02 = findViewById(R.id.btn02)
        btn03 = findViewById(R.id.btn03)
        btn04 = findViewById(R.id.btn04)
        btn05 = findViewById(R.id.btn05)
        btn06 = findViewById(R.id.btn06)
        btn07 = findViewById(R.id.btn07)
        btn08 = findViewById(R.id.btn08)
        btn09 = findViewById(R.id.btn09)
        btn10 = findViewById(R.id.btn10)
        btn11 = findViewById(R.id.btn11)
        btn12 = findViewById(R.id.btn12)

    }
    private fun initListener(){
        btnJugar.setOnClickListener(){
            btnJugar.isEnabled = false
            jugar()
        }
        btnReset.setOnClickListener(){
            inicio()
        }
        //dentro del juego
        btn01.setOnClickListener(){
            btn01.isEnabled = false
            contador()
            randomBotones()
        }
        btn02.setOnClickListener(){
            btn02.isEnabled = false
            contador()
            randomBotones()
        }
        btn03.setOnClickListener(){
            btn03.isEnabled = false
            contador()
            randomBotones()
        }
        btn04.setOnClickListener(){
            btn04.isEnabled = false
            contador()
            randomBotones()
        }
        btn05.setOnClickListener(){
            btn05.isEnabled = false
            contador()
            randomBotones()
        }
        btn06.setOnClickListener(){
            btn06.isEnabled = false
            contador()
            randomBotones()
        }
        btn07.setOnClickListener(){
            btn07.isEnabled = false
            contador()
            randomBotones()
        }
        btn08.setOnClickListener(){
            btn08.isEnabled = false
            contador()
            randomBotones()
        }
        btn09.setOnClickListener(){
            btn09.isEnabled = false
            contador()
            randomBotones()
        }
        btn10.setOnClickListener(){
            btn10.isEnabled = false
            contador()
            randomBotones()
        }
        btn11.setOnClickListener(){
            btn11.isEnabled = false
            contador()
            randomBotones()
        }
        btn12.setOnClickListener(){
            btn12.isEnabled = false
            contador()
            randomBotones()
        }


    }
    private fun inicio(){
        guardarContadorJugada()
        tiempo = 10
        reiniciarContador()
        apagarBotones()
        btnJugar.isEnabled = true
        btnReset.isEnabled = false
    }

    private fun jugar(){
        cuentaAtras()
        randomBotones()
    }
    private fun randomBotones(){
        apagarBotones()

        var nAleatorio:Int = (1..12).random();
        if(nAleatorio == 1){
            btn01.isEnabled = true
        }
        if(nAleatorio==2){
            btn02.isEnabled = true
        }
        if(nAleatorio == 3){
            btn03.isEnabled = true
        }
        if(nAleatorio == 4){
            btn04.isEnabled = true
        }
        if(nAleatorio== 5){
            btn05.isEnabled = true
        }
        if(nAleatorio == 6){
            btn06.isEnabled = true
        }
        if(nAleatorio == 7){
            btn07.isEnabled = true
        }
        if(nAleatorio== 8){
            btn08.isEnabled = true
        }
        if(nAleatorio == 9){
            btn09.isEnabled = true
        }
        if(nAleatorio == 10){
            btn10.isEnabled = true
        }
        if(nAleatorio== 11){
            btn11.isEnabled = true
        }
        if(nAleatorio == 12){
            btn12.isEnabled = true
        }

    }
    private fun contador(){
        var texto:String = "jugadas totales: "
        contador++
        tvJugadaTotales.text = texto+contador.toString()
    }
    private fun reiniciarContador(){

        contador = 0
        var texto:String = "jugadas totales: "
        tvJugadaTotales.text = texto+contador.toString()
    }

    /**
     *
     */
    private fun guardarContadorJugada() {
        var texto:String = "Record : DESCONOCIDO: "
        if(etNombre.text.isEmpty()){
            if(contador > max){
                tvMaxJugada.text =(texto+contador)
                max = contador

            }
        }else{
            texto = ("Record:  "+etNombre.text.toString()+": ")
            if(contador > max){
                tvMaxJugada.text =(texto+contador)
                max = contador

            }
        }


    }
    private fun registro(){
        if (etNombre.text.isEmpty()){
            registro = ("DESCONOCIDO: "+contador+" Clicks")
        }
        else{
            registro = (etNombre.text.toString()+" "+contador+" Clicks")
        }

        registro5 = registro4
        registro4 = registro3
        registro3 = registro2
        registro2 = registro1
        registro1 = registro

        ultimaJugada = "\n"+registro1 +"\n"+ registro2 +"\n" +registro3 +"\n"+registro4 +"\n"+ registro5
        tvRegistro.text = "ULTIMAS JUGADAS" + ultimaJugada
    }

    private fun apagarBotones(){
        btn01.isEnabled = false
        btn02.isEnabled = false
        btn03.isEnabled = false
        btn04.isEnabled = false
        btn05.isEnabled = false
        btn06.isEnabled = false
        btn07.isEnabled = false
        btn08.isEnabled = false
        btn09.isEnabled = false
        btn10.isEnabled = false
        btn11.isEnabled = false
        btn12.isEnabled = false
    }
    private fun cuentaAtras(){
        //LLama a la variable cada x milisSegundos
        if(tiempo == 0){
            return
        }
        var postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 1000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 2000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 3000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 4000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 5000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 6000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 7000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 8000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 9000)
        postDelayed01 = android.os.Handler().postDelayed({
            cuentaAtrasTexto()
        }, 10000)
    }
    private fun cuentaAtrasTexto(){
        var text:String = "Jugada totales: "
        tiempo--
        tvTiempoRestante.text = text + tiempo.toString()
        if(tiempo == 0){
            apagarBotones()
            guardarContadorJugada()
            btnReset.isEnabled = true
            registro()
        }
    }
}