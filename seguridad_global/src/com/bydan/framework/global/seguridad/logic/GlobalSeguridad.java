package com.bydan.framework.global.seguridad.logic;

import java.io.InputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bydan.framework.global.seguridad.resources.AuxiliarGlobalSeguridad;


@SuppressWarnings("unused")
public class GlobalSeguridad {
	public static Boolean ISDEVELOPING=false;
	
	//TEMPORAL(ES PARA BORRAR)
	public static Boolean validarLicenciaCliente(String sUsuarioPCServer, String sNamePCServer,	String sIPPCServer,String sMacAddressPCServer,Date dFechaServer,
			Long idUsuario,Boolean isClienteWeb,String sClaveSistema) throws Exception {
		
		Boolean validar=true;
		
		validar=GlobalSeguridad.validarLicenciaCliente(sUsuarioPCServer, sNamePCServer,	sIPPCServer,sMacAddressPCServer,dFechaServer,
				idUsuario,isClienteWeb,sClaveSistema,"TODOS","TODOS");
		
		return validar;

	}
	//TEMPORAL(ES PARA BORRAR)
	
	public static Boolean validarLicenciaCliente(String sUsuarioPCServer, String sNamePCServer,	String sIPPCServer,String sMacAddressPCServer,Date dFechaServer,
									Long idUsuario,Boolean isClienteWeb,String sClaveSistema,String sNombreModuloActual,String sNombreUsuarioActual) throws Exception {
		Boolean validar=true;
		String sMensajeExcepcion="";
		String sEncript="";
		String sNombreModuloActualEncript="";
		String sNombreUsuarioActualEncript="";
		
		sUsuarioPCServer=sUsuarioPCServer.trim();
		sNamePCServer=sNamePCServer.trim();
		sIPPCServer=sIPPCServer.trim();
		sMacAddressPCServer=sMacAddressPCServer.trim();
		sClaveSistema=sClaveSistema.trim();
		
		//System.out.println(sMacAddressPCServer);
		
		try {
			if(!isClienteWeb) {
				InputStream reportFile=null;
				
				//sNamePCServer="bydan-PC";
				
				//sNamePCServer+="123";
				
				//NOMBRE ARCHIVO SubString=20
				sEncript=SHA1Encrypte.SHA1(sNamePCServer);				   
			    sEncript=sEncript.substring(0,20);
			    
				reportFile = AuxiliarGlobalSeguridad.class.getResourceAsStream(sEncript+".xml");
				
				Document documentBuilder=GlobalSeguridad.parseXml(reportFile);
				
				
				sNombreModuloActualEncript=SHA1Encrypte.SHA1(sNombreModuloActual);
				sNombreUsuarioActualEncript=SHA1Encrypte.SHA1(sNombreUsuarioActual);
				
				//GlobalSeguridad.readXml(documentBuilder);
				
				String sUsuarioPCServerLicencia="";
				String sNamePCServerLicencia="";
				String sIPPCServerLicencia="";
				String sMacAddressPCServerLicencia="";
				ArrayList<String> arrMacAddressesLicencia=new ArrayList<String>();
				String sMacAddressServerLicencia="";
				Long idUsuarioLicencia=1L;
				Boolean isClienteWebLicencia=false;
				String sClaveSistemaLicencia="";
				Date dFechaServerLicencia=null;
				String sUsuarioLicencia="";
				ArrayList<String> arrUsuariosLicencia=new ArrayList<String>();
				ArrayList<String> arrModulosLicencia=new ArrayList<String>();
				
				String sDateFormat="yyyy-MM-dd";
				
				//MODULOS
				String sModuloLicencia="";
				//MODULOS
				
				//CARGAR ELEMENTOS DE LICENCIA
				NodeList nodeList = documentBuilder.getElementsByTagName("Licencia");
				Integer iLength=nodeList.getLength();
				Short shNodeType=0;
				
				for (int iIndice = 0; iIndice < iLength; iIndice++) {
					Node node = nodeList.item(iIndice);
					shNodeType=node.getNodeType();
					
					if (shNodeType == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						 
						sUsuarioPCServerLicencia=GlobalSeguridad.getValueElement("UsuarioPc",element);
						sNamePCServerLicencia=GlobalSeguridad.getValueElement("NombrePc",element);
						sIPPCServerLicencia=GlobalSeguridad.getValueElement("IpPc",element);
						idUsuarioLicencia=Long.parseLong(GlobalSeguridad.getValueElement("idUsuarioPrincipal",element));
						isClienteWebLicencia=Boolean.parseBoolean(GlobalSeguridad.getValueElement("EsClienteWeb",element));				
						sClaveSistemaLicencia=GlobalSeguridad.getValueElement("ClaveSistema",element);
						dFechaServerLicencia=Funciones.ConvertToDate(Funciones.getStringFecha(GlobalSeguridad.getValueElement("FechaCaduca",element),false),sDateFormat);						
						
						//MAC_ADDRESS MAS ABAJO
						/*
						sMacAddressPCServerLicencia=GlobalSeguridad.getValueElement("MacAddress",element);					
						arrMacAddressLicencia=GlobalSeguridad.getValuesString(sMacAddressPCServerLicencia);
						*/
						
						//arrMacAddressLicencia=GlobalSeguridad.getValuesElement("MacAddress","Address", element);
						
						/*
						sUsuarioPCServerLicencia=element.getElementsByTagName("UsuarioPc").item(0).getTextContent().trim();
						sNamePCServerLicencia=element.getElementsByTagName("NombrePc").item(0).getTextContent().trim();
						sIPPCServerLicencia=element.getElementsByTagName("IpPc").item(0).getTextContent().trim();
						idUsuarioLicencia=Long.parseLong(element.getElementsByTagName("idUsuarioPrincipal").item(0).getTextContent().trim());
						isClienteWebLicencia=Boolean.parseBoolean(element.getElementsByTagName("EsClienteWeb").item(0).getTextContent().trim());				
						sClaveSistemaLicencia=element.getElementsByTagName("ClaveSistema").item(0).getTextContent().trim();
						dFechaServerLicencia=Funciones.ConvertToDate(Funciones.getStringFecha(element.getElementsByTagName("FechaCaduca").item(0).getTextContent().trim(),false),sDateFormat);						
						sMacAddressPCServerLicencia=element.getElementsByTagName("MacAddress").item(0).getTextContent().trim();
						*/
						
																						
						//MAC ADDRESSES
						
						NodeList nodeListMacAddresses = element.getElementsByTagName("MacAddresses");
						Integer iLengthMacAddresses=nodeListMacAddresses.getLength();
						//Short shNodeTypeMacAddresses=0;
						
						for (int iIndiceMacAddresses = 0; iIndiceMacAddresses < iLengthMacAddresses; iIndiceMacAddresses++) {
							Node nodeMacAddresses = nodeListMacAddresses.item(iIndiceMacAddresses);
							//shNodeTypeMacAddresses=nodeMacAddresses.getNodeType();
														
							NodeList nodeListMacAddressesHijos = element.getElementsByTagName("MacAddress");														
							Short shNodeTypeMacAddressesHijos=0;
							Integer iLengthMacAddressesHijos=nodeListMacAddressesHijos.getLength();
							
							for (int iIndiceMacAddressesHijos = 0; iIndiceMacAddressesHijos < iLengthMacAddressesHijos; iIndiceMacAddressesHijos++) {
								Node nodeMacAddressesHijos = nodeListMacAddressesHijos.item(iIndiceMacAddressesHijos);
								
								shNodeTypeMacAddressesHijos=nodeMacAddressesHijos.getNodeType();
								
								if (shNodeTypeMacAddressesHijos == Node.ELEMENT_NODE) {
									Element elementMacAddressesHijos = (Element) nodeMacAddressesHijos;
									
									sMacAddressServerLicencia=elementMacAddressesHijos.getFirstChild().getNodeValue();
									
									arrMacAddressesLicencia.add(sMacAddressServerLicencia);
									//sMacAddressServerLicencia=GlobalSeguridad.getValueElement("MacAddress",elementMacAddressesHijos);
									
									//System.out.println(sMacAddressServerLicencia);
								}
								
							}
							
							//System.out.println(nodeListMacAddressesHijos.getLength());
							
							break;
						}
						
						//MAC ADDRESSES
						
						
						//MODULOS
						
						NodeList nodeListModulos = element.getElementsByTagName("Modulos");
						Integer iLengthModulos=nodeListModulos.getLength();
						//Short shNodeTypeModulos=0;
						
						for (int iIndiceModulos = 0; iIndiceModulos < iLengthModulos; iIndiceModulos++) {
							Node nodeModulos = nodeListModulos.item(iIndiceModulos);
							//shNodeTypeModulos=nodeModulos.getNodeType();
														
							NodeList nodeListModulosHijos = element.getElementsByTagName("Modulo");														
							Short shNodeTypeModulosHijos=0;
							Integer iLengthModulosHijos=nodeListModulosHijos.getLength();
							
							for (int iIndiceModulosHijos = 0; iIndiceModulosHijos < iLengthModulosHijos; iIndiceModulosHijos++) {
								Node nodeModulosHijos = nodeListModulosHijos.item(iIndiceModulosHijos);
								
								shNodeTypeModulosHijos=nodeModulosHijos.getNodeType();
								
								if (shNodeTypeModulosHijos == Node.ELEMENT_NODE) {
									Element elementModulosHijos = (Element) nodeModulosHijos;
									
									sModuloLicencia=elementModulosHijos.getFirstChild().getNodeValue();
									
									arrModulosLicencia.add(sModuloLicencia);
									//sModuloLicencia=GlobalSeguridad.getValueElement("Modulo",elementModulosHijos);
									
									//System.out.println(sModuloLicencia);
								}
								
							}
							
							//System.out.println(nodeListModulosHijos.getLength());
							
							break;
						}
						
						//MODULOS
						
						//USUARIOS
						
						NodeList nodeListUsuarios = element.getElementsByTagName("Usuarios");
						Integer iLengthUsuarios=nodeListUsuarios.getLength();
						//Short shNodeTypeUsuarios=0;
						
						for (int iIndiceUsuarios = 0; iIndiceUsuarios < iLengthUsuarios; iIndiceUsuarios++) {
							Node nodeUsuarios = nodeListUsuarios.item(iIndiceUsuarios);
							//shNodeTypeUsuarios=nodeUsuarios.getNodeType();
														
							NodeList nodeListUsuariosHijos = element.getElementsByTagName("Usuario");														
							Short shNodeTypeUsuariosHijos=0;
							Integer iLengthUsuariosHijos=nodeListUsuariosHijos.getLength();
							
							for (int iIndiceUsuariosHijos = 0; iIndiceUsuariosHijos < iLengthUsuariosHijos; iIndiceUsuariosHijos++) {
								Node nodeUsuariosHijos = nodeListUsuariosHijos.item(iIndiceUsuariosHijos);
								
								shNodeTypeUsuariosHijos=nodeUsuariosHijos.getNodeType();
								
								if (shNodeTypeUsuariosHijos == Node.ELEMENT_NODE) {
									Element elementUsuariosHijos = (Element) nodeUsuariosHijos;
									
									sUsuarioLicencia=elementUsuariosHijos.getFirstChild().getNodeValue();
									
									arrUsuariosLicencia.add(sUsuarioLicencia);
									//sUsuarioLicencia=GlobalSeguridad.getValueElement("MacAddress",elementUsuariosHijos);
																	
									if(GlobalSeguridad.ISDEVELOPING) {
										System.out.println(sUsuarioLicencia);
									}
								}
								
							}
							
							//System.out.println(nodeListUsuariosHijos.getLength());
							
							break;
						}
						
						//USUARIOS
						
						break;
					}
				}
				
				//NOMBRE XML CON NOMBRE PC CLIENTE(TALVEZ DE ARCHIVO)
				if(!sNamePCServer.equals(sNamePCServerLicencia)) {
					sMensajeExcepcion="NO COINCIDEN DATOS DE LA LICENCIA (PC)";
					validar=false;
				}
				//NOMBRE XML CON NOMBRE PC CLIENTE FIN
				
				
				//MAC_ADDRESS XML CON MAC_ADDRESS PC CLIENTE
				/*
				if(!sMacAddressPCServer.equals("")) {
					if(!GlobalSeguridad.existeTextoEnArray(sMacAddressPCServer,arrMacAddressesLicencia)) {//if(!sMacAddressPCServer.equals(sMacAddressPCServerLicencia)) {
						sMensajeExcepcion="NO COINCIDEN DATOS DE LA LICENCIA (ADDRESS)";
						validar=false;
						System.out.println(sMacAddressPCServer);
						System.out.println(sMacAddressPCServerLicencia);
					}
				}
				*/
				//MAC_ADDRESS XML CON MAC_ADDRESS PC CLIENTE FIN
				
								
				//CLAVE XML CON CLAVE PC CLIENTE(DE ARCHIVO)
				//HAY QUE HABILITAR Y CAMBIAR LOGICA
				if(false) { //!sClaveSistema.equals(sClaveSistemaLicencia)) {
					sMensajeExcepcion="NO COINCIDEN DATOS DE LA LICENCIA (KEY)";
					validar=false;
				}
				//CLAVE XML CON CLAVE PC CLIENTE FIN
				
				
				//FECHA XML CON FECHA PC CLIENTE
				if(dFechaServer.after(dFechaServerLicencia)) {
					sMensajeExcepcion="LICENCIA CADUCADA";
					validar=false;
				}
				//FECHA XML CON FECHA PC CLIENTE FIN
				
				
				//MODULO XML CON MODULO ACTUAL PC CLIENTE			
				if(!sNombreModuloActualEncript.equals("") && !sNombreModuloActual.equals("TODOS")) {
					if(!GlobalSeguridad.existeTextoEnArray(sNombreModuloActualEncript,arrModulosLicencia)) {//if(!sMacAddressPCServer.equals(sMacAddressPCServerLicencia)) {
						sMensajeExcepcion="NO COINCIDEN DATOS DE LA LICENCIA (MODULO)";
						validar=false;
						//System.out.println(sNombreModuloActualEncript);
						//System.out.println(sMacAddressPCServerLicencia);
					}
				}
				//MODULO XML CON MODULO ACTUAL PC CLIENTE
				
				//USUARIO XML CON USUARIO ACTUAL PC CLIENTE			
				if(!sNombreUsuarioActualEncript.equals("") && !sNombreUsuarioActual.equals("TODOS")) {
					if(!GlobalSeguridad.existeTextoEnArray(sNombreUsuarioActualEncript,arrUsuariosLicencia)) {//if(!sMacAddressPCServer.equals(sMacAddressPCServerLicencia)) {
						sMensajeExcepcion="NO COINCIDEN DATOS DE LA LICENCIA (USUARIO)";
						validar=false;
						//System.out.println(sNombreUsuarioActualEncript);
						//System.out.println(sMacAddressPCServerLicencia);
					}
				}
				//USUARIO XML CON USUARIO ACTUAL PC CLIENTE
			} else {
				validar=true;
			}
			
			
			if(!validar) {
				throw new Exception(sMensajeExcepcion);
			}
			
		} catch(Exception e) {
			validar=false;
			
			if(sMensajeExcepcion.equals("")) {
				sMensajeExcepcion="NO EXISTE LICENCIA O NO ESTA BIEN FORMADO";
			}
			
			throw new Exception(sMensajeExcepcion);
		}
		
		return validar;
	}
	
