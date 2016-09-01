/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.contabilidad.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Time;
import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;



import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.GeneralEntity;
//LOGIC NO DEBE APARECER EN DESKTOP ONLY
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.resources.query.AuxiliarQuery;
import com.bydan.erp.contabilidad.util.ContabilidadConstantesFunciones;
import com.bydan.erp.contabilidad.util.ContabilidadParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ContabilidadParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.util.report.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
import com.bydan.erp.contabilidad.business.logic.report.*;
import com.bydan.erp.contabilidad.util.ContabilidadSql;
import com.bydan.erp.contabilidad.util.ContabilidadSqlReporte;


@SuppressWarnings("unused")
final public class ContabilidadLogicAdditional extends ContabilidadLogic {		
	
	//CONTROL_INICIO
	public  ContabilidadLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkContabilidadToSave(Contabilidad contabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkContabilidadToSave(Contabilidad contabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkContabilidadToSaveAfter(Contabilidad contabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkContabilidadToSaves(List<Contabilidad> contabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkContabilidadToSaves(List<Contabilidad> contabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkContabilidadToSavesAfter(List<Contabilidad> contabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkContabilidadToGet(Contabilidad contabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkContabilidadToGets(List<Contabilidad> contabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateContabilidadToSave(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateContabilidadToGet(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectContabilidadActions(String sTipoJsonResponse,JSONObject jsonObjectContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonContabilidadDataTable(String sTipoJsonResponse,Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonContabilidadsDataTable(String sTipoJsonResponse,List<Contabilidad> contabilidads,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayContabilidadColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayContabilidadsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayContabilidadsColumns;
	}
	
	public static void updateJSONArrayContabilidadActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Contabilidad> contabilidads) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}		
	
	//PARA ACCIONES NORMALES		
	public static GeneralEntityReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityReturnGeneral generalEntityReturnGeneral)throws Exception {				
		//CONTROL_17
		
		 try {	
			
			
			//GeneralEntityReturnGeneral generalEntityReturnGeneral=new GeneralEntityReturnGeneral();
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	//ACCION TABLA PROCESO DESDE BUSQUEDA
	public static GeneralEntityReturnGeneral ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityReturnGeneral generalEntityReturnGeneral) throws Exception  {
		//CONTROL_18
		//GeneralEntityReturnGeneral generalEntityReturnGeneral=new GeneralEntityReturnGeneral();
			
		try {	
			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			//this.connexion.commit();
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		//this.connexion.close();			
		}
		
		return generalEntityReturnGeneral;
	}
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {				
		//CONTROL_19		
		 try {	
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
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
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
	//COTIZACION
		@SuppressWarnings("resource")
		public Double getCotizacionBase(Long id_moneda,Date fecha,Connexion connexion) throws Exception {	
			//CONTROL_23
			Double dCotizacion=0.0;
			ArrayList<Classe> classes=new ArrayList<Classe>();
			Classe classe=new Classe();
			  
			InputStream inputStreamSql = AuxiliarQuery.class.getResourceAsStream("Cotizacion_Postgres.sql");
			
			String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();
			String sFinalQuery="";
			
			sSelectQuery=sSelectQuery.replace("ID_MONEDA",id_moneda.toString());
			sSelectQuery=sSelectQuery.replace("FECHA",Funciones2.getStringPostgresDate(fecha));
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			
			this.setConnexion(connexion);
			
			classe=new Classe("valor_venta",Double.class,true);
			  
			classes.add(classe);
			  
			DatoGeneralMinimo datoGeneralMinimo=this.getEntityDatoGeneralMinimoGenericoWithConnection(sSelectQuery,sFinalQuery,classes);
			
			dCotizacion=datoGeneralMinimo.getdValorDouble();
			
			//this.getEntityNativeHibernate(queryWhereSelectParameters); 
			
			return dCotizacion;
		}
		
		public Double getCotizacion(Long id_moneda,Date fecha,Connexion connexion) throws Exception {	
			Double dCotizacion=0.0;		
			
			if(id_moneda!=null) {
				dCotizacion=this.getCotizacionBase(id_moneda, fecha, connexion);
			}
					
			return dCotizacion;
		}
		
		public Double getCotizacionWithConnection(Long id_moneda,Date fecha) throws Exception {	
			Double dCotizacion=0.0;		
			try {			
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();				
				dCotizacion=this.getCotizacionBase(id_moneda, fecha, connexion);			
				connexion.commit();			
			} catch(Exception e) {
				connexion.rollback();		
				Funciones.manageException(logger,e);
				throw e;		
	      	} finally {
				connexion.close();			
			}
			
			return dCotizacion;
		}	
		//COTIZACION
}