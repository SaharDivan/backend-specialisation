package at.nacs.passwordverifier.ui;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class VerifierUserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public String askForPassWord() {
        printOutUserMessageForPassword();
        return scanner.next();
    }


    public void issuePassWordValidityMessage(Boolean confirmation) {
        if (confirmation) {
            System.out.println("Password Accepted!");
        } else {
            System.out.println("Password is not accepted! Either invalid measure or not safe enough.");
        }
    }


    private void printOutUserMessageForPassword() {
        System.out.println(
                "\b\b ----Please inter you password which has following safety requirements:\b\b" +

                        "\b - It Must construct of at Least 1 character lowercase," +
                        "\b - It should construct of at Least 8 characters," +
                        "\b - It should construct of at Least 1 character uppercase," +
                        "\b - It should construct of at Least 1 characters as digit: "
        );
    }

}
