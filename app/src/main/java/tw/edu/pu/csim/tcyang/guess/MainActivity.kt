package tw.edu.pu.csim.tcyang.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Guess(v: View) {
        var User: Int = 0  //玩家出拳
        var Phone: Int = (0..2).random()  //手機出拳

        val Pictures = intArrayOf(R.drawable.scissors,
            R.drawable.rock, R.drawable.paper,)

        var imgPhone: ImageView = findViewById(R.id.imgPhone)
        imgPhone.setImageResource(Pictures[Phone])

        //玩家出拳
        when (v.id) {
            R.id.imageScissors -> User = 0
            R.id.imageRock -> User = 1
            R.id.imagePaper -> User = 2
        }

        //顯示猜拳結果
        var result: TextView = findViewById(R.id.txvResult)

        result.text = "玩家出：" + GuestType(User) + "; 手機出：" + GuestType(Phone) +
                "\n猜拳結果：" + Judge(User, Phone)
    }

    fun GuestType(x:Int):String{
        return when (x){
            0 -> "剪刀"
            1 -> "石頭"
            else -> "布"
        }
    }

    //判斷勝負
    fun Judge(u:Int, p:Int):String{
        var dif: Int = u - p
        if (dif==0){
            return "平手"
        }
        else if (dif==1 || dif==-2){
            return "玩家獲勝"
        }
        else{
            return "手機獲勝"
        }
    }

}