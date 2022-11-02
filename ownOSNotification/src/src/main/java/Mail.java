import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;

public class Mail {
	private String date;
	private String time;
	private String subject;
	//private String content;
	private final String senderAddress = ""; //set here the senderAddress as desired
	private final String recipientAddress = ""; //set here the recipientAddress as desired


	public Mail(DateContent dateContent, TimeContent timeContent, SubjectContent subjectContent){
		this.date = dateContent.getDay()+dateContent.getMonth()+dateContent.getYear();
		this.time = timeContent.getTime();
		this.subject = subjectContent.getSubjectName();
		generateContent();

	}
	private void generateContent(){
		MailMessage message = new MailMessage();

		// Set subject of the message, body and sender information
		message.setSubject(this.subject);
		message.setBody("This is the body of the email.\n" +
				date + "\n"+
				time + "\n");
		message.setFrom(new MailAddress(senderAddress, "Sender 1", false));

		// Add To recipients and CC recipients
		message.getTo().addItem(new MailAddress(recipientAddress, "Recipient 1", false));

		createSmtpClient(message);

	}

	private void createSmtpClient(MailMessage message){
		// Create an instance of SmtpClient Class
		SmtpClient client = new SmtpClient();

		// Specify your mailing host server, Username, Password, Port
		client.setHost("outlook.office365.com");
		client.setUsername("");//set here your own Mail-Adress
		client.setPassword("");//set here your own Mail-Login password
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
    /*public static void main(String[] args) {
        MailMessage message = new MailMessage();

// Set subject of the message, body and sender information
        message.setSubject("New message created by Aspose.Email for .NET");
        message.setBody("This is the body of the email.");
        message.setFrom(new MailAddress("", "", false));

// Add To recipients and CC recipients
        message.getTo().addItem(new MailAddress("", "Recipient 1", false));
        //message.getCC().addItem(new MailAddress("cc1@domain.com", "Recipient 3", false));

// Add attachments
        //message.getAttachments().addItem(new Attachment("word.docx"));

// Save message in EML, EMLX, MSG and MHTML formats
      *//*  message.save("EmailMessage.eml", SaveOptions.getDefaultEml());
        message.save("EmailMessage.emlx", SaveOptions.createSaveOptions(MailMessageSaveType.getEmlxFormat()));
        message.save("EmailMessage.msg", SaveOptions.getDefaultMsgUnicode());
        message.save("EmailMessage.mhtml", SaveOptions.getDefaultMhtml());*//*



        // Create an instance of SmtpClient Class
        SmtpClient client = new SmtpClient();

// Specify your mailing host server, Username, Password, Port
	    client.setUsername("");
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
	    }client.setHost("outlook.office365.com");

    }*/

}

