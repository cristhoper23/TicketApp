package com.cristhoper.ticket_app.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.cristhoper.ticket_app.R;

public class UserActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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

        if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            String rol = this.getIntent().getExtras().getString("rol");

            switch (rol){
                case "Cliente" :
                    navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_consultar).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_reporte).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_atender).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_settings).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                    break;
                case "Supervisor" :
                    navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_consultar).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_reporte).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_atender).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_settings).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                    break;
                case "Técnico" :
                    navigationView.getMenu().findItem(R.id.nav_registrar).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_consultar).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_asignar).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_reporte).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_atender).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_settings).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
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

}
