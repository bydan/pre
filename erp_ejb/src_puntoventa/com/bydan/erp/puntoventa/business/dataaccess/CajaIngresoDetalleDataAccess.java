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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//CajaIngresoDetalleConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class CajaIngresoDetalleDataAccess extends  CajaIngresoDetalleDataAccessAdditional{ //CajaIngresoDetalleDataAccessAdditional,DataAccessHelper<CajaIngresoDetalle>
	//static Logger logger = Logger.getLogger(CajaIngresoDetalleDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="caja_ingreso_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+"(version_row,id_caja_ingreso,id_empresa,id_sucursal,id_cliente,id_factura,concepto,valor)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_caja_ingreso=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,concepto=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cajaingresodetalle from "+CajaIngresoDetalleConstantesFunciones.SPERSISTENCENAME+" cajaingresodetalle";
	public static String QUERYSELECTNATIVE="select "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".version_row,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_caja_ingreso,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_empresa,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_cliente,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_factura,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".concepto,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".valor from "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaIngresoDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".version_row from "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaIngresoDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_caja_ingreso=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,concepto=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CAJAINGRESODETALLE_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CAJAINGRESODETALLE_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CAJAINGRESODETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CAJAINGRESODETALLE_SELECT(?,?)";
	
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
	
	
	protected CajaIngresoDetalleDataAccessAdditional cajaingresodetalleDataAccessAdditional=null;
	
	public CajaIngresoDetalleDataAccessAdditional getCajaIngresoDetalleDataAccessAdditional() {
		return this.cajaingresodetalleDataAccessAdditional;
	}
	
	public void setCajaIngresoDetalleDataAccessAdditional(CajaIngresoDetalleDataAccessAdditional cajaingresodetalleDataAccessAdditional) {
		try {
			this.cajaingresodetalleDataAccessAdditional=cajaingresodetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CajaIngresoDetalleDataAccess() {
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
		CajaIngresoDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CajaIngresoDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CajaIngresoDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCajaIngresoDetalleOriginal(CajaIngresoDetalle cajaingresodetalle)throws Exception  {
		cajaingresodetalle.setCajaIngresoDetalleOriginal((CajaIngresoDetalle)cajaingresodetalle.clone());		
	}
	
	public void setCajaIngresoDetallesOriginal(List<CajaIngresoDetalle> cajaingresodetalles)throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles){
			cajaingresodetalle.setCajaIngresoDetalleOriginal((CajaIngresoDetalle)cajaingresodetalle.clone());
		}
	}
	
	public static void setCajaIngresoDetalleOriginalStatic(CajaIngresoDetalle cajaingresodetalle)throws Exception  {
		cajaingresodetalle.setCajaIngresoDetalleOriginal((CajaIngresoDetalle)cajaingresodetalle.clone());		
	}
	
	public static void setCajaIngresoDetallesOriginalStatic(List<CajaIngresoDetalle> cajaingresodetalles)throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles){
			cajaingresodetalle.setCajaIngresoDetalleOriginal((CajaIngresoDetalle)cajaingresodetalle.clone());
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
	
	public  CajaIngresoDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		
		
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
	
	public  CajaIngresoDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.CajaIngresoDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCajaIngresoDetalleOriginal(new CajaIngresoDetalle());
      	    	entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaIngresoDetalle("",entity,resultSet); 
				
				//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaIngresoDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CajaIngresoDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();
				
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
	
	public  CajaIngresoDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaIngresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaIngresoDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCajaIngresoDetalleOriginal(new CajaIngresoDetalle());
      	    	entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaIngresoDetalle("",entity,resultSet);    
				
				//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaIngresoDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CajaIngresoDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CajaIngresoDetalle entity = new CajaIngresoDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaIngresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaIngresoDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCajaIngresoDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CajaIngresoDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		
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
	
	public  List<CajaIngresoDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaIngresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaIngresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaIngresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
      	    	//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaIngresoDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaIngresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaIngresoDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
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
	
	public  List<CajaIngresoDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaIngresoDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaIngresoDetalle();
					//entity.setMapCajaIngresoDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCajaIngresoDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaIngresoDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=CajaIngresoDetalleDataAccess.getEntityCajaIngresoDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
					////entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaIngresoDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaIngresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CajaIngresoDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
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
	
	public  CajaIngresoDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaIngresoDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaIngresoDetalle();
					//entity.setMapCajaIngresoDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCajaIngresoDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaIngresoDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=CajaIngresoDetalleDataAccess.getEntityCajaIngresoDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
					////entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCajaIngresoDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaIngresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajaIngresoDetalle getEntityCajaIngresoDetalle(String strPrefijo,CajaIngresoDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CajaIngresoDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CajaIngresoDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CajaIngresoDetalleDataAccess.setFieldReflectionCajaIngresoDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCajaIngresoDetalle=CajaIngresoDetalleConstantesFunciones.getTodosTiposColumnasCajaIngresoDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCajaIngresoDetalle) {
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
							field = CajaIngresoDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CajaIngresoDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CajaIngresoDetalleDataAccess.setFieldReflectionCajaIngresoDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajaIngresoDetalle(Field field,String strPrefijo,String sColumn,CajaIngresoDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaIngresoDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.CONCEPTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaIngresoDetalleConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaIngresoDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaIngresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CajaIngresoDetalle();
					entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCajaIngresoDetalle("",entity,resultSet);
					
					//entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
					//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCajaIngresoDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaIngresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaIngresoDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaIngresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaIngresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CajaIngresoDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
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
	
	public  List<CajaIngresoDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaIngresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaIngresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
      	    	//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCajaIngresoDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaIngresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaIngresoDetalle> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
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
	
	public  List<CajaIngresoDetalle> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaIngresoDetalle> entities = new  ArrayList<CajaIngresoDetalle>();
		CajaIngresoDetalle entity = new CajaIngresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaIngresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaIngresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaIngresoDetalleOriginal( new CajaIngresoDetalle());
      	    	//entity.setCajaIngresoDetalleOriginal(super.getEntity("",entity.getCajaIngresoDetalleOriginal(),resultSet,CajaIngresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaIngresoDetalleOriginal(this.getEntityCajaIngresoDetalle("",entity.getCajaIngresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaIngresoDetalles(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CajaIngresoDetalle getEntityCajaIngresoDetalle(String strPrefijo,CajaIngresoDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_caja_ingreso(resultSet.getLong(strPrefijo+CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO));
				entity.setid_empresa(resultSet.getLong(strPrefijo+CajaIngresoDetalleConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CajaIngresoDetalleConstantesFunciones.IDSUCURSAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+CajaIngresoDetalleConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+CajaIngresoDetalleConstantesFunciones.IDFACTURA));
				entity.setconcepto(resultSet.getString(strPrefijo+CajaIngresoDetalleConstantesFunciones.CONCEPTO));
				entity.setvalor(resultSet.getDouble(strPrefijo+CajaIngresoDetalleConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCajaIngresoDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CajaIngresoDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CajaIngresoDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CajaIngresoDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CajaIngresoDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CajaIngresoDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CajaIngresoDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CajaIngresoDetalleDataAccess.TABLENAME,CajaIngresoDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			CajaIngresoDetalleDataAccess.setCajaIngresoDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public CajaIngreso getCajaIngreso(Connexion connexion,CajaIngresoDetalle relcajaingresodetalle)throws SQLException,Exception {

		CajaIngreso cajaingreso= new CajaIngreso();

		try {
			CajaIngresoDataAccess cajaingresoDataAccess=new CajaIngresoDataAccess();

			cajaingresoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaingresoDataAccess.setConnexionType(this.connexionType);
			cajaingresoDataAccess.setParameterDbType(this.parameterDbType);

			cajaingreso=cajaingresoDataAccess.getEntity(connexion,relcajaingresodetalle.getid_caja_ingreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaingreso;

	}

	public Empresa getEmpresa(Connexion connexion,CajaIngresoDetalle relcajaingresodetalle)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcajaingresodetalle.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CajaIngresoDetalle relcajaingresodetalle)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcajaingresodetalle.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,CajaIngresoDetalle relcajaingresodetalle)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relcajaingresodetalle.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,CajaIngresoDetalle relcajaingresodetalle)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relcajaingresodetalle.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CajaIngresoDetalle cajaingresodetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cajaingresodetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja_ingreso.setValue(cajaingresodetalle.getid_caja_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cajaingresodetalle.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cajaingresodetalle.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(cajaingresodetalle.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(cajaingresodetalle.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueconcepto=new ParameterValue<String>();
					parameterMaintenanceValueconcepto.setValue(cajaingresodetalle.getconcepto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconcepto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(cajaingresodetalle.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!cajaingresodetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cajaingresodetalle.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cajaingresodetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cajaingresodetalle.getId());
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
	
	public void setIsNewIsChangedFalseCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle)throws Exception  {		
		cajaingresodetalle.setIsNew(false);
		cajaingresodetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles)throws Exception  {				
		for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
			cajaingresodetalle.setIsNew(false);
			cajaingresodetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarCajaIngresoDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
