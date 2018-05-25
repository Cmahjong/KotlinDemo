package com.yinjin.expandtextview.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        kotlinOne()
//        kotlinTwo()
//        kotlinThree()




        launch(UI){
            val x = async { getX() }
            val y = async { getY() }

            tv1.text="${x.await()}+${y.await()}"
        }
        tv1.text="你好"
    }

    suspend fun getX(): Int {
        Thread.sleep(10000)
        return 1
    }

    suspend fun getY(): Int {
        Thread.sleep(2000)
        return 1
    }

    fun kotlinFour() {
        tv1.text = "123"
    }

    private fun kotlinThree() {
        val test = Test()
        test.name = "你好"
        Log.e("taga", test.name)
    }

    private fun kotlinTwo() {
        val map = mapOf("1" to 1, "2" to 2, "3" to 3, "4" to 4)
        map.forEach { t, u ->
            Log.e(t, u.toString())
        }
    }

    private fun kotlinOne() {
        val lists = arrayListOf(1, 30, 13, 24, 25, 76, 17, 18)
        a@ for (i in 0 until lists.size step 2) {
            if (i == 2) {
                continue@a
            }
            Log.e("...", i.toString())
        }
        lists.filter { it % 2 != 0 }
                .map { it + 2 }
                .sorted()
                .forEach {
                    Log.e("...", it.toString())
                }
    }
}

class Test {
    var name: String? = null
        get() = field + "123"
        set(value) {
            field = value + "abc"
        }
}

interface A {
    fun foo() {
        print("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

class AImpl : A {
    override fun bar() {
        print("你好")

        abc {}

        abc(::bcd)
    }

    fun abc(block: () -> Unit) {

    }

    fun bcd() {

    }
}

class Derived(a: A) : A by a {

}

class C : D("asd"), A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}