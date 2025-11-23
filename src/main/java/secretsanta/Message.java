package secretsanta;

public class Message {
    private String text;
    private String emailSender;
    private boolean anonymous;

    public Message(String text, String emailSender, boolean anonymous){
        this.text = text;
        this.emailSender = emailSender;
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

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }



}