package android.alberto.app.lipangomovil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by AlBeRtO on 28/04/2017.
 */

public class Administracion_sesion_turnos {

    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Sesion_turnos";

    // All Shared Preferences Keys
    private static final String GUARDAR_TURNO = "Guardar_turno";

    // User name (make variable public to access from outside)
    public static final String KEY_HORA_INICIO = "hora_inicio";

    public static final String KEY_HORA_FIN = "hora_fin";

    public Administracion_sesion_turnos(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void createLoginSession(String hora_inicio, String hora_fin){
        // Storing login value as TRUE
        editor.putBoolean(GUARDAR_TURNO, true);

        // Storing name in pref
        editor.putString(KEY_HORA_INICIO, hora_inicio);

        // Storing email in pref
        editor.putString(KEY_HORA_FIN, hora_fin);

        // commit changes
        editor.commit();
    }

    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Iniciar_Turno.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }


    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> turno = new HashMap<String, String>();
        // user name
        turno.put(KEY_HORA_INICIO, pref.getString(KEY_HORA_INICIO, null));

        // user email id
        turno.put(KEY_HORA_FIN, pref.getString(KEY_HORA_FIN, null));

        // return user
        return turno;
    }

    /**
     * Clear session details
     * */
    public void logoutTurno(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Produccion.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(GUARDAR_TURNO, false);
    }
}
