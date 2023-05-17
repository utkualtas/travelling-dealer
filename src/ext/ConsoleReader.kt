package ext

import java.io.ByteArrayOutputStream
import java.io.PrintStream

fun runWithConsoleOutput(call: () -> Unit): String {
    val baos = ByteArrayOutputStream()
    val ps = PrintStream(baos)
    val old = System.out
    System.setOut(ps)

    call()

    System.out.flush()
    System.setOut(old)
    return baos.toString()
}