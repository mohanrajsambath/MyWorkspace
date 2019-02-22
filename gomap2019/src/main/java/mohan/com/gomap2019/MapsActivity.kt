package mohan.com.gomap2019

import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener  {
    val mRefernce:String="https://www.raywenderlich.com/230-introduction-to-google-maps-api-for-android-with-kotlin"
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var mMap: GoogleMap
    //private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    //private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        setUpMap()
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        setUpMap()


        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val newyork = LatLng(40.73, -73.99)  // this is New York
        val tidelPark = LatLng(11.032498, 77.018223)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.addMarker(MarkerOptions().position(newyork).title("My Favorite City"))
        mMap.addMarker(MarkerOptions().position(tidelPark).title("Marker in TidelPark Coimbatore"))
        placeMarkerOnMap(tidelPark)

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(tidelPark))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newyork, 12.0f))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tidelPark, 12f))

    }


    override fun onMarkerClick(p0: Marker?) = false
    /*override fun onMarkerClick(p0: Marker?): Boolean {}*/

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
    }

    private fun placeMarkerOnMap(location: LatLng) {
        // 1
        val markerOptions = MarkerOptions().position(location)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        // 2
        mMap.addMarker(markerOptions)
    }
}
