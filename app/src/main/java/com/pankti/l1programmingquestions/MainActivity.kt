package com.pankti.l1programmingquestions

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pankti.l1programmingquestions.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myData = MutableStateFlow("")
    private var b = B()

//    private val s: Intent by lazy {
//        Intent(this, SecondActivity::class.java)
//    }

    // activity-ktx library to create instance like this so we don't need to use viewmodelprovider factory
    private val viewModel: MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        observeData()
        performClicks()

        lifecycleScope.launch {
            tryIT()
        }

    }

    suspend fun tryIT() {

        // execute task in parallel
        coroutineScope {
            val a = async { abc() }
            val b = async { xyz() }

            val result1 = a.await()
            val result2 = b.await()

            Log.e("@@@", "tryIT: $result1 $result2")
        }
    }

    fun abc() {}
    fun xyz() {}

    open class CC {
        protected val aa = "khi"
        private val bbb = "gef"

        open fun anc() {

        }
    }


    class D : CC() {
        fun ac() {
            val ccd = aa.toString() + "psp"
        }

        override fun anc() {
            super.anc()
        }

    }


    private fun initView() {

        setBusListAdapter()

        // date format change
        try {
            val dateStr = "12/12/2024"
            val newDate = SimpleDateFormat("dd/MM/yyyy").parse(dateStr)
            val formattedDate = SimpleDateFormat("MMM dd,yy").format(newDate)
            Log.e(
                "@@@@",
                "initView: dateStr : $dateStr newDate : $newDate formattedDate : $formattedDate"
            )

        } catch (e: Exception) {
            Log.e("@@@@", "initView: error -------->${e.message}")
        }

        val abc : (String,String) -> Unit = {a,b -> print(a+b) }

        //lambda function
        val add :(Int,Int)->Int={ b,c -> b+c}
        Log.e("@@@@", "lamda function: ${add(4,5)}")

        // anonymous function
        val sum = fun(a:Int,b:Int):Int = a+b

        Log.e("@@@@", "anonymous function: ${sum(41,5)}")

        //extension function
        val str = "Marry Johnson"
        Log.e("@@@@", "Extension function: ${str.getFormattedString()}")

        //higher order function
        fun submit(a: Int, b: Int, onSubmit: (Int) -> Unit, onFailure: (String) -> Unit) {
            if (a + b > 5) onSubmit(a + b) else onFailure("Sum is less than 5")
        }

        submit(2, 4, onSubmit = {
            Log.e("@@@", "higher order function : Success: $it")
        }, onFailure = {
            Log.e("@@@", "higher order function : Failure: $it")
        })



        l1PrintAppNameThroughApplicationContext()
        b.methodFromA()

        repeat(7) {
            Log.e("@@@@", "onCreate: $it")
        }

        val a = null // assume dynamic response/value
        a?.let {
            Log.e("@@@@", "onCreate: let")
        }.run {
            Log.e("@@@@", "onCreate: run")
        }
        Log.e("@@@@", "onCreate: $a")

        resultClassDemo()
        flowExtensionMethodDemo()
        subListDemo()

        //Use case: Retry a flow that fails (e.g., network request).
        flow {
            emit(listOf("a", "b", "c"))
            throw RuntimeException("Error")
        }.retry(4) // Retries the flow up to 4 times


        lifecycleScope.launch {
            flow<List<String>> {
                delay(1000)
                emit(listOf("a", "b", "c"))
                throw RuntimeException("Error")
            }.flowOn(Dispatchers.Main)
                .catch { error ->
                    Log.e("@@@", "catch: ${error.message}")
                }.retry(2).collect { items ->
                    Log.e("@@@@", "collect:  $items")
                }
        }


        val c = C()
        c.methodFromA()
    }

    private fun setBusListAdapter() {
        binding.rvBusList.adapter = BusListAdapter(listOf("1", "2", "3", "4"), onItemClicked = {
            Toast.makeText(this, "$it selected", Toast.LENGTH_SHORT).show()
        })
    }


    private fun observeData() {


        lifecycleScope.launch {
            getData().collectLatest { value ->
                Log.e("@@@", "Data retrieved: $value")
                myData.value = value
                Log.e("@@@@@", "onCreate: ${myData.value}")
            }
        }

        viewModel.userList.observe(this) { userList ->
            Log.e("@@@@", "observeData: userList ${userList.size}")
        }

    }

    private fun performClicks() {


    }


    private suspend fun getData() = flow {
        delay(10000) // data will be emitted after 10 second
        emit("Good Night.....")
        Log.e("@@@", "data emitted")
    }.flowOn(Dispatchers.IO).catch {
        Log.e("@@@", "Oops!Something went wrong")
    }

    private fun l1PrintAppNameThroughApplicationContext() {
        val appName = MyApplication.getInstance().applicationContext.getString(R.string.app_name)
        Log.e("@@@@", "AppName: $appName")
    }

    override fun onRestart() {
        super.onRestart()
        // when the current activity is being re-displayed to the user

    }

    private fun resultClassDemo() {
        val result: Result<String> =
            Result.success("Result : Pankti Prajapati")/*Result.failure(Throwable(message = "Something went wrong!!!!"))*/

        result.fold(onSuccess = { response ->
            Log.e("@@@@", "onSuccess: $response")
        }, onFailure = { error ->
            Log.e("@@@@", "onFailure: ${error.message}")
        })
    }

    private fun flowExtensionMethodDemo() {
        lifecycleScope.launch {

            var list = listOf(1, 2, 3, 4, 5, 6, 7).asFlow()
            list = list.take(3)
            Log.e("@@@", "flowExtensionMethodDemo: ${list.toList()}")
        }
    }

    private fun subListDemo() {
        //create or get sublist from main list
        //when you want to get specific items
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val subList = list.subList(0, 4) // excluded last index
        val subList1 = list.take(3)
        val subList2 = list.slice(0..5)
        Log.e("@@@@", "onCreate: $subList")
        Log.e("@@@@", "onCreate: $subList1")
        Log.e("@@@@", "onCreate: $subList2")

    }

}


