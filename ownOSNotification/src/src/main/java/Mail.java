import com.aspose.email.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.GregorianCalendar;

public class Mail {
	private final String date;
	private final String time;
	private final String subject;
	private final String senderAddress = ""; //set here the senderAddress as desired
	private final String recipientAddress = ""; //set here the recipientAddress as desired
	private final String body;


	public Mail(DateContent dateContent, TimeContent timeContent, SubjectContent subjectContent, BodyContent bodyContent) {
		this.date = dateContent.getDay() + dateContent.getMonth() + dateContent.getYear();
		this.time = timeContent.getTime();
		this.subject = subjectContent.getSubjectName();
		this.body = bodyContent.getBodyContent();

	}

	private Appointment generateAppointmentForCalendarEvent() {

		// Set up appointment
		MailAddressCollection attendees = new MailAddressCollection();
		attendees.add("yourMailAdress");
		//your second(any adress) mail adress is needed to create an appointment, even though it won't be used:
		attendees.add("yourSecondMailAdress");


		Appointment appointment = new Appointment("Location", // location of meeting
				new GregorianCalendar(Integer.parseInt(this.date.substring(6, 10)), Integer.parseInt(this.date.substring(3, 5)) - 1, Integer.parseInt(this.date.substring(0, 2)), Integer.parseInt(this.time.substring(0, 2)) - 1, Integer.parseInt(this.time.substring(3, 5))).getTime(),// start date
				new GregorianCalendar(Integer.parseInt(this.date.substring(6, 10)), Integer.parseInt(this.date.substring(3, 5)) - 1, Integer.parseInt(this.date.substring(0, 2)), Integer.parseInt(this.time.substring(0, 2)), Integer.parseInt(this.time.substring(3, 5))).getTime(), // end date
				new MailAddress("yourMailAdress"), // organizer
				attendees); // attendees

		//set subject of appointment
		appointment.setSummary(this.subject);
		//set reminder of appointment to one day before the appointment
		AppointmentReminder appointmentReminder = new AppointmentReminder();
		appointmentReminder.setTrigger(new ReminderTrigger(new GregorianCalendar(Integer.parseInt(this.date.substring(6, 10)), Integer.parseInt(this.date.substring(3, 5)) - 1, Integer.parseInt(this.date.substring(0, 2)) - 1, Integer.parseInt(this.time.substring(0, 2)) - 1, Integer.parseInt(this.time.substring(3, 5))).getTime()));
		appointment.getReminders().add(appointmentReminder);

		return appointment;
	}

	private void generateMailContentForAppointment() {
		MailMessage message = new MailMessage();
		Appointment appointment;

		// Set subject of the message, body and sender information
		message.setSubject(this.subject);
		message.setBody(body + "\n\n" + "Datum: " + date + "\n" + "Uhrzeit: " + time + "\n");
		message.setFrom(new MailAddress(senderAddress, "Sender 1", false));

		// Add To recipients and CC recipients
		message.getTo().addItem(new MailAddress(recipientAddress, "Recipient 1", false));

		appointment = generateAppointmentForCalendarEvent();


		// Add meeting request to the message
		message.addAlternateView(appointment.requestApointment());

		createSmtpClient(message);
	}

	private void createSmtpClient(MailMessage message) {
		// Create an instance of SmtpClient Class
		SmtpClient client = new SmtpClient();

		// Specify your mailing host server, Username, Password, Port
		client.setHost("outlook.office365.com");
		client.setUsername("");//set here your own Mail-Adress
		client.setPassword("");//set here your own Mail-Login password
		client.setPort(587);

		try {
			// Client.Send will send this message
			client.send(message);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		Mail mail = new Mail(new DateContent(new Validator(), new Date()), new TimeContent(new Validator(), new Time()), new SubjectContent(new Subject()), new BodyContent(new Body()));
		mail.generateMailContentForAppointment();
		mail.generateAppointmentForCalendarEvent();
	}
}

