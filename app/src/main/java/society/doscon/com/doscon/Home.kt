package society.doscon.com.doscon

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.home_view.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Field
import java.util.*


class Home : Fragment(), SignUpAPICall.CallBackToClass {
    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }

    var currentPage = 0
    var currentAdapterIndex = 0
    var timer: Timer? = null
    var timerForAdapter: Timer? = null
    val DELAY_MS: Long = 1000//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 4000
    val PERIOD_MS_ADAPTER: Long = 6000
    var NUM_PAGES: Int = 4
    var NUM_INDEx: Int = 0
    var images: IntArray = intArrayOf(R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_view, container, false)
        return view
    }

    lateinit var mLayoutManagerL: LinearLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adpter = Carousal(context!!, images)
        carousal.adapter = adpter
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            if (carousal != null)
                carousal.setCurrentItem(currentPage++, true)
        }
        if (timer == null) {
            timer = Timer() // This will create a new Thread
            timer!!.schedule(object : TimerTask() {
                override fun run() {
                    handler.post(Update)
                }
            }, DELAY_MS, PERIOD_MS)
        }
        try {
            val mScroller: Field
            mScroller = ViewPager::class.java.getDeclaredField("mScroller")
            mScroller.setAccessible(true)
            val scroller = FixedSpeedScroller(carousal.getContext())
            // scroller.setFixedDuration(5000);
            mScroller.set(carousal, scroller)
        } catch (e: NoSuchFieldException) {
        } catch (e: IllegalArgumentException) {
        } catch (e: IllegalAccessException) {
        }

        generateticket = GenerateTicketAdapter(context!!, retailerList)
        mLayoutManagerL = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(notification_list.getContext(),
                mLayoutManagerL.getOrientation())
        notification_list.addItemDecoration(dividerItemDecoration)
        notification_list.adapter = generateticket
        notification_list.layoutManager = mLayoutManagerL

        val requestJson = JSONObject()
        requestJson.put("registrationId", "")
        val URL = "https://glaucomasociety.in/api/notification-gsi.php"
        SignUpAPICall(URL, 0, "NOTIFICATION", this@Home, activity).execute(requestJson)


    }

    var generateticket: GenerateTicketAdapter? = null
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
                if (retailerList.size > 0) {
                    generateticket?.updateView(retailerList)

                    NUM_INDEx = retailerList.size
                    if (NUM_INDEx > 1) {
                        val handler = Handler()
                        val Update = Runnable {
                            if (currentAdapterIndex == NUM_INDEx) {
                                currentAdapterIndex = 0
                            }
                            if (mLayoutManagerL != null)
                                mLayoutManagerL.scrollToPositionWithOffset(currentAdapterIndex++, 0)
//                                carousal.setCurrentItem(currentAdapterIndex++, true)
                        }
                        if (timerForAdapter == null) {
                            timerForAdapter = Timer() // This will create a new Thread
                            timerForAdapter!!.schedule(object : TimerTask() {
                                override fun run() {
                                    handler.post(Update)
                                }
                            }, DELAY_MS, PERIOD_MS_ADAPTER)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    internal class Carousal(var context: Context, var images: IntArray) : PagerAdapter() {
        lateinit var layoutInflater: LayoutInflater

        init {

            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val itemView = layoutInflater.inflate(R.layout.item, container, false)

            val imageView = itemView.findViewById<ImageView>(R.id.imageView) as ImageView
//            val banner_text = itemView.findViewById<TextView>(R.id.banner_text) as TextView
            imageView.setImageResource(images[position])
//            if (position==0)
//            banner_text .text = Html.fromHtml("<h1 color='#FCAA23'>ISCKRS MEET 2019</h1> <br> 03rd & 04 Aug 2019.<br> LeMeridien New Delhi")
            container.addView(itemView)
            return itemView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            // super.destroyItem(container, position, `object`)
            (container as ViewPager).removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as RelativeLayout
        }

        override fun getCount(): Int {
            return images.size
        }

    }
}