package com.monteoliva.webteste;

// imports da API do ANDROID
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

/**
 * Classe Util para abertura de WebView
 *
 */
public class WebUtil extends LinearLayout {
    private WebView webView;
    private Progress progresso;

    /**
     * Constructor
     */
    public WebUtil(Context context)                     { super(context);        init(context); }
    public WebUtil(Context context, AttributeSet attrs) { super(context, attrs); init(context); }

    /**
     * Inicializa a leitura da WebView
     *
     * @param context
     */
    public void init(Context context) {

        // pega o inflater
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // pega a View
        final View view = inflater.inflate(R.layout.webutil, this);

        // pega o Progresso
        progresso = view.findViewById(R.id.progresso);
        progresso.hide();

        // seta o Parametro
        webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebClient());
    }

    /**
     * Metodo que carrega uma página da em uma WebView
     * @param url
     */
    public void load(String url) {
        if (webView != null) {
            // inicia o progresso
            progresso.show();

            // carrega a pagina
            webView.loadUrl(url);
        }
    }

    /**
     * Metodo Back
     */
    public void back() { if (webView != null) { if (webView.canGoBack()) { progresso.show(); webView.goBack(); }}}

    /**
     * MetodoNext
     */
    public void next(){ if (webView != null) { if (webView.canGoForward()) { progresso.show(); webView.goForward(); }}}

    /**
     * Classe private de Listener da WebView
     */
    private class WebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            // dismiss
            progresso.hide();
        }
    }
}