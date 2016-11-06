package will.wonderland;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by triti on 2015-12-19.
 */
public class ScreenRiv extends BroadcastReceiver {

        private KeyguardManager km = null;
        private KeyguardManager.KeyguardLock keyLock = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                if (km == null)
                    km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

                if (keyLock == null)
                    keyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);


                disableKeyguard();

                Intent i = new Intent(context, LocjScreen.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        }

        public void reenableKeyguard() {
            keyLock.reenableKeyguard();
        }

        public void disableKeyguard() {
            keyLock.disableKeyguard();
        }
    }