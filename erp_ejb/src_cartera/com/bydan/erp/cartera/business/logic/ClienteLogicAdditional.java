













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.util.ClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.cartera.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ClienteLogicAdditional extends ClienteLogic { // implements ClienteAdditionable{
	
	public  ClienteLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			ClienteLogic clienteLogic=(ClienteLogic)generalEntityLogic;
			ClienteParameterReturnGeneral clienteReturnGeneral=(ClienteParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroCarteraDefecto parametroCarteraDefecto=new ParametroCarteraDefecto();
			ParametroCarteraDefectoLogic parametroCarteraDefectoLogic=new ParametroCarteraDefectoLogic();						
			
			parametroCarteraDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroCarteraDefectoLogic.getEntity(sFinalQuery);
				
				parametroCarteraDefecto=parametroCarteraDefectoLogic.getParametroCarteraDefecto();
				
				if(parametroCarteraDefecto!=null && parametroCarteraDefecto.getId()>0) {
					clienteReturnGeneral.getCliente().setid_tipo_identificacion(parametroCarteraDefecto.getid_tipo_identificacion());
					clienteReturnGeneral.getCliente().setid_pais(parametroCarteraDefecto.getid_pais());
					clienteReturnGeneral.getCliente().setid_region(parametroCarteraDefecto.getid_region());
					clienteReturnGeneral.getCliente().setid_provincia(parametroCarteraDefecto.getid_provincia());
					clienteReturnGeneral.getCliente().setid_ciudad(parametroCarteraDefecto.getid_ciudad());
					clienteReturnGeneral.getCliente().setid_zona(parametroCarteraDefecto.getid_zona());
					clienteReturnGeneral.getCliente().setid_pais_nacionalidad(parametroCarteraDefecto.getid_pais_nacionalidad());
					clienteReturnGeneral.getCliente().setid_estado_civil(parametroCarteraDefecto.getid_estado_civil());
					clienteReturnGeneral.getCliente().setid_tipo_genero(parametroCarteraDefecto.getid_tipo_genero());
					clienteReturnGeneral.getCliente().setid_ruta(parametroCarteraDefecto.getid_ruta());
					clienteReturnGeneral.getCliente().setid_vendedor(parametroCarteraDefecto.getid_vendedor());
					clienteReturnGeneral.getCliente().setid_cuenta_contable(parametroCarteraDefecto.getid_cuenta_contable());
					clienteReturnGeneral.getCliente().setid_dia(parametroCarteraDefecto.getid_dia());
					clienteReturnGeneral.getCliente().setid_tipo_precio(parametroCarteraDefecto.getid_tipo_precio());
					clienteReturnGeneral.getCliente().setid_tipo_lista_precio(parametroCarteraDefecto.getid_tipo_lista_precio());					
					clienteReturnGeneral.getCliente().setid_tipo_nivel_edu(parametroCarteraDefecto.getid_tipo_nivel_edu());
					clienteReturnGeneral.getCliente().setid_estado_legal(parametroCarteraDefecto.getid_estado_legal());
				
					
				} else {
					throw new Exception("DEBE CONFIGURAR PARAMETRO DEFECTOS");
				}
			}
			
			return generalEntityReturnGeneral;

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  ClienteLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkClienteToSave(Cliente cliente,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkClienteToSave(Cliente cliente,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkClienteToSaveAfter(Cliente cliente,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkClienteToSaves(List<Cliente> clientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkClienteToSaves(List<Cliente> clientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkClienteToSavesAfter(List<Cliente> clientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkClienteToGet(Cliente cliente,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkClienteToGets(List<Cliente> clientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateClienteToSave(Cliente cliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception {	
		//CONTROL_9
		
		cliente.setnombre_completo(cliente.getapellido()+" "+cliente.getnombre());
	}		
						
	public static void updateClienteToGet(Cliente cliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectClienteActions(String sTipoJsonResponse,JSONObject jsonObjectCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonClienteDataTable(String sTipoJsonResponse,Cliente cliente,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonClientesDataTable(String sTipoJsonResponse,List<Cliente> clientes,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayClienteColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayClientesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayClientesColumns;
	}
	
	public static void updateJSONArrayClienteActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCliente(Cliente cliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cliente.setcodigo(cliente.getcodigo().trim());
		cliente.setidentificacion(cliente.getidentificacion().trim());
		cliente.setnombre(cliente.getnombre().trim());
		cliente.setapellido(cliente.getapellido().trim());
		cliente.setnombre_completo(cliente.getnombre_completo().trim());
		cliente.setnombre_comercial(cliente.getnombre_comercial().trim());
		cliente.setnombre_garantia(cliente.getnombre_garantia().trim());
		cliente.setruc(cliente.getruc().trim());
		cliente.setpath_imagen_firma(cliente.getpath_imagen_firma().trim());
		cliente.setrepresentante(cliente.getrepresentante().trim());
		//cliente.sethora_pago(cliente.gethora_pago().trim());
		cliente.setobservacion(cliente.getobservacion().trim());
		cliente.setdetalle_estado(cliente.getdetalle_estado().trim());
	}
	
	public static void quitarEspaciosClientes(List<Cliente> clientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cliente cliente: clientes) {
			cliente.setcodigo(cliente.getcodigo().trim());
			cliente.setidentificacion(cliente.getidentificacion().trim());
			cliente.setnombre(cliente.getnombre().trim());
			cliente.setapellido(cliente.getapellido().trim());
			cliente.setnombre_completo(cliente.getnombre_completo().trim());
			cliente.setnombre_comercial(cliente.getnombre_comercial().trim());
			cliente.setnombre_garantia(cliente.getnombre_garantia().trim());
			cliente.setruc(cliente.getruc().trim());
			cliente.setpath_imagen_firma(cliente.getpath_imagen_firma().trim());
			cliente.setrepresentante(cliente.getrepresentante().trim());
			//cliente.sethora_pago(cliente.gethora_pago().trim());
			cliente.setobservacion(cliente.getobservacion().trim());
			cliente.setdetalle_estado(cliente.getdetalle_estado().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ClienteConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ClienteConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cliente> clientes,Cliente cliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cliente clienteAux: clientes) {
			if((clienteAux.getId()==null && cliente.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(clienteAux.getId()!=null && cliente.getId()!=null){
				if(clienteAux.getId().equals(cliente.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCliente(List<Cliente> clientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_garantiaTotal=0.0;
		Double limite_creditoTotal=0.0;
		Double descuentoTotal=0.0;
	
		for(Cliente cliente: clientes) {			
			valor_garantiaTotal+=cliente.getvalor_garantia();
			limite_creditoTotal+=cliente.getlimite_credito();
			descuentoTotal+=cliente.getdescuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.VALORGARANTIA);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_VALORGARANTIA);
		datoGeneral.setdValorDouble(valor_garantiaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		try {

			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_FUNCION2
}