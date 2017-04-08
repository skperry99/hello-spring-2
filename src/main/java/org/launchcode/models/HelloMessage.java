package org.launchcode.models;

/**
 * Created by Sarah on 4/8/2017.
 */
public class HelloMessage {

    public static String createMessage (String name, String language){
        String salutation;

        switch (language) {
            case "En":
                salutation = "Hello, ";
                break;
            case "Sp":
                salutation = "Hola, ";
                break;
            case "Ma":
                salutation = "Ni hau, ";
                break;
            case "Ar":
                salutation = "Marhaba, ";
                break;
            case "Sw":
                salutation = "Jambo, ";
                break;
            default:
                salutation = "Hi, ";
        }

        return salutation + name + "!";
    }
}
