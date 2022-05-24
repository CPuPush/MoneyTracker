package ac.id.del.moneytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // untuk menyembunyikan header
        supportActionBar?.hide()

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }

//    private fun btnToLogin() {
//        btn_signIn.setOnClickListener {
//            startActivity(Intent(this, SignInActivity::class.java))
//        }
//    }
}