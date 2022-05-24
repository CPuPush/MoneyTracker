package ac.id.del.moneytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // untuk menyembunyikan header
        supportActionBar?.hide()

        toNav()
        toRegister()
    }

    // menghubungkan ke halaman register
    private fun toRegister(){
        tv_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun toNav() {
        btn_nav.setOnClickListener {
            startActivity(Intent(this, Navigation::class.java))
        }
    }
}