
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.concurrent.thread

/* Coroutines are very similar to Threads. However, coroutines are cooperatively multitasked, 
 * whereas threads are typically preemptively multitasked. 
 * Coroutines provide concurrency but not parallelism.
 * - Remember underscores in 'val coroutines = List(1_000) {' are ignored you can put them in to make more readable*/

fun main(){
    //Couroutines vs. Threads comparison.
    jorgesysCoroutine() 
    jorgesysThread()
    
}

/* COROUTINE Jorgesys */
fun jorgesysCoroutine() = runBlocking {
    val time = measureTimeMillis {
        val coroutines = List(1_000) {
            launch {
                delay(500)
                log('.')
            }
        }
        coroutines.forEach {
            it.join()
        }
        log('\n')
    }
    log("COROUTINE Time: $time")    
}  

/* THREAD Jorgesys */
 fun jorgesysThread() {
    val time = measureTimeMillis {
        val threads = List(1_000) {
            thread {
                Thread.sleep(500)
                log('.')
            }
        }
        threads.forEach {
            it.join()
        }
        log('\n')
    }
    log("Thread Time: $time")    
  }
 
  /*--------- Print information---------------*/
  fun log(message: String) {
    println("[${Thread.currentThread().name}] : $message")
  }

  fun log(character: Char) {
    print("$character")
  }

