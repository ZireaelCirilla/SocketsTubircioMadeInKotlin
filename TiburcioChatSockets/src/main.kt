import java.net.ServerSocket

class main {

    companion object {

        val PORT = 40000

        @JvmStatic
        fun main(args: Array<String>) {
            println("Kotlin main is running here!")

            var sk = ServerSocket(PORT)


            while (true){
                var socket = sk.accept()

                ClientCommunication(socket).start()
            }



        }


    }


}