package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.commitee.*
import kotlinx.android.synthetic.main.header_other.*

class Commitee : Activity() {
    lateinit var fiilliste: Array<String>
    internal lateinit var home_adapter: Home_Adapter

    companion object {
        fun newInstance(): Commitee {
            return Commitee()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.commitee)
        title_name.text="FACULTY"
        back.setOnClickListener { this@Commitee.finish() }
        val displayMetrics = DisplayMetrics()
        windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
//        fiilliste = getResources().getStringArray(R.array.img_arr_commiti)
        home_adapter = Home_Adapter(applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height, "commity")
        gridview_cyc?.layoutManager = CustomGridLayoutManager(this, 2)
        gridview_cyc?.addItemDecoration(SpacesItemDecoration(1))
        gridview_cyc?.setAdapter(home_adapter)

//        fiilliste = getResources().getStringArray(R.array.img_arr_member);
//        home_adapter = Home_Adapter(applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height, "member")
//
//        gridview_cyc_member?.layoutManager = CustomGridLayoutManager(this, 2)
//        gridview_cyc_member?.addItemDecoration(SpacesItemDecoration(1))
//        gridview_cyc_member?.setAdapter(home_adapter)
//
//
//        fiilliste = getResources().getStringArray(R.array.img_arr_represtative);
//        home_adapter = Home_Adapter(applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height, "representative")

//        gridview_cyc_representive?.layoutManager = CustomGridLayoutManager(this, 2)
//        gridview_cyc_representive?.addItemDecoration(SpacesItemDecoration(1))
//        gridview_cyc_representive?.setAdapter(home_adapter)
//
//        fiilliste = getResources().getStringArray(R.array.img_arr_exofficer);
//        home_adapter = Home_Adapter(applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height, "exmember")
//
//        gridview_cyc_exofficer?.layoutManager = CustomGridLayoutManager(this, 2)
//        gridview_cyc_exofficer?.addItemDecoration(SpacesItemDecoration(1))
//        gridview_cyc_exofficer?.setAdapter(home_adapter)


    }



}