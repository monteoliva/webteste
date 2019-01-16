package com.monteoliva.webteste;

// imports da API do ANDROID
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Classe de Progresso extende de LinearLayout
 *
 */
public class Progress extends LinearLayout {
	private TextView texto;

	/**
	 * Constructor
	 */
	public Progress(final Context context)                     { super(context);       init(context); }
	public Progress(final Context context, AttributeSet attrs) { super(context,attrs); init(context); }

	/**
	 * Metodo de inicializacao
	 * 
	 * @param context
	 */
	private void init(Context context) {
		// seta o Background
		setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));

		// pega o inflater
		final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// pega a View
		inflater.inflate(R.layout.progress, this);
	}

	/**
	 * Metodos para mostrar/inibir o Progresso
	 */
	public void hide() { setVisibility(View.INVISIBLE); }
	public void show() { setVisibility(View.VISIBLE);   }
}