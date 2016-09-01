













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.business.entity.ParametroCarteraDefecto;
import com.bydan.erp.cartera.business.logic.ParametroCarteraDefectoLogic;
import com.bydan.erp.cartera.business.logic.SubClienteLogic;
//import com.bydan.erp.cartera.util.SubClienteReturnGeneral;
import com.bydan.erp.comisiones.util.VendedorConstantesFunciones;
import com.bydan.erp.comisiones.util.VendedorParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.VendedorReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.comisiones.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VendedorLogicAdditional extends VendedorLogic { // implements VendedorAdditionable{
	
	public  VendedorLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			VendedorLogic vendedorLogic=(VendedorLogic)generalEntityLogic;
			VendedorParameterReturnGeneral vendedorReturnGeneral=(VendedorParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroCarteraDefecto parametroCarteraDefecto=new ParametroCarteraDefecto();
			ParametroCarteraDefectoLogic parametroCarteraDefectoLogic=new ParametroCarteraDefectoLogic();						
			
			parametroCarteraDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroCarteraDefectoLogic.getEntity(sFinalQuery);
				
				parametroCarteraDefecto=parametroCarteraDefectoLogic.getParametroCarteraDefecto();
				
				if(parametroCarteraDefecto!=null && parametroCarteraDefecto.getId()>0) {
					vendedorReturnGeneral.getVendedor().setid_pais(parametroCarteraDefecto.getid_pais());
					vendedorReturnGeneral.getVendedor().setid_ciudad(parametroCarteraDefecto.getid_ciudad());
					vendedorReturnGeneral.getVendedor().setid_zona(parametroCarteraDefecto.getid_zona());
					
					
					/*
					vendedorReturnGeneral.getVendedor().setid_tipo_identificacion(parametroCarteraDefecto.getid_tipo_identificacion());
					vendedorReturnGeneral.getVendedor().setid_pais_nacionalidad(parametroCarteraDefecto.getid_pais_nacionalidad());
					vendedorReturnGeneral.getVendedor().setid_estado_civil(parametroCarteraDefecto.getid_estado_civil());
					vendedorReturnGeneral.getVendedor().setid_tipo_genero(parametroCarteraDefecto.getid_tipo_genero());
					vendedorReturnGeneral.getVendedor().setid_cuenta_contable(parametroCarteraDefecto.getid_cuenta_contable());
					vendedorReturnGeneral.getVendedor().setid_tipo_nivel_edu(parametroCarteraDefecto.getid_tipo_nivel_edu());
					vendedorReturnGeneral.getVendedor().setid_estado_legal(parametroCarteraDefecto.getid_estado_legal());																		
					vendedorReturnGeneral.getVendedor().setid_region(parametroCarteraDefecto.getid_region());
					vendedorReturnGeneral.getVendedor().setid_provincia(parametroCarteraDefecto.getid_provincia());
					vendedorReturnGeneral.getVendedor().setid_ruta(parametroCarteraDefecto.getid_ruta());
					//vendedorReturnGeneral.getVendedor().setid_vendedor(parametroCarteraDefecto.getid_vendedor());					
					vendedorReturnGeneral.getVendedor().setid_dia(parametroCarteraDefecto.getid_dia());
					vendedorReturnGeneral.getVendedor().setid_tipo_precio(parametroCarteraDefecto.getid_tipo_precio());
					vendedorReturnGeneral.getVendedor().setid_tipo_lista_precio(parametroCarteraDefecto.getid_tipo_lista_precio());
					*/
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
	public  VendedorLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVendedorToSave(Vendedor vendedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVendedorToSave(Vendedor vendedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVendedorToSaveAfter(Vendedor vendedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVendedorToSaves(List<Vendedor> vendedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVendedorToSaves(List<Vendedor> vendedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVendedorToSavesAfter(List<Vendedor> vendedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVendedorToGet(Vendedor vendedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVendedorToGets(List<Vendedor> vendedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVendedorToSave(Vendedor vendedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVendedorToGet(Vendedor vendedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVendedorActions(String sTipoJsonResponse,JSONObject jsonObjectVendedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVendedorDataTable(String sTipoJsonResponse,Vendedor vendedor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVendedorsDataTable(String sTipoJsonResponse,List<Vendedor> vendedors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVendedorColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVendedorsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVendedorsColumns;
	}
	
	public static void updateJSONArrayVendedorActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVendedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVendedor(Vendedor vendedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vendedor.setcodigo(vendedor.getcodigo().trim());
		vendedor.setnombre(vendedor.getnombre().trim());
		vendedor.setruc(vendedor.getruc().trim());
		vendedor.setrepresentante(vendedor.getrepresentante().trim());
		vendedor.setemail(vendedor.getemail().trim());
		vendedor.setdescripcion(vendedor.getdescripcion().trim());
		vendedor.setdireccion_domicilio(vendedor.getdireccion_domicilio().trim());
		vendedor.setdireccion_referencia(vendedor.getdireccion_referencia().trim());
		vendedor.settelefono(vendedor.gettelefono().trim());
	}
	
	public static void quitarEspaciosVendedors(List<Vendedor> vendedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Vendedor vendedor: vendedors) {
			vendedor.setcodigo(vendedor.getcodigo().trim());
			vendedor.setnombre(vendedor.getnombre().trim());
			vendedor.setruc(vendedor.getruc().trim());
			vendedor.setrepresentante(vendedor.getrepresentante().trim());
			vendedor.setemail(vendedor.getemail().trim());
			vendedor.setdescripcion(vendedor.getdescripcion().trim());
			vendedor.setdireccion_domicilio(vendedor.getdireccion_domicilio().trim());
			vendedor.setdireccion_referencia(vendedor.getdireccion_referencia().trim());
			vendedor.settelefono(vendedor.gettelefono().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VendedorConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VendedorConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Vendedor> vendedors,Vendedor vendedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Vendedor vendedorAux: vendedors) {
			if((vendedorAux.getId()==null && vendedor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(vendedorAux.getId()!=null && vendedor.getId()!=null){
				if(vendedorAux.getId().equals(vendedor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVendedor(List<Vendedor> vendedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_comisionTotal=0.0;
		Double monto_vendidoTotal=0.0;
		Double monto_ultima_ventaTotal=0.0;
	
		for(Vendedor vendedor: vendedors) {			
			porcentaje_comisionTotal+=vendedor.getporcentaje_comision();
			monto_vendidoTotal+=vendedor.getmonto_vendido();
			monto_ultima_ventaTotal+=vendedor.getmonto_ultima_venta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.PORCENTAJECOMISION);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_PORCENTAJECOMISION);
		datoGeneral.setdValorDouble(porcentaje_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.MONTOVENDIDO);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOVENDIDO);
		datoGeneral.setdValorDouble(monto_vendidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VendedorConstantesFunciones.MONTOULTIMAVENTA);
		datoGeneral.setsDescripcion(VendedorConstantesFunciones.LABEL_MONTOULTIMAVENTA);
		datoGeneral.setdValorDouble(monto_ultima_ventaTotal);
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