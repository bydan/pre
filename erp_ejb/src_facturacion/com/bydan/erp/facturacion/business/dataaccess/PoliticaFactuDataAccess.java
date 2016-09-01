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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//PoliticaFactuConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class PoliticaFactuDataAccess extends  PoliticaFactuDataAccessAdditional{ //PoliticaFactuDataAccessAdditional,DataAccessHelper<PoliticaFactu>
	//static Logger logger = Logger.getLogger(PoliticaFactuDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="politica_factu";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_producto,id_grupo_cliente,nombre,fecha_desde,fecha_hasta,porcentaje,valor,con_banco_cliente,con_banco_producto,es_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_producto=?,id_grupo_cliente=?,nombre=?,fecha_desde=?,fecha_hasta=?,porcentaje=?,valor=?,con_banco_cliente=?,con_banco_producto=?,es_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select politicafactu from "+PoliticaFactuConstantesFunciones.SPERSISTENCENAME+" politicafactu";
	public static String QUERYSELECTNATIVE="select "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".version_row,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_empresa,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_sucursal,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_producto,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_grupo_cliente,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".nombre,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".fecha_desde,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".fecha_hasta,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".porcentaje,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".valor,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".con_banco_cliente,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".con_banco_producto,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".es_activo from "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME;//+" as "+PoliticaFactuConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".version_row,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".nombre from "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME;//+" as "+PoliticaFactuConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_producto=?,id_grupo_cliente=?,nombre=?,fecha_desde=?,fecha_hasta=?,porcentaje=?,valor=?,con_banco_cliente=?,con_banco_producto=?,es_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_POLITICAFACTU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_POLITICAFACTU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_POLITICAFACTU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_POLITICAFACTU_SELECT(?,?)";
	
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
	
	
	protected PoliticaFactuDataAccessAdditional politicafactuDataAccessAdditional=null;
	
	public PoliticaFactuDataAccessAdditional getPoliticaFactuDataAccessAdditional() {
		return this.politicafactuDataAccessAdditional;
	}
	
	public void setPoliticaFactuDataAccessAdditional(PoliticaFactuDataAccessAdditional politicafactuDataAccessAdditional) {
		try {
			this.politicafactuDataAccessAdditional=politicafactuDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PoliticaFactuDataAccess() {
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
		PoliticaFactuDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PoliticaFactuDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PoliticaFactuDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPoliticaFactuOriginal(PoliticaFactu politicafactu)throws Exception  {
		politicafactu.setPoliticaFactuOriginal((PoliticaFactu)politicafactu.clone());		
	}
	
	public void setPoliticaFactusOriginal(List<PoliticaFactu> politicafactus)throws Exception  {
		
		for(PoliticaFactu politicafactu:politicafactus){
			politicafactu.setPoliticaFactuOriginal((PoliticaFactu)politicafactu.clone());
		}
	}
	
	public static void setPoliticaFactuOriginalStatic(PoliticaFactu politicafactu)throws Exception  {
		politicafactu.setPoliticaFactuOriginal((PoliticaFactu)politicafactu.clone());		
	}
	
	public static void setPoliticaFactusOriginalStatic(List<PoliticaFactu> politicafactus)throws Exception  {
		
		for(PoliticaFactu politicafactu:politicafactus){
			politicafactu.setPoliticaFactuOriginal((PoliticaFactu)politicafactu.clone());
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
	
	public  PoliticaFactu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();		
		
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
	
	public  PoliticaFactu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.PoliticaFactu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPoliticaFactuOriginal(new PoliticaFactu());
      	    	entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPoliticaFactu("",entity,resultSet); 
				
				//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePoliticaFactu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PoliticaFactu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();
				
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
	
	public  PoliticaFactu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PoliticaFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PoliticaFactu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPoliticaFactuOriginal(new PoliticaFactu());
      	    	entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPoliticaFactu("",entity,resultSet);    
				
				//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePoliticaFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PoliticaFactu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PoliticaFactu entity = new PoliticaFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PoliticaFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PoliticaFactu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePoliticaFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PoliticaFactu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		
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
	
	public  List<PoliticaFactu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PoliticaFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticaFactu();
      	    	entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPoliticaFactu("",entity,resultSet);
      	    	
				//entity.setPoliticaFactuOriginal( new PoliticaFactu());
      	    	//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePoliticaFactus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticaFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PoliticaFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
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
	
	public  List<PoliticaFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticaFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapPoliticaFactu();
					//entity.setMapPoliticaFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPoliticaFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPoliticaFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
					entity=PoliticaFactuDataAccess.getEntityPoliticaFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPoliticaFactuOriginal( new PoliticaFactu());
					////entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePoliticaFactus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticaFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PoliticaFactu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();		  
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
	
	public  PoliticaFactu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticaFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapPoliticaFactu();
					//entity.setMapPoliticaFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPoliticaFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPoliticaFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
					entity=PoliticaFactuDataAccess.getEntityPoliticaFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPoliticaFactuOriginal( new PoliticaFactu());
					////entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePoliticaFactu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticaFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PoliticaFactu getEntityPoliticaFactu(String strPrefijo,PoliticaFactu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PoliticaFactu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PoliticaFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PoliticaFactuDataAccess.setFieldReflectionPoliticaFactu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPoliticaFactu=PoliticaFactuConstantesFunciones.getTodosTiposColumnasPoliticaFactu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPoliticaFactu) {
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
							field = PoliticaFactu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PoliticaFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PoliticaFactuDataAccess.setFieldReflectionPoliticaFactu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPoliticaFactu(Field field,String strPrefijo,String sColumn,PoliticaFactu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PoliticaFactuConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.FECHADESDE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticaFactuConstantesFunciones.FECHAHASTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticaFactuConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.CONBANCOCLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PoliticaFactuConstantesFunciones.ESACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PoliticaFactu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PoliticaFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PoliticaFactu();
					entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPoliticaFactu("",entity,resultSet);
					
					//entity.setPoliticaFactuOriginal( new PoliticaFactu());
					//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
					//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePoliticaFactus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticaFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PoliticaFactu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticaFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PoliticaFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PoliticaFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
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
	
	public  List<PoliticaFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticaFactu();
      	    	entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPoliticaFactu("",entity,resultSet);
      	    	
				//entity.setPoliticaFactuOriginal( new PoliticaFactu());
      	    	//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePoliticaFactus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticaFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PoliticaFactu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
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
	
	public  List<PoliticaFactu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticaFactu> entities = new  ArrayList<PoliticaFactu>();
		PoliticaFactu entity = new PoliticaFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticaFactu();
      	    	entity=super.getEntity("",entity,resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPoliticaFactu("",entity,resultSet);
      	    	
				//entity.setPoliticaFactuOriginal( new PoliticaFactu());
      	    	//entity.setPoliticaFactuOriginal(super.getEntity("",entity.getPoliticaFactuOriginal(),resultSet,PoliticaFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticaFactuOriginal(this.getEntityPoliticaFactu("",entity.getPoliticaFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePoliticaFactus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PoliticaFactu getEntityPoliticaFactu(String strPrefijo,PoliticaFactu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PoliticaFactuConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PoliticaFactuConstantesFunciones.IDSUCURSAL));
				entity.setid_producto(resultSet.getLong(strPrefijo+PoliticaFactuConstantesFunciones.IDPRODUCTO));
				entity.setid_grupo_cliente(resultSet.getLong(strPrefijo+PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE));
				entity.setnombre(resultSet.getString(strPrefijo+PoliticaFactuConstantesFunciones.NOMBRE));
				entity.setfecha_desde(new Date(resultSet.getDate(strPrefijo+PoliticaFactuConstantesFunciones.FECHADESDE).getTime()));
				entity.setfecha_hasta(new Date(resultSet.getDate(strPrefijo+PoliticaFactuConstantesFunciones.FECHAHASTA).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+PoliticaFactuConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+PoliticaFactuConstantesFunciones.VALOR));
				entity.setcon_banco_cliente(resultSet.getBoolean(strPrefijo+PoliticaFactuConstantesFunciones.CONBANCOCLIENTE));
				entity.setcon_banco_producto(resultSet.getBoolean(strPrefijo+PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO));
				entity.setes_activo(resultSet.getBoolean(strPrefijo+PoliticaFactuConstantesFunciones.ESACTIVO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+PoliticaFactuConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPoliticaFactu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PoliticaFactu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PoliticaFactuDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PoliticaFactuDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PoliticaFactuDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PoliticaFactuDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PoliticaFactuConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PoliticaFactuDataAccess.TABLENAME,PoliticaFactuDataAccess.ISWITHSTOREPROCEDURES);
			
			PoliticaFactuDataAccess.setPoliticaFactuOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PoliticaFactu relpoliticafactu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpoliticafactu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PoliticaFactu relpoliticafactu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpoliticafactu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Producto getProducto(Connexion connexion,PoliticaFactu relpoliticafactu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relpoliticafactu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,PoliticaFactu relpoliticafactu)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relpoliticafactu.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PoliticaFactu politicafactu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!politicafactu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(politicafactu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(politicafactu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(politicafactu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_cliente.setValue(politicafactu.getid_grupo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(politicafactu.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_desde=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_desde.setValue(politicafactu.getfecha_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_hasta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_hasta.setValue(politicafactu.getfecha_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(politicafactu.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(politicafactu.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_banco_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_banco_cliente.setValue(politicafactu.getcon_banco_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_banco_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_banco_producto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_banco_producto.setValue(politicafactu.getcon_banco_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_banco_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_activo.setValue(politicafactu.getes_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!politicafactu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(politicafactu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(politicafactu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(politicafactu.getId());
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
	
	public void setIsNewIsChangedFalsePoliticaFactu(PoliticaFactu politicafactu)throws Exception  {		
		politicafactu.setIsNew(false);
		politicafactu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePoliticaFactus(List<PoliticaFactu> politicafactus)throws Exception  {				
		for(PoliticaFactu politicafactu:politicafactus) {
			politicafactu.setIsNew(false);
			politicafactu.setIsChanged(false);
		}
	}
	
	public void generarExportarPoliticaFactu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
