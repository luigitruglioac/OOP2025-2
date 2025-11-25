package secretsanta;

public class Message {
    private String text;
    private String senderMail;
    private boolean anonymous;

    public Message(String text, String emailSender, boolean anonymous){
        this.text = text;
        this.senderMail = senderMail;
        this.anonymous = anonymous;

    }
    public Message(){
        this("","",false);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setEmailSender(String senderMail) {
        this.senderMail = senderMail;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }



}