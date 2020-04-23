
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


public class Main {

	
	static SerialPort serialPort = new SerialPort("COM5");

	public static void main(String[] args) {
		try {
			
			// Open serial port
			serialPort.openPort();
			// Set params.
			serialPort.setParams(9600, 8, 1, 0);
			int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;
			serialPort.setEventsMask(mask);
			serialPort.addEventListener(new SerialPortReader());

			
		} catch (SerialPortException ex) {
			System.out.println(ex + "Erro");
		}
	}
	
	
	static class SerialPortReader implements SerialPortEventListener{

		@Override
		public void serialEvent(SerialPortEvent event) {
			// TODO Auto-generated method stub
			
		if(event.isRXCHAR() == true){
			
				try {
					
					System.out.print(serialPort.readString());
					
				} catch (SerialPortException e) {
					e.printStackTrace();
				}
		}
	
			
			}
			
		}
		
	}
	

/* codigo Simples antigo
public class Main {

	public static void main(String[] args) {
		SerialPort serialPort = new SerialPort("COM5");
		try {
			// Open serial port
			serialPort.openPort();

			// Set params.
			serialPort.setParams(9600, 8, 1, 0);
			
				int closePort = 1;
				while(closePort <= 10){
			
				String buffer = serialPort.readString(122);
			
				System.out.println(buffer);
				
				closePort = closePort+1;
				
				}
				
				serialPort.closePort();//Close serial port

			
		} catch (SerialPortException ex) {
			System.out.println(ex + "Erro");
		}
	}
}

*/

