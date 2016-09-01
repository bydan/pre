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
package com.bydan.erp.tesoreria.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//PagoAutoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class PagoAutoDataAccess extends  PagoAutoDataAccessAdditional{ //PagoAutoDataAccessAdditional,DataAccessHelper<PagoAuto>
	//static Logger logger = Logger.getLogger(PagoAutoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pago_auto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_cliente,id_asiento_contable,id_centro_costo,id_centro_actividad,id_factura,id_detalle_prove,id_cuenta_banco,id_transaccion,id_estado_pago_auto,numero_factura,fecha_emision,fecha_vencimiento,fecha_corte,valor_por_pagar,valor_cancelado,esta_autorizado,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_cliente=?,id_asiento_contable=?,id_centro_costo=?,id_centro_actividad=?,id_factura=?,id_detalle_prove=?,id_cuenta_banco=?,id_transaccion=?,id_estado_pago_auto=?,numero_factura=?,fecha_emision=?,fecha_vencimiento=?,fecha_corte=?,valor_por_pagar=?,valor_cancelado=?,esta_autorizado=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pagoauto from "+PagoAutoConstantesFunciones.SPERSISTENCENAME+" pagoauto";
	public static String QUERYSELECTNATIVE="select "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".version_row,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_empresa,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_sucursal,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_ejercicio,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_cliente,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_asiento_contable,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_centro_costo,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_centro_actividad,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_factura,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_detalle_prove,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_transaccion,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_estado_pago_auto,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".numero_factura,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_emision,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_corte,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".valor_por_pagar,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".valor_cancelado,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".esta_autorizado,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".descripcion from "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME;//+" as "+PagoAutoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".version_row from "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME;//+" as "+PagoAutoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_cliente=?,id_asiento_contable=?,id_centro_costo=?,id_centro_actividad=?,id_factura=?,id_detalle_prove=?,id_cuenta_banco=?,id_transaccion=?,id_estado_pago_auto=?,numero_factura=?,fecha_emision=?,fecha_vencimiento=?,fecha_corte=?,valor_por_pagar=?,valor_cancelado=?,esta_autorizado=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PAGOAUTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PAGOAUTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PAGOAUTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PAGOAUTO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected PagoAutoDataAccessAdditional pagoautoDataAccessAdditional=null;
	
	public PagoAutoDataAccessAdditional getPagoAutoDataAccessAdditional() {
		return this.pagoautoDataAccessAdditional;
	}
	
	public void setPagoAutoDataAccessAdditional(PagoAutoDataAccessAdditional pagoautoDataAccessAdditional) {
		try {
			this.pagoautoDataAccessAdditional=pagoautoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PagoAutoDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		PagoAutoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PagoAutoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PagoAutoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setPagoAutoOriginal(PagoAuto pagoauto)throws Exception  {
		pagoauto.setPagoAutoOriginal((PagoAuto)pagoauto.clone());		
	}
	
	public void setPagoAutosOriginal(List<PagoAuto> pagoautos)throws Exception  {
		
		for(PagoAuto pagoauto:pagoautos){
			pagoauto.setPagoAutoOriginal((PagoAuto)pagoauto.clone());
		}
	}
	
	public static void setPagoAutoOriginalStatic(PagoAuto pagoauto)throws Exception  {
		pagoauto.setPagoAutoOriginal((PagoAuto)pagoauto.clone());		
	}
	
	public static void setPagoAutosOriginalStatic(List<PagoAuto> pagoautos)throws Exception  {
		
		for(PagoAuto pagoauto:pagoautos){
			pagoauto.setPagoAutoOriginal((PagoAuto)pagoauto.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  PagoAuto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  PagoAuto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.PagoAuto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPagoAutoOriginal(new PagoAuto());
      	    	entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPagoAuto("",entity,resultSet); 
				
				//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePagoAuto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PagoAuto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PagoAuto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.PagoAuto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPagoAutoOriginal(new PagoAuto());
      	    	entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPagoAuto("",entity,resultSet);    
				
				//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePagoAuto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PagoAuto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PagoAuto entity = new PagoAuto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.PagoAuto.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalsePagoAuto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PagoAuto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PagoAuto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagoAuto();
      	    	entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPagoAuto("",entity,resultSet);
      	    	
				//entity.setPagoAutoOriginal( new PagoAuto());
      	    	//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePagoAutos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PagoAuto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PagoAuto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagoAuto();
				
				if(conMapGenerico) {
					entity.inicializarMapPagoAuto();
					//entity.setMapPagoAuto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPagoAutoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPagoAuto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=PagoAutoDataAccess.getEntityPagoAuto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPagoAutoOriginal( new PagoAuto());
					////entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
					////entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePagoAutos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PagoAuto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PagoAuto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagoAuto();
				
				if(conMapGenerico) {
					entity.inicializarMapPagoAuto();
					//entity.setMapPagoAuto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPagoAutoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPagoAuto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=PagoAutoDataAccess.getEntityPagoAuto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPagoAutoOriginal( new PagoAuto());
					////entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
					////entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePagoAuto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PagoAuto getEntityPagoAuto(String strPrefijo,PagoAuto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PagoAuto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PagoAuto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PagoAutoDataAccess.setFieldReflectionPagoAuto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPagoAuto=PagoAutoConstantesFunciones.getTodosTiposColumnasPagoAuto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPagoAuto) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = PagoAuto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PagoAuto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PagoAutoDataAccess.setFieldReflectionPagoAuto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPagoAuto(Field field,String strPrefijo,String sColumn,PagoAuto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PagoAutoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDCENTROACTIVIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDDETALLEPROVE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.IDESTADOPAGOAUTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagoAutoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagoAutoConstantesFunciones.FECHACORTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PagoAutoConstantesFunciones.VALORPORPAGAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.VALORCANCELADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.ESTAAUTORIZADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PagoAutoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PagoAuto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new PagoAuto();
					entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPagoAuto("",entity,resultSet);
					
					//entity.setPagoAutoOriginal( new PagoAuto());
					//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
					//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePagoAutos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PagoAuto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<PagoAuto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PagoAuto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagoAuto();
      	    	entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPagoAuto("",entity,resultSet);
      	    	
				//entity.setPagoAutoOriginal( new PagoAuto());
      	    	//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePagoAutos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PagoAuto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PagoAuto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PagoAuto> entities = new  ArrayList<PagoAuto>();
		PagoAuto entity = new PagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PagoAuto();
      	    	entity=super.getEntity("",entity,resultSet,PagoAutoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPagoAuto("",entity,resultSet);
      	    	
				//entity.setPagoAutoOriginal( new PagoAuto());
      	    	//entity.setPagoAutoOriginal(super.getEntity("",entity.getPagoAutoOriginal(),resultSet,PagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPagoAutoOriginal(this.getEntityPagoAuto("",entity.getPagoAutoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePagoAutos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PagoAuto getEntityPagoAuto(String strPrefijo,PagoAuto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDEJERCICIO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDCLIENTE));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_centro_actividad(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDCENTROACTIVIDAD));if(resultSet.wasNull()) {entity.setid_centro_actividad(null); }
				entity.setid_factura(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDFACTURA));
				entity.setid_detalle_prove(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDDETALLEPROVE));
				entity.setid_cuenta_banco(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDCUENTABANCO));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDTRANSACCION));
				entity.setid_estado_pago_auto(resultSet.getLong(strPrefijo+PagoAutoConstantesFunciones.IDESTADOPAGOAUTO));
				entity.setnumero_factura(resultSet.getString(strPrefijo+PagoAutoConstantesFunciones.NUMEROFACTURA));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PagoAutoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+PagoAutoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setfecha_corte(new Date(resultSet.getDate(strPrefijo+PagoAutoConstantesFunciones.FECHACORTE).getTime()));
				entity.setvalor_por_pagar(resultSet.getDouble(strPrefijo+PagoAutoConstantesFunciones.VALORPORPAGAR));
				entity.setvalor_cancelado(resultSet.getDouble(strPrefijo+PagoAutoConstantesFunciones.VALORCANCELADO));
				entity.setesta_autorizado(resultSet.getBoolean(strPrefijo+PagoAutoConstantesFunciones.ESTAAUTORIZADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+PagoAutoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPagoAuto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PagoAuto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PagoAutoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PagoAutoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PagoAutoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PagoAutoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PagoAutoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PagoAutoDataAccess.TABLENAME,PagoAutoDataAccess.ISWITHSTOREPROCEDURES);
			
			PagoAutoDataAccess.setPagoAutoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpagoauto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpagoauto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpagoauto.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Cliente getCliente(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpagoauto.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public AsientoContable getAsientoContable(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relpagoauto.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public CentroCosto getCentroCosto(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpagoauto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CentroActividad getCentroActividad(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);

			centroactividad=centroactividadDataAccess.getEntity(connexion,relpagoauto.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}

	public Factura getFactura(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relpagoauto.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public DetalleProve getDetalleProve(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		DetalleProve detalleprove= new DetalleProve();

		try {
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);

			detalleprove=detalleproveDataAccess.getEntity(connexion,relpagoauto.getid_detalle_prove());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleprove;

	}

	public CuentaBanco getCuentaBanco(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		CuentaBanco cuentabanco= new CuentaBanco();

		try {
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			cuentabanco=cuentabancoDataAccess.getEntity(connexion,relpagoauto.getid_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabanco;

	}

	public Transaccion getTransaccion(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relpagoauto.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public EstadoPagoAuto getEstadoPagoAuto(Connexion connexion,PagoAuto relpagoauto)throws SQLException,Exception {

		EstadoPagoAuto estadopagoauto= new EstadoPagoAuto();

		try {
			EstadoPagoAutoDataAccess estadopagoautoDataAccess=new EstadoPagoAutoDataAccess();

			estadopagoautoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopagoautoDataAccess.setConnexionType(this.connexionType);
			estadopagoautoDataAccess.setParameterDbType(this.parameterDbType);

			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion,relpagoauto.getid_estado_pago_auto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopagoauto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PagoAuto pagoauto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pagoauto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pagoauto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pagoauto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pagoauto.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pagoauto.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(pagoauto.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(pagoauto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_actividad=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_actividad.setValue(pagoauto.getid_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(pagoauto.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_prove=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_prove.setValue(pagoauto.getid_detalle_prove());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_prove);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_banco.setValue(pagoauto.getid_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(pagoauto.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pago_auto=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pago_auto.setValue(pagoauto.getid_estado_pago_auto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pago_auto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(pagoauto.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(pagoauto.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(pagoauto.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_corte=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_corte.setValue(pagoauto.getfecha_corte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_corte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_por_pagar=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_por_pagar.setValue(pagoauto.getvalor_por_pagar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_por_pagar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cancelado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cancelado.setValue(pagoauto.getvalor_cancelado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cancelado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_autorizado=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_autorizado.setValue(pagoauto.getesta_autorizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_autorizado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pagoauto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!pagoauto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pagoauto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pagoauto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pagoauto.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalsePagoAuto(PagoAuto pagoauto)throws Exception  {		
		pagoauto.setIsNew(false);
		pagoauto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePagoAutos(List<PagoAuto> pagoautos)throws Exception  {				
		for(PagoAuto pagoauto:pagoautos) {
			pagoauto.setIsNew(false);
			pagoauto.setIsChanged(false);
		}
	}
	
	public void generarExportarPagoAuto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
