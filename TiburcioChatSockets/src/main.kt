import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.util.logging.Level
import java.util.logging.Logger

class main {

    companion object {

        val PORT = 40000

        @JvmStatic fun main(args: Array<String>) {
            println("Kotlin main is running here!")
            try{

                while (true){
                    var sk = ServerSocket(PORT)

                    var socket: Socket = sk.accept()

                    ClientCommunication(socket).run()
                }


            } catch (ex: IOException){
                Logger.getLogger(main.javaClass.name).log(Level.SEVERE, null, ex)
            }
        }


    }




}