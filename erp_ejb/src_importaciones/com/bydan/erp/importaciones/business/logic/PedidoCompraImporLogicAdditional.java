














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.importaciones.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.importaciones.util.PedidoCompraImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.PedidoCompraImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PedidoCompraImporLogicAdditional extends PedidoCompraImporLogic { // implements PedidoCompraImporAdditionable{
	public  PedidoCompraImporLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19


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
	public  PedidoCompraImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidoCompraImporToSave(PedidoCompraImpor pedidocompraimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidoCompraImporToSave(PedidoCompraImpor pedidocompraimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidoCompraImporToSaveAfter(PedidoCompraImpor pedidocompraimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidoCompraImporToSaves(List<PedidoCompraImpor> pedidocompraimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidoCompraImporToSaves(List<PedidoCompraImpor> pedidocompraimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidoCompraImporToSavesAfter(List<PedidoCompraImpor> pedidocompraimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidoCompraImporToGet(PedidoCompraImpor pedidocompraimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidoCompraImporToGets(List<PedidoCompraImpor> pedidocompraimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidoCompraImporToSave(PedidoCompraImpor pedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidoCompraImporToGet(PedidoCompraImpor pedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidoCompraImporActions(String sTipoJsonResponse,JSONObject jsonObjectPedidoCompraImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidoCompraImporDataTable(String sTipoJsonResponse,PedidoCompraImpor pedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidoCompraImporsDataTable(String sTipoJsonResponse,List<PedidoCompraImpor> pedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidoCompraImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidoCompraImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidoCompraImporsColumns;
	}
	
	public static void updateJSONArrayPedidoCompraImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedidoCompraImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidocompraimpor.setforma_pago(pedidocompraimpor.getforma_pago().trim());
		pedidocompraimpor.setnumero_dui(pedidocompraimpor.getnumero_dui().trim());
		pedidocompraimpor.setsecuencial(pedidocompraimpor.getsecuencial().trim());
		pedidocompraimpor.setuso_en(pedidocompraimpor.getuso_en().trim());
		pedidocompraimpor.setresponsable(pedidocompraimpor.getresponsable().trim());
		pedidocompraimpor.setorden_compra(pedidocompraimpor.getorden_compra().trim());
		pedidocompraimpor.setlugar_entrega(pedidocompraimpor.getlugar_entrega().trim());
		pedidocompraimpor.setdescripcion(pedidocompraimpor.getdescripcion().trim());
		pedidocompraimpor.setnombre_seguro(pedidocompraimpor.getnombre_seguro().trim());
		pedidocompraimpor.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario().trim());
		pedidocompraimpor.setprecios(pedidocompraimpor.getprecios().trim());
	}
	
	public static void quitarEspaciosPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {
			pedidocompraimpor.setforma_pago(pedidocompraimpor.getforma_pago().trim());
			pedidocompraimpor.setnumero_dui(pedidocompraimpor.getnumero_dui().trim());
			pedidocompraimpor.setsecuencial(pedidocompraimpor.getsecuencial().trim());
			pedidocompraimpor.setuso_en(pedidocompraimpor.getuso_en().trim());
			pedidocompraimpor.setresponsable(pedidocompraimpor.getresponsable().trim());
			pedidocompraimpor.setorden_compra(pedidocompraimpor.getorden_compra().trim());
			pedidocompraimpor.setlugar_entrega(pedidocompraimpor.getlugar_entrega().trim());
			pedidocompraimpor.setdescripcion(pedidocompraimpor.getdescripcion().trim());
			pedidocompraimpor.setnombre_seguro(pedidocompraimpor.getnombre_seguro().trim());
			pedidocompraimpor.setnombre_consignatario(pedidocompraimpor.getnombre_consignatario().trim());
			pedidocompraimpor.setprecios(pedidocompraimpor.getprecios().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDMODULO);
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(PedidoCompraImporConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImpor pedidocompraimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoCompraImpor pedidocompraimporAux: pedidocompraimpors) {
			if((pedidocompraimporAux.getId()==null && pedidocompraimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pedidocompraimporAux.getId()!=null && pedidocompraimpor.getId()!=null){
				if(pedidocompraimporAux.getId().equals(pedidocompraimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoCompraImpor(List<PedidoCompraImpor> pedidocompraimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fleteTotal=0.0;
		Double seguroTotal=0.0;
		Double gastosTotal=0.0;
		Double cfrTotal=0.0;
		Double cifTotal=0.0;
		Double totalTotal=0.0;
	
		for(PedidoCompraImpor pedidocompraimpor: pedidocompraimpors) {			
			fleteTotal+=pedidocompraimpor.getflete();
			seguroTotal+=pedidocompraimpor.getseguro();
			gastosTotal+=pedidocompraimpor.getgastos();
			cfrTotal+=pedidocompraimpor.getcfr();
			cifTotal+=pedidocompraimpor.getcif();
			totalTotal+=pedidocompraimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.SEGURO);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_SEGURO);
		datoGeneral.setdValorDouble(seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.GASTOS);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_GASTOS);
		datoGeneral.setdValorDouble(gastosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.CFR);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CFR);
		datoGeneral.setdValorDouble(cfrTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.CIF);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_CIF);
		datoGeneral.setdValorDouble(cifTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoCompraImporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
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