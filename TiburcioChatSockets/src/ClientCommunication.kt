import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket
import java.util.*

class ClientCommunication(val socket: Socket) : Thread() {

    @Override
    override fun run() {
        serveClient(socket)
    }

    private fun serveClient(socket: Socket) {


        var myis = socket.getInputStream()
        var isr = InputStreamReader(myis)
        var br = BufferedReader(isr)


        var os = socket.getOutputStream()
        var osw = OutputStreamWriter(os)
        var bw = BufferedWriter(osw)
        var sendLine: String

        do {
            var line = br.readLine()


            var sc = Scanner(System.`in`)

            println("Client said: $line")

            println("Write to Client: ")

            sendLine = sc.nextLine()
            bw.write(sendLine)
            bw.newLine()
            bw.flush()

        } while (line != null)

        if (br != null) {
            br.close()
        }

    }


}