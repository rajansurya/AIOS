package society.doscon.com.doscon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header_view.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity(), View.OnClickListener, Menuitem.menuckick {
    var schedule: JSONArray? = null


    lateinit var menuposition: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var myretailer: String? = intent?.extras?.get("DATA") as? String
        var prefs: SharedPreferences = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        var restoredText = prefs.getString("DATA", null);
//        if (restoredText != null) {
        if (!TextUtils.isEmpty(restoredText)) {
            val reader = JSONObject(restoredText).getJSONArray("Data").getJSONObject(0)
            if (reader.optJSONArray("schedule") != null)
                schedule = reader.getJSONArray("schedule")
            var intent = Intent(this, TicketDetail::class.java)
            intent.putExtra("DATA", restoredText)
            startActivity(intent)
            menuposition = getResources().getStringArray(R.array.tabname);
            menuposition.set(8, "LOGOUT")
        } else {
            menuposition = getResources().getStringArray(R.array.tabname);
        }
        title_name.text = "GLAUCOMA SOCIETY OF INDIA";
//        sub_title_name.text = Html.fromHtml("<font color='#FCAA23'>MEET 2019</font>")

//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
        first?.layoutManager = LinearLayoutManager(this)
        first?.addItemDecoration(SpacesItemDecoration(1))
        var adapter = Menuitem(this, this, menuposition)
        first?.setAdapter(adapter)
        drawer_click.setOnClickListener(this)
        // blinkAnim()
        /*val imageView = findViewById<ImageView>(R.id.right_icon) as ImageView
        if (schedule != null && !TextUtils.isEmpty(schedule.toString())) {
            val rippleBackground = findViewById<View>(R.id.content) as RippleBackground

            imageView.setOnClickListener {
                rippleBackground.stopRippleAnimation()
                var dd = Diao().getInstance(schedule.toString())

                dd.show(supportFragmentManager, "")
            }
            rippleBackground.startRippleAnimation()
        } else {
            imageView.visibility = View.GONE
        }*/
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawer_layout.addDrawerListener(Drawerlayout(content_View));

    }


    public fun onClickitem(view: View) {
        when (view?.id) {
            R.id.officebear -> {
                var inyeny: Intent = Intent(this, ShowPDF::class.java)
                inyeny.putExtra("which", "")
                startActivity(inyeny)
            }
            R.id.officebear2 -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            R.id.officebear3 -> {
                startActivity(Intent(this, Highlight::class.java))
            }
            R.id.officebear4 -> {
                var inyeny: Intent = Intent(this, ShowPDF::class.java)
                inyeny.putExtra("which", "programm")
                startActivity(inyeny)
//                startActivity(Intent(this, Abstract::class.java))
              /*  var webpagesLinear: WebView = WebView(this)
                webpagesLinear.getSettings().setJavaScriptEnabled(true);
                webpagesLinear.getSettings().setSupportMultipleWindows(true)
                webpagesLinear.setWebChromeClient(object : WebChromeClient() {
                    override fun onCreateWindow(view: WebView, dialog: Boolean, userGesture: Boolean, resultMsg: android.os.Message): Boolean {
                        val result = view.hitTestResult
                        val data = result.extra
                        val context = view.context
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data))
                        context.startActivity(browserIntent)
                        return false
                    }
                })
                val pdf = "http://isckrs.com/Scientific-Programme.pdf"
                webpagesLinear.loadUrl("http://docs.google.com/gview?embedded=true&url="+pdf)*/
            }
            R.id.officebear5 -> {
                var prefs: SharedPreferences = getSharedPreferences("MY_PREFS_NAME", AppCompatActivity.MODE_PRIVATE);
                var restoredText = prefs.getString("DATA", null);
                if (!TextUtils.isEmpty(restoredText)) {
                    if (schedule != null && !TextUtils.isEmpty(schedule.toString())) {
                        var intent = Intent(this, Scheduled_Meeting::class.java)
                        intent.putExtra("dataT", schedule.toString())
                        startActivity(intent)
                    }
                } else {
                    var intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
            }
            R.id.officebear6 -> {
                startActivity(Intent(this, Venue::class.java))
            }

        }
    }

    override fun menuClick(position: Int) {
        drawer_layout.closeDrawer(Gravity.LEFT)
        when (position) {
            0 -> {
                drawer_layout.closeDrawer(Gravity.LEFT)
            }
            1 -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            /* 2 -> {
                 var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php"))
                 startActivity(intent)
             }*/
            /*2 -> {
                startActivity(Intent(this, Commitee::class.java))
            }*/
            /*3 -> {
    startActivity(Intent(this, Exhibation::class.java))
    }*/
            2 -> {
                startActivity(Intent(this, Venue::class.java))
            }
            /*6 -> {
                startActivity(Intent(this, Tour::class.java))
            }*/

            3 -> {
                var inyeny: Intent = Intent(this, Accomodation::class.java)
                inyeny.putExtra("which", "bearer")
                startActivity(inyeny)
            }
            4 -> {
                var prefs: SharedPreferences = getSharedPreferences("MY_PREFS_NAME", AppCompatActivity.MODE_PRIVATE);
                var restoredText = prefs.getString("DATA", null);
                if (!TextUtils.isEmpty(restoredText)) {
                    var intent = Intent(this, TicketDetail::class.java)
                    intent.putExtra("DATA", restoredText)
                    startActivity(intent)
                } else {
                    var intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
            }
            5 -> {
                var inyeny: Intent = Intent(this, ShowPDF::class.java)
                inyeny.putExtra("which", "")
                startActivity(inyeny)
            }
            6 -> {
                startActivity(Intent(this, Contact::class.java))
            }
            7 -> {
                startActivity(Intent(this, NotificationAPI::class.java))
            }
            8 -> {
                if (menuposition[8].equals("LOGOUT")) {
                    getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE).edit().clear().commit()
                    var intent = Intent(this, Login::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                } else {
                    var intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.drawer_click -> {
                if (drawer_layout.isDrawerOpen(Gravity.START)) {
                    drawer_layout.closeDrawer(Gravity.LEFT)
                } else {
                    drawer_layout.openDrawer(Gravity.LEFT)
                }
            }
        }
    }


    private fun blinkAnim() {
        val shake: Animation
        shake = AnimationUtils.loadAnimation(applicationContext, R.anim.shake)

        val image: ImageView
        image = findViewById<ImageView>(R.id.right_icon) as ImageView

        image.startAnimation(shake)
    }

    class Diao : DialogFragment() {

        fun getInstance(text: String): Diao {
            this.text = text
            var bundle: Bundle = Bundle()
            bundle.putString("dataT", text)
            var intent = Diao()
            intent.arguments = bundle
            return intent
        }

        var text: String? = ""
        lateinit var messge: TextView
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val v = inflater.inflate(R.layout.cust, container, false)
            messge = v.findViewById<TextView>(R.id.messge)
            var bundle = arguments

            var data: String = ""
            text = bundle?.getString("dataT")
            try {
                var json: JSONArray = JSONArray(text)
                var jsnarray: JSONObject = json.getJSONObject(0)
                var iterate = jsnarray.keys()

                while (iterate.hasNext()) {
                    var key: String = iterate.next()
                    var value: String = jsnarray.getString(key)
                    data = data + "<br>" + " <b>" + key + ": " + " </b>" + value
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            messge.setText(Html.fromHtml(data))
            return v
        }


    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(Home.newInstance(), "HOME")
//        adapter.addFrag(Invitation.newInstance(), "INVITATION")
//        adapter.addFrag(Highlight.newInstance(), "KERASIGHT")
//        adapter.addFrag(Home.newInstance(), "HIGHLIGHTS")
//        adapter.addFrag(Abstract.newInstance(), "ABSTRACT")
//        adapter.addFrag(Commitee.newInstance(), "COMMITTEE")
//        adapter.addFrag(Invitation.newInstance(), "PROGRAM")
//        adapter.addFrag(Invitation.newInstance(), "EXHIBITION")
//        adapter.addFrag(Invitation.newInstance(), "VENUE")
//        adapter.addFrag(Invitation.newInstance(), "TOURS")
//        adapter.addFrag(Invitation.newInstance(), "ACCOMMODATION")
//        adapter.addFrag(Invitation.newInstance(), "CONTACT")
        viewPager.adapter = adapter
    }

    inner class ViewPagerAdapter(var fragmnger: FragmentManager) : FragmentPagerAdapter(fragmnger) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()
        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position);
        }

    }

}
