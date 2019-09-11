package society.doscon.com.doscon

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.login_view.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.header_other.*


class Login : Activity(), View.OnClickListener, SignUpAPICall.CallBackToClass {
    override fun returnDataToClass(tag: String?, data: String?) {
        println(data)
        when (tag) {
            "OAUTHTOKEN" -> {
                try {
                    val reader = JSONObject(data)
                    if (reader.has("status_api")) {
                        var status_api = reader.getString("status_api")
                        if (status_api.equals("true")) {
                            val requestJson = JSONObject()
                            requestJson.put("registrationId", reader.getString("Registration Id"))
                            val URL = "https://glaucomasociety.in/api/reg-gsi.php"
                            SignUpAPICall(URL, 0, "REGISTRATION", this@Login, this@Login).execute(requestJson)

                        } else {
                            toast(reader.getString("status_msg"))
                        }
                    }
                } catch (E: Exception) {
                    E.printStackTrace()
                }
            }
            "REGISTRATION" -> {
                val editor = getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE).edit()
                editor.putString("DATA", data)
                editor.apply()
                this@Login.finish()
                var intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("DATA", data)
                startActivity(intent)

            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_loginbtn -> {
                println("clicked  sdfsdfsdfsdfsdfsdfsdf")
                if (validation()) {
                    val requestJson = JSONObject()
                    requestJson.put("uemail", etUserName.text)
                    requestJson.put("umobile", etPassword.text)
                    val URL = "https://glaucomasociety.in/api/login-gsi.php"
                    SignUpAPICall(URL, 0, "OAUTHTOKEN", this@Login, this@Login).execute(requestJson)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view)
        tv_loginbtn.setOnClickListener(this)
        title_name.text="LOGIN"
        back.setOnClickListener { this@Login.finish() }
    }

    fun validation(): Boolean {
        if (TextUtils.isEmpty(etUserName.text)) {
            usererror.setError("Please enter user name")
            return false
        } else if (TextUtils.isEmpty(etPassword.text)) {
            usererror.error = null
            etPassworderror.setError("Please enter password")
            return false
        } else {
            usererror.error = null
            etPassworderror.error = null
            return true
        }
    }
}