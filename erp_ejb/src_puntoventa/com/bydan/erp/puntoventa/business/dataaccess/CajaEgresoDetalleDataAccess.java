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
import com.bydan.erp.puntoventa.util.*;//CajaEgresoDetalleConstantesFunciones;


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
final public class CajaEgresoDetalleDataAccess extends  CajaEgresoDetalleDataAccessAdditional{ //CajaEgresoDetalleDataAccessAdditional,DataAccessHelper<CajaEgresoDetalle>
	//static Logger logger = Logger.getLogger(CajaEgresoDetalleDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="caja_egreso_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+"(version_row,id_caja_egreso,id_empresa,id_sucursal,id_cliente,id_factura,concepto,valor)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_caja_egreso=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,concepto=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cajaegresodetalle from "+CajaEgresoDetalleConstantesFunciones.SPERSISTENCENAME+" cajaegresodetalle";
	public static String QUERYSELECTNATIVE="select "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".version_row,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_caja_egreso,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_empresa,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_cliente,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_factura,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".concepto,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".valor from "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaEgresoDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".version_row from "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaEgresoDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_caja_egreso=?,id_empresa=?,id_sucursal=?,id_cliente=?,id_factura=?,concepto=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CAJAEGRESODETALLE_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CAJAEGRESODETALLE_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CAJAEGRESODETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CAJAEGRESODETALLE_SELECT(?,?)";
	
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
	
	
	protected CajaEgresoDetalleDataAccessAdditional cajaegresodetalleDataAccessAdditional=null;
	
	public CajaEgresoDetalleDataAccessAdditional getCajaEgresoDetalleDataAccessAdditional() {
		return this.cajaegresodetalleDataAccessAdditional;
	}
	
