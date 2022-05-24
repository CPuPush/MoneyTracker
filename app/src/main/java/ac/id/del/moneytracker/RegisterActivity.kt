package ac.id.del.moneytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // untuk menyembunyikan header
        supportActionBar?.hide()

        toLogin()
    }

    private fun toLogin() {
        tv_haveaccount.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}