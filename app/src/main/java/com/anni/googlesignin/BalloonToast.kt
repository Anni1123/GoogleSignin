package com.anni.googlesignin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import it.beppi.balloonpopuplibrary.BalloonPopup
import kotlinx.android.synthetic.main.activity_balloon_toast.*

class BalloonToast : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balloon_toast)
        val bp= BalloonPopup.Builder(applicationContext, findViewById(R.id.samplegeeks))
            .text("Showing Balloon Toast")               // set the text displayed (String or resource)
            .timeToLive(5000)           // Millseconds before closing the popup. 0 = persistent
            .animation(BalloonPopup.BalloonAnimation.fade_and_scale)    // animation style used. Available:
            // pop, scale, fade, fade75
            // and all the possible combinations.
            // When fade75 is used (up to alpha .75) the view is slightly transparent
            .shape(BalloonPopup.BalloonShape.rounded_square)      // Circle (oval) or rounded square
            .bgColor(Color.CYAN)        // unused yet
            .fgColor(Color.RED)         // text color
            .textSize(20)                // text size
            .offsetX(10)                // offsets to move the position accordingly
            .offsetY(15)
            .positionOffset(510, 815)
            .drawable(R.drawable.bg_circle) // custom background drawable
            .show();
    }
}
