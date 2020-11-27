package pakiet.arkadiuszzimny.kotlinmvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import pakiet.arkadiuszzimny.kotlinmvplogin.Presenter.ILoginPresenter
import pakiet.arkadiuszzimny.kotlinmvplogin.Presenter.LoginPresenter
import pakiet.arkadiuszzimny.kotlinmvplogin.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init
        loginPresenter = LoginPresenter(this)

        //Event
        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }

    }

    override fun onLoginSucces(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

}