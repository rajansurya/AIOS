package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.notificationlist.*
import org.json.JSONArray
import org.json.JSONObject
import android.support.v7.widget.DividerItemDecoration


class NotificationAPI : Activity(), SignUpAPICall.CallBackToClass {
    var retailerList = ArrayList<NotificationData>()
    override fun returnDataToClass(tag: String?, data: String?) {
        println(data)
        try {
            var json = JSONObject(data)
            if (json.has("Data") && (json.getJSONArray("Data") is JSONArray)) {

                var gson = Gson()
                var retalerListLOC: ArrayList<NotificationData> = gson.fromJson(json.getJSONArray("Data").toString(), object : TypeToken<ArrayList<NotificationData>>() {}.type)
                retailerList.clear()
                retailerList.addAll(retalerListLOC)
                if (retailerList.size > 0)
                    generateticket?.updateView(retailerList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    var generateticket: GenerateTicketAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notificationlist)
        title_name.text = "UPDATES"
        back.setOnClickListener { this@NotificationAPI.finish() }

        generateticket = GenerateTicketAdapter(this@NotificationAPI, retailerList)
        val mLayoutManagerL = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(notification_list.getContext(),
                mLayoutManagerL.getOrientation())
        notification_list.addItemDecoration(dividerItemDecoration)
        notification_list.adapter = generateticket
        notification_list.layoutManager = mLayoutManagerL

        val requestJson = JSONObject()
        requestJson.put("registrationId", "")
        val URL = "http://isckrs.com/api/notification-isckrs.php"
        SignUpAPICall(URL, 0, "NOTIFICATION", this@NotificationAPI, this@NotificationAPI).execute(requestJson)
    }
}