	public void setCajaEgresoDetalleDataAccessAdditional(CajaEgresoDetalleDataAccessAdditional cajaegresodetalleDataAccessAdditional) {
		try {
			this.cajaegresodetalleDataAccessAdditional=cajaegresodetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CajaEgresoDetalleDataAccess() {
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
		CajaEgresoDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CajaEgresoDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CajaEgresoDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCajaEgresoDetalleOriginal(CajaEgresoDetalle cajaegresodetalle)throws Exception  {
		cajaegresodetalle.setCajaEgresoDetalleOriginal((CajaEgresoDetalle)cajaegresodetalle.clone());		
	}
	
	public void setCajaEgresoDetallesOriginal(List<CajaEgresoDetalle> cajaegresodetalles)throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles){
			cajaegresodetalle.setCajaEgresoDetalleOriginal((CajaEgresoDetalle)cajaegresodetalle.clone());
		}
	}
	
	public static void setCajaEgresoDetalleOriginalStatic(CajaEgresoDetalle cajaegresodetalle)throws Exception  {
		cajaegresodetalle.setCajaEgresoDetalleOriginal((CajaEgresoDetalle)cajaegresodetalle.clone());		
	}
	
	public static void setCajaEgresoDetallesOriginalStatic(List<CajaEgresoDetalle> cajaegresodetalles)throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles){
			cajaegresodetalle.setCajaEgresoDetalleOriginal((CajaEgresoDetalle)cajaegresodetalle.clone());
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
	
	public  CajaEgresoDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		
		
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
	
	public  CajaEgresoDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.CajaEgresoDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCajaEgresoDetalleOriginal(new CajaEgresoDetalle());
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaEgresoDetalle("",entity,resultSet); 
				
				//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaEgresoDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CajaEgresoDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();
				
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
	
	public  CajaEgresoDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaEgresoDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCajaEgresoDetalleOriginal(new CajaEgresoDetalle());
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaEgresoDetalle("",entity,resultSet);    
				
				//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaEgresoDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CajaEgresoDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CajaEgresoDetalle entity = new CajaEgresoDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaEgresoDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCajaEgresoDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CajaEgresoDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		
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
	
	public  List<CajaEgresoDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
      	    	//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresoDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaEgresoDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
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
	
	public  List<CajaEgresoDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgresoDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaEgresoDetalle();
					//entity.setMapCajaEgresoDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCajaEgresoDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaEgresoDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=CajaEgresoDetalleDataAccess.getEntityCajaEgresoDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
					////entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresoDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CajaEgresoDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
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
	
	public  CajaEgresoDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgresoDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaEgresoDetalle();
					//entity.setMapCajaEgresoDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCajaEgresoDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaEgresoDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=CajaEgresoDetalleDataAccess.getEntityCajaEgresoDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
					////entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCajaEgresoDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajaEgresoDetalle getEntityCajaEgresoDetalle(String strPrefijo,CajaEgresoDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CajaEgresoDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CajaEgresoDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CajaEgresoDetalleDataAccess.setFieldReflectionCajaEgresoDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCajaEgresoDetalle=CajaEgresoDetalleConstantesFunciones.getTodosTiposColumnasCajaEgresoDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCajaEgresoDetalle) {
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
							field = CajaEgresoDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CajaEgresoDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CajaEgresoDetalleDataAccess.setFieldReflectionCajaEgresoDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajaEgresoDetalle(Field field,String strPrefijo,String sColumn,CajaEgresoDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaEgresoDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.CONCEPTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaEgresoDetalleConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaEgresoDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CajaEgresoDetalle();
					entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCajaEgresoDetalle("",entity,resultSet);
					
					//entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
					//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCajaEgresoDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaEgresoDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CajaEgresoDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
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
	
	public  List<CajaEgresoDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
      	    	//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCajaEgresoDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgresoDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaEgresoDetalle> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
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
	
	public  List<CajaEgresoDetalle> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgresoDetalle> entities = new  ArrayList<CajaEgresoDetalle>();
		CajaEgresoDetalle entity = new CajaEgresoDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgresoDetalle();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgresoDetalle("",entity,resultSet);
      	    	
				//entity.setCajaEgresoDetalleOriginal( new CajaEgresoDetalle());
      	    	//entity.setCajaEgresoDetalleOriginal(super.getEntity("",entity.getCajaEgresoDetalleOriginal(),resultSet,CajaEgresoDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoDetalleOriginal(this.getEntityCajaEgresoDetalle("",entity.getCajaEgresoDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresoDetalles(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CajaEgresoDetalle getEntityCajaEgresoDetalle(String strPrefijo,CajaEgresoDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_caja_egreso(resultSet.getLong(strPrefijo+CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO));
				entity.setid_empresa(resultSet.getLong(strPrefijo+CajaEgresoDetalleConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CajaEgresoDetalleConstantesFunciones.IDSUCURSAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+CajaEgresoDetalleConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+CajaEgresoDetalleConstantesFunciones.IDFACTURA));
				entity.setconcepto(resultSet.getString(strPrefijo+CajaEgresoDetalleConstantesFunciones.CONCEPTO));
				entity.setvalor(resultSet.getDouble(strPrefijo+CajaEgresoDetalleConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCajaEgresoDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CajaEgresoDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CajaEgresoDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CajaEgresoDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CajaEgresoDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CajaEgresoDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CajaEgresoDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CajaEgresoDetalleDataAccess.TABLENAME,CajaEgresoDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			CajaEgresoDetalleDataAccess.setCajaEgresoDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public CajaEgreso getCajaEgreso(Connexion connexion,CajaEgresoDetalle relcajaegresodetalle)throws SQLException,Exception {

		CajaEgreso cajaegreso= new CajaEgreso();

		try {
			CajaEgresoDataAccess cajaegresoDataAccess=new CajaEgresoDataAccess();

			cajaegresoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaegresoDataAccess.setConnexionType(this.connexionType);
			cajaegresoDataAccess.setParameterDbType(this.parameterDbType);

			cajaegreso=cajaegresoDataAccess.getEntity(connexion,relcajaegresodetalle.getid_caja_egreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegreso;

	}

	public Empresa getEmpresa(Connexion connexion,CajaEgresoDetalle relcajaegresodetalle)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcajaegresodetalle.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CajaEgresoDetalle relcajaegresodetalle)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcajaegresodetalle.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,CajaEgresoDetalle relcajaegresodetalle)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relcajaegresodetalle.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,CajaEgresoDetalle relcajaegresodetalle)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relcajaegresodetalle.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CajaEgresoDetalle cajaegresodetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cajaegresodetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja_egreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja_egreso.setValue(cajaegresodetalle.getid_caja_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cajaegresodetalle.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cajaegresodetalle.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(cajaegresodetalle.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(cajaegresodetalle.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueconcepto=new ParameterValue<String>();
					parameterMaintenanceValueconcepto.setValue(cajaegresodetalle.getconcepto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconcepto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(cajaegresodetalle.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!cajaegresodetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cajaegresodetalle.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cajaegresodetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cajaegresodetalle.getId());
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
	
	public void setIsNewIsChangedFalseCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle)throws Exception  {		
		cajaegresodetalle.setIsNew(false);
		cajaegresodetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCajaEgresoDetalles(List<CajaEgresoDetalle> cajaegresodetalles)throws Exception  {				
		for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
			cajaegresodetalle.setIsNew(false);
			cajaegresodetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarCajaEgresoDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
