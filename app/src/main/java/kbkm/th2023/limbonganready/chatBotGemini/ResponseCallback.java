package kbkm.th2023.limbonganready.chatBotGemini;

public interface ResponseCallback {
    void  onResponse(String response);
    void onEror(Throwable throwable);
}
