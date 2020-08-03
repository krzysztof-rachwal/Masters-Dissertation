package ebe.Classes;

public class Email {
    private String name;
    private String email;
    private String postcode;
    private String subject;
    private String message;

//    public Email(String name, String email, String postcode, String subject, String message){
//        this.name = name;
//        this.email = email;
//        this.postcode = postcode;
//        this.subject = message;
//    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPostcode(){
        return postcode;
    }

    public void setPostcode(String postcode){
        this.postcode = postcode;
    }

    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

}
