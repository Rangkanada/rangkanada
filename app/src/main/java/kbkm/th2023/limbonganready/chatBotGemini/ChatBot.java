package kbkm.th2023.limbonganready.chatBotGemini;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import kbkm.th2023.limbonganready.R;

public class ChatBot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_bot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextInputEditText queryEditText = findViewById(R.id.queryEditText);
        Button sendQueryButton = findViewById(R.id.sendPromptButton);
        TextView responseTextView = findViewById(R.id.modelResponseTextView);
        ProgressBar progressBar = findViewById(R.id.sendPromptProgressBar);

//        sendQueryButton.setOnClickListener(v -> {
//            GeminiPro model = new GeminiPro();
//
//            String query = queryEditText.getText().toString();
//            progressBar.setVisibility(View.VISIBLE);
//
//            responseTextView.setText("");
//            queryEditText.setText("");
//
//            model.getResponse(query, new ResponseCallback() {
//                @Override
//                public void onResponse(String response) {
//                    responseTextView.setText(response);
//                    progressBar.setVisibility(View.GONE);
//                }
//
//                @Override
//                public void onEror(Throwable throwable) {
//                    Toast.makeText(ChatBot.this,"Eror: "+ throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                    progressBar.setVisibility(View.GONE);
//                }
//            });
//        });
    }
    public void Finish(View view) {
        onBackPressed();
    }
}