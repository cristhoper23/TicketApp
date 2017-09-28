package com.cristhoper.ticket_app.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cristhoper.ticket_app.R;

public class UserActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Botón action bar drawer con efecto material
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()) {
                    case R.id.nav_registrar:
                        Toast.makeText(UserActivity.this, "Registrar ticket...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultar:
                        Toast.makeText(UserActivity.this, "Consultar ticket...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignar:
                        Toast.makeText(UserActivity.this, "Asignar ticket...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_reporte:
                        Toast.makeText(UserActivity.this, "Reporte de tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_atender:
                        Toast.makeText(UserActivity.this, "Atender ticket...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(UserActivity.this, "Perfil...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(UserActivity.this, "Configuración...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(UserActivity.this, MainActivity.class));
                        finish();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        // Change navigation header information

        if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            String rol = this.getIntent().getExtras().getString("rol");

            switch (rol){
                case "Cliente" :
                    rolInterface(navigationView, rol, "Roy Anderson", "roy.anderson@gmail.com", true, true, false, false, false);
                    break;
                case "Supervisor" :
                    rolInterface(navigationView, rol, "Stan Leabreu", "stan.leabreu@gmail.com", false, true, true, true, false);
                    break;
                case "Técnico" :
                    rolInterface(navigationView, rol, "Johnny Cage", "johnny.cage@gmail.com", false, true, false, false, true);
                    break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void rolInterface(NavigationView navView, String rol, String nombre, String correo, boolean a, boolean b, boolean c, boolean d, boolean e){
        ImageView photoImage = (ImageView) navView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(rol + ": " + nombre);

        TextView emailText = (TextView) navView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText(correo);

        navView.getMenu().findItem(R.id.nav_registrar).setVisible(a);
        navView.getMenu().findItem(R.id.nav_consultar).setVisible(b);
        navView.getMenu().findItem(R.id.nav_asignar).setVisible(c);
        navView.getMenu().findItem(R.id.nav_reporte).setVisible(d);
        navView.getMenu().findItem(R.id.nav_atender).setVisible(e);
    }
}
