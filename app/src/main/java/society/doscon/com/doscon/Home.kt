package society.doscon.com.doscon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.home_view.*
import java.lang.reflect.Field
import java.util.*


class Home : Fragment() {
    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }
    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 1000//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 4000
    var NUM_PAGES: Int = 2
    var images: IntArray = intArrayOf(R.drawable.copy2, R.drawable.copy3)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_view, container, false)
        return view
    }
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