	private static String getValueElement(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();		
		Node node = (Node) nodes.item(0);
		
		return node.getNodeValue().trim();
	}
		
	private static ArrayList<String> getValuesString(String sValue) {
		ArrayList<String> arrLisValues=new ArrayList<String> (); 
		
		String[] arrValues=sValue.split(",");
		
		for(String sValueLocal:arrValues) {
			arrLisValues.add(sValueLocal);
		}
		
		return arrLisValues;
	}
	
	private static ArrayList<String> getValuesElement(String tagPadre,String tag, Element element) {
		NodeList nodeListPadre = element.getElementsByTagName(tagPadre).item(0).getChildNodes();	
		Node nodePadre = (Node) nodeListPadre.item(0);
		Element elementPadre =null;
		
		if (nodePadre.getNodeType() == Node.ELEMENT_NODE) {
			elementPadre = (Element) nodePadre;
		}
		
		
		NodeList nodeList = nodePadre.getChildNodes();//elementPadre.getElementsByTagName(tag);
		Node node =null;
		ArrayList<String> arrValues=new ArrayList<String> (); 
		String sValue="";
		int length=nodeList.getLength();
		
		for (int i = 0; i < length; i++) {			 
			node = nodeList.item(i);	
			
			sValue=node.getNodeValue().trim();
			
			arrValues.add(sValue);
		}
		
	
		return arrValues;
	}
	
