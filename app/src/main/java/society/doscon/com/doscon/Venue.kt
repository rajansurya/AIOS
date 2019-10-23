package society.doscon.com.doscon

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.webkit.WebView
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.header_other.*


/**
 * Created by RDX on 02-10-2018.
 */
class Venue : FragmentActivity(), OnMapReadyCallback {
    private val LOCATION_REQUEST_CODE = 101

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map


      /*  if (map != null) {
            val permission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)

            if (permission == PackageManager.PERMISSION_GRANTED) {
                map?.isMyLocationEnabled = true
            } else {
                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE)
            }
        }*/

         val sydney = LatLng(26.664924, 80.8031743)
 //        map?.setMyLocationEnabled(true)
         map?.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
         map?.addMarker(MarkerOptions().title("Meridien Commercial Tower").position(sydney))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Unable to show location - permission required", Toast.LENGTH_LONG).show()
                }else{
//                    val mapFragment = supportFragmentManager.findFragmentById(R.id.googleMap) as SupportMapFragment
//                    mapFragment.getMapAsync(this)
                }
            }
        }
    }

    lateinit var webpagesLinear: WebView
    var mapFragment: SupportMapFragment? = null
    var googleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.venue)
        webpagesLinear = findViewById(R.id.venue)
        mapFragment = supportFragmentManager.findFragmentById(R.id.googleMap) as SupportMapFragment?
        mapFragment?.getMapAsync(this);
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webpagesLinear.loadData(resources.getString(R.string.venue), "text/html; charset=utf-8", "utf-8");
        title_name.text = "VENUE"
        back.setOnClickListener { this@Venue.finish() }
//        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE)
    }
    private fun requestPermission(permissionType: String, requestCode: Int){
        ActivityCompat.requestPermissions(this, arrayOf(permissionType),requestCode)
    }
}