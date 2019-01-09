import java.io.*
import java.net.Socket
import java.util.*

class ClientCommunication(val socket: Socket): Thread() {

    @Override
    override fun run() {
        super.run()

    serveClient(socket)

    }

    private fun serveClient(socket: Socket) {

        try {
            var myis = socket.getInputStream()
            var isr = InputStreamReader(myis)
            var br = BufferedReader(isr)
            var line = br.readLine()

            var os = socket.getOutputStream()
            var osw = OutputStreamWriter(os)
            var bw = BufferedWriter(osw)

            var sc = Scanner(System.`in`)
            var sendLine: String

            do {

                println("Client said: +$line")
                println("Write to Client: ")

                sendLine = sc.nextLine()
                bw.write(sendLine)
                bw.newLine()
                bw.flush()

            }while (line != "FIN")

            if (br != null) { br.close() }
        } catch (ex: IOException){

        }



    }


}