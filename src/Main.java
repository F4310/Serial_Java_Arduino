import jssc.SerialPort;
import jssc.SerialPortException;

public class Main {

	public static void main(String[] args) {
		SerialPort serialPort = new SerialPort("COM3");
		try {
			// Open serial port
			serialPort.openPort();

			// Set params.
			serialPort.setParams(9600, 8, 1, 0);
				
				int closePort = 1;
				while(closePort <= 10){
			
				String buffer = serialPort.readString(11);
			
				System.out.println(buffer + " - "+ closePort);
				
				closePort = closePort+1;
				
				}
				
				serialPort.closePort();//Close serial port

			
		} catch (SerialPortException ex) {
			System.out.println(ex + "Erro");
		}
	}
}