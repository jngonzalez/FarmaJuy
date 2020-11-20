package com.example.farmajuy;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    private TextInputLayout tilNombre;
    private TextInputLayout tilTelefono;
    private TextInputLayout tilCorreo;
    private TextInputLayout tilContraseña;
    private EditText campoNombre;
    private EditText campoTelefono;
    private EditText campoCorreo;
    private EditText campoContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Referencias TILs
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_telefono);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        tilContraseña = (TextInputLayout) findViewById(R.id.til_contraseña);

        // Referencias ETs
        campoNombre = (EditText) findViewById(R.id.campo_nombre);
        campoTelefono = (EditText) findViewById(R.id.campo_telefono);
        campoCorreo = (EditText) findViewById(R.id.campo_correo);
        campoContraseña = (EditText) findViewById(R.id.campo_contraseña);

        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        campoTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilTelefono.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        campoCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                esCorreoValido(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        campoContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilContraseña.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.boton_aceptar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });

    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            tilNombre.setError("Nombre inválido");
            return false;
        } else {
            tilNombre.setError(null);
        }

        return true;
    }

    private boolean esTelefonoValido(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches()) {
            tilTelefono.setError("Teléfono inválido");
            return false;
        } else {
            tilTelefono.setError(null);
        }

        return true;
    }

    private boolean esCorreoValido(String correo) {
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            tilCorreo.setError("Correo electrónico inválido");
            return false;
        } else {
            tilCorreo.setError(null);
        }

        return true;
    }

    private boolean esContraValido(String contra) {
        if (contra.length() < 5) {
            tilNombre.setError("Contraseña muy corta. Debe superar los 4 caracteres.");
            return false;
        } else {
            tilNombre.setError(null);
        }

        return true;
    }

    private void validarDatos() {
        String nombre = tilNombre.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();
        String correo = tilCorreo.getEditText().getText().toString();
        String contraseña = tilContraseña.getEditText().getText().toString();

        boolean a = esNombreValido(nombre);
        boolean b = esTelefonoValido(telefono);
        boolean c = esCorreoValido(correo);
        boolean d = esContraValido(contraseña);

        if (a && b && c && d) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show();
        }

    }
}