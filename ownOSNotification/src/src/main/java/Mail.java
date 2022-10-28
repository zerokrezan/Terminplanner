import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

public class Mail {
    public static void main(String[] args) {
        MailMessage message = new MailMessage();

// Set subject of the message, body and sender information
        message.setSubject("New message created by Aspose.Email for .NET");
        message.setBody("This is the body of the email.");
        message.setFrom(new MailAddress("zerokrezan@hotmail.de", "Rezan Hüseyin Yilmaz", false));

// Add To recipients and CC recipients
        message.getTo().addItem(new MailAddress("zerokrezan@hotmail.de", "Recipient 1", false));
        //message.getCC().addItem(new MailAddress("cc1@domain.com", "Recipient 3", false));

// Add attachments
        //message.getAttachments().addItem(new Attachment("word.docx"));

// Save message in EML, EMLX, MSG and MHTML formats
      /*  message.save("EmailMessage.eml", SaveOptions.getDefaultEml());
        message.save("EmailMessage.emlx", SaveOptions.createSaveOptions(MailMessageSaveType.getEmlxFormat()));
        message.save("EmailMessage.msg", SaveOptions.getDefaultMsgUnicode());
        message.save("EmailMessage.mhtml", SaveOptions.getDefaultMhtml());*/



        // Create an instance of SmtpClient Class
        SmtpClient client = new SmtpClient();

// Specify your mailing host server, Username, Password, Port
        client.setHost("outlook.office365.com");
        client.setUsername("zerokrezan@hotmail.de");
        client.setPassword("");
        client.setPort(587);

        try
        {
            // Client.Send will send this message
            client.send(message);
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

