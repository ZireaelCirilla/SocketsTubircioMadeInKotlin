import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket
import java.util.*

class Client {
    companion object {

        val PORT = 40080

        @JvmStatic
        fun main(args: Array<String>) {
            println("Kotlin main is running here!")

            val HOST = "192.168.201.35"

            var socket = Socket(HOST, PORT)
            
            comunicateWithServer(socket)

        }

        private fun comunicateWithServer(socket: Socket) {

            var os = socket.getOutputStream()
            var osw = OutputStreamWriter(os)
            var bw = BufferedWriter(osw)

            var myis = socket.getInputStream()
            var isr = InputStreamReader(myis)
            var br = BufferedReader(isr)

            var sc = Scanner(System.`in`)

            do {
                println("Write something to send: ")
                var line = sc.nextLine()

                bw.write(line)
                bw.newLine()
                bw.flush()

                var lineFromServer = br.readLine()

                println("Server said: $lineFromServer")

            } while (line != "FIN")


        }

    }
}
