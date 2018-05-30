package org.smartregister.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {

    public static final int CAMERA_PERMISSION_REQUEST_CODE = 15141;
    public static final int PHONE_STATE_PERMISSION_REQUEST_CODE = 15142;
    public static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 15143;
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 15144;
    public static final int ACCESS_FINE_LOCATION_REQUEST_CODE = 15145;


    public static boolean isPermissionGranted(Activity context, String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{permission}, requestCode);
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPermissionGranted(Activity context, String[] permissions, int requestCode) {
        if (permissions == null || permissions.length == 0) {
            return false;
        }

        List<String> notGranted = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                notGranted.add(permission);
            }
        }

        if (notGranted.isEmpty()) {
            return true;
        }

        ActivityCompat.requestPermissions(context, notGranted.toArray(new String[notGranted.size()]), requestCode);
        return false;

    }
}
