/**
 *  @package VentanasLogin
 */
package com.SPQ.ventanasLogin;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Font;

public class VentanaPrivacidad extends JFrame{
	public VentanaPrivacidad() {
		getContentPane().setLayout(null);
		
		JTextPane txtpnPolticaDePrivacidad = new JTextPane();
		txtpnPolticaDePrivacidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnPolticaDePrivacidad.setText("Política de privacidad y aviso legal\r\nPolítica de privacidad\r\nA través de este sitio web no se recaban datos de carácter personal de las personas usuarias sin su conocimiento, ni se ceden a terceros.\r\n\r\nCon la finalidad de ofrecerle el mejor servicio y con el objeto de facilitar el uso, se analizan el número de páginas visitadas, el número de visitas, así como la actividad de las persona visitantes y su frecuencia de utilización. A estos efectos, Spq-Project (Spq-P) utiliza la información estadística elaborada por el Proveedor de Servicios de Internet.\r\n\r\nSpq-P no utiliza cookies para recoger información de las personas usuarias, ni registra las direcciones IP de acceso. Únicamente se utilizan cookies propias,  de sesión, con finalidad técnica (aquellas que permiten la navegación a través del sitio web y la utilización de las diferentes opciones y servicios que en ella existen).\r\n\r\nEl portal del que es titular la Spq-P contiene enlaces a sitios web de terceros, cuyas políticas de privacidad son ajenas a la de la Spq-P. Al acceder a tales sitios web usted puede decidir si acepta sus políticas de privacidad y de cookies. Con carácter general, si navega por internet usted puede aceptar o rechazar las cookies de terceros desde las opciones de configuración de su navegador.\r\n\r\nInformación básica sobre protección de datos\r\n\r\nA continuación le informamos sobre la política de protección de datos de Spq-Project.\r\n\r\nResponsable del tratamiento\r\n\r\nLos datos de carácter personal que se pudieran recabar directamente de la persona interesada serán tratados de forma confidencial y quedarán incorporados a la correspondiente actividad de tratamiento titularidad de  Spq-Project (Spq-P).\r\n\r\nLa relación actualizada de las actividades de tratamiento que la Spq-P lleva a cabo se encuentra disponible en el siguiente enlace al registro de actividades de la Spq-P.\r\n\r\nFinalidad\r\n\r\nLa finalidad del tratamiento de los datos corresponde a cada una de las actividades de tratamiento que realiza la Spq-P y que están accesibles en el registro de actividades de tratamiento.\r\n\r\nLegitimación\r\n\r\nEl tratamiento de sus datos se realiza para el cumplimiento de obligaciones legales por parte de la Spq-P, para el cumplimiento de misiones realizada en interés público o en el ejercicio de poderes públicos conferidos a la Spq-P, así como cuando la finalidad del tratamiento requiera su consentimiento, que habrá de ser prestado mediante una clara acción afirmativa.\r\n\r\nPuede consultar la base legal para cada una de las actividades de tratamiento que lleva a cabo la Spq-P en  el siguiente enlace al registro de actividades de la Spq-P.\r\n\r\nConservación de datos\r\n\r\nLos datos personales proporcionados se conservarán durante el tiempo necesario para cumplir con la finalidad para la que se recaban y para determinar las posibles responsabilidades que se pudieran derivar de la finalidad, además de los períodos establecidos en la normativa de archivos y documentación.\r\n\r\nComunicación de datos\r\n\r\nCon carácter general no se comunicarán los datos personales a terceros, salvo obligación legal, entre las que pueden estar las comunicaciones al Defensor del Pueblo, Jueces y Tribunales, personas interesadas en los procedimientos relacionados con la reclamaciones presentadas.\r\n\r\nPuede consultar los destinatarios para cada una de las actividades de tratamiento que lleva a cabo la Spq-P en el siguiente  enlace al registro de actividades de la Spq-P.\r\n\r\nDerechos de las personas interesadas\r\n\r\nCualquier persona tiene derecho a obtener confirmación sobre los tratamientos que de sus datos que se llevan a cabo por la Spq-P.\r\n\r\nPuede ejercer sus derechos de acceso, rectificación, supresión y portabilidad de sus datos, de limitación y oposición a su tratamiento, así como a no ser objeto de decisiones basadas únicamente en el tratamiento automatizado de sus datos, cuando procedan, anteSpq-Project, C/Simon Bolivar,17, 48004- Bilbao o en la dirección de correo electrónico spq@gmail.com");
		txtpnPolticaDePrivacidad.setBounds(23, 11, 873, 599);
		getContentPane().add(txtpnPolticaDePrivacidad);
		
		this.setVisible(true);
		this.dispose();
	}
}
