package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.text.Html
import android.widget.TextView
import kotlinx.android.synthetic.main.cust.*
import org.json.JSONArray
import org.json.JSONObject

class Scheduled_Meeting : Activity() {
    var text: String? = ""
    lateinit var messge: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cust)
        back.setOnClickListener { this@Scheduled_Meeting.finish() }
        messge = findViewById<TextView>(R.id.messge)

        var data: String = ""
        text = intent?.getStringExtra("dataT")
        try {
            var json: JSONArray = JSONArray(text)
            var i:Int=0
            while (i<json.length()) {
                var jsnarray: JSONObject = json.getJSONObject(i)
                var iterate = jsnarray.keys()
                var count:Int=0
                while (iterate.hasNext()) {
                    var key: String = iterate.next()
                    var value: String = jsnarray.getString(key)
                    data = data + "<br>" + " <b>" + key + ": " + " </b>" + value
                    count++
                    if (count>=6)
                        break
                }
                i++
                data = data + "<br> ———— <br>"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        messge.setText(Html.fromHtml(data))
    }
}