	private static Boolean existeTextoEnArray(String sNombre, ArrayList<String> arrValues) {
		Boolean existe=false;
		
		for(String sNombreLocal:arrValues) {
			if(sNombreLocal.equals(sNombre)) {
				existe=true;
				break;
			}
		}
		
		return existe;
	}
	
	public static Document parseXml(InputStream inputStream) throws Exception {
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	
	    documentBuilderFactory.setValidating(false);
	    documentBuilderFactory.setIgnoringComments(true);
	    documentBuilderFactory.setIgnoringElementContentWhitespace(false);
	    documentBuilderFactory.setNamespaceAware(true);
	    // documentBuilderFactory.setCoalescing(true);
	    // documentBuilderFactory.setExpandEntityReferences(true);
	
	    DocumentBuilder documentBuilder = null;
	    documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    //documentBuilder.setEntityResolver(new NullResolver());
	
	    // documentBuilder.setErrorHandler( new MyErrorHandler());
	
	    return documentBuilder.parse(inputStream);
	}
	
	public static void readXml(Document documentBuilder) {
		System.out.println("Root element :" + documentBuilder.getDocumentElement().getNodeName());
		 
		NodeList nodeList = documentBuilder.getElementsByTagName("Licencia");
		
		for (int iIndice = 0; iIndice < nodeList.getLength(); iIndice++) {
			Node node = nodeList.item(iIndice);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				 
				System.out.println(element.getElementsByTagName("ClaveSistema").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("FechaCaduca").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("NombrePc").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("MacAddress").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("IpPc").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("UsuarioPc").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("idUsuarioPrincipal").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("EsClienteWeb").item(0).getTextContent());
			}
		}
	}
}
