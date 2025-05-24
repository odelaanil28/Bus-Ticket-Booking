package com.airlines;

		import javax.swing.*;
		import java.awt.*;
		import java.awt.event.*;
		import java.io.FileWriter;
		import java.io.IOException;
		public class AirlineReservation {

			public static void main(String[] args) {
				
		        JFrame frame = new JFrame("Airline Reservation System");
		        frame.setSize(400, 400);
		        frame.setLayout(new GridLayout(7, 2, 10, 10));
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        JLabel nameLabel = new JLabel("Passenger Name:");
		        JTextField nameField = new JTextField();

		        JLabel fromLabel = new JLabel("From:");
		        JTextField fromField = new JTextField();

		        JLabel toLabel = new JLabel("To:");
		        JTextField toField = new JTextField();

		        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
		        JTextField dateField = new JTextField();

		        JButton bookButton = new JButton("Book Flight");
		        JTextArea resultArea = new JTextArea();
		        resultArea.setEditable(false);
		        resultArea.setLineWrap(true);

		        frame.add(nameLabel); frame.add(nameField);
		        frame.add(fromLabel); frame.add(fromField);
		        frame.add(toLabel); frame.add(toField);
		        frame.add(dateLabel); frame.add(dateField);
		        frame.add(bookButton); frame.add(new JLabel()); // Empty cell
		        frame.add(new JLabel("Confirmation:"));
		        frame.add(resultArea);

		        bookButton.addActionListener(e -> {
		            String name = nameField.getText();
		            String from = fromField.getText();
		            String to = toField.getText();
		            String date = dateField.getText();

		            if (name.isEmpty() || from.isEmpty() || to.isEmpty() || date.isEmpty()) {
		                resultArea.setText("All fields are required.");
		            } else {
		                String confirmation = "Flight booked for    " + name +
		                        " from " + from + " to " + to + " on " + date + ".";
		                resultArea.setText(confirmation);

		                // Optional: Save to a file
		                try (FileWriter writer = new FileWriter("bookings.txt", true)) {
		                    writer.write(name + "," + from + "," + to + "," + date + "\n");
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        });

		        frame.setVisible(true);

	}

}