// we can't extend more than one class : multiple inheritance case in java/kotlin
// but we can implement multiple interfaces
// that's why instead of abstract class , prefer interface
// abstract class & interface , both provide abstraction , loose coupling but it depends when to use based on requirement
// in kotlin, interfaces can have method implementation
interface A {
    fun methodFromA() {
        Log.e("@@@@", "methodFromA: ")
    }
}

interface AA : A {
    override fun methodFromA() {
        Log.e("@@@@@", "method in AA")
    }
}

open class B() : A, AA {
    override fun methodFromA() {
        super<AA>.methodFromA()
        Log.e("@@@@", "methodFromA:from B ")
    }
}

class C() : B(), A {
    override fun methodFromA() {
        val typeOfFruits = Fruits.Banana
        when (typeOfFruits) {
            Fruits.Apple -> Log.e("@@@", "methodFromA: apple ")
            Fruits.Banana -> Log.e("@@@", "methodFromA: banana ")
            Fruits.Pineapple -> Log.e("@@@", "methodFromA: pineapple ")
        }

        val tempList = listOf(5, 3, 6, 8, 2, 5, 1, 7, 33)
        Log.e("#####", tempList.sorted().toString())
        val itemCount = tempList.filter { it == 5 }.size
        Log.e("@@@", "item count : $itemCount")
        Log.e("@#$%^%", tempList.reversed().toString())

        val tempList1 = listOf(5, 3, 6, 7, 8, 2, 5, 1, 7, 33, 2)
        Log.e("@@@@", "Remove Duplicates : $tempList1")
        Log.e("@@@@", "Remove Duplicates : ${tempList1.distinct()}")


        val sumFun = operation(type = OperationType.ADD)
        Log.e("@@@@", "methodFromA: ${sumFun(10, 23)}")

        val addition = 5 add 6
        Log.e("@@@@", "methodFromA: $addition")
    }

    // higher order function ------------------------------------------

    // take fun as an argument
    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        // Calls the passed-in function
        return operation(a, b)
    }

    //return a fun
    fun operation(type: OperationType): (Int, Int) -> Int {
        return when (type) {
            OperationType.ADD -> { x, y -> x + y }
            OperationType.MULTIPLY -> { x, y -> x * y }
            OperationType.SUBTRACT -> { x, y -> x - y }
            OperationType.DIVIDE -> { x, y -> x / y }
        }
    }
    // ------------------------------------------------------------------

    infix fun Int.add(item: Int): Int = this + item
}


enum class OperationType {
    ADD, MULTIPLY, SUBTRACT, DIVIDE
}
enum class Fruits(id: Int) {
    Apple(4), Banana(2), Pineapple(1)
}

private fun String.getFormattedString(): String {
    return "${this.uppercase()}  ${MyApplication.getInstance().applicationContext.getString(R.string.app_name)}"
}


abstract class MyLibrary {

    private val abc = "Pankti"

    abstract fun doYourWork()

    fun printMyName():String{
        return abc
    }
}


object Util {


    fun String.abc(){
    }

    fun MyLibrary.date(){
        print("prajapati")
    }


    fun User11.isMyTeacher(){

    }


}

class User11(val name : String){
    fun isStudent():Boolean{
        return false
    }
}


class My : MyLibrary(){
    val type: ABCD = ABCD.None
    override fun doYourWork() {
        when (type) {
            is ABCD.A -> {
                type.doSomething()
            }

            is ABCD.BB -> {
                type.value
            }

            ABCD.None -> {

            }
        }


        CoroutineScope(Dispatchers.Main).launch {
            val abb = flow<String> {
                emit("sdfg")
            }.buffer(capacity = BUFFERED).collectLatest {
                delay(4000)
                it.length
            }.run {

            }

            val a = async { doYourWork() }.await()
        }

        try {

        } catch (e: Exception) {

        } finally {

        }

    }
}

sealed class ABCD(val type: String) {
    object None : ABCD("none")
    data object A : ABCD("dashboard") {
        fun doSomething() {
            type.toString()
        }
    }

    data class BB(val value: String) : ABCD("main screen")
}